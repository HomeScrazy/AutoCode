package ren.zhaoruncheng.wrap.methods;
/**
 * insert method wrapping 
 * now the id of table and object is fixed "id"
 */
import ren.zhaoruncheng.model.ColumnInformation;
import ren.zhaoruncheng.model.TableInformation;
import ren.zhaoruncheng.wrap.BaseWrapping;
import ren.zhaoruncheng.wrap.StringChecking;

public class InsertWrapping extends BaseWrapping{

	private String methodName;
	
	private TableInformation tableInformation;
	
	private String tableName;
	
	private String paramterType;
	
	
	public String getInsertString(){
		StringBuilder insert=new StringBuilder();
		insert.append(enterKey);
		insert.append("<insert id=\"");
		insert.append(methodName);
		insert.append("\" parameterType=\"");
		insert.append(paramterType);
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
		insert.append(enterKey);
		insert.append(tabSize);
		int i=0;
		for(ColumnInformation index:tableInformation.getColumnList()){
			if(i!=0) {
				insert.append(",");
				insert.append(enterKey);
				insert.append(tabSize);
			}
			if(index.getCloumnName().toLowerCase().equals("id")) continue;
			insert.append("#{");
			insert.append(StringChecking.propertyTransformFormDatabaseToObject(index.getCloumnName()));
			insert.append(",jdbcType=");
			if(index.getDataType().equals("VARCHAR2"))
			insert.append("VARCHAR");
			else insert.append(index.getDataType());
			insert.append("}");
			i++;
		}
		insert.append(")");
		insert.append(enterKey);
		insert.append("</insert>");
		insert.append(enterKey);
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

	public String getParamterType() {
		return paramterType;
	}

	public void setParamterType(String paramterType) {
		this.paramterType = paramterType;
	}

	
}
