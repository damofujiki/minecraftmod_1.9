package mods.hinasch.lib.world;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import mods.hinasch.lib.util.HSLibs;
import mods.hinasch.lib.world.EnvironmentalHelper.EnvironmentalCondition.Type;
import mods.hinasch.lib.world.WorldHelper.CustomCheckWH;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

/** minecraftに環境？体調？の概念を入れる、まだあついさむいぐらいしか概念がない*/
public class EnvironmentalHelper {
	public static EnvironmentalCondition getCondition(World w,XYZPos pos,BiomeGenBase biome){
		List biomeList = BiomeHelper.getBiomeTypeList(biome);
		//boolean isNight = world.getBlockLightValue(pos.x,pos.y, pos.z) < 7;
		if(biomeList.contains(BiomeDictionary.Type.COLD)){
			if(w.isAABBInMaterial(HSLibs.getBounding(pos, 3.0D, 3.0D), Material.lava)){
				return EnvironmentalCondition.getSafeEnvironment();
			}
			if(w.isAABBInMaterial(HSLibs.getBounding(pos, 3.0D, 3.0D), Material.fire)){
				return EnvironmentalCondition.getSafeEnvironment();
			}
			if(WorldHelper.findNear(w,Blocks.lit_furnace, pos, 7, checkFurnace)!=null){
				return EnvironmentalCondition.getSafeEnvironment();
			}


			return new EnvironmentalCondition(true,Type.COLD);
		}
		if(biomeList.contains(BiomeDictionary.Type.HOT)){
			if(biomeList.contains(BiomeDictionary.Type.DRY) && !w.isDaytime()){
				return new EnvironmentalCondition(false,null);
			}else{
				return new EnvironmentalCondition(true,Type.HOT);
			}
		}

		if(biomeList.contains(BiomeDictionary.Type.WET)){
			return new EnvironmentalCondition(true,Type.HUMID);
		}
		if(!biomeList.contains(BiomeDictionary.Type.DRY)){
			if(w.isRaining()){
				return new EnvironmentalCondition(true,Type.HUMID);
			}
		}
		if(w.isAABBInMaterial(HSLibs.getBounding(pos, 3.0D, 3.0D), Material.lava)){
			return new EnvironmentalCondition(true,Type.HOT);
		}
		return EnvironmentalCondition.getSafeEnvironment();
	}

	public static Set<Block> hotBlocks = Sets.newHashSet(Blocks.lit_furnace,Blocks.fire,Blocks.lava,Blocks.flowing_lava);
	public static final WorldHelper.CustomCheckWH checkFurnace = new CustomCheckWH(){
		@Override
		public boolean apply(World parent,XYZPos pos,Block block,ScanHelper scan){
			if(hotBlocks.contains(WorldHelper.getBlock(parent,scan.getXYZPos()))){
				return true;
			}
			return false;
		}
	};
	/**
	 * 環境に関するやつ。
	 *アンサガmodでの自動回復や就寝時に使う。
	 *
	 */
	public static class EnvironmentalCondition{
		public boolean isHarsh;
		public static enum Type {COLD("condition.cold"),HOT("condition.hot"),SAFE("condition.safe"),HUMID("condition.humid");

			String name;
			public String getName() {
				return name;
			}
			private Type(String name){
				this.name = name;
			}
		};
		public Type result;
		public Type getType() {
			return result;
		}

		public EnvironmentalCondition(boolean isHarsh,Type en){
			this.isHarsh = isHarsh;
			this.result = en;
			if(this.result==null){
				this.result = Type.SAFE;
			}
		}

		/**
		 * 通常の環境
		 * @return
		 */
		public static EnvironmentalCondition getSafeEnvironment(){
			return new EnvironmentalCondition(false,Type.SAFE);
		}
	}
}
