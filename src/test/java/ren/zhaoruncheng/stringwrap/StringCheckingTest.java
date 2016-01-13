package ren.zhaoruncheng.stringwrap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ren.zhaoruncheng.wrap.StringChecking;

public class StringCheckingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPropertyTransformFormDatabaseToObject() {
		
		String source="AEGEG_VEGFEFG_sregfe";
		System.out.println(StringChecking.propertyTransformFormDatabaseToObject(source));
		fail("Not yet implemented");
	}

}
