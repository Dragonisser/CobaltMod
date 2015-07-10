package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCobaltBlock extends Block 
{
	public BlockCobaltBlock() 
	{
		super(Material.rock);
		this.setHardness(5F);
		this.setResistance(4F);
		this.setStepSound(Block.soundTypeStone);
	}
	
	
}