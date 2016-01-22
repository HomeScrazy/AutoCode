/**
 * 
 * @author Holmes
 * directory model, include the root directory file and his child-directory and files
 */
package ren.zhaoruncheng.model;

import java.io.File;

public class Directory {

	private File directory;
	
	private TreeInfo treeInfo;

	public File getDirectory() {
		return directory;
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}

	public TreeInfo getTreeInfo() {
		return treeInfo;
	}

	public void setTreeInfo(TreeInfo treeInfo) {
		this.treeInfo = treeInfo;
	}
	
	
}
