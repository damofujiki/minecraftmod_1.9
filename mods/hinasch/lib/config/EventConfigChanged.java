package mods.hinasch.lib.config;



import mods.hinasch.lib.primitive.LogWrapper;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventConfigChanged {



	private final String modid;
	private LogWrapper logger;
	private final ConfigBase configHandler;
	public EventConfigChanged(String modid,ConfigBase configHandler){

		this.modid = modid;
		this.configHandler = configHandler;
	}

	public EventConfigChanged setLogger(LogWrapper logger){
		this.logger = logger;
		return this;
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e){
		if(e.getModID().equals(modid)){
			if(logger!=null){
				logger.trace("config sync!");
			}

			configHandler.syncConfig();
		}
	}
}
