package ren.zhaoruncheng.OutputData;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class AutoCreateFileTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAutoCreate() {
		AutoCreateFile atuo=new AutoCreateFile();
		atuo.AutoCreate();
		fail("Not yet implemented");
	}

}
