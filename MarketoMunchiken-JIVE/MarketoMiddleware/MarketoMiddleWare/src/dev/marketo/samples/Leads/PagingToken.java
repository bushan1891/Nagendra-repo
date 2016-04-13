package dev.marketo.samples.Leads;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

//the Java sample code on dev.marketo.com uses the minimal-json package
//minimal-json provides easy and fast representations of JSON
//for more information check out https://github.com/ralfstx/minimal-json

public class PagingToken {

	public String sinceDatetime; // starting dateTime for the token to represent

	public static void main(String[] args) {
		PagingToken token = new PagingToken();
		token.sinceDatetime = "2015-06-25T00:00:00z";
		String result = token.getData();
		System.out.println(result);
	}

	// make request
	private String getData() {
		String data = null;
		Config config = new Config();
		try {
			// assemble the URL
			StringBuilder endpoint = new StringBuilder(
					config.marketoInstance + "/rest/v1/activities/pagingtoken.json?access_token=" + config.getToken()
							+ "&sinceDatetime=" + sinceDatetime);
			URL url = new URL(endpoint.toString());
			HttpsURLConnection urlConn = (HttpsURLConnection) url.openConnection();
			urlConn.setRequestMethod("GET");
			urlConn.setRequestProperty("accept", "text/json");
			int responseCode = urlConn.getResponseCode();
			if (responseCode == 200) {
				InputStream inStream = urlConn.getInputStream();
				data = convertStreamToString(inStream);
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

	private String convertStreamToString(InputStream inputStream) {

		try {
			return new Scanner(inputStream).useDelimiter("\\A").next();
		} catch (NoSuchElementException e) {
			return "";
		}
	}
}