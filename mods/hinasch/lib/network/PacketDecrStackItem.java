package mods.hinasch.lib.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public class PacketDecrStackItem extends AbstractPacket{

	public PacketDecrStackItem(){

	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		System.out.println("packetdecrstack:client");
		if(player.getHeldItemMainhand()!=null){
			player.getHeldItemMainhand().stackSize --;
			if(player.getHeldItemMainhand().stackSize<0){
				player.getHeldItemMainhand().stackSize = 0;
			}
		}

	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		System.out.println("packetdecrstack:server");
		if(player.getHeldItemMainhand()!=null){
			player.getHeldItemMainhand().stackSize --;
			if(player.getHeldItemMainhand().stackSize<0){
				player.getHeldItemMainhand().stackSize = 0;
			}
		}

	}


}
