package mods.hinasch.lib.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityFXCustom extends EntityFX {

//	private static ResourceLocation loc = new ResourceLocation(Unsaga.MODID, "textures/particle/custom.png");
	private ResourceLocation loc;


	public EntityFXCustom(World par1World, double par2, double par4, double par6, float par8, float par9, float par10)
	{
		this(par1World, par2, par4, par6, 1.0F, par8, par9, par10);
	}
	public EntityFXCustom(World par1World, double par2, double par4, double par6, float par8, float par9, float par10, float par11)
	{
		super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
		this.xSpeed = par9;//initial motion value X
		this.ySpeed = par10;
		this.zSpeed = par11;
		if (par9 == 0.0F)
		{
			par9 = 1.0F;
		}
		float var12 = (float)Math.random() * 0.4F + 0.6F;
		this.particleTextureIndexX = 0; //
		this.particleTextureIndexY = 3;
		this.particleRed = 1.0F;//RGB of your particle
		this.particleGreen = 1.0F;
		this.particleBlue = 1.0F;
		this.particleScale *= 1.4F;
		this.particleScale *= par8;

		this.particleMaxAge = 80;//how soon the particle dies. You can use randomizer for this
		this.isCollided = true;//does your particle collide with blocks?
	}

	/**
	 * ex) new ResourceLocation(MODID,"textures/particle/custom.png")
	 * @param modid
	 * @param path
	 */
	public void setResourceLocation(String modid,String path){
		this.loc = new ResourceLocation(modid,path);
	}
	@Override
	public void onUpdate()
	{
	this.prevPosX = this.posX;
	this.prevPosY = this.posY;
	this.prevPosZ = this.posZ;

	if (this.particleAge++ >= this.particleMaxAge)
	{
	this.setExpired();//make sure to have this
	}
	this.moveEntity(this.xSpeed, this.ySpeed, this.zSpeed);// also important if you want your particle to move
	this.xSpeed *= xSpeed>=0.04D?1D:1.03D;
	this.ySpeed *= ySpeed>=0.04D?1D:1.03D;
	this.zSpeed *= zSpeed>=0.04D?1D:1.03D;
	}


	public void setParticleTextureIndex(int x,int y){
		this.particleTextureIndexX = x;
		this.particleTextureIndexY = y;
	}

    @Override
    public void renderParticle(VertexBuffer worldRenderer, Entity e, float f1, float f2, float f3, float f4, float f5, float f6) {

        Minecraft.getMinecraft().getTextureManager().bindTexture(loc);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        worldRenderer.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
        super.renderParticle(worldRenderer, e, f1, f2, f3, f4, f5, f6);
        Tessellator.getInstance().draw();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
    }
    @Override
    public int getFXLayer() {
        return 3; // THE IMPORTANT PART
    }
}
