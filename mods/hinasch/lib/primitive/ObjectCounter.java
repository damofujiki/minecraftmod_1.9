package mods.hinasch.lib.primitive;

import java.util.HashMap;
import java.util.Map;

import mods.hinasch.lib.iface.BiConsumer;
import mods.hinasch.lib.iface.Consumer;
import mods.hinasch.lib.world.ScanHelper;

/** 任意のオブジェクトの数を数えるクラス。
 * オブジェクトの同定はmap.containsKey(obj）に依存
 * staticにstream関連をちょっと用意
 * */
public class ObjectCounter<T> {

	public Map<T,Integer> map;

	public ObjectCounter(){
		map = new HashMap();
	}

	public void add(T obj){
		if(map.containsKey(obj)){
			int cnt = map.get(obj);
			map.put(obj, cnt+1);
		}else{
			map.put(obj, 1);
		}
	}

	public int get(T obj){
		return map.get(obj)==null ? 0 : map.get(obj);
	}


	public static ObjectCounter fromScanner(ScanHelper scan,ScannerCounterConsumer  biconsumer){
		ObjectCounter counter = new ObjectCounter();
		scan.asStream(biconsumer,counter);
		return counter;
	}

	public static ObjectCounter asStream(Consumer<ObjectCounter> consumer){
		ObjectCounter counter = new ObjectCounter();
		consumer.accept(counter);
		return counter;
	}

	public interface ScannerCounterConsumer extends BiConsumer<ScanHelper,ObjectCounter>{

	}

	public static class CounterConsumer<V> implements BiConsumer<V,ObjectCounter>{

		@Override
		public void accept(V input,ObjectCounter counter) {
			counter.add(input);

		}
	}
}
