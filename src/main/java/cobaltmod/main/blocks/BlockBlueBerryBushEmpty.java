package cobaltmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlueBerryBushEmpty extends BlockCrops {

	public BlockBlueBerryBushEmpty() {
		super();
		this.setTickRandomly(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setHardness(0.0F);
		this.setStepSound(soundTypeGrass);
		this.disableStats();
	}

	/**
	 * Gets passed in the blockID of the block below and supposed to return true
	 * if its allowed to grow on the type of blockID passed in. Args: blockID
	 */
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.getBlock(x, y - 1, z) == CMContent.cobaltgrass || world.getBlock(x, y - 1, z) == CMContent.cobaltfarmland
				|| world.getBlock(x, y - 1, z) == CMContent.cobaltdirt;
	}

	@Override
	protected boolean canPlaceBlockOn(Block block) {
		return block == CMContent.cobaltgrass || block == CMContent.cobaltfarmland || block == CMContent.cobaltdirt;
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		super.updateTick(par1World, par2, par3, par4, par5Random);

		if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9) {
			int l = par1World.getBlockMetadata(par2, par3, par4);

			if (l < 7) {
				float f = this.getGrowthRate(par1World, par2, par3, par4);

				if (par5Random.nextInt((int) (25.0F / f) + 1) == 0) {
					++l;
					par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
				}
			} else {
				if (l > 6) {
					par1World.setBlock(par2, par3, par4, CMContent.blueberrybush_full);
				}
			}
		}

	}

	/**
	 * Apply bonemeal to the crops.
	 */
	public void fertilize(World par1World, int par2, int par3, int par4) {
		int l = par1World.getBlockMetadata(par2, par3, par4) + MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);

		if (l > 7) {
			l = 7;
		}
		if (l > 6) {
			par1World.setBlock(par2, par3, par4, CMContent.blueberrybush_full);
		}
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
	}

	/**
	 * Gets the growth rate for the crop. Setup to encourage rows by halving
	 * growth rate if there is diagonals, crops on different sides that aren't
	 * opposing, and by adding growth for every crop next to this one (and for
	 * crop below this one). Args: x, y, z
	 */
	private float getGrowthRate(World par1World, int par2, int par3, int par4) {
		float f = 1.0F;
		Block l = par1World.getBlock(par2, par3, par4 - 1);
		Block i1 = par1World.getBlock(par2, par3, par4 + 1);
		Block j1 = par1World.getBlock(par2 - 1, par3, par4);
		Block k1 = par1World.getBlock(par2 + 1, par3, par4);
		Block l1 = par1World.getBlock(par2 - 1, par3, par4 - 1);
		Block i2 = par1World.getBlock(par2 + 1, par3, par4 - 1);
		Block j2 = par1World.getBlock(par2 + 1, par3, par4 + 1);
		Block k2 = par1World.getBlock(par2 - 1, par3, par4 + 1);
		boolean flag = j1 == this || k1 == this;
		boolean flag1 = l == this || i1 == this;
		boolean flag2 = l1 == this || i2 == this || j2 == this || k2 == this;

		for (int l2 = par2 - 1; l2 <= par2 + 1; ++l2) {
			for (int i3 = par4 - 1; i3 <= par4 + 1; ++i3) {
				Block j3 = par1World.getBlock(l2, par3 - 1, i3);
				float f1 = 0.0F;

				if (j3 != null && j3.canSustainPlant(par1World, l2, par3 - 1, i3, ForgeDirection.UP, this)) {
					f1 = 1.0F;

					if (j3.isFertile(par1World, l2, par3 - 1, i3)) {
						f1 = 3.0F;
					}
				}

				if (l2 != par2 || i3 != par4) {
					f1 /= 4.0F;
				}

				f += f1;
			}
		}

		if (flag2 || flag && flag1) {
			f /= 2.0F;
		}

		return f;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		if (par2 == 0) {
			return blockIcon;
		}
		if (par2 == 1) {
			return blockIcon;
		}
		if (par2 == 2) {
			return blockIcon;
		}
		if (par2 == 3) {
			return blockIcon;
		}
		if (par2 == 4) {
			return blockIcon;
		}
		if (par2 == 5) {
			return blockIcon;
		}
		if (par2 == 6) {
			return blockIcon;
		}
		if (par2 == 7) {
			return blockIcon;
		}
		return blockIcon;
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType() {
		return 1;
	}

	/**
	 * Generate a seed ItemStack for this crop.
	 */
	protected Item func_149866_i() {
		return Item.getItemFromBlock(CMContent.blueberrybush_empty);
	}

	/**
	 * Generate a crop produce ItemStack for this crop.
	 */
	protected Item func_149865_P() {
		return Item.getItemFromBlock(CMContent.blueberrybush_empty);
	}

	/**
	 * Drops the block items with a specified chance of dropping the specified
	 * items
	 */
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public Block idDropped(int par1, Random par2Random, int par3) {
		return CMContent.blueberrybush_empty;

	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random) {
		return 1;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	public Item getItem(World par1World, int par2, int par3, int par4) {
		return this.func_149866_i();
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.blockIcon = p_149651_1_.registerIcon(this.getTextureName());
	}
}
