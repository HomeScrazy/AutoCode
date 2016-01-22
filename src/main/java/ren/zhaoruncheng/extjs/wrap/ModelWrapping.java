package ren.zhaoruncheng.extjs.wrap;

import ren.zhaoruncheng.model.ColumnInformation;
import ren.zhaoruncheng.model.TableInformation;
import ren.zhaoruncheng.wrap.BaseWrapping;
import ren.zhaoruncheng.wrap.StringChecking;

/**
 * 
 * @author Holmes
 * warpping the table information with Extjs model format
 * input: table information
 */
public class ModelWrapping extends BaseWrapping{
	private TableInformation tableInformation;
	
	private String packageName;
	
	private String modelName;
	
	public String extjsModelWarppingString(){
		StringBuilder extjs=new StringBuilder();
		extjs.append("Ext.define('");
		extjs.append(packageName);
		extjs.append(".");
		extjs.append(modelName);
		extjs.append("',{");
		extjs.append(enterKey);
		extjs.append(tabSize);
		extjs.append("extend:'Ext.data.Model',");
		extjs.append(enterKey);
		extjs.append(tabSize);
		extjs.append("fields:[");
		for(ColumnInformation index:tableInformation.getColumnList()){
			extjs.append(enterKey);
			extjs.append(tabSize);
			extjs.append(tabSize);
			extjs.append("{name:'");
			extjs.append(StringChecking.propertyTransformFormDatabaseToObject(index.getCloumnName()));
			extjs.append("'},");
		}
		extjs.append(enterKey);
		extjs.append(tabSize);
		extjs.append("]");
		extjs.append("})");
		return extjs.toString();
	}

	public TableInformation getTableInformation() {
		return tableInformation;
	}

	public void setTableInformation(TableInformation tableInformation) {
		this.tableInformation = tableInformation;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public String getModelName(){
		return modelName;
	}
	
	public void setModelName(String modelName){
		this.modelName=modelName;
	}
}
