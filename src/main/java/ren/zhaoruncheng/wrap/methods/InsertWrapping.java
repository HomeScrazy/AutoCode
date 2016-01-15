package ren.zhaoruncheng.wrap.methods;

import ren.zhaoruncheng.model.TableInformation;
import ren.zhaoruncheng.wrap.BaseWrapping;

public class InsertWrapping extends BaseWrapping{

	private String methodName;
	
	private TableInformation tableInformation;
	
	private String tableName;
	
	private String[] resultAssembly;
	
	public String getInsertString(){
		StringBuilder insert=new StringBuilder();
		insert.append("<insert id=\"");
		insert.append(methodName);
		insert.append("\">");
		insert.append(enterKey);
		insert.append(tabSize);
		insert.append("<selectKey order=\"BEFORE\" keyProperty=\"id\" resultType=\"int\">");
		insert.append(enterKey);
		insert.append(tabSize);
		insert.append(tabSize);
		insert.append("select ");
		insert.append("SEQ_");
		insert.append(tableName.toUpperCase());
		insert.append(".nextval as id from dual");
		insert.append(enterKey);
		insert.append(tabSize);
		insert.append("</selectKey>");
		insert.append(enterKey);
		insert.append(tabSize);
		insert.append("insert into ");
		insert.append(tableName.toLowerCase());
		insert.append(" values(");
		insert.append(enterKey);
		insert.append(tabSize);
		insert.append("#{id,jdbcType=INTEGER},");
		
		insert.append("</insert>");
		return insert.toString();
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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String[] getResultAssembly() {
		return resultAssembly;
	}

	public void setResultAssembly(String[] resultAssembly) {
		this.resultAssembly = resultAssembly;
	}
}
