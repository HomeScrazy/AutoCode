package ren.zhaoruncheng.sourcedata;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ren.zhaoruncheng.model.TableInformation;

public class ImportTableInformationFromOracleTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetTableInformation() {
		
		ImportTableInformationFromOracle itifo=new ImportTableInformationFromOracle();
		itifo.setConnectString("jdbc:oracle:thin:@172.16.4.177:1521:ORCL");
		itifo.setUserName("comprice");
		itifo.setPassword("comprice");
		TableInformation ti=itifo.GetTableInformation("T_SYS_RATE");
		System.out.println(ti.toString());
		fail("Not yet implemented");
	}

}
