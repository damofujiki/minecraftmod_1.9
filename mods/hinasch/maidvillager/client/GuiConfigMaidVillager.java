package mods.hinasch.maidvillager.client;

import mods.hinasch.lib.config.ConfigGuiSettings;
import mods.hinasch.maidvillager.mod_MaidVillager;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class GuiConfigMaidVillager extends GuiConfig {

	public GuiConfigMaidVillager(GuiScreen parentScreen) {
		super(parentScreen, ConfigGuiSettings.getConfigElements(mod_MaidVillager.configFile, Configuration.CATEGORY_GENERAL), mod_MaidVillager.MODID, true,
				false, "Maid Villagers Config");
		// TODO 自動生成されたコンストラクター・スタブ
	}

}
