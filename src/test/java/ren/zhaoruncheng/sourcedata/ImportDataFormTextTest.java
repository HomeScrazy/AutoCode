package ren.zhaoruncheng.sourcedata;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ImportDataFormTextTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetStringFromFile() {
		ImportDataFromText ifdt=new ImportDataFromText();
		System.out.println(ifdt.getStringFromFile());
		fail("Not yet implemented");
	}

}
