package mods.hinasch.lib;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CSVTextNew {

	protected Map<Integer,String> elements;
	
	public CSVTextNew(){
		this.elements = new HashMap();
	}
	
	public <T> CSVTextNew(Collection<T> col){
		int num = 0;
		for(T elm:col){
			this.elements.put(num, elm.toString());
			num +=1;
		}
	}
	
	public <T> void addElement(T elm){
		int num = this.elements.isEmpty()? 0 : this.elements.size();
		this.elements.put(num,elm.toString());
		
	}
	
	public <T> void overrideElement(int num,T elm){
		this.elements.put(num,elm.toString());
	}
	
	public String getElement(int num){
		return this.elements.get(num);
	}
	
	public String serialize(){
		String ser = "";
		if(this.elements.isEmpty()){
			return ser;
		}
		for(String str:this.elements.values()){
			ser += ("," + str);
		}
		return ser;
	}
	
	public int search(String key){
		int num = 0;
		for(String str:this.elements.values()){
			if(str.equals(key)){
				return num;
			}
			num += 1;
		}
		return -1;
	}
}
