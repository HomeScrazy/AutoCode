package ren.zhaoruncheng.write;

/**
 * this class is to writer a string to a indicated file
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class WriteFile {
		
	private File file;
	
	public void Write(String code){
		/**
		 * create the file
		 * and write string to it by java I/O
		 */
		String encoding="UTF-8";
		try{
			OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(file),encoding);
			BufferedWriter bufferedWriter=new BufferedWriter(writer);
			bufferedWriter.write(code);
			//writer.close();
			bufferedWriter.close();
			}catch(Exception e) {
			 System.out.println("Write error");
			 e.printStackTrace();
			 }
		
	}
	public WriteFile(File file){
		this.file=file;
	}

	

}
