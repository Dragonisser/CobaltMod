package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import cobaltmod.main.api.CMContent;

public class BlockGlowFlower extends BlockBush {
	protected BlockGlowFlower(Material par2Material) {
		super(par2Material);
		this.setTickRandomly(true);
		float f = 0.3F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
		this.setStepSound(Block.soundTypeGrass);
		this.setLightLevel(0.4F);
	}

	public BlockGlowFlower() {
		this(Material.plants);
		
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.getBlock(x, y - 1, z) == CMContent.cobaltgrass || world.getBlock(x, y - 1, z) == CMContent.cobaltfarmland || world.getBlock(x, y - 1, z) == CMContent.cobaltdirt;
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block block)
    {
        return block == CMContent.cobaltgrass || block == CMContent.cobaltfarmland || block == CMContent.cobaltdirt;
    }
	
}
