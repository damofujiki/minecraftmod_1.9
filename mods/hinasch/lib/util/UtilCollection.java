package mods.hinasch.lib.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mods.hinasch.lib.CSVText;

@Deprecated
public class UtilCollection<T> {




	@Deprecated
	public static <T> List<T> getListExceptList(List<T> baselist,List<T> list){
		List<T> output = baselist;
		for(T i:list){
			if(output.contains(i))output.remove(i);
		}
		return output;
	}

	/**
	 * リストの交わる部分を除いたリストを返す。
	 * @param input1
	 * @param input2
	 * @return
	 */
	public static <T> List<T> getExceptIntersections(List<T> input1,List<T> input2){
		List<T> output = new ArrayList();
		for(T in:input1){
			if(!input2.contains(in)){
				output.add(in);
			}
		}
		return output;
	}

//	/**
//	 * 直列化したテキストのリストを得る。ISerializableHSをつける必要ある
//	 * @param col
//	 * @return
//	 */
//	public static List<String> getSerializedList(Collection<? extends ISerializableHS> col){
//		List<String> output = new ArrayList();
//		for(ISerializableHS elm:col){
//			output.add(elm.getSerialized());
//		}
//		return output;
//	}
	public static String mapToCSV(Map map){
		StringBuilder output = new StringBuilder("");
		for(Iterator<String> ite=map.keySet().iterator();ite.hasNext();){
			String key = ite.next().toString();
			String value = map.get(key).toString();
			String mapstr = key+":"+value;
			output.append(mapstr);
			if(ite.hasNext()){
				output.append(",");
			}

		}
		return new String(output);
	}

	public static Map CSVToMap(String csv){
		HashMap<String,String> output = new HashMap();
		List<String> lists = CSVText.csvToStrList(csv);
		for(String str:lists){
			if(str.contains(":")){
				String[] keymap = str.split(":");
				output.put(keymap[0], keymap[1]);
			}else{
				output.put(str, "");
			}
		}
		return output;
	}
//
//	public static HashMap<String,Integer> getSortedHashMap(HashMap<String,Integer> sample){
//		HashMap<String,Integer> = new HashMap();
//		Integer pick = null;
//		ArrayList<Integer> list = new ArrayList();
//		for(Integer i:sample.values()){
//			if(pick==null){
//				pick = i;
//			}
//		}
//	}
//
//	public static int[] sort(int[] intlist){
//		int[] newlist = intlist;
//		boolean flag = false;
//		for(int i=0;i<intlist.length;i++){
//			if(i+1<intlist.length){
//				if(intlist[i]>intlist[i+1]){
//					newlist[i] = intlist[i+1];
//					newlist[i+1] = intlist[i];
//					flag = true;
//				}
//			}
//		}
//		return flag ? sort(newlist) : newlist;
//	}

	/**
	 *
	 * @param list1
	 * @param list2がlist1のいずれかを含む場合true.
	 * @return
	 */
	public static <T> boolean intersect(Collection<T> list1,Collection<T> list2){
		boolean sw = false;
		for(T elm:list1){
			if(list2.contains(elm)){
				sw = true;
			}

		}
		return sw;
	}

	/**
	 *
	 * @param a が含まれるかどうか
	 * @param collection
	 * @return
	 */
	public static <T> boolean collectionContains(T a,Collection<T> collection){
		boolean useEqual = false;
		if(a instanceof String){
			useEqual = true;
		}
		boolean flag = false;
		for(T obj:collection){
			if(useEqual){
				if(a.equals(obj)){
					flag = true;
				}
			}else{
				if(a==obj){
					flag = true;
				}
			}

		}
		return flag;

	}

	public static <T> boolean collectionContainsOR(Collection<T> collection,T... a){
		for(T obj:a){
			if(collectionContains(obj,collection)){
				return true;
			}
		}
		return false;
	}
	/**
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T> boolean contains(T a,T... b){
		boolean useEqual = false;
		boolean flag = false;
		if(a instanceof String){
			useEqual = true;
		}
		for(T obj:b){
			if(useEqual){
				if(a.equals(obj)){
					flag = true;
				}
			}else{
				if(a==obj){
					flag = true;
				}
			}

		}
		return flag;

	}

	public static <T> void printArray(T[] obj,String str){
		for(T o:obj){
			System.out.println("["+str+":printArray]"+o.toString());
		}
	}


}
