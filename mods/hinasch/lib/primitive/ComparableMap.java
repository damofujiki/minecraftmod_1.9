package mods.hinasch.lib.primitive;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;

public class ComparableMap<T extends Comparable<K>, V, K> {

	Map<T,V> map = Maps.newHashMap();

	public Map<T, V> getMap() {
		return map;
	}

	public void put(T t,V v){
		this.map.put(t, v);
	}
	public Optional<V> getFirst(K compareto){
		for(Entry<T,V> elm:map.entrySet()){
			if(elm.getKey().compareTo(compareto)==0){
				return Optional.of(elm.getValue());
			}
		}
		return Optional.absent();
	}
}
