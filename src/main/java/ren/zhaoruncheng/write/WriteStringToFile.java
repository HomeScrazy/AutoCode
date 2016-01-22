package ren.zhaoruncheng.write;

/**
 * this class is to create a mapper.xml file 
 * input: file path and mapper string(constructed by MapperWrapping)
 * output: create a xml file contain the mapper string
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class WriteStringToFile {
	
	private String filePath;
	
	private String writeString;
	
	private File file;
	
	public void WriteFile(){
		/**
		 * create the file
		 * and write string to it by java I/O
		 */
		String encoding="UTF-8";
		try{
			OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(file),encoding);
			BufferedWriter bufferedWriter=new BufferedWriter(writer);
			bufferedWriter.write(writeString);
			bufferedWriter.close();
			
		}catch(Exception e) {
			 System.out.println("Write error");
			 e.printStackTrace();
		 	}
		
	}
	
	public WriteStringToFile(String path,String writeString){
		this.filePath=path;
		this.file=new File(path);
		this.writeString=writeString;
	}
	
	public WriteStringToFile(File file){
		this.file=file;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getWriteString() {
		return writeString;
	}

	public void setWriteString(String writeString) {
		this.writeString = writeString;
	}
	
	
}
