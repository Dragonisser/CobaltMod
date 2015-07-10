package cobaltmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cobaltmod.entity.EntityBlueSlime;
import cobaltmod.entity.EntityCobaltGuardian;
import cobaltmod.entity.EntityCobaltZombie;
import cobaltmod.main.api.CMApiReplace;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDarkWater extends BlockFluidClassic {

	public static BlockDarkWater instance;

	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon flowingIcon;

	public BlockDarkWater(Fluid fluid, Material material) {
		super(fluid, material);

	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		stillIcon = register.registerIcon("mod_cobalt:darkwater_still");
		flowingIcon = register.registerIcon("mod_cobalt:darkwater_flow");
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return (side == 0 || side == 1) ? stillIcon : flowingIcon;
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;
		return super.displaceIfPossible(world, x, y, z);
	}

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
		if (par5Entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) par5Entity;
			ItemStack[] armor = player.inventory.armorInventory;
			if (armor[0] != null) {
				if (armor[0].getItem() == CMContent.cobaltboots && armor[1].getItem() == CMContent.cobaltlegs && armor[2].getItem() == CMContent.cobaltplate
						&& armor[3].getItem() == CMContent.cobalthelmet) {
					return;
				}
			}
		}
		if (par5Entity instanceof EntityLivingBase) {
			EntityLivingBase elb = (EntityLivingBase) par5Entity;

			if (elb.isPotionActive(CMContent.potion_cobalt_resistance)) {
				return;
			}
		}
		if (par5Entity instanceof EntityItem) {
			return;
		}
		if (par5Entity instanceof EntityCobaltZombie) {
			return;
		}
		if (par5Entity instanceof EntityCobaltGuardian) {
			return;
		}
		if (par5Entity instanceof EntityBlueSlime) {
			return;
		}
		par5Entity.attackEntityFrom(DamageSource.magic, 0.5F);

	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		int quantaRemaining = quantaPerBlock - world.getBlockMetadata(x, y, z);
		int expQuanta = -101;

		// check adjacent block levels if non-source
		if (quantaRemaining < quantaPerBlock) {
			int y2 = y - densityDir;

			if (world.getBlock(x, y2, z) == this || world.getBlock(x - 1, y2, z) == this || world.getBlock(x + 1, y2, z) == this
					|| world.getBlock(x, y2, z - 1) == this || world.getBlock(x, y2, z + 1) == this) {
				expQuanta = quantaPerBlock - 1;
			} else {
				int maxQuanta = -100;
				maxQuanta = getLargerQuanta(world, x - 1, y, z, maxQuanta);
				maxQuanta = getLargerQuanta(world, x + 1, y, z, maxQuanta);
				maxQuanta = getLargerQuanta(world, x, y, z - 1, maxQuanta);
				maxQuanta = getLargerQuanta(world, x, y, z + 1, maxQuanta);

				expQuanta = maxQuanta - 1;
			}

			// decay calculation
			if (expQuanta != quantaRemaining) {
				quantaRemaining = expQuanta;

				if (expQuanta <= 0) {
					world.setBlock(x, y, z, Blocks.air);
				} else {
					world.setBlockMetadataWithNotify(x, y, z, quantaPerBlock - expQuanta, 3);
					world.scheduleBlockUpdate(x, y, z, this, tickRate);
					world.notifyBlocksOfNeighborChange(x, y, z, this);
				}
			}
		}
		// This is a "source" block, set meta to zero, and send a server only
		// update
		else if (quantaRemaining >= quantaPerBlock) {
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		}

		// Flow vertically if possible
		if (canDisplace(world, x, y + densityDir, z)) {
			flowIntoBlock(world, x, y + densityDir, z, 1);
			return;
		}

		// Flow outward if possible
		int flowMeta = quantaPerBlock - quantaRemaining + 1;
		if (flowMeta >= quantaPerBlock) {
			return;
		}

		if (isSourceBlock(world, x, y, z) || !isFlowingVertically(world, x, y, z)) {
			if (world.getBlock(x, y - densityDir, z) == this) {
				flowMeta = 1;
			}
			boolean flowTo[] = getOptimalFlowDirections(world, x, y, z);

			if (flowTo[0])
				flowIntoBlock(world, x - 1, y, z, flowMeta);
			if (flowTo[1])
				flowIntoBlock(world, x + 1, y, z, flowMeta);
			if (flowTo[2])
				flowIntoBlock(world, x, y, z - 1, flowMeta);
			if (flowTo[3])
				flowIntoBlock(world, x, y, z + 1, flowMeta);
		}
		if (!world.isRemote) {
			// System.out.println("Is not remote");

			for (int l = 0; l < 4; ++l) {

				int i1 = x + rand.nextInt(3) - 1;
				int j1 = y + rand.nextInt(5) - 3;
				int k1 = z + rand.nextInt(3) - 1;

				Block spreadable = world.getBlock(i1, j1, k1);
				if (world.getChunkProvider().chunkExists(i1 / 16, k1 / 16)) {
					if (world.getChunkFromBlockCoords(x, z).isChunkLoaded) {
						if (world.getBlock(j1, y - 1, k1) != CMContent.cobaltgrass) {
							if (CMApiReplace.map.containsKey(spreadable)) {
								world.setBlock(i1, j1, k1, CMApiReplace.map.get(spreadable));
							}
						}

					}

				}
			}

		}

	}

}
