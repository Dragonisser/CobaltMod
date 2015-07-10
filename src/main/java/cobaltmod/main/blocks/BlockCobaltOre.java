package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCobaltOre extends Block {
	public BlockCobaltOre() {
		super(Material.rock);
		this.setHardness(5F);
		this.setResistance(5F);
		this.setStepSound(Block.soundTypeStone);
		this.setHarvestLevel("pickaxe", 3);
	}
}
