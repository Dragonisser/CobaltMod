package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCobaltPortalFrame extends Block {

	public BlockCobaltPortalFrame() {
		super(Material.rock);
		this.setHardness(50F);
		this.setResistance(2000F);
		this.setStepSound(Block.soundTypeStone);
	}
}