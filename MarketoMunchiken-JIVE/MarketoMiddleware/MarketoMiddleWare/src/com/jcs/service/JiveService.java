package com.jcs.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpConnection;
import org.apache.http.client.HttpClient;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.jcs.exception.AppException;

import java.net.Proxy;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
public class JiveService implements JiveServiceInterface {

	public  List<String> getUserEmail(String id)  {
		
		  List<String> emails = new ArrayList();
		
		    try {
		    	String idEndpoint = "https://jivedemo-slicesoftware.jiveon.com/api/core/v3/people/"+id;
		    	URL url = new URL(null, idEndpoint, new sun.net.www.protocol.https.Handler());
				HttpsURLConnection urlConn = (HttpsURLConnection) url.openConnection();
				urlConn.setRequestMethod("GET");
	            urlConn.setRequestProperty("accept", "application/json");
	            String userpass = "adminuser" + ":" + "jive123";
			    String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes("UTF-8"));
			    urlConn.setRequestProperty ("Authorization", basicAuth);
	            int responseCode = urlConn.getResponseCode();
	        
	            if (responseCode == 200) {
	                InputStream inStream = urlConn.getInputStream();
	                
	                Reader reader = new InputStreamReader(inStream);
	               
	                String inputStreamString = new Scanner(inStream,"UTF-8").useDelimiter("\\A").next();
	                    

	                    // Removing the unwanted jive data from the JSON
	                  
	                    String modifiedResponse = StringUtils.replace(inputStreamString, "throw 'allowIllegalResourceCall is false.';", "");
                        System.out.println(modifiedResponse);
	                    // close the stream
                        JsonObject jsonObject = JsonObject.readFrom(modifiedResponse);
                        JSONObject responseObject = new JSONObject(modifiedResponse);
                      
                        // pull the value email here 
                        JSONArray array = responseObject.getJSONArray("emails");
                      // getting all the emails associated to the account 
                        for(int i=0; i<array.length(); i++) {
                        	JSONObject result = new JSONObject( array.get(i).toString());
                        	System.out.println(result.get("value"));
                        	emails.add((String) result.get("value"));
                       }
                    

	                 } 
	            }catch (IOException ex) {
	                    ex.printStackTrace();
	                 }		
		
		return emails;
	
		    }
	public  int getUserID(String requestPayload) {
		Integer userID = 0;
		
		// Verb tells kind of event in JIVE 
		
		JSONArray jsonarray = new JSONArray(requestPayload);
		System.out.println("called");
		for(int i =0 ; i<jsonarray.length();i++){
			JSONObject jsonobject = jsonarray.getJSONObject(i);
			JSONObject activity = jsonobject.getJSONObject("activity");
			String verb = activity.getString("verb");
			
			// jive object gives information about the USER ID
			
			JSONObject jiveString = activity.getJSONObject("jive");
			
			System.out.println("jive string is " + jiveString.toString());
			userID=  jiveString.getInt("objectID");
			
			
			if( verb.equals("jive:user_account_created")){
				System.out.println("New Account created on jive");	
				return userID;
			}

			System.out.println(verb);
			String name = jsonobject.getString("webhook");
			System.out.println(name);
		}
		
		  userID=-1;
		
		return userID ;
	}
	
	

}
	
