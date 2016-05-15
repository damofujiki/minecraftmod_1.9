package mods.hinasch.lib;

import java.util.UUID;

import net.minecraft.entity.ai.attributes.AttributeModifier;

public class AttributeHelper {

	/**
	 * 
	 * @param uuid UUID。fromStringと生成ソフトとかであらかじめ作っておく
	 * @param name 名前。なんでもいい
	 * @param amount 効果量。オペレーションでかわる
	 * @param operation オペレーションの種類。Staticsに定数を用意してるのでそれ使う
	 * @return
	 */
	public static AttributeModifier getNewAttributeModifier(UUID uuid,String name,double amount,int operation){
		return new AttributeModifier(uuid,name,amount,operation);
	}
}
