package ren.zhaoruncheng.wrap;
/**
 * 
 * @author crazy
 *
 * this class is to wrap string array with mapper format
 * mapper is a xml file of mybatis framework, developer write sql sentence into mapper
 * the reflection of database table is a important function of mybatis, and the process of crate the reflection by ourselves
 * now I can throw this boring and repeat task to computer
 * the following is reflection format
 * <resultMap id="{map name}" type="{the javaBean you wanna reflect}">
	  <id property="primary key of javabean" column="{primary key in databse table}" />
	  <result property="{property 1}" column="{table's line 1}"/>
	  <result property="{property 2}" column="{table's line 2}"/> 
 * </resultMap>

 */
public class MapperReflectWrapping {

	private String[] sourceAssembly;
	
	private String[] resultAssembly;
	
	private String id;
	
	private String key;
	
	private String name;
	
	private String className;
	
	public String getMapperReflectionString(){
		if(sourceAssembly.length!=resultAssembly.length) return null;
		StringBuilder mapper=new StringBuilder();
		mapper.append("<resultMap id=\"");
		mapper.append(name);
		mapper.append("\" type=\"");
		mapper.append(className);
		mapper.append("\" >\r\n");
		mapper.append("  ");
	    mapper.append(" <id property=\"");
	    mapper.append(id);
	    mapper.append("\" column=\"");
	    mapper.append(key);
		mapper.append("\" />\r\n");
		for(int i=0;i<sourceAssembly.length;i++){
			if(resultAssembly[i].equals(id)) continue;
			mapper.append("  ");
			mapper.append(" <result property=\"");
			mapper.append(resultAssembly[i]);
			mapper.append("\" column=\"");
			mapper.append(sourceAssembly[i]);
	        mapper.append("\" />\r\n");
		}
		mapper.append("</resultMap>");
		return mapper.toString();
	}
	
	
	
	
	//============================common method============================
	public MapperReflectWrapping(){
		
	}

	public MapperReflectWrapping(String[] sourceAssembly,String[] resultAssembly){
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
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
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
