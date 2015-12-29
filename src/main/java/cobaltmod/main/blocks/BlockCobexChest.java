package cobaltmod.main.blocks;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cobaltmod.entity.tileentity.TileEntityCobexChest;
import cobaltmod.renderer.RenderCobexChest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCobexChest extends BlockContainer {
	private final Random random = new Random();

	/** 1 for trapped chests, 0 for normal chests. */
	public final int chestType;

	public BlockCobexChest(int par2) {
		super(Material.wood);
		this.chestType = par2;
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		this.setHardness(2F);
		this.setResistance(1F);
		this.setStepSound(Block.soundTypeWood);
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
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

	/**
	 * The type of render function that is called for this block
	 */
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return RenderCobexChest.chestRenderId;
		// return 22;
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y,
	 * z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
		if (p_149719_1_.getBlock(p_149719_2_, p_149719_3_, p_149719_4_ - 1) == this) {
			this.setBlockBounds(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
		} else if (p_149719_1_.getBlock(p_149719_2_, p_149719_3_, p_149719_4_ + 1) == this) {
			this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
		} else if (p_149719_1_.getBlock(p_149719_2_ - 1, p_149719_3_, p_149719_4_) == this) {
			this.setBlockBounds(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		} else if (p_149719_1_.getBlock(p_149719_2_ + 1, p_149719_3_, p_149719_4_) == this) {
			this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
		} else {
			this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		}
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
		this.unifyAdjacentChests(par1World, par2, par3, par4);
		Block l = par1World.getBlock(par2, par3, par4 - 1);
		Block i1 = par1World.getBlock(par2, par3, par4 + 1);
		Block j1 = par1World.getBlock(par2 - 1, par3, par4);
		Block k1 = par1World.getBlock(par2 + 1, par3, par4);

		if (l == this) {
			this.unifyAdjacentChests(par1World, par2, par3, par4 - 1);
		}

		if (i1 == this) {
			this.unifyAdjacentChests(par1World, par2, par3, par4 + 1);
		}

		if (j1 == this) {
			this.unifyAdjacentChests(par1World, par2 - 1, par3, par4);
		}

		if (k1 == this) {
			this.unifyAdjacentChests(par1World, par2 + 1, par3, par4);
		}
	}

	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		Block l = par1World.getBlock(par2, par3, par4 - 1);
		Block i1 = par1World.getBlock(par2, par3, par4 + 1);
		Block j1 = par1World.getBlock(par2 - 1, par3, par4);
		Block k1 = par1World.getBlock(par2 + 1, par3, par4);
		byte b0 = 0;
		int l1 = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l1 == 0) {
			b0 = 2;
		}

		if (l1 == 1) {
			b0 = 5;
		}

		if (l1 == 2) {
			b0 = 3;
		}

		if (l1 == 3) {
			b0 = 4;
		}

		if (l != this && i1 != this && j1 != this && k1 != this) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 3);
		} else {
			if ((l == this || i1 == this) && (b0 == 4 || b0 == 5)) {
				if (l == this) {
					par1World.setBlockMetadataWithNotify(par2, par3, par4 - 1, b0, 3);
				} else {
					par1World.setBlockMetadataWithNotify(par2, par3, par4 + 1, b0, 3);
				}

				par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 3);
			}

			if ((j1 == this || k1 == this) && (b0 == 2 || b0 == 3)) {
				if (j1 == this) {
					par1World.setBlockMetadataWithNotify(par2 - 1, par3, par4, b0, 3);
				} else {
					par1World.setBlockMetadataWithNotify(par2 + 1, par3, par4, b0, 3);
				}

				par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 3);
			}
		}

		if (par6ItemStack.hasDisplayName()) {
			((TileEntityCobexChest) par1World.getTileEntity(par2, par3, par4)).func_145976_a(par6ItemStack.getDisplayName());
		}
	}

	/**
	 * Turns the adjacent chests to a double chest.
	 */
	public void unifyAdjacentChests(World par1World, int par2, int par3, int par4) {
		if (!par1World.isRemote) {
			Block l = par1World.getBlock(par2, par3, par4 - 1);
			Block i1 = par1World.getBlock(par2, par3, par4 + 1);
			Block j1 = par1World.getBlock(par2 - 1, par3, par4);
			Block k1 = par1World.getBlock(par2 + 1, par3, par4);
			Block l1;
			Block i2;

			byte b0;
			int j2;

			if (l != this && i1 != this) {
				if (j1 != this && k1 != this) {
					b0 = 3;

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
				} else {
					l1 = par1World.getBlock(j1 == this ? par2 - 1 : par2 + 1, par3, par4 - 1);
					i2 = par1World.getBlock(j1 == this ? par2 - 1 : par2 + 1, par3, par4 + 1);
					b0 = 3;

					if (j1 == this) {
						j2 = par1World.getBlockMetadata(par2 - 1, par3, par4);
					} else {
						j2 = par1World.getBlockMetadata(par2 + 1, par3, par4);
					}

					if (j2 == 2) {
						b0 = 2;
					}

					if ((l.func_149730_j() || l1.func_149730_j()) && !i1.func_149730_j() && !i2.func_149730_j()) {
						b0 = 3;
					}

					if ((i1.func_149730_j() || i2.func_149730_j()) && !l.func_149730_j() && !l1.func_149730_j()) {
						b0 = 2;
					}
				}
			} else {
				l1 = par1World.getBlock(par2 - 1, par3, l == this ? par4 - 1 : par4 + 1);
				i2 = par1World.getBlock(par2 + 1, par3, l == this ? par4 - 1 : par4 + 1);
				b0 = 5;

				if (l == this) {
					j2 = par1World.getBlockMetadata(par2, par3, par4 - 1);
				} else {
					j2 = par1World.getBlockMetadata(par2, par3, par4 + 1);
				}

				if (j2 == 4) {
					b0 = 4;
				}

				if ((j1.func_149730_j() || l1.func_149730_j()) && !k1.func_149730_j() && !i2.func_149730_j()) {
					b0 = 5;
				}

				if ((k1.func_149730_j() || i2.func_149730_j()) && !j1.func_149730_j() && !l1.func_149730_j()) {
					b0 = 4;
				}
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 3);
		}
	}

	/**
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		int l = 0;

		if (par1World.getBlock(par2 - 1, par3, par4) == this) {
			++l;
		}

		if (par1World.getBlock(par2 + 1, par3, par4) == this) {
			++l;
		}

		if (par1World.getBlock(par2, par3, par4 - 1) == this) {
			++l;
		}

		if (par1World.getBlock(par2, par3, par4 + 1) == this) {
			++l;
		}

		return l > 1 ? false : (this.isThereANeighborChest(par1World, par2 - 1, par3, par4) ? false : (this.isThereANeighborChest(par1World, par2 + 1, par3,
				par4) ? false : (this.isThereANeighborChest(par1World, par2, par3, par4 - 1) ? false : !this.isThereANeighborChest(par1World, par2, par3,
				par4 + 1))));
	}

	/**
	 * Checks the neighbor blocks to see if there is a chest there. Args: world,
	 * x, y, z
	 */
	private boolean isThereANeighborChest(World par1World, int par2, int par3, int par4) {
		return par1World.getBlock(par2, par3, par4) != this ? false : (par1World.getBlock(par2 - 1, par3, par4) == this ? true : (par1World.getBlock(par2 + 1,
				par3, par4) == this ? true : (par1World.getBlock(par2, par3, par4 - 1) == this ? true : par1World.getBlock(par2, par3, par4 + 1) == this)));
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		TileEntityCobexChest tileentitychest = (TileEntityCobexChest) par1World.getTileEntity(par2, par3, par4);

		if (tileentitychest != null) {
			tileentitychest.updateContainingBlockInfo();
		}
	}

	/**
	 * Called on server worlds only when the block has been replaced by a
	 * different block ID, or the same block with a different metadata value,
	 * but before the new metadata value is set. Args: World, x, y, z, old block
	 * ID, old metadata
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6) {
		TileEntityCobexChest tileentitychest = (TileEntityCobexChest) par1World.getTileEntity(par2, par3, par4);

		if (tileentitychest != null) {
			for (int j1 = 0; j1 < tileentitychest.getSizeInventory(); ++j1) {
				ItemStack itemstack = tileentitychest.getStackInSlot(j1);

				if (itemstack != null) {
					float f = this.random.nextFloat() * 0.8F + 0.1F;
					float f1 = this.random.nextFloat() * 0.8F + 0.1F;
					EntityItem entityitem;

					for (float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; par1World.spawnEntityInWorld(entityitem)) {
						int k1 = this.random.nextInt(21) + 10;

						if (k1 > itemstack.stackSize) {
							k1 = itemstack.stackSize;
						}

						itemstack.stackSize -= k1;
						entityitem = new EntityItem(par1World, (double) ((float) par2 + f), (double) ((float) par3 + f1), (double) ((float) par4 + f2),
								new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));
						float f3 = 0.05F;
						entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
						entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
						}
					}
				}
			}

			par1World.func_147453_f(par2, par3, par4, par5);
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		} else {

			IInventory iinventory = this.getInventory(par1World, par2, par3, par4);
			if (iinventory != null) {
				par5EntityPlayer.displayGUIChest(iinventory);
			}

			return false;
		}
	}

	/**
	 * Gets the inventory of the chest at the specified coords, accounting for
	 * blocks or ocelots on top of the chest, and double chests.
	 */
	public IInventory getInventory(World par1World, int par2, int par3, int par4) {
		Object object = (TileEntityCobexChest) par1World.getTileEntity(par2, par3, par4);

		if (object == null) {
			return null;
		} else if (par1World.isSideSolid(par2, par3 + 1, par4, DOWN)) {
			return null;
		} else if (isOcelotBlockingChest(par1World, par2, par3, par4)) {
			return null;
		} else if (par1World.getBlock(par2 - 1, par3, par4) == this
				&& (par1World.isSideSolid(par2 - 1, par3 + 1, par4, DOWN) || isOcelotBlockingChest(par1World, par2 - 1, par3, par4))) {
			return null;
		} else if (par1World.getBlock(par2 + 1, par3, par4) == this
				&& (par1World.isSideSolid(par2 + 1, par3 + 1, par4, DOWN) || isOcelotBlockingChest(par1World, par2 + 1, par3, par4))) {
			return null;
		} else if (par1World.getBlock(par2, par3, par4 - 1) == this
				&& (par1World.isSideSolid(par2, par3 + 1, par4 - 1, DOWN) || isOcelotBlockingChest(par1World, par2, par3, par4 - 1))) {
			return null;
		} else if (par1World.getBlock(par2, par3, par4 + 1) == this
				&& (par1World.isSideSolid(par2, par3 + 1, par4 + 1, DOWN) || isOcelotBlockingChest(par1World, par2, par3, par4 + 1))) {
			return null;
		} else {
			if (par1World.getBlock(par2 - 1, par3, par4) == this) {
				object = new InventoryLargeChest("container.chestDouble", (TileEntityCobexChest) par1World.getTileEntity(par2 - 1, par3, par4),
						(IInventory) object);
			}

			if (par1World.getBlock(par2 + 1, par3, par4) == this) {
				object = new InventoryLargeChest("container.chestDouble", (IInventory) object, (TileEntityCobexChest) par1World.getTileEntity(par2 + 1, par3,
						par4));
			}

			if (par1World.getBlock(par2, par3, par4 - 1) == this) {
				object = new InventoryLargeChest("container.chestDouble", (TileEntityCobexChest) par1World.getTileEntity(par2, par3, par4 - 1),
						(IInventory) object);
			}

			if (par1World.getBlock(par2, par3, par4 + 1) == this) {
				object = new InventoryLargeChest("container.chestDouble", (IInventory) object, (TileEntityCobexChest) par1World.getTileEntity(par2, par3,
						par4 + 1));
			}

			return (IInventory) object;
		}
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	/*
	 * public TileEntity createNewTileEntity(World par1World) {
	 * TileEntityCobaltChest tileentitychest = new TileEntityCobaltChest();
	 * return tileentitychest; }
	 */

	/**
	 * Can this block provide power. Only wire currently seems to have this
	 * change based on its state.
	 */
	public boolean canProvidePower() {
		return this.chestType == 1;
	}

	/**
	 * Returns true if the block is emitting indirect/weak redstone power on the
	 * specified side. If isBlockNormalCube returns true, standard redstone
	 * propagation rules will apply instead and this will not be called. Args:
	 * World, X, Y, Z, side. Note that the side is reversed - eg it is 1 (up)
	 * when checking the bottom of the block.
	 */
	public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		if (!this.canProvidePower()) {
			return 0;
		} else {
			int i1 = ((TileEntityCobexChest) par1IBlockAccess.getTileEntity(par2, par3, par4)).numPlayersUsing;
			return MathHelper.clamp_int(i1, 0, 15);
		}
	}

	/**
	 * Returns true if the block is emitting direct/strong redstone power on the
	 * specified side. Args: World, X, Y, Z, side. Note that the side is
	 * reversed - eg it is 1 (up) when checking the bottom of the block.
	 */
	public int isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		return par5 == 1 ? this.isProvidingWeakPower(par1IBlockAccess, par2, par3, par4, par5) : 0;
	}

	/**
	 * Looks for a sitting ocelot within certain bounds. Such an ocelot is
	 * considered to be blocking access to the chest.
	 */
	public static boolean isOcelotBlockingChest(World par0World, int par1, int par2, int par3) {
		Iterator<?> iterator = par0World.getEntitiesWithinAABB(EntityOcelot.class,
				AxisAlignedBB.getBoundingBox((double) par1, (double) (par2 + 1), (double) par3, (double) (par1 + 1), (double) (par2 + 2), (double) (par3 + 1)))
				.iterator();
		EntityOcelot entityocelot;

		do {
			if (!iterator.hasNext()) {
				return false;
			}

			EntityOcelot entityocelot1 = (EntityOcelot) iterator.next();
			entityocelot = (EntityOcelot) entityocelot1;
		} while (!entityocelot.isSitting());

		return true;
	}

	/**
	 * If this returns true, then comparators facing away from this block will
	 * use the value from getComparatorInputOverride instead of the actual
	 * redstone signal strength.
	 */
	public boolean hasComparatorInputOverride() {
		return true;
	}

	/**
	 * If hasComparatorInputOverride returns true, the return value from this is
	 * used instead of the redstone signal strength when this block inputs to a
	 * comparator.
	 */
	public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5) {
		return Container.calcRedstoneFromInventory(this.getInventory(par1World, par2, par3, par4));
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new TileEntityCobexChest();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("mod_cobalt:cobexwood");
	}

}
