package com.rit.pa4.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.MongoClient;
import com.rit.pa4.model.API;
import com.rit.pa4.model.Mashup;

/**
 * HomeController class Handles requests for the application home page.
 * 
 * @author Harshit
 */
@Controller
public class HomeController {

	// Instance and class variables to store file name and database connection
	// details.
	public static final String PATH = "C:/Users/Harshit/OneDrive/Documents/workspace-sts-3.7.3.RELEASE/PA4WebServiceClassification/";
	public static final String API_FILE_NAME = "api.txt";
	public static final String MASHUP_FILE_NAME = "mashup.txt";

	public static final String DB_NAME = "ProgrammableWeb";
	public static final String MONGO_HOST = "localhost";
	public static final int MONGO_PORT = 27017;

	public static MongoOperations mongoOps;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Construct a mongo operations object.
	 */
	public HomeController() {
		getMongoOperationsObject();
	}

	/**
	 * Initialize data base connection and return MongoOperations object.
	 * 
	 * @return
	 */
	public static MongoOperations getMongoOperationsObject() {
		MongoClient mongo = null;
		try {
			mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		mongoOps = new MongoTemplate(mongo, DB_NAME);
		return mongoOps;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/**
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Welcome home!");
		return "home";
	}

	/**
	 * Create DB if its not exists and create according collections.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/createdb", method = RequestMethod.GET)
	public String createMongoDb(Model model) {
		logger.info("Database creation: Started!");

		String createDBMessage = "Collections already exist in the Database: " + DB_NAME + ".";

		try {

			if (!mongoOps.collectionExists(API.class)) {
				readAPIFileAndParseIntoDB(mongoOps);
				readMashupFileAndParseIntoDB(mongoOps);
				createDBMessage = "Collections created. Api & Mashup files are read and inserted.";
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("createDbMessage", createDBMessage);

		logger.info("Database creation: finished!");

		return "home";
	}

	/**
	 * Read API file and parse it and insert into database using API data
	 * structure created to perform CRUD operations on API collection.
	 * 
	 * @param mongoOps
	 * @throws IOException
	 */
	public void readAPIFileAndParseIntoDB(MongoOperations mongoOps) throws IOException {

		mongoOps.dropCollection(API.class);

		BufferedReader br = null;
		String line = "";
		String delimiter = "\\$\\#\\$";
		String multipleValueSeparator = "###";

		br = new BufferedReader(new FileReader(PATH + API_FILE_NAME));

		List<API> apiList = new ArrayList<API>();
		while ((line = br.readLine()) != null) {

			// Replace multiple separator values with ',' and split the line
			// with the delimiter.
			line = line.replace(multipleValueSeparator, ",");
			String[] api_attributes_array = line.split(delimiter);

			// Parse each line into database data structure for API collection.
			// (API class).
			API api = new API(api_attributes_array[0], api_attributes_array[1], api_attributes_array[2],
					api_attributes_array[3].isEmpty() ? 0 : Double.parseDouble(api_attributes_array[3]),
					api_attributes_array[4], api_attributes_array[5], api_attributes_array[6], api_attributes_array[7],
					api_attributes_array[8], api_attributes_array[9], api_attributes_array[10],
					api_attributes_array[11], api_attributes_array[12], api_attributes_array[13],
					api_attributes_array[14], api_attributes_array[15], api_attributes_array[16],
					api_attributes_array[17], api_attributes_array[18], api_attributes_array[19],
					api_attributes_array[20], api_attributes_array[21], api_attributes_array[22],
					api_attributes_array[23], api_attributes_array[24], api_attributes_array[25],
					api_attributes_array[26], api_attributes_array[27], api_attributes_array[28],
					api_attributes_array[29], api_attributes_array[30], api_attributes_array[31],
					api_attributes_array[32], api_attributes_array[33], api_attributes_array[34],
					api_attributes_array[35], api_attributes_array[36], api_attributes_array[37],
					api_attributes_array[38], api_attributes_array[39], api_attributes_array[40],
					api_attributes_array[41], api_attributes_array[42], api_attributes_array[43],
					api_attributes_array[44], api_attributes_array[45]);
			apiList.add(api);
		}

		mongoOps.insert(apiList, API.class);

		br.close();
	}

	/**
	 * Read Mashup file and parse it and insert into database using Mashup data
	 * structure created to perform CRUD operations on API collection.
	 * 
	 * @param mongoOps
	 * @throws IOException
	 */
	public void readMashupFileAndParseIntoDB(MongoOperations mongoOps) throws IOException {

		mongoOps.dropCollection(Mashup.class);

		BufferedReader br = null;
		String line = "";
		String delimiter = "\\$\\#\\$";
		String multipleValueSeparator = "###";

		br = new BufferedReader(new FileReader(PATH + MASHUP_FILE_NAME));

		List<Mashup> mashupList = new ArrayList<Mashup>();

		while ((line = br.readLine()) != null) {

			// Replace multiple separator values with ',' and split the line
			// with the delimiter.
			line = line.replace(multipleValueSeparator, ",");
			String[] mashup_attributes_array = line.split(delimiter);

			// Parse each line into database data structure for Mashup
			// collection.
			// (Mashup class).
			Mashup mashup = new Mashup(mashup_attributes_array[0], mashup_attributes_array[1],
					mashup_attributes_array[2], mashup_attributes_array[3], mashup_attributes_array[4],
					mashup_attributes_array[5], mashup_attributes_array[6], mashup_attributes_array[7],
					mashup_attributes_array[8], mashup_attributes_array[9], mashup_attributes_array[10],
					mashup_attributes_array[11], mashup_attributes_array[12], mashup_attributes_array[13],
					mashup_attributes_array[14], mashup_attributes_array[15], mashup_attributes_array[16],
					mashup_attributes_array[17]);
			mashupList.add(mashup);
		}

		mongoOps.insert(mashupList, Mashup.class);

		br.close();
	}
}
