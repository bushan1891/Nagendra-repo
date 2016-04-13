package dev.marketo.samples.Leads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;

//the Java sample code on dev.marketo.com uses the minimal-json package
//minimal-json provides easy and fast representations of JSON
//for more information check out https://github.com/ralfstx/minimal-json

public class UpsertLeads {

	public String lookupField = "email"; // defines the field to deduplicate off
											// of
	public String action = "createOrUpdate"; // createOnly, updateOnly,
												// createOrUpdate, or
												// createDuplicate
	public JsonObject[] leads; // a set of leads as JsonObjects, has to be
								// non-empty

	public static String createLead(String email, Map<String, String> details, String activityJson) {
		// Create two JsonObjects representing leads
		JsonObject lead1 = new JsonObject().add("email", email);

		// add data here

		lead1.add("firstName", details.get("displayName"));
		lead1.add("site", "TESTSITE");
		lead1.add("company", details.get("displayName"));
		lead1.add("mainPhone", details.get("phone"));
		lead1.add("unsubscribedReason", details.get("roles"));
		lead1.add("activityJson", activityJson);

		// JsonObject lead2 = new JsonObject().add("email", "mkto@mkto.mkto");
		// lead2.add("firstName", "mkto");
		UpsertLeads upsertLeads = new UpsertLeads();
		upsertLeads.leads = new JsonObject[] { lead1 };// add out leads
														// {lead1,lead2}
		upsertLeads.lookupField = "email"; // set the lookupField
		String result = upsertLeads.postData();
		System.out.println(result);

		return result;
	}

	public static void createLead(String email) {
		JsonObject lead1 = new JsonObject().add("email", email);
		UpsertLeads upsertLeads = new UpsertLeads();
		upsertLeads.leads = new JsonObject[] { lead1 };// add out leads
														// {lead1,lead2}
		upsertLeads.lookupField = "email"; // set the lookupField
		String result = upsertLeads.postData();
		System.out.println("********print at createLead***********");
		System.out.println(result);

	}

	/*
	 * { "action":"createOnly", "lookupField":"email", "partitionName":"name",
	 * "input":[ { "email":"kjashaedd-1@klooblept.com",
	 * "firstName":"Kataldar-1", "postalCode":"04828" }, {
	 * "email":"kjashaedd-2@klooblept.com", "firstName":"Kataldar-2",
	 * "postalCode":"04828" }, { "email":"kjashaedd-3@klooblept.com",
	 * "firstName":"Kataldar-3", "postalCode":"04828" } ] }
	 */

	// submits the request to create/update/upsert leads to the leads.json
	// endpoint
	public String postData() {
		Config config = new Config();
		String result = null;
		try {
			JsonObject requestBody = buildRequest();
			String endpoint = config.marketoInstance + "/rest/v1/leads.json?access_token=" + config.getToken();
			URL url = new URL(endpoint.toString());
			HttpsURLConnection urlConn = (HttpsURLConnection) url.openConnection();
			urlConn.setRequestMethod("POST");
			urlConn.setRequestProperty("Content-type", "application/json");// "application/json"
																			// content-type
																			// is
																			// required.
			urlConn.setRequestProperty("accept", "text/json");
			urlConn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(urlConn.getOutputStream());
			wr.write(requestBody.toString());
			wr.flush();
			int responseCode = urlConn.getResponseCode();
			if (responseCode == 200) {
				InputStream inStream = urlConn.getInputStream();
				result = convertStreamToString(inStream);
			} else {
				result = "Status Code: " + responseCode;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;

	}

	private JsonObject buildRequest() {
		JsonObject requestBody = new JsonObject(); // JsonObject container for
													// the request body
		// add optional params
		if (action != null) {
			requestBody.add("action", action);
		}
		if (lookupField != null) {
			requestBody.add("lookupField", lookupField);
		}
		// assemble the input from leads into a JsonArray
		JsonArray input = new JsonArray();
		int i;
		for (i = 0; i < leads.length; i++) {
			input.add(leads[i]);
		}
		// add our array to the input parameter of the body
		requestBody.add("input", input);
		return requestBody;
	}

	private String convertStreamToString(InputStream inputStream) {

		try {
			return new Scanner(inputStream).useDelimiter("\\A").next();
		} catch (NoSuchElementException e) {
			return "";
		}
	}

}