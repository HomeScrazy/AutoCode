package ren.zhaoruncheng.wrap;

import ren.zhaoruncheng.model.ColumnInformation;
import ren.zhaoruncheng.model.TableInformation;

/**
 * 
 * @author Holmes
 *  get bean list form database 
 */
public class SelectListWrapping extends BaseWrapping {
	
	private String methodName;
	
	private TableInformation tableInformation;
	
	private String returnType;
	
	private String tableName;
	
	public String getSelectListString(){
		StringBuilder select=new StringBuilder();
		select.append("<select id=\"");
		select.append(methodName);
		select.append("\" resultMap=\"");
		select.append(returnType);
		select.append("\">");
		select.append(enterKey);
		select.append(tabSize);
		select.append("select ");
		for(ColumnInformation index:tableInformation.getColumnList()){
			select.append(index.getCloumnName().toLowerCase());
			select.append(" ");
		}
		select.append("from ");
		select.append(tableName.toLowerCase());
		select.append(enterKey);
		select.append("</select>");
		return select.toString();
	}


	public String getMethodName() {
		return methodName;
	}


	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}



	public TableInformation getTableInformation() {
		return tableInformation;
	}


	public void setTableInformation(TableInformation tableInformation) {
		this.tableInformation = tableInformation;
	}


	public String getReturnType() {
		return returnType;
	}


	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	public void setTableName(String tableName){
		this.tableName=tableName;
	}
	
	public String getTableName(){
		return tableName;
	}
}
