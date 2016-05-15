package mods.hinasch.lib.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;

public class ModifierHelper {

	public static boolean hasModifier(EntityLivingBase living,IAttribute attribute,AttributeModifier modifier){
		if(living.getEntityAttribute(attribute)!=null){
			return living.getEntityAttribute(attribute).getModifier(modifier.getID())!=null;
		}
		return false;
	}
	public static void refleshModifier(EntityLivingBase living,IAttribute atttribute,AttributeModifier modifier){
		if(living.getEntityAttribute(atttribute)==null){
			living.getAttributeMap().registerAttribute(atttribute);
		}
		if(living.getEntityAttribute(atttribute).getModifier(modifier.getID())==null){
			living.getEntityAttribute(atttribute).applyModifier(modifier);
		}
	}
}
