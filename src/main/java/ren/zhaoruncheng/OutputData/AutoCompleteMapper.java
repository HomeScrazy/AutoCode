package ren.zhaoruncheng.OutputData;
/**
 * auto-complete the mapper
 * input: table name,package name(model),class name(model),dao name(include pacakge),
 * set database setting in this class
 */

import java.util.List;


import ren.zhaoruncheng.model.ColumnInformation;
import ren.zhaoruncheng.model.TableInformation;
import ren.zhaoruncheng.sourcedata.ImportTableInformationFromOracle;
import ren.zhaoruncheng.wrap.MapperWrapping;
import ren.zhaoruncheng.wrap.ReflectWrapping;
import ren.zhaoruncheng.wrap.SelectListWrapping;
import ren.zhaoruncheng.wrap.StringParsing;
import ren.zhaoruncheng.wrap.methods.DeleteWrapping;
import ren.zhaoruncheng.wrap.methods.InsertWrapping;
import ren.zhaoruncheng.wrap.methods.UpdateWrapping;

public class AutoCompleteMapper {
	
	private String tableName;
	
	//private String reflectName;
	
	//private String reflectId;
	
	//private String reflectKey;
	
	private String packageName;
	
	private String className;
	
	private String daoName;
	
	public String AutoComplete() {
	
		//Auto-complete some String
		String reflectId="id";
		String reflectKey="id";
		//String daoName=className+"Dao";
		String reflectName=className.toLowerCase();
		
		//selectMethod name
		String selectMethodName;
		//insert method name
		String insertMethodName;
		//delete method name
		String deleteMethodName;
		//update method name;
		String updateMethodName;
		
		ImportTableInformationFromOracle itifo=new ImportTableInformationFromOracle();
		itifo.setConnectString("jdbc:oracle:thin:@172.16.4.177:1521:ORCL");
		itifo.setUserName("comprice");
		itifo.setPassword("comprice");
		TableInformation ti=itifo.GetTableInformation(tableName);
		StringBuilder sb=new StringBuilder();
		List<ColumnInformation> clist=ti.getColumnList();
		for(ColumnInformation index:clist){
			sb.append(index.getCloumnName());
			sb.append("\n");
		}
		
		String source=sb.toString();
		
		
		//create StringParsing analyze source String
		StringParsing sParsing=new StringParsing(source);
		sParsing.setSplitkey("\n");
		ReflectWrapping mRW=new ReflectWrapping(sParsing.getSouceAssembly(),sParsing.getResultAssembly());
		mRW.setId(reflectId);
		mRW.setName(reflectName);
		mRW.setPackageName(packageName);
		mRW.setClassName(className);
		mRW.setKey(reflectKey);
		String reflectString=mRW.getMapperReflectionString();
		SelectListWrapping select=new SelectListWrapping();
		InsertWrapping insert=new InsertWrapping();
		UpdateWrapping update=new UpdateWrapping();
		DeleteWrapping delete=new DeleteWrapping();
		//build select method name
		selectMethodName="select"+mRW.getClassName()+"List";
		//build insert method name
		insertMethodName="insert"+mRW.getClassName();
		//build delete method name
		deleteMethodName="delete"+mRW.getClassName()+"ById";
		//update delete method name
		updateMethodName="update"+mRW.getClassName();
		
		
		select.setMethodName(selectMethodName);
		select.setReturnType(reflectName);
		select.setTableInformation(ti);
		select.setTableName(tableName);
		
		insert.setMethodName(insertMethodName);
		insert.setTableInformation(ti);
		insert.setTableName(tableName);
		insert.setParamterType(packageName+"."+className);
		
		update.setMethodName(updateMethodName);
		update.setTableInformation(ti);
		update.setTableName(tableName);
		update.setParamterType(packageName+"."+className);
		
		delete.setMethodName(deleteMethodName);
		delete.setTableName(tableName);
		
		MapperWrapping mapperWrapping=new MapperWrapping();
		mapperWrapping.setDaoName(daoName);
		mapperWrapping.setReflectString(reflectString);
		//method string
		String methodString=select.getSelectListString()+insert.getInsertString()+update.getUpdateString()+delete.getDeleteString();
		mapperWrapping.setMethodString(methodString);
		return mapperWrapping.getMapperString();
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	

	public String getDaoName() {
		return daoName;
	}

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}
	
}
