/**
 * 
 * @author Holmes
 * file tree
 * 
 * store directory information
 * include two list one is used to store directories and the other is used to store files
 */
package ren.zhaoruncheng.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeInfo implements Iterable<File>{

	private List<File> files=new ArrayList<File>();
	
	private List<File> dirs=new ArrayList<File>();

	
	
	public void addAll(TreeInfo other){
		/**
		 *  and other tree information
		 */
		files.addAll(other.getFiles());
		
		dirs.addAll(other.getDirs());
	}

	public Iterator<File> iterator() {
		// TODO Auto-generated method stub
		return files.iterator();
	}
	
	public void addDir(File dir){
		this.dirs.add(dir);
	}
	
	public void addFile(File file){
		this.files.add(file);
	}
	
	public List<File> getDirs() {
		return dirs;
	}

	public void setDirs(List<File> dirs) {
		this.dirs = dirs;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}
	
	

}
