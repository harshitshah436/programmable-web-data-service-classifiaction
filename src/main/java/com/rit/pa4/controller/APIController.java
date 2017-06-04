package com.rit.pa4.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rit.pa4.controller.HomeController;
import com.rit.pa4.model.API;
import com.rit.pa4.view.APIView;

/**
 * APIController class Handles requests for the API query page.
 * 
 * @author Harshit
 */
@Controller
public class APIController {

	private static final Logger logger = LoggerFactory.getLogger(APIController.class);
	private MongoOperations mongoOps = HomeController.getMongoOperationsObject();

	/**
	 * Simply selects the api view to render by returning its name.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public String apis() {
		logger.info("Query APIs!.");
		return "api";
	}

	/**
	 * Selects the api view, using model object controls the API operations
	 * including querying the database, and finally render by returning its
	 * name.
	 * 
	 * @param apiView
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/api", method = RequestMethod.POST)
	public String apiForm(APIView apiView, ModelMap model) {
		logger.info("Submitted form: APIs!");

		List<API> result = new ArrayList<API>();
		Query query = new Query();

		// Check the received field values from the view and make query
		// accordingly, and also add an attribute into model to display at view
		// side.
		if (apiView.getUpdated() != null && !apiView.getUpdated().isEmpty()) {
			String start_year = apiView.getUpdated();
			String end_year = Integer.toString(Integer.parseInt(apiView.getUpdated()) + 1);
			query.addCriteria(Criteria.where("updated").gte(start_year).lt(end_year));
			model.addAttribute("year", "Updated Year: " + start_year);
		}
		if (apiView.getProtocols() != null && !apiView.getProtocols().isEmpty()) {
			query.addCriteria(Criteria.where("protocols").is(apiView.getProtocols()));
			model.addAttribute("protocol", "Protocol: " + apiView.getProtocols());
		}
		if (apiView.getCategory() != null && !apiView.getCategory().isEmpty()) {
			query.addCriteria(Criteria.where("category").is(apiView.getCategory()));
			model.addAttribute("category", "Category: " + apiView.getCategory());
		}
		if (apiView.getRating() != null && !apiView.getRating().isEmpty()) {
			String[] rating = apiView.getRating().split(",");
			if (rating.length > 1) {
				if (rating[0].equalsIgnoreCase("higher")) {
					model.addAttribute("rating1", "Ratings higher than: ");
					query.addCriteria(Criteria.where("rating").gt(Double.parseDouble(rating[1])));
				} else if (rating[0].equalsIgnoreCase("lower")) {
					model.addAttribute("rating1", "Ratings lower than: ");
					query.addCriteria(Criteria.where("rating").lt(Double.parseDouble(rating[1])));
				} else {
					model.addAttribute("rating1", "Ratings equal to: ");
					query.addCriteria(Criteria.where("rating").is(Double.parseDouble(rating[1])));
				}
				model.addAttribute("rating2", rating[1]);
			}
		}
		if (apiView.getTags() != null && !apiView.getTags().isEmpty()) {
			String[] tags = apiView.getTags().split(",");
			if (tags.length > 0) {
				String regex = "";
				for (int i = 0; i < tags.length; i++) {
					if (i != 0 && i != tags.length) {
						regex += "|";
					}
					String tag = tags[i];
					regex += ".*" + tag + ".*";
				}
				query.addCriteria(Criteria.where("tags").regex(regex, "i"));
				model.addAttribute("tags", "Tags: " + apiView.getTags());
			}
		}
		if (apiView.getKeyword() != null && !apiView.getKeyword().isEmpty()) {
			String[] keywords = apiView.getKeyword().split(",");

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
				model.addAttribute("keyword", "Keyword: " + apiView.getKeyword());
			}
		}

		System.out.println(query);

		// Perform find query to mongoDB and insert result into a list of API
		// data structure.
		result = mongoOps.find(query, API.class);

		System.out.println(result.size());
		if (result.size() == 0) {
			model.addAttribute("norecord", "No record found.");
		}

		model.put("result", result);
		return "api";
	}
}
