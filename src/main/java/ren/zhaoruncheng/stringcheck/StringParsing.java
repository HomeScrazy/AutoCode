/*
 * this class is used to parsing string 
 * 
 * The string is composing of some value-string,prefix,suffix,space and enter key,
 * value-string is a assembly of useful string and the others is useless,
 * the task of this is to remove the useless string and assemble the useful message into an arraylist
 */
package ren.zhaoruncheng.stringcheck;


public abstract class StringParsing {
	
	public static String[] getResultAssembly(String sourceString,String prefix,String suffix){
		String[] resultAssembly=sourceString.split("\r\n");
		int preLength,sufLength,i;
		for(i=0;i<resultAssembly.length;i++){
			resultAssembly[i]=resultAssembly[i].trim();
		}
		if(prefix!=null){
			preLength=prefix.length();
			for(i=0;i<resultAssembly.length;i++){
				resultAssembly[i]=resultAssembly[i].substring(preLength);
			}
		}
		if(suffix!=null) {
			sufLength=suffix.length();
			for(i=0;i<resultAssembly.length;i++){
				resultAssembly[i]=resultAssembly[i].substring(0,resultAssembly[i].length()-sufLength);
			}
		}
		return resultAssembly;
		
	}
	
}
