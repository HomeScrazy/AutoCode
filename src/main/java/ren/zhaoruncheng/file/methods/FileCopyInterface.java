/**
 *  file copy method interface
 *  method list:
 *  	copyFile: copy file from source file to the indicated file
 */
package ren.zhaoruncheng.file.methods;

import java.io.File;

public interface FileCopyInterface {
	
	public void copyFiles(File copyFile,File pasteFile);
	
}
