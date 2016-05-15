package mods.hinasch.lib;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import mods.hinasch.lib.iface.BiConsumer;
import mods.hinasch.lib.primitive.ListHelper;
import mods.hinasch.lib.util.HSLibs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class RangeDamage {

	protected World world;

	protected List<RangeDamage> hooks = Lists.newArrayList();
	protected boolean hitOnGroundOnly = true;

	public static AxisAlignedBB makeBBFromPlayer(EntityPlayer player,double horizontal,double vertical){
		return player.getEntityBoundingBox().expand(horizontal,vertical,horizontal);
	}

	public static RangeDamage create(World world){
		return new RangeDamage(world);
	}
	protected RangeDamage(World world){
		this.world = world;
		this.hitOnGroundOnly = false;
	}

	public RangeDamage setHitOnlyOnGroundMob(boolean par1){
		this.hitOnGroundOnly = par1;
		return this;
	}

	public boolean isHitOnlyOnGroundMob(){

		return this.hitOnGroundOnly;
	}

	public RangeDamage addHook(RangeDamage range){
		this.hooks.add(range);
		return this;
	}
	public void causeDamage(final DamageSource ds,final AxisAlignedBB aabb,final float damage){
		final Entity attacker = ds.getEntity();
		List<EntityLivingBase> mobList = world.getEntitiesWithinAABB(EntityLivingBase.class, aabb,new Predicate<EntityLivingBase>(){

			@Override
			public boolean apply(EntityLivingBase input) {
				return input!=attacker;
			}}
		);

		if(!mobList.isEmpty()){
			ListHelper.stream(mobList).forEach(new BiConsumer<EntityLivingBase,RangeDamage>(){

				@Override
				public void accept(EntityLivingBase input,RangeDamage parent) {
//					UnsagaMod.logger.trace("range", input);
					if(!isSameTeam(attacker,input)){
						parent.doRangedAttack(ds,aabb,damage,input);
					}

				}},this);

		}
	}

	protected void doRangedAttack(DamageSource ds, AxisAlignedBB aabb, float damage,EntityLivingBase mob){
		if(mob.onGround && this.hitOnGroundOnly || !this.hitOnGroundOnly){
			mob.attackEntityFrom(ds, damage);
			if(!this.hooks.isEmpty()){
				for(RangeDamage hook:this.hooks){
					hook.postRangeAttacked(ds, aabb, damage, mob);
				}

			}else{
				this.postRangeAttacked(ds,aabb,damage,mob);
			}

		}
	}


	public void postRangeAttacked(DamageSource ds, AxisAlignedBB aabb, float damage, EntityLivingBase mob){

	}

	protected boolean isSameTeam(Entity atacker,EntityLivingBase mob){
		if(atacker instanceof EntityLivingBase){
			if(HSLibs.isSameTeam((EntityLivingBase) atacker, mob)){
				return true;
			}
		}
		return false;
	}
}
