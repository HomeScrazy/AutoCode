package ren.zhaoruncheng.model;

import java.util.List;

/**
 * 
 * @author Holmes
 *
 *	model of information of a table form databases
 *	now it just contain the list of column
 */
public class TableInformation {

	private List<ColumnInformation> columnList;
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("table information ");
		sb.append("\n");
		for(ColumnInformation index:columnList){
			sb.append("column name :");
			sb.append(index.getCloumnName());
			sb.append("  data type :");
			sb.append(index.getDataType());
			sb.append("\n");
		}
		return sb.toString();
	}
	public TableInformation(){
		
	}
	
	public TableInformation(List<ColumnInformation> columnList){
		this.columnList=columnList;
	}

	public List<ColumnInformation> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<ColumnInformation> columnList) {
		this.columnList = columnList;
	}
	
	
}
