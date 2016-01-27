package jcs.contorller;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import static spark.Spark.*;
import com.squareup.okhttp.*;
import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import spark.Route;
import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxAPIRequest;
import com.box.sdk.BoxCollaboration;
import com.box.sdk.BoxFile;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxItem;
import com.box.sdk.BoxUser;
import com.box.sdk.CreateUserParams;
import com.box.sdk.ProgressListener;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.MediaType;
	import com.squareup.okhttp.OkHttpClient;
	import com.squareup.okhttp.RequestBody;
	import jcs.service.UserService;

public class UserController implements ProgressListener {

	

	public UserController(final UserService userService) {
		

		get("/users", new Route() {
			public Object handle(spark.Request request, spark.Response response) throws Exception {
		        
				System.out.println("called");
			
				BoxAPIConnection api = new BoxAPIConnection("IsL4vHUowLVKZ2jDVFOYpeYnD5ZZ1dWx");
				BoxFolder rootFolder = BoxFolder.getRootFolder(api);
			   
				
				
				/*BoxAPIConnection api = new BoxAPIConnection("d0apdicfw300vm271hsbczm4oiw0iu2l",
					    "0OIXTPmxUXXAQvt3gAnvlixsIDm9GUhq", "8ojLqdEh0mu23L4wyAatKPNOqnh6k32C");
				
				BoxFolder rootFolder = BoxFolder.getRootFolder(api);
				System.out.println(api.toString() + "hi");
				
	
				URL url = new URL("https://api.box.com/2.0/users");
				BoxAPIRequest get = new BoxAPIRequest(api,url,"HTTP");
				
				get.addHeader("-H", "Authorization: Bearer tgfyPpVbZ8RvdSRwkCINrXmx5PoeDbHl");
			    get.send();
			    
				System.out.println(get.getBody());
				
				// 
				*/
				
				
				 /*String clientId ="d0apdicfw300vm271hsbczm4oiw0iu2l";
				  String clientSecret = "NHpsitTk46fiKPZwCt61xW83KFvphyRy";
				   String requestBody = "response_type=code&"
						 	                  //                  + "state=security_token%253DKnhMJatFipTAnM0nHlZA&"
						 	                  + "client_id="+ clientId
						 	                  + "&client_secret="+ clientSecret ;
						 	
				
				
				URL url = new URL("https://app.box.com/api/oauth2/authorize?");			
				
				BoxAPIRequest http = new BoxAPIRequest(url,"POST");
				http.setBody(requestBody);
				
				
				 http.send();
				 http.send();
				 System.out.println();
				 InputStream b  = http.getBody();
				 
				 
				 
				 System.out.println(b.toString());
						//new BoxAPIRequest(, "POST");
				 */
				
				
				//BoxAPIConnection api = new BoxAPIConnection("d0apdicfw300vm271hsbczm4oiw0iu2l", "NHpsitTk46fiKPZwCt61xW83KFvphyRy");
				
				/* String access = api.getAccessToken();
		         String refresh = api.getRefreshToken();
		         
		         api.setAutoRefresh(true);*/
		         	 //   setupLogging();
		         	// print(access);
		           // print(refresh);
				
				//BoxUser role = new BoxUser(api,"defender");
				
		         // to download for box
		          
		         for (BoxItem.Info itemInfo : rootFolder) {
						System.out.format("[%s] %s\n", itemInfo.getID(), itemInfo.getName());

						BoxFile file = new BoxFile(api, itemInfo.getID());
						BoxFile.Info info = file.getInfo();
						FileOutputStream stream = new FileOutputStream(info.getName());
						try {
						file.download(stream);
						stream.close();
						}
						catch(Exception e){
							System.out.println("Download failed " + e );
						}
		         }
		         
		           
		           BoxUser user = BoxUser.getCurrentUser(api);
				   
		           BoxUser.Info info = user.getInfo();
				     System.out.println(user.getID());
				
				  CreateUserParams  boxuser = new CreateUserParams ();
				  
				    boxuser.setJobTitle("programmer");
				  
				  
				  System.out.println(boxuser.getJobTitle());
				   // to upload to box 
		         
		        try { 
		         FileInputStream stream = new FileInputStream("myupload.txt");
		         rootFolder.uploadFile(stream, "myuplaod.txt");
		         System.out.println(" hi i did uplaod ");
		         stream.close();
		        }
		        catch(Exception e){
		        	System.out.println("Upload fialed "+ e);
		        }
		         
			
				
				return "hi i did the work";
		         	}
		});

		
		
		get("/auth", new Route() {

			public Object handle(spark.Request request, spark.Response response) throws Exception {
				// TODO Auto-generated method stub
				
				System.out.println("auth is called");
				
				OkHttpClient client = new OkHttpClient();
				
				String requestBody = "response_type=code&"
				        + "state=security_token%d0apdicfw300vm271hsbczm4oiw0iu2l&"
				        + "client_id=d0apdicfw300vm271hsbczm4oiw0iu2l&"
				        + "client_secret= MdRmQ3HpOgejMrB9DA6qRZG5IaWgsinC&"
				        + "login=nagendra.balachandra%40jcsconsulting.com&"
				        + "password=Bushanrock12!";
				
				MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
				 RequestBody body = RequestBody.create(mediaType, requestBody);
	               		 
                 // Request req = new Request.    
				
				return null;
			}

		});	
		
	}

	public void onProgressChanged(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
		System.out.println("i was called ");
		
		
	}

}
