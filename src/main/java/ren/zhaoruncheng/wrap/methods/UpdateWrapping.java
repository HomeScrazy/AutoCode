package ren.zhaoruncheng.wrap.methods;
/**
 * update method wrapping 
 * now the id of table and object is fixed with "id"
 */
import java.util.List;

import ren.zhaoruncheng.model.ColumnInformation;
import ren.zhaoruncheng.model.TableInformation;
import ren.zhaoruncheng.wrap.BaseWrapping;
import ren.zhaoruncheng.wrap.StringChecking;

public class UpdateWrapping extends BaseWrapping{

	private String methodName;
	
	private TableInformation tableInformation;
	
	private String tableName;
	
	private String paramterType;
	
	public String getUpdateString(){
		StringBuilder update=new StringBuilder();
		update.append("<update id=\"");
		update.append(methodName);
		update.append("\" parameterType=\"");
		update.append(paramterType);
		update.append("\">");
		update.append(enterKey);
		update.append(tabSize);
		update.append("update ");
		update.append(tableName.toLowerCase());
		update.append(" set ");
		update.append(enterKey);
		update.append(tabSize);
		List<ColumnInformation> clist=tableInformation.getColumnList();
		int k=0;
		for(int i=0;i<clist.size();i++){
			if(clist.get(i).getCloumnName().toLowerCase().equals("id")) continue;
			if(k!=0) {
				update.append(",");
				update.append(enterKey);
				update.append(tabSize);
			}
			update.append(clist.get(i).getCloumnName().toLowerCase());
			update.append("=#{");
			update.append(StringChecking.propertyTransformFormDatabaseToObject(clist.get(i).getCloumnName()));
			update.append(",jdbcType=");
			ColumnInformation c=clist.get(i);
			if(c.getDataType().equals("VARCHAR2")) update.append("VARCHAR");
			else update.append(c.getDataType());
			update.append("}");
			k++;
			
		}
		update.append(enterKey);
		update.append(tabSize);
		update.append("where id=#{id,jdbcType=INTEGER}");
		update.append(enterKey);
		update.append("</update>");
		update.append(enterKey);
		return update.toString();
		
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

	public String getParamterType() {
		return paramterType;
	}

	public void setParamterType(String paramterType) {
		this.paramterType = paramterType;
	}
}
