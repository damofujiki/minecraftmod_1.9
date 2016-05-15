package mods.hinasch.lib.entity;
//package com.hinasch.lib.base;
//
//import net.minecraft.client.particle.EntityFX;
//import net.minecraft.client.renderer.texture.TextureAtlasSprite;
//import net.minecraft.world.World;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//@Deprecated
//@SideOnly(Side.CLIENT)
//public class EntityFXBase extends EntityFX {
//
//	// 発生地点のY座標。消滅条件に利用する
//	double orginalPosY;
//
//	public EntityFXBase(World par1World, double par2, double par4,
//			double par6, double par8, double par10, double par12) {
//		super(par1World, par2, par4, par6);
//		this.orginalPosY = par4;
//		this.motionX = par8;
//		this.motionY = par10;
//		this.motionZ = par12;
//	}
//
//	/*
//	 * tickごとの更新。スーパークラスであるEntityFXでは放射状に拡散してparticleMaxAge経過で消滅しますが、
//	 * ここでは発生地点から1m上昇したら消滅するように変更しています。
//	 * 作ろうとしているパーティクルに適した動きを実装してください。
//	 * 例えばポータルエフェクトのパーティクルはポータルブロックに吸い込まれるような動きを実装しています。
//	 */
//	@Override
//	public void onUpdate() {
//		this.prevPosX = this.posX;
//		this.prevPosY = this.posY;
//		this.prevPosZ = this.posZ;
//
//		// 時間経過とともに大きくなる
//		this.particleScale = this.particleScale + 0.1F;
//
//		// 発生地点から1m以上上昇したら消滅する
//		if (this.particleAge++ >= this.particleMaxAge) {
//			this.setDead();
//		}
//		this.moveEntity(this.motionX, this.motionY, this.motionZ);
//	}
//
//	@Override
//	public int getFXLayer() {
//		// たぶん数値が大きいほど手前に描画される？
//		// 1or2でないと例外が発生するのでとりあえず2に設定
//		return 2;
//	}
//
//    public void func_180435_a(TextureAtlasSprite par1Icon)
//    {
//        if (getFXLayer() == 1)
//        {
//            particleIcon = par1Icon;
//        }
//        else if (getFXLayer() == 2)
//        {
//            particleIcon = par1Icon;
//        }
//        else
//        {
//            throw new RuntimeException("Invalid call to Particle.setTex, use coordinate methods");
//        }
//    }
//
//}
