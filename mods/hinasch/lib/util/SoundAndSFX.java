package mods.hinasch.lib.util;

import mods.hinasch.lib.world.XYZPos;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SoundAndSFX {


	public static SoundHandler getSoundHandler(){
		return Minecraft.getMinecraft().getSoundHandler();
	}

	public static void playPositionedSoundRecord(ResourceLocation loc,float pitch){
		getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvent.soundEventRegistry.getObject(loc),pitch));
	}
	public static void playPositionedSoundRecord(SoundEvent event,float pitch){
		getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(event,pitch));
	}
	/**
	 *
	 * @param world
	 * @param pos
	 * @param blockdata
	 * @param canDrop
	 */
	public static void playBlockBreakSFX(World world,BlockPos pos,IBlockState blockdata,boolean canDrop){
		if(world.rand.nextInt(2)==0){ //あまりSFXが数多くなるとコンカレントエラーが出る？
//			world.playAuxSFX(2001, pos, 0);
			world.playAuxSFX(2001, pos, Block.getIdFromBlock(blockdata.getBlock()) + (Block.getStateId(blockdata) << 12));
		}

//		PlaySFXEvent.addEvent(2001, pos,Block.getIdFromBlock(blockdata.getBlock()) + (Block.getStateId(blockdata) << 12));
		//if(!world.isRemote){

			//Unsaga.logger.log("kiteru");;
			boolean flag = world.setBlockToAir(pos);
			if (blockdata.getBlock() != null && flag) {
				blockdata.getBlock().onBlockDestroyedByPlayer(world, pos, blockdata);

				if(!canDrop){
					blockdata.getBlock().dropBlockAsItem(world, pos, blockdata,1);
				}




			}
		//}
	}

	public static void playBlockBreakSFX(World world,BlockPos pos,IBlockState blockdata){
		playBlockBreakSFX(world,pos,blockdata,false);
	}

	public static void playPlaceSound(World par3World,XYZPos xyz,SoundType sound,SoundCategory category){

		par3World.playSound((double)((float)xyz.dx + 0.5F), (double)((float)xyz.dy + 0.5F), (double)((float)xyz.dz + 0.5F), sound.getBreakSound(), category,(sound.getVolume() + 1.0F) / 2.0F, sound.getPitch() * 0.8F,true);
	}


}
