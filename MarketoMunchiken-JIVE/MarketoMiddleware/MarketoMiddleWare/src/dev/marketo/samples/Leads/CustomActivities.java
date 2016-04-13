package dev.marketo.samples.Leads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TimeZone;

//A simple Java Toolkit for JSON (https://code.google.com/p/json-simple/)


import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jcs.modal.ActivityMap;

public class CustomActivities {


 public static void pushActivityLog(String leadid,List<ActivityMap> activitiesMap,String email ) {
	 
	 for(int i=0;i<activitiesMap.size();i++){
     if(!leadid.equals(null)&&!email.equals(null)){
		 String lead = new CustomActivities().addActivity(leadid,activitiesMap.get(i),email);
		 System.out.println("Activity push >>>>" +i +leadid);
		 System.out.println(lead);
     }else
     {
    	 System.out.println("NO LEAD OR EMAIL");
     }
	     
	 }
 }

 // Call Add Custom Activities API endpoint
 public String addActivity(String leadid,ActivityMap activitiesMap,String email) {
	 Config config = new Config();
     String url = config.marketoInstance + "/rest/v1/activities/external.json?access_token=" + config.getToken();
     System.out.println(url);
     String result = addData(url,leadid,activitiesMap,email);
     return result;
 }


 private String addData(String endpoint,String lead,ActivityMap map,String mail) {
     String data = null;
     try {
         // Construct request payload
         JSONObject attrObj=new JSONObject();
         
         JSONArray attributes= new JSONArray();
        // JSONObject loadattr = new JSONObject();
         List<String> valueNames= new ArrayList();
         
         for ( String key : map.map.keySet() ) {
        	 valueNames.add(key);
        	}
         
         String temp=new String();
         
         for(int i=0;i<map.map.size();i++){
        	 JSONObject loadattr = new JSONObject();
        	 temp= valueNames.get(i);
        	 loadattr.put("name",temp);
        	 loadattr.put("value",map.map.get(temp) );
        	 attributes.put(loadattr);  // adds the object to attributes array      	 
         }
         
         
         // attributes value is pushed here 
         
      //   attrObj.put("Action", map.map.get("Action"));
     //    attrObj.put("Date",map.map.get("Date"));
      //   attrObj.put("Title", map.map.get("Title"));
       //  attrObj.put("Updated Date", map.map.get("Updated Date"));
       //  attrObj.put("url", map.map.get("url"));
       //  attrObj.put("Summary", map.map.get("Summary"));
       //  attrObj.put("Object Type", map.map.get("Object Type"));
        // attrObj.put("Object Viewed", map.map.get("Object Viewed"));
        // attrObj.put("Liked", map.map.get("liked"));
         //attrObj.put("Updated Date", map.map.get("Updated Date"));

         JSONArray attrArray = new JSONArray();
         attrArray.put(attrObj);

    	 TimeZone tz = TimeZone.getTimeZone("UTC");
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
         df.setTimeZone(tz);
         String dateAsISO = df.format(new Date());
         String dateAsISOAppended = dateAsISO+"+07:00";

         // Required attributes
         JSONObject obj=new JSONObject();
         
         obj.put("leadId",lead);
         obj.put("activityDate", dateAsISOAppended);
         obj.put("activityTypeId", "100001"); // default id of our custom activity log
         obj.put("primaryAttributeValue",mail);
         obj.put("attributes", attributes);    // loading attributes json here
         

         // needs to map to input 
         
         JSONObject objectJson=new JSONObject();
         JSONArray arrayJson = new JSONArray();
         arrayJson.put(obj);
         
         objectJson.put("input",arrayJson);
         
         System.out.println("objectJson" +objectJson.toString());
         
         // Make request
         URL url = new URL(endpoint);
         HttpsURLConnection urlConn = (HttpsURLConnection) url.openConnection();
         urlConn.setRequestMethod("POST");
         urlConn.setAllowUserInteraction(false);
         urlConn.setDoOutput(true);
         urlConn.setRequestProperty("Content-type", "application/json");
         urlConn.setRequestProperty("accept", "application/json");
         urlConn.connect();
         OutputStream os = urlConn.getOutputStream();
         os.write(objectJson.toString().getBytes());
         os.close();

         // Inspect response
         int responseCode = urlConn.getResponseCode();
         if (responseCode == 200) {
             System.out.println("Status: 200");
             InputStream inStream = urlConn.getInputStream();
             data = convertStreamToString(inStream);
             System.out.println(data);
         } else {
             System.out.println(responseCode);
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