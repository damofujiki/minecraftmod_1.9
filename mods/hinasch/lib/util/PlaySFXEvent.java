package mods.hinasch.lib.util;

import java.util.List;

import com.google.common.collect.Lists;

import mods.hinasch.lib.client.ClientHelper;
import mods.hinasch.lib.core.HSLib;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlaySFXEvent {

	static List<Container> list = Lists.newArrayList();
	static final int THRESHOLD = 2;
	int interval = 0;

	@SubscribeEvent
	public void onRenderGame(RenderGameOverlayEvent.Pre ev){
		if(ev.getType()==ElementType.ALL){
			interval ++;
			if(interval>THRESHOLD){

				interval = 0;
				this.updateByPlayer(ev);
			}
		}
	}
//	@Override
//	public void update(LivingUpdateEvent e) {
//		if(e.getEntityLiving().getEntityWorld().isRemote){
//			HSLib.logger.trace(getName(), "remote");
//			if(e.getEntityLiving() instanceof EntityPlayer){
//				interval ++;
//				if(interval>THRESHOLD){
//
//					interval = 0;
//					this.updateByPlayer(e);
//				}
//			}
//		}
//
//
//
//	}

	public void updateByPlayer(RenderGameOverlayEvent.Pre e){
		HSLib.logger.trace("soudn", e.getPartialTicks());
		if(!list.isEmpty()){
			Container c = list.get(0);
			World world = ClientHelper.getWorld();
			world.playAuxSFX(c.sfxNumber, c.pos,c.args);
			list.remove(0);
		}
	}
//	@Override
//	public String getName() {
//		// TODO 自動生成されたメソッド・スタブ
//		return "Play SFX Event";
//	}

	public static void addEvent(int sfx,BlockPos pos, int args){
		list.add(new Container(sfx,pos,args));
	}
	public static class Container{

		int args;
		int sfxNumber;
		BlockPos pos;
		public Container(int sfxNumber, BlockPos pos,int args) {
			super();
			this.sfxNumber = sfxNumber;
			this.pos = pos;
			this.args = args;
		}
	}
}
