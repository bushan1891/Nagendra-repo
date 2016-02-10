package com.jcs.box;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxItem;
import com.box.sdk.BoxUser;
import com.jcs.service.BoxService;


public final class BoxTest {



	public BoxTest() {
	}

	public void test() throws IOException {
   BoxService service = new BoxService();
  
     service.rename("rename"); 
   
  

	}

	private static void listFolder(BoxFolder folder, int depth) {
		for (BoxItem.Info itemInfo : folder) {
			String indent = "";
			for (int i = 0; i < depth; i++) {
				indent += "    ";
			}

			System.out.println(indent + itemInfo.getName() + itemInfo.getID());
			if (itemInfo instanceof BoxFolder.Info) {
				BoxFolder childFolder = (BoxFolder) itemInfo.getResource();
				if (depth < 2) {
					listFolder(childFolder, depth + 1);
				}
			}
		}

	}

}