package cobaltmod.main.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBluishMushroom extends BlockBush implements IGrowable {

	public static final String[] field_149882_a = new String[] {"small", "big"};
	private static final IIcon[] field_149881_b = new IIcon[field_149882_a.length];

	protected BlockBluishMushroom() {
		super(Material.plants);
		this.setHardness(0.1F);
		this.setResistance(0.2F);
		this.setStepSound(Block.soundTypeGrass);
	}

	public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
		return this.canPlaceBlockOn(p_149742_1_.getBlock(p_149742_2_, p_149742_3_ - 1, p_149742_4_));
	}

	protected boolean canPlaceBlockOn(Block p_149854_1_) {
		return p_149854_1_ == CMContent.hardendcorruptedstone || p_149854_1_ == CMContent.corruptedstone || p_149854_1_ == CMContent.cobaltfarmland;
	}

	public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
		return true;
	}

	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		return (double) p_149852_2_.nextFloat() < 0.4D;
	}

	public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
		return;
	}

	public int damageDropped(int p_149692_1_) {
		return MathHelper.clamp_int(p_149692_1_ & 7, 0, 2);
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        p_149691_2_ &= 7;
        return field_149881_b[MathHelper.clamp_int(p_149691_2_, 0, 2)];     
    }

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
		for(int i = 0; i < field_149882_a.length; i++) {
			p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		for (int i = 0; i < field_149881_b.length; ++i) {
			field_149881_b[i] = p_149651_1_.registerIcon(this.getTextureName() + "_" + field_149882_a[i]);
		}
	}

}
