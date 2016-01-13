package ren.zhaoruncheng.wrap;

/**
 * 
 * @author crazy
 *
 *this class is to wrap some string method such as replace chars.
 */
public abstract class StringChecking {
	
	public static String propertyTransformFormDatabaseToObject(String source){
		/*
		 * Transform format form A_B to aB
		 * the first and the last char cannot be '_'
		 */
		source=source.toLowerCase();
		String[] result=source.split("_");
		for(int i=1;i<result.length;i++) result[i]=firstCharUpCase(result[i]);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<result.length;i++){
			sb.append(result[i]);
		}
		return sb.toString();
	}
	
	public static String firstCharUpCase(String source){
		/*
		 * upcase the first char of every single word
		 * "getname" to "getName"
		 */
		StringBuffer sb=new StringBuffer(source);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.toString();
	}

}
