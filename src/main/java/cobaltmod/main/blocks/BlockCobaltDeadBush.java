package cobaltmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import cobaltmod.main.api.CMContent;

public class BlockCobaltDeadBush extends BlockBush implements IGrowable {

	protected BlockCobaltDeadBush() {
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

}
