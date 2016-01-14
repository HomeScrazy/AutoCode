package ren.zhaoruncheng.wrap;
/**
 * 
 * @author crazy
 *
 * this class is to wrap string array with mapper format
 * mapper is a xml file of mybatis framework, developer write sql sentence into mapper
 * the reflection of database table is a important function of mybatis, it reflection a table to an objrct
 * every columns of the table will match a property of class.
 * the function of this class is to get a source strong array that import from database or file,
 * and then, analyze the string and rebuild a string accord with the reflection format
 * the following is reflection format
 * <resultMap id="{map name}" type="{the javaBean you wanna reflect}">
	  <id property="primary key of javabean" column="{primary key in databse table}" />
	  <result property="{property 1}" column="{table's line 1}"/>
	  <result property="{property 2}" column="{table's line 2}"/> 
 * </resultMap>

 */
public class ReflectWrapping extends BaseWrapping {
	/**
	 * the sourceAssembly is the column-value in the reflection,
	 * and the resultAssembly is the property-value.
	 */

	private String[] sourceAssembly;
	
	private String[] resultAssembly;
	
	private String id;
	
	private String key;
	
	private String name;
	
	private String className;
	
	public String getMapperReflectionString(){
		/**
		 * build the reflection string in the correct format
		 */
		if(sourceAssembly.length!=resultAssembly.length) return null;
		StringBuilder mapper=new StringBuilder();
		mapper.append("<resultMap type=\"");
		mapper.append(className);
		mapper.append("\" id=\"");
		mapper.append(name);
		mapper.append("\">");
		mapper.append(enterKey);
		mapper.append(tabSize);
	    mapper.append("<id property=\"");
	    mapper.append(id);
	    mapper.append("\" column=\"");
	    mapper.append(key);
		mapper.append("\"  />");
		mapper.append(enterKey);
		for(int i=0;i<sourceAssembly.length;i++){
			if(resultAssembly[i].equals(id)) continue;
			mapper.append(tabSize);
			mapper.append("<result property=\"");
			mapper.append(StringChecking.propertyTransformFormDatabaseToObject(resultAssembly[i]));
			mapper.append("\" column=\"");
			mapper.append(sourceAssembly[i]);
	        mapper.append("\"  />");
	        mapper.append(enterKey);
		}
		mapper.append("</resultMap>");
		return mapper.toString();
	}
	
	
	
	
	//============================common method============================
	public ReflectWrapping(){
		
	}

	public ReflectWrapping(String[] sourceAssembly,String[] resultAssembly){
		this.sourceAssembly=sourceAssembly;
		this.resultAssembly=resultAssembly;
	}
	public String[] getSouceAssembly() {
		return sourceAssembly;
	}

	public void setSouceAssembly(String[] souceAssembly) {
		this.sourceAssembly = souceAssembly;
	}

	public String[] getResultAssembly() {
		return resultAssembly;
	}

	public void setResultAssembly(String[] resultAssembly) {
		this.resultAssembly = resultAssembly;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		/**
		 * set the id of object 
		 */
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		/**
		 * set the primary key of table
		 */
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}
