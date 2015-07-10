package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCarthunBrick extends Block {

	public BlockCarthunBrick() {
		super(Material.rock);
		this.setHardness(5F);
		this.setResistance(2000F);
		this.setStepSound(Block.soundTypeStone);
		this.setTickRandomly(true);

	}
}