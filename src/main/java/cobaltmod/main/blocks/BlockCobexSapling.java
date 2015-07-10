package cobaltmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import cobaltmod.main.api.CMContent;
import cobaltmod.world.gen.WorldGenCobaltTree;

public class BlockCobexSapling extends BlockBush implements IGrowable {

	public BlockCobexSapling() {
		super();
		float var3 = 0.4F;
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
		this.setHardness(0F);
		this.setResistance(1F);
		this.setStepSound(soundTypeGrass);
	}

	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.getBlock(x, y - 1, z) == CMContent.cobaltgrass || world.getBlock(x, y - 1, z) == CMContent.cobaltdirt;
	}
	@Override
	protected boolean canPlaceBlockOn(Block block)
    {
        return block == CMContent.cobaltgrass || block == CMContent.cobaltdirt;
    }

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		if (!par1World.isRemote) {
			super.updateTick(par1World, par2, par3, par4, par5Random);

			if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9
					&& par5Random.nextInt(7) == 0) {
				int var6 = par1World.getBlockMetadata(par2, par3, par4);

				if ((var6 & 8) == 0) {
					par1World.setBlockMetadataWithNotify(par2, par3, par4,
							var6 | 8, 2);
				} else {
					this.growTree(par1World, par2, par3, par4, par5Random);
				}
			}
		}
	}

	public void markOrGrowMarked(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		int l = par1World.getBlockMetadata(par2, par3, par4);

		if ((l & 8) == 0) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
		} else {
			this.growTree(par1World, par2, par3, par4, par5Random);
		}
	}

	/**
	 * Attempts to grow a sapling into a tree
	 */
	public void growTree(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4))
			return;

		int var6 = par1World.getBlockMetadata(par2, par3, par4) & 3;
		Object var7 = null;
		int var8 = 0;
		int var9 = 0;
		boolean var10 = false;

		if (var6 == 1) {
			var7 = new WorldGenCobaltTree(true, 4 + par5Random.nextInt(2), 0,
					0, false);
		} else if (var6 == 2) {
			var7 = new WorldGenCobaltTree(true, 4 + par5Random.nextInt(2), 0,
					0, false);
		} else if (var6 == 3) {
			for (var8 = 0; var8 >= -1; --var8) {
				for (var9 = 0; var9 >= -1; --var9) {
					if (this.isSameSapling(par1World, par2 + var8, par3, par4
							+ var9, 3)
							&& this.isSameSapling(par1World, par2 + var8 + 1,
									par3, par4 + var9, 3)
							&& this.isSameSapling(par1World, par2 + var8, par3,
									par4 + var9 + 1, 3)
							&& this.isSameSapling(par1World, par2 + var8 + 1,
									par3, par4 + var9 + 1, 3)) {
						var7 = new WorldGenCobaltTree(true,
								4 + par5Random.nextInt(2), 0, 0, false);
						var10 = true;
						break;
					}
				}

				if (var7 != null) {
					break;
				}
			}

			if (var7 == null) {
				var9 = 0;
				var8 = 0;
				var7 = new WorldGenCobaltTree(true, 4 + par5Random.nextInt(2),
						0, 0, false);
			}
		} else {
			var7 = new WorldGenCobaltTree(true, 4 + par5Random.nextInt(2), 0,
					0, false);

			if (par5Random.nextInt(10) == 0) {
				var7 = new WorldGenCobaltTree(true, 4 + par5Random.nextInt(2),
						0, 0, false);
			}
		}

		if (var10) {
			par1World.setBlock(par2 + var8, par3, par4 + var9, Blocks.air);
			par1World.setBlock(par2 + var8 + 1, par3, par4 + var9, Blocks.air);
			par1World.setBlock(par2 + var8, par3, par4 + var9 + 1, Blocks.air);
			par1World.setBlock(par2 + var8 + 1, par3, par4 + var9 + 1,
					Blocks.air);
		} else {
			par1World.setBlock(par2, par3, par4, Blocks.air);
		}

		if (!((WorldGenerator) var7).generate(par1World, par5Random, par2
				+ var8, par3, par4 + var9)) {
			if (var10) {
				par1World.setBlock(par2 + var8, par3, par4 + var9, this);
				par1World.setBlock(par2 + var8 + 1, par3, par4 + var9, this);
				par1World.setBlock(par2 + var8, par3, par4 + var9 + 1, this);
				par1World
						.setBlock(par2 + var8 + 1, par3, par4 + var9 + 1, this);
			} else {
				par1World.setBlock(par2, par3, par4, this);
			}
		}
	}

	/**
	 * Determines if the same sapling is present at the given location.
	 */
	public boolean isSameSapling(World par1World, int par2, int par3, int par4,
			int par5) {
		return par1World.getBlock(par2, par3, par4) == this
				&& (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
	}


	@Override
	public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
    {
        return true;
    }

	@Override
    public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_)
    {
        return (double)p_149852_1_.rand.nextFloat() < 0.45D;
    }

	@Override
    public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_)
    {
        this.markOrGrowMarked(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
    }
}