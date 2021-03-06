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
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cobaltmod.entity.tileentity.TileEntityLockedCobaltChest;
import cobaltmod.main.api.CMContent;
import cobaltmod.renderer.TileEntityLockedCobaltChestRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLockedCobaltChest extends BlockContainer {
	private final Random random = new Random();

	/** 1 for trapped chests, 0 for normal chests. */
	public final int chestType;

	// private static boolean keepInventory = false;
	private final boolean locked;

	public BlockLockedCobaltChest(int par2, boolean par3) {
		super(Material.wood);
		this.chestType = par2;
		this.locked = par3;
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		this.setHardness(2F);
		this.setResistance(1F);
		this.setStepSound(Block.soundTypeWood);
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent b locks and also whether
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
		return TileEntityLockedCobaltChestRenderer.chestRenderId;
	}
	
	@Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
		super.onBlockAdded(world, x, y, z);
    }

	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {

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

		par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 3);

		if (par6ItemStack.hasDisplayName()) {
			((TileEntityLockedCobaltChest) par1World.getTileEntity(par2, par3, par4)).func_145976_a(par6ItemStack.getDisplayName());
		}
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	@Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
    }

	/**
	 * Called on server worlds only when the block has been replaced by a
	 * different block ID, or the same block with a different metadata value,
	 * but before the new metadata value is set. Args: World, x, y, z, old block
	 * ID, old metadata
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6) {
		TileEntityLockedCobaltChest tileentitychest = (TileEntityLockedCobaltChest) par1World.getTileEntity(par2, par3, par4);

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
	
	@Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
		if(world.getBlock(x, y - 1, z) == Blocks.air)
			return false;
		if(world.getBlock(x, y + 1, z) != Blocks.air)
			return false;
		if(world.getBlock(x, y - 1, z).getMaterial().isLiquid())
			return false;
		if(!world.getBlock(x, y - 1, z).getMaterial().isSolid())
			return false;
		
		return true;
    }
	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		} else {

			System.out.println(this.locked);

			IInventory iinventory = this.getInventory(par1World, par2, par3, par4);
			ItemStack item = par5EntityPlayer.getHeldItem();

			if (iinventory != null) {
				if (!this.locked) {
					par5EntityPlayer.displayGUIChest(iinventory);
				} else if (this.locked) {

					if (par5EntityPlayer.getHeldItem() != null) {
						if (par5EntityPlayer.getHeldItem().getItem() != null && par5EntityPlayer.getHeldItem().getItem() == CMContent.chestkey) {
							updateFurnaceBlockState(true, par1World, par2, par3, par4);
							//par5EntityPlayer.addChatMessage(new ChatComponentText("I've unlocked the chest"));
							par5EntityPlayer.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("chatmessage.cobbaltchest.unlocked")));
							item.stackSize--;

						} else {

							par5EntityPlayer.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("chatmessage.cobbaltchest.key_wrong") + " ["
									+ par5EntityPlayer.getHeldItem().getItem().getItemStackDisplayName(item) + "]"));
							return false;
						}
					} else {
						par5EntityPlayer.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("chatmessage.cobbaltchest.key_required")));
					}
				}
			}

		}

		return true;
	}

	public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4) {
		int var5 = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity var6 = par1World.getTileEntity(par2, par3, par4);
		if (par0) {
			par1World.setBlock(par2, par3, par4, CMContent.cobaltchest);
		} else {
			par1World.setBlock(par2, par3, par4, CMContent.lockedcobaltchest);
		}
		// keepInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, var5, 2);

		if (var6 != null) {
			var6.validate();
			par1World.setTileEntity(par2, par3, par4, var6);
		}
	}

	/**
	 * Gets the inventory of the chest at the specified coords, accounting for
	 * blocks or ocelots on top of the chest, and double chests.
	 */
	public IInventory getInventory(World par1World, int par2, int par3, int par4) {
		Object object = (TileEntityLockedCobaltChest) par1World.getTileEntity(par2, par3, par4);

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

			return (IInventory) object;
		}
	}

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
			int i1 = ((TileEntityLockedCobaltChest) par1IBlockAccess.getTileEntity(par2, par3, par4)).numPlayersUsing;
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
		return new TileEntityLockedCobaltChest();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("mod_cobalt:cobaltbrick");
	}

}
