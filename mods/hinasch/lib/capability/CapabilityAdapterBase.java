package mods.hinasch.lib.capability;

import java.util.List;

import com.google.common.collect.Lists;

import mods.hinasch.lib.capability.ComponentCapabilityAdapterFactory.ICapabilityAdapter;
import mods.hinasch.lib.capability.ComponentCapabilityAdapterItem.ComponentCapabilityAdapterEntity;
import mods.hinasch.lib.capability.ComponentCapabilityAdapterItem.ComponentCapabilityAdapterTileEntity;
import mods.hinasch.lib.util.HSLibs;

public class CapabilityAdapterBase<T> {


	ComponentCapabilityAdapterFactory parent;
	ICapabilityAdapter<T> capabilityAdapter;
	List<ComponentCapabilityAdapter> list = Lists.newArrayList();

	public CapabilityAdapterBase(ComponentCapabilityAdapterFactory parent,ICapabilityAdapter<T> adapter){
		this.parent = parent;
		this.capabilityAdapter = adapter;
	}

	public void registerCapability(){
		HSLibs.registerCapability(this.capabilityAdapter.getCapabilityClass(), this.capabilityAdapter.getStorage(), this.capabilityAdapter.getDefault());
	}

	public ComponentCapabilityAdapterItem createChildItem(String name){
		return new ComponentCapabilityAdapterItem(parent.modid,name,this);
	}

	public ComponentCapabilityAdapterEntity createChildEntity(String name){
		return new ComponentCapabilityAdapterEntity(parent.modid,name,this);
	}

	public ComponentCapabilityAdapterTileEntity createChildTileEntity(String name){
		return new ComponentCapabilityAdapterTileEntity(parent.modid,name,this);
	}
}
