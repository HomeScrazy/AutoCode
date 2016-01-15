package ren.zhaoruncheng.wrap;

import java.util.List;

import ren.zhaoruncheng.OutputData.CreateMapperFile;
import ren.zhaoruncheng.model.ColumnInformation;
import ren.zhaoruncheng.model.TableInformation;
import ren.zhaoruncheng.sourcedata.ImportTableInformationFromOracle;

public class CreateMappingFile {
	
	private String xmlFileName;
	
	private String xmlFilePath;
	
	private String tableName;
	

	public void createMappering() {
		// xml file name
		String name = "RiskPremiumMapper.xml";
	
		// the resultMap's id(name)
		String reflectName = "riskPremium";
		// the resultMap's primary key of object
		String reflectId = "id";
		// the resultMap's primary key of table
		String reflectKey = "id";
		// the package name mapper match
		String packageName = "com.sunyard.suncp.model.rate.";
		// the class name mapper match
		String className = "RiskPremium";

		// dao name
		String daoName = "com.sunyard.suncp.dao.rate.RiskPremiumDao";

		// =========================don't need modify====================================

		// selectMethod name
		String selectMethodName;
		// insert method name
		String insertMethodName;
		// delete method name
		String deleteMethodName;
		// update method name;
		String updateMethodName;
		//method string
		String methodString;
		String filePath = xmlFilePath + xmlFileName;
		CreateMapperFile createMapperFile = new CreateMapperFile(filePath);
		ImportTableInformationFromOracle itifo = new ImportTableInformationFromOracle();
		itifo.setConnectString("jdbc:oracle:thin:@172.16.4.177:1521:ORCL");
		itifo.setUserName("comprice");
		itifo.setPassword("comprice");
		TableInformation ti = itifo.GetTableInformation(tableName);
		StringBuilder sb = new StringBuilder();
		List<ColumnInformation> clist = ti.getColumnList();
		for (ColumnInformation index : clist) {
			sb.append(index.getCloumnName());
			sb.append("\n");
		}
		String source = sb.toString();

		// System.out.println(source);
		StringParsing sParsing = new StringParsing(source);
		sParsing.setSplitkey("\n");
		ReflectWrapping mRW = new ReflectWrapping(sParsing.getSouceAssembly(), sParsing.getResultAssembly());
		mRW.setId("id");
		mRW.setName(reflectName);
		mRW.setPackageName(packageName);
		mRW.setClassName(className);
		mRW.setKey(reflectKey);
		String reflectString = mRW.getMapperReflectionString();
		SelectListWrapping select = new SelectListWrapping();
		// build select method name
		selectMethodName = "select" + mRW.getClassName() + "list";
		// build insert method name
		insertMethodName = "insert" + mRW.getClassName();
		// build delete method name
		deleteMethodName = "delete" + mRW.getClassName() + "ById";
		// update delete method name
		updateMethodName = "updata" + mRW.getClassName();

		select.setMethodName(selectMethodName);
		select.setReturnType(reflectName);
		select.setTableInformation(ti);
		select.setTableName("T_RISK_PREMIUM");
		MapperWrapping mapperWrapping = new MapperWrapping();
		mapperWrapping.setDaoName(daoName);
		mapperWrapping.setReflectString(reflectString);
	
		createMapperFile.setMapperString(mapperWrapping.getMapperString());
		System.out.println(mapperWrapping.getMapperString());
		// createMapperFile.createMapper();
	}


	public String getXmlFileName() {
		return xmlFileName;
	}


	public void setXmlFileName(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}


	public String getXmlFilePath() {
		return xmlFilePath;
	}


	public void setXmlFilePath(String xmlFilePath) {
		this.xmlFilePath = xmlFilePath;
	}


	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
