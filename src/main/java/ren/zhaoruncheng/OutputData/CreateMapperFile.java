package ren.zhaoruncheng.OutputData;

/**
 * this class is to create a mapper.xml file 
 * input: file path and mapper string(constructed by MapperWrapping)
 * output: create a xml file contain the mapper string
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class CreateMapperFile {
	
	private String filePath;
	
	private String createString;
	
	public void createMapper(){
		/**
		 * create the file
		 * and write string to it by java I/O
		 */
		File file=new File(filePath);
		String encoding="UTF-8";
		try{
			OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(file),encoding);
			BufferedWriter bufferedWriter=new BufferedWriter(writer);
			bufferedWriter.write(createString);
			bufferedWriter.close();
			
		}catch(Exception e) {
			 System.out.println("Write error");
			 e.printStackTrace();
		 	}
		
	}
	
	
	public CreateMapperFile(String filePath){
	
		this.filePath=filePath;
		}
	public CreateMapperFile(){
		
		}
	
	public CreateMapperFile(String filePath,String createString){
	
		this.filePath=filePath;
		this.createString=createString;
	}





	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getMapperString() {
		return createString;
	}

	public void setMapperString(String createString) {
		this.createString = createString;
	}
}
