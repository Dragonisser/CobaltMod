package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockHardendCorruptedStone extends Block {

	protected BlockHardendCorruptedStone() {
		super(Material.rock);
		this.setHardness(4F);
		this.setResistance(5F);
		this.setStepSound(Block.soundTypeStone);
		this.setHarvestLevel("pickaxe", 3);
	}
}
