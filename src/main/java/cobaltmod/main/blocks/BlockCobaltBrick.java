package cobaltmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import cobaltmod.handler.AchievementHandler;
import cobaltmod.main.api.CMContent;

public class BlockCobaltBrick extends Block {

	public BlockCobaltBrick() {
		super(Material.rock);
		this.setHardness(5F);
		this.setResistance(2000F);
		this.setStepSound(Block.soundTypeStone);
		this.setTickRandomly(true);

	}

	public void onEntityWalking(World par1World, int par2, int par3, int par4,
			Entity par5Entity) {
		if (par5Entity instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) par5Entity;
			entityplayer.addStat(AchievementHandler.cobaltachiev9, 1);
		}
		super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
	}
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) 
	{
		if (!par1World.isRemote) 
		{
				for (int l = 0; l < 40; ++l) 
				{
					int i1 = par2 + par5Random.nextInt(3) - 1;
					int j1 = par3 + par5Random.nextInt(5) - 3;
					int k1 = par4 + par5Random.nextInt(3) - 1;
					

					if (par1World.getBlock(i1, j1, k1) == Blocks.grass && par1World.getBlockMetadata(i1, j1, k1) == 0 && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) 
					{
						par1World.setBlock(i1, j1, k1, CMContent.cobaltgrass);
					}
				}
			}
	}
}