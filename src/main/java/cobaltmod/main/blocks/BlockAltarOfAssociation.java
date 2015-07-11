package cobaltmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cobaltmod.entity.tileentity.TileEntityAltar;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;
import cobaltmod.renderer.RenderAltar;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAltarOfAssociation extends BlockContainer {

	/** Maps the foot-of-bed block to the head-of-bed block. */
	public static final int[][] footBlockToHeadBlockMap = new int[][] {
			{ 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	private static boolean keepFurnaceInventory = false;

	public BlockAltarOfAssociation(Material par2Material) {
		super(par2Material);
		
		this.setHardness(3F);
		this.setResistance(4F);
		this.setStepSound(Block.soundTypeStone);
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i,
			int j, int k, int l) {
		return false;
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube() {
		return false;
	}
	
	/**
	 * The type of render function that is called for this block
	 */
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return RenderAltar.altarRenderId;
	}


	/*public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {

		boolean flag1 = par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 2 || par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 3;
		boolean flag2 = par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 5 || par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 4;

		float f = 0.875F;
		float f3 = 0.9375F;
		float f4 = 0.125F;
		float f6 = 0.0625F;
		
		
		if (flag1) 
		{
			f = 0.125F;
			f3 = 0.0625F;
			f4 = 0.875F;
			f6 = 0.9375F;
			this.setBlockBounds(f, 0.0F, f3, f4, 0.8125F, f6);
		} 
		else if (flag2)
		{
			f = 0.875F;
			f3 = 0.9375F;
			f4 = 0.125F;
			f6 = 0.0625F;
			this.setBlockBounds(f, 0.0F, f3, f4, 0.8125F, f6);
		}	
	}*/
	
	/*public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) 
	{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
	}*/

	/**
	 * Set the bounds of the bed block.
	 */
	/*private void setBounds() {
		this.setBlockBounds(0.125F, 0.0F, 0.0625F, 0.875F, 0.8125F, 0.9375F);
	}*/

	/**
	 * Adds all intersecting collision boxes to a list. (Be sure to only add
	 * boxes to the list if they intersect the mask.) Parameters: World, X, Y,
	 * Z, mask, list, colliding entity
	 */
	/*
	 * public void addCollisionBoxesToList(World par1World, int par2, int par3,
	 * int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity
	 * par7Entity) { this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.6F, 0.875F, 0.6F);
	 * super.addCollisionBoxesToList(par1World, par2, par3, par4,
	 * par5AxisAlignedBB, par6List, par7Entity);
	 * this.setBlockBoundsForItemRender();
	 * super.addCollisionBoxesToList(par1World, par2, par3, par4,
	 * par5AxisAlignedBB, par6List, par7Entity); }
	 */

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}

	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, Block par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		this.checkFlowerChange(par1World, par2, par3, par4);
	}

	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		this.checkFlowerChange(par1World, par2, par3, par4);
	}

	protected final void checkFlowerChange(World par1World, int par2, int par3,
			int par4) {
		if (!this.canBlockStay(par1World, par2, par3, par4)) {
			this.dropBlockAsItem(par1World, par2, par3, par4,
					par1World.getBlockMetadata(par2, par3, par4), 0);
			par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
		}
	}

	public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
		Block soil = par1World.getBlock(par2, par3 - 1, par4);
		return (soil != Blocks.air);
	}

	/**
	 * set a blocks direction
	 */
	private void setDefaultDirection(World par1World, int par2, int par3,
			int par4) {
		if (!par1World.isRemote) {
			Block l = par1World.getBlock(par2, par3, par4 - 1);
			Block i1 = par1World.getBlock(par2, par3, par4 + 1);
			Block j1 = par1World.getBlock(par2 - 1, par3, par4);
			Block k1 = par1World.getBlock(par2 + 1, par3, par4);
			byte b0 = 3;
			if (l.func_149730_j() && !i1.func_149730_j()) {
				b0 = 3;
			}

			if (i1.func_149730_j() && !l.func_149730_j()) {
				b0 = 2;
			}

			if (j1.func_149730_j() && !k1.func_149730_j()) {
				b0 = 5;
			}

			if (k1.func_149730_j() && !j1.func_149730_j()) {
				b0 = 4;
			}
			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
		}
	}

	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
			EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		int l = MathHelper
				.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if (l == 0) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		}
		if (l == 1) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
		}
		if (l == 2) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		}
		if (l == 3) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		}
		if (par6ItemStack.hasDisplayName()) {
			((TileEntityAltar) par1World.getTileEntity(par2, par3, par4))
					.setGuiDisplayName(par6ItemStack.getDisplayName());
		}
	}

	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		} else {
			TileEntityAltar tileentityfurnace = (TileEntityAltar) par1World.getTileEntity(par2, par3, par4);

			if (tileentityfurnace != null) {
				par5EntityPlayer.openGui(CMMain.instance, 0, par1World, par2, par3, par4);
			}

			return true;
		}
	}

	public void breakBlock(World par1World, int par2, int par3, int par4,
			Block par5, int par6) {
		Random rand = new Random();
		if (!keepFurnaceInventory) {
			TileEntityAltar tileentityfurnace = (TileEntityAltar) par1World
					.getTileEntity(par2, par3, par4);

			if (tileentityfurnace != null) {
				for (int j1 = 0; j1 < tileentityfurnace.getSizeInventory(); ++j1) {
					ItemStack itemstack = tileentityfurnace.getStackInSlot(j1);

					if (itemstack != null) {
						float f = rand.nextFloat() * 0.8F + 0.1F;
						float f1 = rand.nextFloat() * 0.8F + 0.1F;
						float f2 = rand.nextFloat() * 0.8F + 0.1F;

						while (itemstack.stackSize > 0) {
							int k1 = rand.nextInt(21) + 10;

							if (k1 > itemstack.stackSize) {
								k1 = itemstack.stackSize;
							}

							itemstack.stackSize -= k1;
							EntityItem entityitem = new EntityItem(par1World,
									(double) ((float) par2 + f),
									(double) ((float) par3 + f1),
									(double) ((float) par4 + f2),
									new ItemStack(itemstack.getItem(), k1,
											itemstack.getItemDamage()));

							if (itemstack.hasTagCompound()) {
								entityitem.getEntityItem().setTagCompound(
										(NBTTagCompound) itemstack
												.getTagCompound().copy());
							}

							float f3 = 0.05F;
							entityitem.motionX = (double) ((float) rand
									.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) rand
									.nextGaussian() * f3 + 0.2F);
							entityitem.motionZ = (double) ((float) rand
									.nextGaussian() * f3);
							par1World.spawnEntityInWorld(entityitem);
						}
					}
				}

				par1World.func_147453_f(par2, par3, par4, par5);
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new TileEntityAltar();
	}
	
	public static void updateFurnaceBlockState(boolean par0, World par1World,
			int par2, int par3, int par4) {
		int var5 = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity var6 = par1World.getTileEntity(par2, par3, par4);
		keepFurnaceInventory = true;
		if (par0) {
			par1World.setBlock(par2, par3, par4,
					CMContent.altarofassociation);
		} else {
			par1World.setBlock(par2, par3, par4, CMContent.altarofassociation);
		}
		keepFurnaceInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, var5, 2);

		if (var6 != null) {
			var6.validate();
			par1World.setTileEntity(par2, par3, par4, var6);
		}
	}

}
