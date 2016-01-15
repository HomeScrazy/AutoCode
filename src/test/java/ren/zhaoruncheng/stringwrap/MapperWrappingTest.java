package ren.zhaoruncheng.stringwrap;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ren.zhaoruncheng.model.ColumnInformation;
import ren.zhaoruncheng.model.TableInformation;
import ren.zhaoruncheng.sourcedata.ImportTableInformationFromOracle;
import ren.zhaoruncheng.wrap.MapperWrapping;
import ren.zhaoruncheng.wrap.ReflectWrapping;
import ren.zhaoruncheng.wrap.StringParsing;

public class MapperWrappingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMapperString() {
		
		ImportTableInformationFromOracle itifo=new ImportTableInformationFromOracle();
		itifo.setConnectString("jdbc:oracle:thin:@172.16.4.177:1521:ORCL");
		itifo.setUserName("comprice");
		itifo.setPassword("comprice");
		TableInformation ti=itifo.GetTableInformation("T_SYS_RATE");
		StringBuilder sb=new StringBuilder();
		List<ColumnInformation> clist=ti.getColumnList();
		for(ColumnInformation index:clist){
			sb.append(index.getCloumnName());
			sb.append("\n");
		}
		
		String source=sb.toString();
		System.out.println(source);
		StringParsing sParsing=new StringParsing(source);
		sParsing.setSplitkey("\n");
		ReflectWrapping mRW=new ReflectWrapping(sParsing.getSouceAssembly(),sParsing.getResultAssembly());
		mRW.setId("id");
		mRW.setName("capitalraterecovery");
		mRW.setClassName("com.sunyard.suncp.model.rate.CapitalRateRecovery");
		mRW.setKey("id");
		String reflectString=mRW.getMapperReflectionString();
		
		MapperWrapping mapperWrapping=new MapperWrapping();
		mapperWrapping.setDaoName("com.sunyard.suncp.dao.rate.CapitalRateRecoveryDao");
		mapperWrapping.setReflectString(reflectString);
		System.out.println(mapperWrapping.getMapperString());
		fail("Not yet implemented");
	}

}
