package ren.zhaoruncheng.stringcheck;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class StringParsingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetResultAssembly() {
		String source="   pre142341654suf\r\n pre142341654suf  \r\n  pre142341654suf \r\n  pre142341654suf";
		System.out.println(source);
		System.out.println("==================result==================");
		StringParsing sParsing=new StringParsing(source,"pre","suf");
		String[] result=sParsing.getResultAssembly();
		for(int i=0;i<result.length;i++)
		System.out.println(result[i]);
			
	}

}
