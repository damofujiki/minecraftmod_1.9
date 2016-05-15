package mods.hinasch.lib.primitive;

public interface Accumulator<R,T> {



	public abstract  void accumulate(R collector,T in);



}
