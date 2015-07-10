package cobaltmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cobaltmod.handler.AchievementHandler;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlueBerryBushFull extends BlockCrops {

	public BlockBlueBerryBushFull(Material par2Material) {
		super();
		this.setTickRandomly(true);
		this.setHardness(0.6F);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.setStepSound(Block.soundTypeGrass);
	}

	public BlockBlueBerryBushFull(int par1) {
		this(Material.grass);
	}

	public int getRenderType() {
		return 1;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
		return AxisAlignedBB.getBoundingBox((double) p_149668_2_ + this.minX, (double) p_149668_3_ + this.minY, (double) p_149668_4_ + this.minZ,
				(double) p_149668_2_ + this.maxX, (double) p_149668_3_ + this.maxY, (double) p_149668_4_ + this.maxZ);
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.getBlock(x, y - 1, z) == CMContent.cobaltgrass || world.getBlock(x, y - 1, z) == CMContent.cobaltfarmland;
	}

	@Override
	protected boolean canPlaceBlockOn(Block block) {
		return block == CMContent.cobaltgrass || block == CMContent.cobaltfarmland;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

	protected Item func_149866_i() {
		return Item.getItemFromBlock(CMContent.blueberrybush_empty);
	}

	/**
	 * Generate a crop produce ItemStack for this crop.
	 */
	protected Item func_149865_P() {
		return null;
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock(CMContent.blueberrybush_empty);
	}

	/**
	 * Drops the block items with a specified chance of dropping the specified
	 * items
	 */
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return blockIcon;
	}

	public int quantityDropped(Random par1Random) {
		return 1;
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		par1World.setBlock(par2, par3, par4, CMContent.blueberrybush_empty);
		par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);

		par5EntityPlayer.addStat(AchievementHandler.cobaltachiev12, 1);

		int i = 1 + par1World.rand.nextInt(2);
		return par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(CMContent.blueberry, i));
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("mod_cobalt:blueberrybushfull");
	}
}