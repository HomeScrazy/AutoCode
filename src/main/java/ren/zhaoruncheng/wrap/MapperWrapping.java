package ren.zhaoruncheng.wrap;
/**
 * 
 * @author Holmes
 *
 * the class is to wrap string with the format of mapper.
 * input:class name of the dao you wanna to implement and the string of database table
 * output: base mapper string include reflect
 *  
 */
public class MapperWrapping extends BaseWrapping {
	
	private String daoName;
	
	private String reflectString;
	
	public String getMapperString(){
		
		/**
		 * wrap the source data and return the wrapped string 
		 */
		
		//builder the base of xml format
		StringBuilder mapper=new StringBuilder();
		mapper.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		mapper.append(enterKey);
		mapper.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" ");
		mapper.append(enterKey);
		mapper.append("\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
		mapper.append(enterKey);
		
		//build the base of mapper
		mapper.append("<mapper namespace=\"");
		mapper.append(daoName);
		mapper.append("\">");
		
		//add reflect string
		mapper.append(enterKey);
		mapper.append(reflectString);
		
		mapper.append(enterKey);
		mapper.append("</mapper>");
		return mapper.toString();
		
	}
	
	
	
	//============================common method============================
	
	public  MapperWrapping(){
		
	}

	public String getDaoName() {
		return daoName;
	}

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}


	public String getReflectString() {
		return reflectString;
	}



	public void setReflectString(String reflectString) {
		this.reflectString = reflectString;
	}
}
