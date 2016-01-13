package ren.zhaoruncheng.wrap;
/**
 * 
 * @author crazy
 *
 * this class is used to parsing string 
 * 
 * The string is composing of some value-string,prefix,suffix,space,split string and enter key,
 * value-string is a assembly of useful string and the others is useless,
 * the task of this is to remove the useless string and assemble the useful message into an array.
 */

public class StringParsing{
	
	private String prefix;
	
	private String suffix;
	
	private String splitkey;
	
	private String source;
	
	public String[] getResultAssembly(){
		String[] resultAssembly=null;
		if(splitkey!=null) resultAssembly=source.split(splitkey);else resultAssembly=source.split("\r\n");
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
	
	public String[] getSouceAssembly() {
		String[] resultAssembly = null;
		if(source!=null){
			if(splitkey!=null) resultAssembly=source.split(splitkey);else resultAssembly=source.split("\r\n");
			for(int i=0;i<resultAssembly.length;i++){
				resultAssembly[i]=resultAssembly[i].trim();
			}
		}
		return resultAssembly;
	}

	
	
	
	
	//============================common method============================
	public StringParsing(){
		
	}
	
	public StringParsing(String source){
		this.source=source;
	}
	public StringParsing(String source,String prefix,String suffix){
		this.source=source;
		this.prefix=prefix;
		this.suffix=suffix;
	}
	
	public StringParsing(String source,String prefix,String suffix,String splitkey){
		this.source=source;
		this.prefix=prefix;
		this.suffix=suffix;
		this.splitkey=splitkey;
	}
	
	public String getSplitkey() {
		return splitkey;
	}
	public void setSplitkey(String splitkey) {
		this.splitkey = splitkey;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getSource(){
		return source;
	}
	
	public void setSource(String source){
		this.source=source;
	}
	

	
}
