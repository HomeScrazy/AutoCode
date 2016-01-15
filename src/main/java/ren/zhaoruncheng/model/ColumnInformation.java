package ren.zhaoruncheng.model;
/**
 * 
 * @author Holmes
 * model of column information of a table
 * now it just contain column-name and data-type  
 */
public class ColumnInformation {

	private String columnName;
	
	private String dataType;
	
	public ColumnInformation(){
		
	}
	
	public ColumnInformation(String columnName,String dataType){
		
		this.columnName=columnName;
		this.dataType=dataType;
	}

	public String getCloumnName() {
		return columnName;
	}

	public void setCloumnName(String cloumnName) {
		this.columnName = cloumnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	
}
