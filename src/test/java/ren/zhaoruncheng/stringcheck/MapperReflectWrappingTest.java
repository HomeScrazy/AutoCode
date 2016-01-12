package ren.zhaoruncheng.stringcheck;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MapperReflectWrappingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMapperReflectionString() {
		String source="   pre142341654suf\r\n pre142341654suf  \r\n  pre142341654suf \r\n  pre142341654suf";
		System.out.println(source);
		StringParsing sParsing=new StringParsing(source,"pre","suf");
		MapperReflectWrapping mRW=new MapperReflectWrapping(sParsing.getSouceAssembly(),sParsing.getResultAssembly());
		System.out.println("==================result==================");
		System.out.println(mRW.getMapperReflectionString());
		fail("Not yet implemented");
	}

}
