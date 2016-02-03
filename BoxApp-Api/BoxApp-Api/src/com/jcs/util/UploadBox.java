package com.jcs.util;

import java.io.InputStream;

import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFolder;

public class UploadBox {

	
	
	public boolean writeToFile(InputStream uploadedInputStream, String filename , BoxFolder folder,BoxAPIConnection api) {
		
	try{
		BoxFolder rootFolder = BoxFolder.getRootFolder(api);
		rootFolder.uploadFile(uploadedInputStream, filename);
	
		return true;
	}
	catch(Exception e){
		e.printStackTrace();
	}
		
		
		return false;
		
	}
	
	
}
