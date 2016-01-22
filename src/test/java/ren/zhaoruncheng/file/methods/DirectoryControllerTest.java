package ren.zhaoruncheng.file.methods;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class DirectoryControllerTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCopyFiles() {
		File copy=new File("E:\\Runcheng\\tools\\AutoCode\\autofile\\template");
		File paste=new File("E:\\Runcheng\\tools\\AutoCode\\autofile\\result");
		FileCopyInterface copyTools=new DirectoryController();
		copyTools.copyFiles(copy, paste);
		System.out.println("complete");
		fail("Not yet implemented");
	}

}
