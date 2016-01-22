package ren.zhaoruncheng.OutputData;

import java.util.Scanner;

import ren.zhaoruncheng.wrap.DaoLayerWrapping;
import ren.zhaoruncheng.wrap.StringChecking;

public class AutoCreateFile {
	
	
	public static void Main(String[] args){
		AutoCreateFile test=new AutoCreateFile();
		test.AutoCreate();
	}
	
	private CreateMapperFile createMapperFile=new CreateMapperFile();
	
	
	public void AutoCreate(){
		/**
		 * input table name
		 * output dao file and mapper file
		 * you need to modify the package in mapper and dao
		 */
		Scanner scan=new Scanner(System.in);
		System.out.println("please input table name");
		String tableName=scan.nextLine();
		String packageName="modelpackage";
		String className=StringChecking.propertyTransformFormDatabaseToObject(tableName.substring(2));
		className=className.substring(0,1).toUpperCase()+className.substring(1);
		String daoPackage="daoPackageName";
		String daoName=className+"Dao";
		AutoCompleteMapper aotoCompleteMapper=new AutoCompleteMapper();
		aotoCompleteMapper.setClassName(className);
		aotoCompleteMapper.setPackageName(packageName);
		aotoCompleteMapper.setDaoName(daoPackage+"."+daoName);
		aotoCompleteMapper.setTableName(tableName);
		String mapperName=className+"Mappering.xml";
		createMapperFile.setFilePath("E:\\Runcheng\\tools\\AutoCode\\autofile\\java\\mapper\\"+mapperName);
		createMapperFile.setMapperString(aotoCompleteMapper.AutoComplete());
		createMapperFile.createMapper();
		String daolayer=className+"Dao.java";
		DaoLayerWrapping daoWrap=new DaoLayerWrapping();
		daoWrap.setClassName(className);
		daoWrap.setPaceageName(daoPackage);
		createMapperFile.setFilePath("E:\\Runcheng\\tools\\AutoCode\\autofile\\java\\dao\\"+daolayer);
		createMapperFile.setMapperString(daoWrap.getDaoWrappintString());
		createMapperFile.createMapper();
		System.out.println("complete!");
		
	}
	
	
}
