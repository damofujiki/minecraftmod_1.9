package mods.hinasch.maidvillager.client;

import mods.hinasch.maidvillager.CommonProxy;
import mods.hinasch.maidvillager.mod_MaidVillager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenderer(){
		mod_MaidVillager.debug("registering maidvillager renderer...");
		RenderingRegistry.registerEntityRenderingHandler(EntityVillager.class, new IRenderFactory<EntityVillager>(){

			@Override
			public Render<? super EntityVillager> createRenderFor(RenderManager manager) {
				if(mod_MaidVillager.configHandler.isEnableMaidVillager()){
					return new RenderMaidVillager(manager,new ModelMaidVillager(), 0.5F);
				}
				return new RenderVillager(manager);
			}}
		);
	}
}
