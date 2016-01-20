package ren.zhaoruncheng.OutputData;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class AutoCompleteMapperTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAutoComplete() {
		AutoCompleteMapper auto=new AutoCompleteMapper();
		auto.setClassName("CapitalRateRecovery");
		auto.setPackageName("com.sunyard.suncp.model.rate.");
		auto.setDaoName("com.sunyard.suncp.dao.rate.CapitalRateRecoveryDao");
		auto.setTableName("T_Capital_Rate_Recovery");
		System.out.println(auto.AutoComplete());
		fail("Not yet implemented");
	}

}
