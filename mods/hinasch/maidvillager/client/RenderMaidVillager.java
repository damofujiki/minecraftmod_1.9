package mods.hinasch.maidvillager.client;

import org.lwjgl.opengl.GL11;

import mods.hinasch.maidvillager.mod_MaidVillager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;

public class RenderMaidVillager extends RenderLivingBase{



	public RenderMaidVillager(RenderManager rm,ModelBase modelbase, float f) {
		super(rm,modelbase, f);

	}

	public void renderMaidVillager(EntityVillager entity, double d, double d1, double d2, float f, float f1){
		super.doRender(entity, d, d1, d2, f, f1);
	}

	@Override
	public void doRender(EntityLivingBase entityliving, double d, double d1, double d2, float f, float f1){
//			mod_MaidVillager.debug("called");

		renderMaidVillager((EntityVillager)entityliving, d, d1, d2, f, f1);
	}
//
//	@Override
//	public void doRender(Entity entity, double d, double d1,double d2, float f, float f1){
//		renderMaidVillager((EntityVillager)entity, d, d1, d2, f, f1);
//	}

    protected void preRenderVillager(EntityVillager par1EntityVillager, float par2)
    {
        float var3 = 0.9375F;

        if (par1EntityVillager.getGrowingAge() < 0)
        {
        	// �q���̕`��T�C�Y
            var3 = (float)((double)var3 * mod_MaidVillager.changeChildMaidSize);
            this.shadowSize = (float)(mod_MaidVillager.changeChildMaidSize * 0.5);
        }
        else
        {
        	// ��l�̕`��T�C�Y
            var3 = (float)((double)var3 * mod_MaidVillager.changeMaidSize);
            this.shadowSize = (float)(mod_MaidVillager.changeMaidSize * 0.5);
        }

        GL11.glScalef(var3, var3, var3);
    }

	@Override
    protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2)
    {
        this.preRenderVillager((EntityVillager)par1EntityLiving, par2);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		int profession = 0;
		if(var1 instanceof EntityVillager){
			profession = ((EntityVillager) var1).getProfession();

		}
		return mod_MaidVillager.getResource(profession);
	}

}
