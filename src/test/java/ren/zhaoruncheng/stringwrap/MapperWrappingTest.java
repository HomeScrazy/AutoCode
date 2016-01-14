package ren.zhaoruncheng.stringwrap;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ren.zhaoruncheng.sourcedata.ImportDataFromText;
import ren.zhaoruncheng.wrap.MapperWrapping;
import ren.zhaoruncheng.wrap.ReflectWrapping;
import ren.zhaoruncheng.wrap.StringParsing;

public class MapperWrappingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMapperString() {
		
		ImportDataFromText ifdt=new ImportDataFromText();
		String source=ifdt.getStringFromFile();
		//System.out.println(source);
		StringParsing sParsing=new StringParsing(source);
		ReflectWrapping mRW=new ReflectWrapping(sParsing.getSouceAssembly(),sParsing.getResultAssembly());
		mRW.setId("id");
		mRW.setName("capitalraterecovery");
		mRW.setClassName("com.sunyard.suncp.model.rate.CapitalRateRecovery");
		mRW.setKey("id");
		String reflectString=mRW.getMapperReflectionString();
		
		MapperWrapping mapperWrapping=new MapperWrapping();
		mapperWrapping.setDaoName("com.sunyard.suncp.dao.rate.CapitalRateRecoveryDao");
		mapperWrapping.setReflectString(reflectString);
		System.out.println(mapperWrapping.getMapperString());
		fail("Not yet implemented");
	}

}
