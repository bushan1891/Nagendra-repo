package com.jcs.util;

import java.util.ArrayList;
import java.util.List;

import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxItem;

public class BoxUtil {

	
	public static BoxAPIConnection getApi(){
		// enter the developer token here 
		BoxAPIConnection api = new BoxAPIConnection("LLsUGD109Y6jWiSCWXmfknW3njFQzrFk");
		
	
		return api;
		
	}
	public static BoxFolder getClaimFolder() {

		BoxAPIConnection api = BoxUtil.getApi();
		BoxFolder Folder = new BoxFolder(api, "6372398869");

		return Folder;

	}

	public static BoxFolder getUserFolder() {

		BoxAPIConnection api = BoxUtil.getApi();
		BoxFolder Folder = new BoxFolder(api, "6372397685");

		return Folder;

	}
	
	
	public static BoxItem.Info getSearchResult(BoxFolder rootFolder ,String str ){
		
		BoxItem.Info result = null ;
		
		for(BoxItem.Info info : rootFolder ){
		if(info.getName().equals(str))
			return info;
		}
			
		return result;
	}
	
	
	
}
