package mods.hinasch.lib.container;

import mods.hinasch.lib.container.inventory.AbstractInventoryBinder;
import mods.hinasch.lib.network.PacketGuiButtonBaseNew;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

/**
 * バインダーの基礎クラス。GUIはguicontainerbaseを使う
 *
 *
 */
public abstract class AbstractContainerBinder extends ContainerBase{

	protected AbstractInventoryBinder invBinder;
	protected IInventory invEP;
	protected ItemStack binderStack;
	public AbstractContainerBinder(EntityPlayer ep,ItemStack is,AbstractInventoryBinder inv) {
		super(ep,inv);
		this.invBinder = (AbstractInventoryBinder) inv;
		this.invEP = ep.inventory;
		this.binderStack = is;

		for(int i=0;i<this.inv.getSizeInventory();i++){
			if(i>=0 && i<8){
				this.addSlotToContainer(this.getBinderSlot(this.inv , i, 18+(i* 18), 53-(18*2)));
			}else{
				this.addSlotToContainer(this.getBinderSlot(this.inv , i, 18+((i-8)* 18), 53-(18*1)));
			}

		}
		this.spreadSlotItems = false;
	}

	public abstract Slot getBinderSlot(IInventory inv,int par1,int par2,int par3);

	public abstract Item getBinderItem();

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		// TODO 自動生成されたメソッド・スタブ
		return inv.isUseableByPlayer(var1);
	}

	@Override
	public PacketGuiButtonBaseNew getPacketGuiButton(int guiID, int buttonID,
			NBTTagCompound args) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public SimpleNetworkWrapper getPacketPipeline() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int getGuiID() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void onPacketData() {
		// TODO 自動生成されたメソッド・スタブ

	}


	@Override
	public void onContainerClosed(EntityPlayer par1EntityPlayer)
	{

		if(!ep.worldObj.isRemote){
			if(ep.getHeldItemMainhand()!=null){
				this.invBinder.saveToNBT(ep.getHeldItemMainhand());
				//par1EntityPlayer.entityDropItem(binderStack, 0.1F);
			}

		}


		super.onContainerClosed(par1EntityPlayer);
	}

	/**
	 * Esc以外のクローズを禁止（ヌルポ防止の苦肉の策）
	 */
	@Override
    public ItemStack func_184996_a(int par1, int dragType, ClickType clickTypeIn, EntityPlayer player)
    {
    	if(par1>0){

    		if(this.getSlot(par1).getStack()!=null){
    			ItemStack is = this.getSlot(par1).getStack();
    			if(is.getItem()==this.getBinderItem()){
    				return null;
    			}
    		}
    	}

    	return super.func_184996_a(par1, dragType, clickTypeIn, player);
    }
}
