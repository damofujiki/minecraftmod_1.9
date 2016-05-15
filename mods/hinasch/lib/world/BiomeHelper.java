package mods.hinasch.lib.world;

import java.util.List;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

import com.google.common.collect.Lists;

public class BiomeHelper {

	public static void registerBiome(BiomeType type,BiomeGenBase biome){
		BiomeManager.addBiome(type, new BiomeEntry(biome,10));
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addStrongholdBiome(biome);
	}

	public static void addVillageBiome(BiomeGenBase biome){
		BiomeManager.addVillageBiome(biome, true);
	}
	

	public static List<BiomeDictionary.Type> getBiomeTypeList(BiomeGenBase biome){
		return Lists.newArrayList(BiomeDictionary.getTypesForBiome(biome));
	}
}
