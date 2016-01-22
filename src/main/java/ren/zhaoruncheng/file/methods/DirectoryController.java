/**
 * directory controller
 * function list:
 * 	copy directory form source directory to the indicate directory
 */
package ren.zhaoruncheng.file.methods;

import java.io.File;
import java.io.IOException;

public class DirectoryController implements FileCopyInterface{

	private TextFileController txtFileController=new TextFileController() ;
	public void copyFiles(File copyFile, File pasteFile) {
		// TODO Auto-generated method stub
		File[] fileList=copyFile.listFiles();
		for(File item:fileList){
			if(item.isDirectory()){
				File dir=new File(pasteFile.getPath()+File.separator+item.getName());
				if(!dir.exists()) dir.mkdir();
				copyFiles(item,dir);
			}else{
				File file=new File(pasteFile.getPath()+File.separator+item.getName());
				if(!file.exists()){
					try {
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				txtFileController.copyFiles(item, file);
				
			}
		}
	}

}
