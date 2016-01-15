package ren.zhaoruncheng.sourcedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ren.zhaoruncheng.model.ColumnInformation;
import ren.zhaoruncheng.model.TableInformation;

/**
 * 
 * @author Holmes
 * get information form oracle
 * 
 */
public class ImportTableInformationFromOracle {
	
	private String connectString;
	
	private String userName;
	
	private String password;
	
	public TableInformation GetTableInformation(String tableName){
		TableInformation tableInformation=new TableInformation();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection(connectString, userName, password);
			Statement stmt=conn.createStatement();
			StringBuilder sb=new StringBuilder();
			sb.append("SELECT * ");
			sb.append("FROM ALL_TAB_COLUMNS AAA where ");
			sb.append("AAA.TABLE_NAME='");
			sb.append(tableName.toUpperCase());
			sb.append("'");
			ResultSet rs=stmt.executeQuery(sb.toString());
			List<ColumnInformation> cList=new ArrayList<ColumnInformation>();
			while(rs.next()){
				ColumnInformation columInformation=new ColumnInformation(rs.getString("COLUMN_NAME"),rs.getString("DATA_TYPE"));
				cList.add(columInformation);
			}
			tableInformation.setColumnList(cList);
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tableInformation;
	}
	
	public ImportTableInformationFromOracle(String con){
		this.connectString=con;
	}
	
	public ImportTableInformationFromOracle(String con,String user,String pwd){
		this.connectString=con;
		this.userName=user;
		this.password=pwd;
	}
	public ImportTableInformationFromOracle(){
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getConnectString() {
		return connectString;
	}

	public void setConnectString(String connectString) {
		this.connectString = connectString;
	}
}
