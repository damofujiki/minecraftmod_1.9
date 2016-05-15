package mods.hinasch.lib.world;

import java.util.Random;

import mods.hinasch.tallforest.world.AbstractGenTreeTallForest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldGenSmallTree extends AbstractGenTreeTallForest{

	IBlockState log;
	IBlockState leaves;
    public WorldGenSmallTree(boolean notify) {
		super(notify);
		// TODO 自動生成されたコンストラクター・スタブ
	}

    public WorldGenSmallTree init(IBlockState log,IBlockState leaves){
    	this.leaves = leaves;
    	this.log = log;
    	return this;
    }
	public void genSmallPine(World world,BlockPos pos){
    	//WorldHelper wh = new WorldHelper(world);
    	for(int i=0;i<2;i++){
    		for(int j=0;j<3;j++){
    			for(int k=0;k<3;k++){

    				boolean flag = true;
    				BlockPos leavespos = new BlockPos(pos.getX()-1+k,pos.getY()+i,pos.getZ()-1+j);
    				if(i==1 && (j==0 || j==2 || k==0 || k==2)){
    					flag = false;
    					if(j==1 || k==1){
    						flag = true;
    					}
    				}
                    if (!world.getBlockState(leavespos).isOpaqueCube() && flag)
                    {
                        this.setBlockAndNotifyAdequately(world, leavespos, this.leaves);
                    }
    			}
    		}
    	}

         this.setBlockAndNotifyAdequately(world, pos, this.log);

    }

	@Override
	public boolean generate(World p_76484_1_, Random p_76484_2_,
			BlockPos pos) {
		// TODO 自動生成されたメソッド・スタブ
		this.genSmallPine(p_76484_1_, pos);
		return true;
	}
}
