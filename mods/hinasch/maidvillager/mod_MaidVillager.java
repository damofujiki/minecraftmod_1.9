package mods.hinasch.maidvillager;

import mods.hinasch.lib.config.EventConfigChanged;
import mods.hinasch.lib.core.HSLib;
import mods.hinasch.lib.primitive.LogWrapper;
import mods.hinasch.lib.util.HSLibs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = mod_MaidVillager.MODID, name = mod_MaidVillager.NAME, version=mod_MaidVillager.VERSION,guiFactory="mods.hinasch.maidvillager.ConfigGuiFactoryMaidVillager")
public class mod_MaidVillager {
	@SidedProxy(modId= mod_MaidVillager.MODID,clientSide = "mods.hinasch.maidvillager.client.ClientProxy", serverSide = "mods.hinasch.maidvillager.CommonProxy")
	public static CommonProxy proxy;
	@Instance(mod_MaidVillager.MODID)
	public static mod_MaidVillager instance;

	public static final String MODID = "maidvillager";
	public static final String NAME = "Maid Villager";
	public static final String VERSION = "1.0 build 12/25 2014 #01";


	public static Configuration configFile;

	public static final MaidVillagerConfigs configHandler = new MaidVillagerConfigs();

	public static LogWrapper logger;

	public static double changeMaidSize = 1.0;
	public static double changeChildMaidSize = 0.5;

	//public static String entityName = "Villager";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = LogWrapper.newLogger(event);
		configFile = new Configuration(event.getSuggestedConfigurationFile());
		configFile.load();
		this.configHandler.setConfigFile(configFile);
		this.configHandler.init();
		this.configHandler.syncConfig();
		configFile.save();


		proxy.registerRenderer();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{

		HSLibs.registerEvent(new EventConfigChanged(MODID,configHandler).setLogger(logger));
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){

	}

	public static ResourceLocation getResource(int id){
		String path = getTexture(id);
		return new ResourceLocation(MODID,path);
	}
    public static String getTexture(int id)
    {
    	String texFile = mod_MaidVillager.configHandler.villagerTextureMap.get(id) != null ? mod_MaidVillager.configHandler.villagerTextureMap.get(id) : "farmer.png";

    	return "textures/entity/" + texFile;
//        switch (id)
//        {
//            case 0:
//                return "textures/entity/farmer.png";
//
//            case 1:
//                return "textures/entity/librarian.png";
//
//            case 2:
//                return "textures/entity/priest.png";
//
//            case 3:
//                return "textures/entity/smith.png";
//
//            case 4:
//                return "textures/entity/butcher.png";
//
//            case 155:
//            	return "textures/entity/carrier.png";
//            case 300:
//            	return "textures/entity/builder.png";
//            default:
//                return "textures/entity/farmer.png";
//        }
    }

	public static void debug(Object... par1){



		String str = "[MaidVillagerForge]";
		for(Object obj:par1){
			if(obj!=null){
				Class clas = obj.getClass();
				str += clas.cast(obj).toString()+":";
			}else{
				str += "Null!";
			}

		}
		if(HSLib.configHandler.isDebug()){
			System.out.println(str);
		}
	}
//	@Override
//	public void modsLoaded() {
//		// Entity�u��
//        Entity entity = EntityList.createEntityByName(entityName, null);
//        int id = EntityList.getEntityID(entity);
//
//        ModLoader.registerEntityID(EntityMaidVillager.class, entityName, id);
//	}
//
//	// ���f�������A�����_�����O
//	@Override
//	public void addRenderer(Map map){
//		super.addRenderer(map);
//		map.put(net.minecraft.src.EntityMaidVillager.class, new RenderMaidVillager(new ModelMaidVillager(), 0.5F));
//	}

}
