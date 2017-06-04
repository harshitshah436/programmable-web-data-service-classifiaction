package com.rit.pa4.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rit.pa4.controller.HomeController;
import com.rit.pa4.model.Mashup;
import com.rit.pa4.view.MashupClassifierView;
import com.rit.pa4.view.MashupView;

import weka.classifiers.Classifier;
import weka.core.Instances;

/**
 * MashupController class Handles requests for the Mashup query page.
 * 
 * @author Harshit
 */

@Controller
public class MashupController {
	private static final Logger logger = LoggerFactory.getLogger(MashupController.class);
	private MongoOperations mongoOps = HomeController.getMongoOperationsObject();

	/**
	 * Simply selects the mashup view to render by returning its name.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mashup", method = RequestMethod.GET)
	public String mashups(Model model) {
		logger.info("Query Mashups!.");
		return "mashup";
	}

	/**
	 * Simply selects the mashup view to render by returning its name.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mashup_classifier", method = RequestMethod.GET)
	public String mashup_classification(Model model) {
		logger.info("Classify Mashups!.");
		return "mashup_classifier";
	}

	/**
	 * Selects the mashup view, using model object controls the Mashup
	 * operations including querying the database, and finally render by
	 * returning its name.
	 * 
	 * @param mashupView
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/mashup", method = RequestMethod.POST)
	public String mashupForm(MashupView mashupView, ModelMap model) {
		logger.info("Submitted form: Mashups!");

		List<Mashup> result = new ArrayList<Mashup>();
		Query query = new Query();

		// Check the received field values from the view and make query
		// accordingly, and also add an attribute into model to display at view
		// side.
		if (mashupView.getUpdated() != null && !mashupView.getUpdated().isEmpty()) {
			String start_year = mashupView.getUpdated();
			String end_year = Integer.toString(Integer.parseInt(mashupView.getUpdated()) + 1);
			query.addCriteria(Criteria.where("updated").gte(start_year).lt(end_year));
			model.addAttribute("year", "Updated Year: " + start_year);
		}

		if (mashupView.getApis() != null && !mashupView.getApis().isEmpty()) {
			query.addCriteria(Criteria.where("apis").regex(".*" + mashupView.getApis() + ".*", "i"));
			model.addAttribute("apis", "Used APIs: " + mashupView.getApis());
		}

		if (mashupView.getTags() != null && !mashupView.getTags().isEmpty()) {
			String[] tags = mashupView.getTags().split(",");
			if (tags.length > 0) {
				String regex = "";
				for (int i = 0; i < tags.length; i++) {
					if (i != 0 && i != tags.length) {
						regex += "|";
					}
					String tag = tags[i];
					regex += ".*" + tag + ".*";
				}
				System.out.println(regex);
				query.addCriteria(Criteria.where("tags").regex(regex, "i"));
				model.addAttribute("tags", "Tags: " + mashupView.getTags());
			}
		}

		if (mashupView.getKeyword() != null && !mashupView.getKeyword().isEmpty()) {
			String[] keywords = mashupView.getKeyword().split(",");

			if (keywords.length > 0) {
				Criteria criteriaTitle = Criteria.where("title").regex(".*" + keywords[0].trim() + ".*", "i");
				Criteria criteriaName = Criteria.where("name").regex(".*" + keywords[0].trim() + ".*", "i");
				Criteria criteriaDesc = Criteria.where("description").regex(".*" + keywords[0].trim() + ".*", "i");
				for (int i = 1; i < keywords.length; i++) {
					String keyword = keywords[i].trim();
					criteriaTitle.andOperator(Criteria.where("title").regex(".*" + keyword + ".*", "i"));
					criteriaName.andOperator(Criteria.where("name").regex(".*" + keyword + ".*", "i"));
					criteriaDesc.andOperator(Criteria.where("description").regex(".*" + keyword + ".*", "i"));
				}
				query.addCriteria(criteriaTitle).addCriteria(criteriaName).addCriteria(criteriaDesc);
				model.addAttribute("keyword", "Keyword: " + mashupView.getKeyword());
			}
		}

		System.out.println(query);

		// Perform find query to mongoDB and insert result into a list of Mashup
		// data structure.
		result = mongoOps.find(query, Mashup.class);

		System.out.println(result.size());
		if (result.size() == 0) {
			model.addAttribute("norecord", "No record found.");
		}

		model.put("result", result);
		return "mashup";
	}

	/**
	 * Selects the mashup_classifier view, using model object controls the Web
	 * service classification task and finally render by returning its name.
	 * 
	 * @param mashupView
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mashup_classifier", method = RequestMethod.POST)
	public String mashupClassifierForm(MashupClassifierView mashupClassifierView, Model model) throws Exception {
		logger.info("Submitted form: Mashup Classifier!");

		model.addAttribute("downloads", "" + "Total downloads: " + mashupClassifierView.getDownloads());
		model.addAttribute("useCounts", "" + "Use Counts: " + mashupClassifierView.getUseCounts());
		model.addAttribute("numComments", "" + "Number of comments: " + mashupClassifierView.getNumComments());
		model.addAttribute("updatedYear", "" + "Updated Year: " + mashupClassifierView.getUpdatedYear());
		
		String prediction = classifyUsingWekaModel(mashupClassifierView);

		if (!prediction.isEmpty() && prediction != null) {

			if (prediction.equalsIgnoreCase("one")) {
				prediction = "1 rating (*)";
			} else if (prediction.equalsIgnoreCase("two")) {
				prediction = "2 ratings (**)";
			} else if (prediction.equalsIgnoreCase("three")) {
				prediction = "3 ratings (***)";
			} else if (prediction.equalsIgnoreCase("four")) {
				prediction = "4 ratings (****)";
			} else {
				prediction = "5 ratings (*****)";
			}

			model.addAttribute("rating_message", "Classified ratings for this Mashup: ");
			model.addAttribute("ratings", prediction);
		} else {
			model.addAttribute("norecord", "Cannot classify. Please give all the inputs.");
		}
		
		return "mashup_classifier";
	}

	/**
	 * Predict the class label using Weka's classification model.
	 * 
	 * @param mashupClassifierView
	 * @return
	 * @throws Exception
	 */
	public String classifyUsingWekaModel(MashupClassifierView mashupClassifierView) throws Exception {
		Classifier cls = (Classifier) weka.core.SerializationHelper.read(HomeController.PATH + "ratings_3_labels.model");

		MakeARFFFile(mashupClassifierView);

		// Load or create instances to predict.
		Instances isntanceToPredict = new Instances(
				new BufferedReader(new FileReader(HomeController.PATH + "test_data.arff")));

		// Which instance to predict class value.
		int s1 = 0;

		// Set class variable index.
		isntanceToPredict.setClassIndex(4);

		// Perform the prediction.
		double value = cls.classifyInstance(isntanceToPredict.instance(s1));

		// Get the name of the class value.
		String prediction = isntanceToPredict.classAttribute().value((int) value);
		System.out.println("The predicted value of instance " + Integer.toString(s1) + ": " + prediction);

		return prediction;
	}

