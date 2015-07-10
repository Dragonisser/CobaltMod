package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBouncyCobalt extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon blocktop;
	@SideOnly(Side.CLIENT)
	private IIcon blockbottom;

	public BlockBouncyCobalt() {
		super(Material.rock);
		this.setHardness(2F);
		this.setResistance(3F);
		this.setStepSound(Block.soundTypeStone);

	}

	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDispenserDefaultDirection(par1World, par2, par3, par4);
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		int l = BlockPistonBase.determineOrientation(par1World, par2, par3, par4, par5EntityLivingBase);
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
	}

	private void setDispenserDefaultDirection(World par1World, int par2, int par3, int par4) {
		if (!par1World.isRemote) {
			Block l = par1World.getBlock(par2, par3, par4 - 1);
			Block i1 = par1World.getBlock(par2, par3, par4 + 1);
			Block j1 = par1World.getBlock(par2 - 1, par3, par4);
			Block k1 = par1World.getBlock(par2 + 1, par3, par4);
			byte b0 = 3;

			if (l.func_149730_j() && !l.func_149730_j()) {
				b0 = 3;
			}

			if (i1.func_149730_j() && !i1.func_149730_j()) {
				b0 = 2;
			}

			if (j1.func_149730_j() && !j1.func_149730_j()) {
				b0 = 5;
			}

			if (k1.func_149730_j() && !k1.func_149730_j()) {
				b0 = 4;
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
		}
	}

	public static int getDirection(int par0) {
		return par0 & 3;
	}

	protected int getInputStrength(World par1World, int par2, int par3, int par4, int par5) {

		int i1 = getDirection(par5);
		int j1 = par2 + Direction.offsetX[i1];
		int k1 = par4 + Direction.offsetZ[i1];
		int l1 = par1World.getIndirectPowerLevelTo(j1, par3, k1, Direction.directionToFacing[i1]);
		return l1 >= 15 ? l1 : Math.max(l1, par1World.getBlock(j1, par3, k1) == Blocks.redstone_wire ? par1World.getBlockMetadata(j1, par3, k1) : 0);
	}

	protected boolean isGettingInput(World par1World, int par2, int par3, int par4, int par5) {
		return this.getInputStrength(par1World, par2, par3, par4, par5) > 0;
	}

	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
			par5Entity.motionY = 1.0F;
		}
	}

	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6) {
		par5Entity.fallDistance = 0.0F;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return p_149691_1_ == 1 ? this.blocktop : (p_149691_1_ == 0 ? this.blockbottom : this.blockIcon);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.blockIcon = p_149651_1_.registerIcon("mod_cobalt:bouncycobalt_side");
		this.blocktop = p_149651_1_.registerIcon("mod_cobalt:bouncycobalt_top");
		this.blockbottom = p_149651_1_.registerIcon("mod_cobalt:bouncycobalt_bottom");
	}
}