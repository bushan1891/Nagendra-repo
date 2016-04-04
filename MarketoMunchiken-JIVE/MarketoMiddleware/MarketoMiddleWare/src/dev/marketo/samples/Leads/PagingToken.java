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

public class PagingToken {
	public String marketoInstance = "https://035-FTC-660.mktorest.com" ; //Replace this with the host from Admin Web Services
	public String marketoIdURL = marketoInstance + "/identity";	
	public String clientId = "9ffbe6d9-529b-4b6c-9613-6a207bc458a5";	//Obtain from your Custom Service in Admin>Launchpoint
	public String clientSecret = "uXfFYgacbmUYNzs87y5E2Kh5VBMNBqwc";	//Obtain from your Custom Service in Admin>Launchpoint
	public String idEndpoint = marketoIdURL + "/oauth/token?grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecret;
	
	public String sinceDatetime; //starting dateTime for the token to represent
	
	public static void main(String[] args){
		PagingToken token = new PagingToken();
		token.sinceDatetime = "2015-06-25T00:00:00z";
		String result = token.getData();
		System.out.println(result);
	}
	//make request
	private String getData() {
        String data = null;
        try {
        	//assemble the URL
        	StringBuilder endpoint = new StringBuilder(marketoInstance + "/rest/v1/activities/pagingtoken.json?access_token=" + getToken() + "&sinceDatetime=" + sinceDatetime);
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
	public String getToken(){
		String token = null;
		try {
			URL url = new URL(idEndpoint);
			HttpsURLConnection urlConn = (HttpsURLConnection) url.openConnection();
			urlConn.setRequestMethod("GET");
            urlConn.setRequestProperty("accept", "application/json");
            int responseCode = urlConn.getResponseCode();
            if (responseCode == 200) {
                InputStream inStream = urlConn.getInputStream();
                Reader reader = new InputStreamReader(inStream);
                JsonObject jsonObject = JsonObject.readFrom(reader);
                token = jsonObject.get("access_token").asString();
            }else {
                throw new IOException("Status: " + responseCode);
            }
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (IOException e) {
            e.printStackTrace();
        }
		return token;
	}

    private String convertStreamToString(InputStream inputStream) {

        try {
            return new Scanner(inputStream).useDelimiter("\\A").next();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}