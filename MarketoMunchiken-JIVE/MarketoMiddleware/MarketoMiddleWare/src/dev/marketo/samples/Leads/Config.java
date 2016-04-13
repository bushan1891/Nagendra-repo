package dev.marketo.samples.Leads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.eclipsesource.json.JsonObject;

public class Config {
	public String marketoInstance = "https://035-FTC-660.mktorest.com" ; //Replace this with the host from Admin Web Services
	public String marketoIdURL = marketoInstance + "/identity";	
	public String clientId = "9ffbe6d9-529b-4b6c-9613-6a207bc458a5";	//Obtain from your Custom Service in Admin>Launchpoint
	public String clientSecret = "uXfFYgacbmUYNzs87y5E2Kh5VBMNBqwc";	//Obtain from your Custom Service in Admin>Launchpoint
	public String idEndpoint = marketoIdURL + "/oauth/token?grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecret;


	public String getMarketoInstance() {
		return marketoInstance;
	}


	public void setMarketoInstance(String marketoInstance) {
		this.marketoInstance = marketoInstance;
	}


	public String getMarketoIdURL() {
		return marketoIdURL;
	}


	public void setMarketoIdURL(String marketoIdURL) {
		this.marketoIdURL = marketoIdURL;
	}


	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public String getClientSecret() {
		return clientSecret;
	}


	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}


	public String getIdEndpoint() {
		return idEndpoint;
	}


	public void setIdEndpoint(String idEndpoint) {
		this.idEndpoint = idEndpoint;
	}


	public  String getToken(){
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
                throw new Exception("Status: " + responseCode);
            }
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (Exception e) {
            e.printStackTrace();
        }
		return token;
	}
}
