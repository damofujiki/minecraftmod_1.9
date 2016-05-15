package mods.hinasch.lib;


@Deprecated
public class CSVAndProp extends CSVTextNew{

	public  void addKeyAndProp(String key,String prop){
		String str = key + ":"  + prop;
		this.addElement(str);
	}

	public  void setKeyAndProp(Integer num,String key,String prop){
		String str = key + ":"  + prop;
		this.overrideElement(num, str);
	}

	public String getKey(int num){
		String str = this.elements.get(num);
		if(str.contains(":")){
			return str.split(":")[0];
		}
		return null;
	}

	public String getProp(int num){
		String str = this.elements.get(num);
		if(str.contains(":")){
			return str.split(":")[1];
		}
		return null;
	}
}
