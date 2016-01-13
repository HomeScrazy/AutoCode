package ren.zhaoruncheng.wrap;
/**
 * 
 * @author crazy
 * wrapping source string with bean format.
 */

public class BeanWrapping extends BaseWrapping {
	
	private String[] porpertyAssembly;
	
	private String beanName;
	
	public String getBeanString(){
		/**
		 * wrapping source string with bean format.
		 * return the bean string
		 */
		StringBuilder sb=new StringBuilder();
		if(beanName==null) return null;
		sb.append("public class ");
		sb.append(beanName);
		sb.append("{");
		sb.append(enterKey);
		sb.append(tabSize);
		for(int i=0;i<porpertyAssembly.length;i++){
			
		}
		
		sb.append("}");
		return sb.toString();
	}

	
	
	public BeanWrapping(String beanName){
		this.beanName=beanName;
	}
	
	public BeanWrapping(){
		
	}
	public String[] getPorpertyAssembly() {
		return porpertyAssembly;
	}

	public void setPorpertyAssembly(String[] porpertyAssembly) {
		this.porpertyAssembly = porpertyAssembly;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	
}
