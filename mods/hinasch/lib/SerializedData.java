//package mods.hinasch.lib;
//
//
//public class SerializedData {
//	private final String[] data;
//
//	public SerializedData(String[] data){
//		this.data = data;
//	}
//
//	public int getInteger(int n){
//		if(data.length>n){
//			return Integer.parseInt(data[n]);
//		}
//		return -1;
//	}
//
//	public float getFloat(int n){
//		if(data.length>n){
//			return Float.parseFloat(data[n]);
//		}
//		return -1;
//	}
//
//	public boolean getBoolean(int n){
//		if(data.length>n){
//			return this.getInteger(n) == -1 ? true : false;
//		}
//		return false;
//	}
//	public String getString(int n){
//		if(data.length>n){
//			return data[n];
//		}
//		return "";
//	}
//
//
//}
