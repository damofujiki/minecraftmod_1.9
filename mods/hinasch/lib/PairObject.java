package mods.hinasch.lib;

import org.apache.commons.lang3.tuple.Pair;

public class PairObject<T,U> extends Pair<T,U>{

	public T left;
	public U right;
	
	public PairObject(T left,U right){
		this.left = left;
		this.right = right;
	}

	@Override
	public U setValue(U value) {
		this.right = value;
		return this.right;
	}

	@Override
	public T getLeft() {
		// TODO 自動生成されたメソッド・スタブ
		return this.left;
	}

	@Override
	public U getRight() {
		// TODO 自動生成されたメソッド・スタブ
		return this.right;
	}
	

}
