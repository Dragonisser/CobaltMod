package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBluishMushroom extends Block {

	protected BlockBluishMushroom() {
		super(Material.plants);
		this.setHardness(0.1F);
		this.setResistance(0.2F);
		this.setStepSound(Block.soundTypeGrass);
	}

}
