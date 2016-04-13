package dev.marketo.samples.Leads;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import com.eclipsesource.json.JsonObject;

//the Java sample code on dev.marketo.com uses the minimal-json package
//minimal-json provides easy and fast representations of JSON
//for more information check out https://github.com/ralfstx/minimal-json

public class MultipleLeads {

	public Integer batchSize = null;
	public String nextPageToken = null;
	public String[] fields = null;
	public String filterType; // required, must match the REST API name of a
								// Marketo field
	public String[] filterValues;

	public static String getLeads(String filterTy, String FilterVal) {
		MultipleLeads leads = new MultipleLeads();
		leads.filterType = filterTy; // add a filterType, email
		leads.filterValues = new String[] { FilterVal }; // add an email address
															// to search for
		String result = leads.getData();
		System.out.println("********print at getLeads***********");
		System.out.println(result);
		return result;
	}

	// Make request
	private String getData() {
		Config config = new Config();
		String data = null;
		try {
			// Assemble the URL to retrieve data from
			StringBuilder endpoint = new StringBuilder(config.marketoInstance + "/rest/v1/leads.json?access_token="
					+ config.getToken() + "&filterType=" + filterType + "&filterValues=" + csvString(filterValues));
			// append optional params
			if (batchSize != null) {
				endpoint.append("&batchSize=" + batchSize);
			}
			if (nextPageToken != null) {
				endpoint.append("&nextPageToken=" + nextPageToken);
			}
			if (fields != null) {
				endpoint.append("&fields=" + csvString(fields));
			}
			URL url = new URL(endpoint.toString());
			HttpsURLConnection urlConn = (HttpsURLConnection) url.openConnection();
			urlConn.setRequestMethod("GET");
			urlConn.setRequestProperty("accept", "text/json");
			int responseCode = urlConn.getResponseCode();
			if (responseCode == 200) {
				InputStream inStream = urlConn.getInputStream();
				data = convertStreamToString(inStream);
				System.out.println(data);
			} else {
				data = "Status:" + responseCode;
			}
		} catch (MalformedURLException e) {
			System.out.println("URL not valid.");
		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
			e.printStackTrace();
		}

		return data;
	}

	// takes an array of fields as strings and concatenates them with
	// alternating commas to use in a URL param
	private String csvString(String[] fields) {
		StringBuilder fieldCsv = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			fieldCsv.append(fields[i]);
			if (i + 1 != fields.length) {
				fieldCsv.append(",");
			}
		}
		return fieldCsv.toString();
	}

	private String convertStreamToString(InputStream inputStream) {

		try {
			return new Scanner(inputStream).useDelimiter("\\A").next();
		} catch (NoSuchElementException e) {
			return "";
		}
	}
}
