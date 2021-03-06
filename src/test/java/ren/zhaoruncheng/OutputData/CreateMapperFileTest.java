package ren.zhaoruncheng.OutputData;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ren.zhaoruncheng.model.ColumnInformation;
import ren.zhaoruncheng.model.TableInformation;
import ren.zhaoruncheng.sourcedata.ImportTableInformationFromOracle;
import ren.zhaoruncheng.wrap.MapperWrapping;
import ren.zhaoruncheng.wrap.ReflectWrapping;
import ren.zhaoruncheng.wrap.SelectListWrapping;
import ren.zhaoruncheng.wrap.StringParsing;
import ren.zhaoruncheng.wrap.methods.DeleteWrapping;
import ren.zhaoruncheng.wrap.methods.InsertWrapping;
import ren.zhaoruncheng.wrap.methods.UpdateWrapping;
/**
 * use it to create mapper file
 */
public class CreateMapperFileTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateMapper() {
		//xml file name
		String name="CapitalRateRecoveryMapper.xml";
		// the table name of database
		String tableName="T_Capital_Rate_Recovery";
		// the resultMap's id(name)
		String reflectName="capitalraterecovery";
		//the resultMap's primary key of object
		String reflectId="id";
		//the resultMap's primary key of table
		String reflectKey="id";
		//the package name mapper match
		String packageName="com.sunyard.suncp.model.rate.";
		//the class name mapper match
		String className="CapitalRateRecovery";
		
		//dao name
		String daoName="com.sunyard.suncp.dao.rate.CapitalRateRecoveryDao";

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//=========================don't need modify====================================
		
		//selectMethod name
		String selectMethodName;
		//insert method name
		String insertMethodName;
		//delete method name
		String deleteMethodName;
		//update method name;
		String updateMethodName;
		
		String path="E:\\Runcheng\\sunyard_developer\\workspaces\\ee\\SunCP\\src\\mapper\\";
		String filePath=path+name;
		CreateMapperFile createMapperFile=new CreateMapperFile(filePath);
		ImportTableInformationFromOracle itifo=new ImportTableInformationFromOracle();
		itifo.setConnectString("jdbc:oracle:thin:@172.16.4.177:1521:ORCL");
		itifo.setUserName("comprice");
		itifo.setPassword("comprice");
		TableInformation ti=itifo.GetTableInformation(tableName);
		StringBuilder sb=new StringBuilder();
		List<ColumnInformation> clist=ti.getColumnList();
		for(ColumnInformation index:clist){
			sb.append(index.getCloumnName());
			sb.append("\n");
		}
		
		String source=sb.toString();
		

		//System.out.println(source);
		StringParsing sParsing=new StringParsing(source);
		sParsing.setSplitkey("\n");
		ReflectWrapping mRW=new ReflectWrapping(sParsing.getSouceAssembly(),sParsing.getResultAssembly());
		mRW.setId(reflectId);
		mRW.setName(reflectName);
		mRW.setPackageName(packageName);
		mRW.setClassName(className);
		mRW.setKey(reflectKey);
		String reflectString=mRW.getMapperReflectionString();
		SelectListWrapping select=new SelectListWrapping();
		InsertWrapping insert=new InsertWrapping();
		UpdateWrapping update=new UpdateWrapping();
		DeleteWrapping delete=new DeleteWrapping();
		//build select method name
		selectMethodName="select"+mRW.getClassName()+"List";
		//build insert method name
		insertMethodName="insert"+mRW.getClassName();
		//build delete method name
		deleteMethodName="delete"+mRW.getClassName()+"ById";
		//update delete method name
		updateMethodName="update"+mRW.getClassName();
		
		
		select.setMethodName(selectMethodName);
		select.setReturnType(reflectName);
		select.setTableInformation(ti);
		select.setTableName(tableName);
		
		insert.setMethodName(insertMethodName);
		insert.setTableInformation(ti);
		insert.setTableName(tableName);
		insert.setParamterType(packageName+className);
		
		update.setMethodName(updateMethodName);
		update.setTableInformation(ti);
		update.setTableName(tableName);
		update.setParamterType(packageName+className);
		
		delete.setMethodName(deleteMethodName);
		delete.setTableName(tableName);
		
		MapperWrapping mapperWrapping=new MapperWrapping();
		mapperWrapping.setDaoName(daoName);
		mapperWrapping.setReflectString(reflectString);
		//method string
		String methodString=select.getSelectListString()+insert.getInsertString()+update.getUpdateString()+delete.getDeleteString();
		mapperWrapping.setMethodString(methodString);
		createMapperFile.setMapperString(mapperWrapping.getMapperString());
		//System.out.println(mapperWrapping.getMapperString());
		createMapperFile.createMapper();
		fail("Not yet implemented");
	}

}
