package ren.zhaoruncheng.stringwrap;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ren.zhaoruncheng.wrap.DaoLayerWrapping;

public class DaoLayerWrappingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDaoWrappintString() {
		DaoLayerWrapping daoLayerWrapping=new DaoLayerWrapping();
		daoLayerWrapping.setClassName("RiskPremium");
		daoLayerWrapping.setPaceageName("com.sunyard.suncp.dao.rate");
		System.out.println(daoLayerWrapping.getDaoWrappintString());
		fail("Not yet implemented");
	}

}
