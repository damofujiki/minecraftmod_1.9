package mods.hinasch.lib.container.inventory;

import mods.hinasch.lib.item.ItemUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public abstract class AbstractInventoryBinder extends InventoryBase{

	public ItemStack stackBinder;
	public final int stackMax;
	public AbstractInventoryBinder(boolean isRemote,ItemStack is,int max) {
		super(max);
		this.stackBinder = is;
		this.stackMax = max;
		if(!isRemote){
			this.loadFromNBT();
		}


	}

	public abstract Item getBinderItem();

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		// TODO 自動生成されたメソッド・スタブ

		if(entityplayer.getHeldItemMainhand()!=null && entityplayer.getHeldItemMainhand().getItem()==this.getBinderItem()){
			return true;
		}
		return false;
	}

	public void loadFromNBT(){
		ItemStack[] maps = ItemUtil.loadItemStacksFromItemNBT(stackBinder, this.stackMax);
		if(maps!=null){
			for(int i=0;i<this.getSizeInventory();i++){
				if(maps[i]!=null){
					this.setInventorySlotContents(i, maps[i]);
				}

			}
		}


	}

	public void saveToNBT(ItemStack binder){
		ItemUtil.saveItemStacksToItemNBT(binder,theInventory);

	}
}
