package ren.zhaoruncheng.sourcedata;


/**
 * 
 * @author crazy
 *
 * import source data(the String need to transform) form txt file
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ImportDataFromText {
	
	private static final String FILEPATH="E:\\Runcheng\\tools\\test.txt";
	
	public String getStringFromFile(){
		StringBuilder sb=new StringBuilder();
		 try {
             String encoding="GBK";
             
             File file=new File(FILEPATH);
             if(file.isFile() && file.exists()){ 
                 InputStreamReader read = new InputStreamReader(
                 new FileInputStream(file),encoding);
                 BufferedReader bufferedReader = new BufferedReader(read);
                 String lineTxt = null;
                 while((lineTxt = bufferedReader.readLine()) != null){
                     sb.append(lineTxt);sb.append("\r\n");
                 }
                 read.close();
             }else{
            	 System.out.println("找不到指定的文件");
             }
		 } catch (Exception e) {
			 System.out.println("读取文件内容出错");
			 e.printStackTrace();
		 	}
		 return sb.toString();
	}
	
}
