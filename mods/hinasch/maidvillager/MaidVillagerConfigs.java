package mods.hinasch.maidvillager;

import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.realmsclient.util.Pair;

import mods.hinasch.lib.config.ConfigBase;
import mods.hinasch.lib.config.PropertyCustomNew;


public class MaidVillagerConfigs extends ConfigBase{

	public PropertyCustomNew props;
	boolean enableMaidVillager = true;
public boolean isEnableMaidVillager() {
		return enableMaidVillager;
	}

	//	public String villagerTexturesStr;
	public Map<Integer,String> villagerTextureMap;
	@Override
	public void init() {
		this.props = PropertyCustomNew.newInstance();
		this.props.add(0, "textureFiles.villager", "Textures Files of Maid Villagers.",
				Lists.newArrayList("0:farmer.png","1:librarian.png","2:priest.png","3:smith.png","4:butcher.png"),String.class );
		this.props.add(1, "enable.maidVillager", "set true to enable maidvilalger textures.", true);
//		this.props = new PropertyCustom(new String[]{"textureFiles.villager"});
//		this.props.setCategoriesAll(Configuration.CATEGORY_GENERAL);
//		this.props.setComments("Texture Files of Villagers.");
//		this.props.setValuesSequentially("155:carrier.png,300:builder.png");
		this.props.adapt(configFile);
		this.syncConfig();
	}

	@Override
	public void syncConfig() {
		// TODO 自動生成されたメソッド・スタブ
		String[] strs = this.props.getAdaptedProperties().get(0).getStringList();
		this.enableMaidVillager = this.props.getAdaptedProperties().get(1).getBoolean();

		this.villagerTextureMap = Maps.newHashMap();
//		String[] splitPerVillagers = this.villagerTexturesStr.split(",");
//		this.setDafaultTextures();
		try{
			for(String str:strs){
				Pair<Integer,String> numTexturePair = new Function<String,Pair<Integer,String>>(){

					@Override
					public Pair<Integer, String> apply(String input) {
						List<String> list = Splitter.on(":").splitToList(input);
						if(list.size()>=2){

							return Pair.of(Integer.valueOf(list.get(0)),list.get(1) );
						}
						return null;
					}
				}.apply(str);
				if(numTexturePair!=null){
					this.villagerTextureMap.put(numTexturePair.first(), numTexturePair.second());
				}
			}
		}catch(Exception e){
			e.printStackTrace();

		}

//		for(String splitPerVillager:splitPerVillagers){
//			String[] textureData = splitPerVillager.split(":");
//			if(textureData.length==2){
//				this.villagerTextureMap.put(Integer.valueOf(textureData[0]), textureData[1]);
//			}
//		}

		super.syncConfig();
	}

	public void setDafaultTextures(){
		this.villagerTextureMap.put(0, "farmer.png");
		this.villagerTextureMap.put(1, "librarian.png");
		this.villagerTextureMap.put(2, "priest.png");
		this.villagerTextureMap.put(3, "smith.png");
		this.villagerTextureMap.put(4, "butcher.png");
	}

}
