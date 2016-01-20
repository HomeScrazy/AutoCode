package ren.zhaoruncheng.extjs.wrap;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import ren.zhaoruncheng.model.TableInformation;
import ren.zhaoruncheng.sourcedata.ImportTableInformationFromOracle;

public class ModelWrappingTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExtjsModelWarppingString() {
		ModelWrapping modelWrapping=new ModelWrapping();
		modelWrapping.setPackageName("suncp.model.rate");
		ImportTableInformationFromOracle itifo=new ImportTableInformationFromOracle();
		itifo.setConnectString("jdbc:oracle:thin:@172.16.4.177:1521:ORCL");
		itifo.setUserName("comprice");
		itifo.setPassword("comprice");
		TableInformation ti=itifo.GetTableInformation("T_RISK_PREMIUM");
		modelWrapping.setTableInformation(ti);
		modelWrapping.setModelName("RiskPremiumModel");
		System.out.println(modelWrapping.extjsModelWarppingString());
		fail("Not yet implemented");
	}

}
