package ren.zhaoruncheng.wrap;
/**
 * auto-complete dao layer's code
 * the default primary key is "id"
 * include insert,delete,update,select method
 */
import java.util.List;

public class DaoLayerWrapping extends BaseWrapping{

	private String className;
	
	
	private String packageName;
	
	
	
	public String getDaoWrappintString(){
		StringBuilder dao=new StringBuilder();
		dao.append("public interface ");
		dao.append(className+"Dao");
		dao.append("{");
		dao.append(enterKey);
		dao.append(tabSize);
		dao.append("public void insert");
		dao.append(className);
		dao.append("(");
		dao.append(className);
		dao.append(" ");
		dao.append(className.substring(0, 1).toLowerCase()+className.substring(1));
		dao.append(");");
		dao.append(enterKey);
		dao.append(tabSize);
		dao.append("public List<");
		dao.append(className);
		dao.append("> ");
		dao.append("select");
		dao.append(className);
		dao.append("List");
		dao.append("();");
		dao.append(enterKey);
		dao.append(tabSize);
		dao.append("public void ");
		dao.append("update");
		dao.append(className);
		dao.append("(");
		dao.append(className);
		dao.append(" ");
		dao.append(className.substring(0, 1).toLowerCase()+className.substring(1));
		dao.append(");");
		dao.append(enterKey);
		dao.append(tabSize);
		dao.append("public void ");
		dao.append("delete");
		dao.append(className);
		dao.append("ById(");
		dao.append("Integer id);");
		dao.append(enterKey);
		dao.append(tabSize);
		dao.append("}");
		return dao.toString();
	}

	



	public String getPaceageName() {
		return packageName;
	}

	public void setPaceageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