	/**
	 * Make an ARFF file from the given input to predict the class label.
	 * 
	 * @param mashupClassifierView
	 * @throws IOException
	 */
	public void MakeARFFFile(MashupClassifierView mashupClassifierView) throws IOException {
		FileWriter fw = new FileWriter(new File(HomeController.PATH + "test_data.arff"));
		BufferedWriter bw = new BufferedWriter(fw);

		// relation and attribute declaration in .arff file.
		String relation = "mashup_cleaned";
		String attribute1 = "@attribute downloads numeric";
		String attribute2 = "@attribute useCount numeric";
		String attribute3 = "@attribute numComments numeric";
		String attribute4 = "@attribute updated numeric";
		String attribute5 = "@attribute rating {Four,Five,Three}";

		bw.write("@relation " + relation);
		bw.newLine();
		bw.newLine();
		bw.write(attribute1);
		bw.newLine();
		bw.write(attribute2);
		bw.newLine();
		bw.write(attribute3);
		bw.newLine();
		bw.write(attribute4);
		bw.newLine();
		bw.write(attribute5);

		bw.newLine();
		bw.newLine();

		bw.write("@data");
		bw.newLine();
		bw.write(mashupClassifierView.getDownloads() + "," + mashupClassifierView.getUseCounts() + ","
				+ mashupClassifierView.getNumComments() + "," + mashupClassifierView.getUpdatedYear() + "," + "?");

		bw.close();
		fw.close();
	}
}
