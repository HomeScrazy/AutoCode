package ren.zhaoruncheng.stringwrap;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ren.zhaoruncheng.sourcedata.ImportDataFromText;
import ren.zhaoruncheng.wrap.MapperReflectWrapping;
import ren.zhaoruncheng.wrap.StringParsing;

public class MapperReflectWrappingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMapperReflectionString() {
		ImportDataFromText ifdt=new ImportDataFromText();
		String source=ifdt.getStringFromFile();
		System.out.println(source);
		StringParsing sParsing=new StringParsing(source);
		MapperReflectWrapping mRW=new MapperReflectWrapping(sParsing.getSouceAssembly(),sParsing.getResultAssembly());
		mRW.setId("pre142341655");
		mRW.setName("Test");
		mRW.setClassName("com.runcheng.stringcheck");
		System.out.println("==================result==================");
		System.out.println(mRW.getMapperReflectionString());
		fail("Not yet implemented");
	}

}
