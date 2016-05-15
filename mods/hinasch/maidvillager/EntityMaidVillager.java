//package net.minecraft.src;
//
//import net.minecraft.entity.passive.EntityVillager;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.world.World;
//
//public class EntityMaidVillager extends EntityVillager {
//	
//	public EntityMaidVillager(World world){
//		super(world);
//	}
//	
//	@Override
//	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound){
//		super.readEntityFromNBT(par1NBTTagCompound);
//	}
//
//	// �e�N�X�`���ύX
//	@Override
//    public String getTexture()
//    {
//        switch (this.getProfession())
//        {
//            case 0:
//                return "/mob/maidvillager/farmer.png";
//
//            case 1:
//                return "/mob/maidvillager/librarian.png";
//
//            case 2:
//                return "/mob/maidvillager/priest.png";
//
//            case 3:
//                return "/mob/maidvillager/smith.png";
//
//            case 4:
//                return "/mob/maidvillager/butcher.png";
//
//            default:
//                return "/mob/maidvillager/farmer.png";
//        }
//    }
//}
