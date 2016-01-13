package ren.zhaoruncheng.stringwrap;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ren.zhaoruncheng.sourcedata.ImportDataFromText;
import ren.zhaoruncheng.wrap.ReflectWrapping;
import ren.zhaoruncheng.wrap.StringParsing;

public class ReflectWrappingTest  {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMapperReflectionString() {
		ImportDataFromText ifdt=new ImportDataFromText();
		String source=ifdt.getStringFromFile();
		//System.out.println(source);
		StringParsing sParsing=new StringParsing(source);
		ReflectWrapping mRW=new ReflectWrapping(sParsing.getSouceAssembly(),sParsing.getResultAssembly());
		mRW.setId("risk");
		mRW.setName("id");
		mRW.setClassName("com.runcheng.stringcheck");
		System.out.println("==================result==================");
		System.out.println(mRW.getMapperReflectionString());
		fail("Not yet implemented");
	}

}
