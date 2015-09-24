package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPortalFrameCaves extends Block {

	public BlockPortalFrameCaves() {
		super(Material.rock);
		this.setHardness(4F);
		this.setResistance(6F);
		this.setStepSound(Block.soundTypeStone);
		this.setHarvestLevel("pickaxe", 4);
	}
}