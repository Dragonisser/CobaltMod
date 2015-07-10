package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockCarthunBrickStair extends BlockStairs 
{

	public BlockCarthunBrickStair(Block par2Block, int par3) 
	{
		super(par2Block, par3);
		this.setHardness(5F);
		this.setResistance(4F);
		this.setStepSound(Block.soundTypeStone);
		this.setLightOpacity(1);
	}

	public int getRenderType() 
	{
		return 10;
	}
}