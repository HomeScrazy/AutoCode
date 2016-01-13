package ren.zhaoruncheng.stringwrap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ren.zhaoruncheng.wrap.MapperReflectWrapping;
import ren.zhaoruncheng.wrap.StringParsing;

public class MapperReflectWrappingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMapperReflectionString() {
		String source="   pre142341655suf\r\n pre142341654suf  \r\n  pre142341654suf \r\n  pre142341654suf";
		System.out.println(source);
		StringParsing sParsing=new StringParsing(source,"pre","suf");
		MapperReflectWrapping mRW=new MapperReflectWrapping(sParsing.getSouceAssembly(),sParsing.getResultAssembly());
		mRW.setId("pre142341655");
		mRW.setName("Test");
		mRW.setClassName("com.runcheng.stringcheck");
		System.out.println("==================result==================");
		System.out.println(mRW.getMapperReflectionString());
		fail("Not yet implemented");
	}

}
