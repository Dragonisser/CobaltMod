package cobaltmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCobexWood extends Block {
	public BlockCobexWood() 
	{
		super(Material.wood);
		this.setHardness(3F);
		this.setResistance(2F);
		this.setStepSound(Block.soundTypeWood);
	}
	public int quantityDropped(Random random) {
		return 1;
	}
}