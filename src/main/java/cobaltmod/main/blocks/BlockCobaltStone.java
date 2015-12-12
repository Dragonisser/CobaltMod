package cobaltmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cobaltmod.entity.EntityCobaltGuardian;
import cobaltmod.entity.EntityCobaltZombie;
import cobaltmod.main.api.CMContent;

public class BlockCobaltStone extends Block {

	Minecraft minecraft;

	public BlockCobaltStone() {
		super(Material.rock);
		this.setHardness(3F);
		this.setResistance(4F);
		this.setStepSound(Block.soundTypeStone);
		this.setTickRandomly(true);

	}

	// EntityPlayer entityplayer;
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		if (par3 > 3) {
			par3 = 3;
		}

		return (Item) (par2Random.nextInt(30 - par3 * 3) == 0 ? CMContent.cobaltstonefragment : Item.getItemFromBlock(this));
	}

	// public void updateTick(World par1World, int par2, int par3, int par4,
	// Random par5Random)
	// {
	// if (!par1World.isRemote)
	// {
	// if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
	// {
	// for (int l = 0; l < 4; ++l)
	// {
	// int i1 = par2 + par5Random.nextInt(3) - 1;
	// int j1 = par3 + par5Random.nextInt(5) - 3;
	// int k1 = par4 + par5Random.nextInt(3) - 1;
	//
	//
	// if (par1World.getBlock(i1, j1, k1) == Blocks.stone &&
	// par1World.getBlockMetadata(i1, j1, k1) == 0 &&
	// par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4)
	// {
	// par1World.setBlock(i1, j1, k1, this);
	// }
	// }
	// }
	// }
	// }

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		float f = 0.0625F;
		return AxisAlignedBB.getBoundingBox((double) ((float) par2 + f), (double) par3, (double) ((float) par4 + f), (double) ((float) (par2 + 1) - f),
				(double) ((float) (par3 + 1) - f), (double) ((float) (par4 + 1) - f));
	}

	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
		if (par5Entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) par5Entity;
			ItemStack[] armor = player.inventory.armorInventory;
			if (armor[0] != null) {
				if (armor[0].getItem() == CMContent.cobaltboots) {
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
		if (par5Entity instanceof EntityCobaltZombie) {
			return;
		}
		if (par5Entity instanceof EntityCobaltGuardian) {
			return;
		}
		par5Entity.attackEntityFrom(DamageSource.magic, 4F);

	}
}