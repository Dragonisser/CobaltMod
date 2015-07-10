package cobaltmod.main.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import cobaltmod.main.api.CMContent;

public class BlockBlueTallGrass extends BlockBush implements IShearable {

	protected BlockBlueTallGrass(Material par2Material) {
		super(par2Material);
		float f = 0.3F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
		this.setStepSound(Block.soundTypeGrass);
	}

	public BlockBlueTallGrass() {
		this(Material.plants);

	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.getBlock(x, y - 1, z) == CMContent.cobaltgrass || world.getBlock(x, y - 1, z) == CMContent.cobaltfarmland
				|| world.getBlock(x, y - 1, z) == CMContent.cobaltdirt;
	}

	@Override
	protected boolean canPlaceBlockOn(Block block) {
		return block == CMContent.cobaltgrass || block == CMContent.cobaltfarmland || block == CMContent.cobaltdirt;
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return null;
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z)));
		return ret;
	}

}
