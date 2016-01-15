package ren.zhaoruncheng.wrap.methods;

import ren.zhaoruncheng.wrap.BaseWrapping;

public class DeleteWrapping extends BaseWrapping{
	
	private String methodName;
	private String tableName;
	
	public String getDeleteString(){
		StringBuilder delete=new StringBuilder();
		delete.append("<delete id=\"");
		delete.append(methodName);
		delete.append("\" parameterType=\"");
		delete.append("java.lang.Integer");
		delete.append("\">");
		delete.append(enterKey);
		delete.append(tabSize);
		delete.append("delete ");
		delete.append(tableName.toLowerCase());
		delete.append(" where id=#{id,jdbcType=INTEGER}");
		delete.append(enterKey);
		delete.append("</delete>");
		delete.append(enterKey);
		return delete.toString();
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
