package cobaltmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cobaltmod.main.api.CMApiReplace;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCobexLog extends BlockLog {
	public BlockCobexLog() {
		super();
		this.setTickRandomly(true);
		this.setHardness(3F);
		this.setResistance(4F);
		this.setStepSound(Block.soundTypeWood);

	}

	public static int func_150165_c(int p_150165_0_) {
		return p_150165_0_ & 3;
	}

	@SideOnly(Side.CLIENT)
	private IIcon logtop;

	public int quantityDropped(Random random) {
		return 1;
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock(this);
	}

	public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
		super.harvestBlock(world, entityplayer, i, j, k, l);
	}

	public void onBlockRemoval(World world, int i, int j, int k) {
		byte byte0 = 4;
		int l = byte0 + 1;
		if (world.checkChunksExist(i - l, j - l, k - l, i + l, j + l, k + l)) {
			for (int i1 = -byte0; i1 <= byte0; i1++) {
				for (int j1 = -byte0; j1 <= byte0; j1++) {
					for (int k1 = -byte0; k1 <= byte0; k1++) {
						Block l1 = world.getBlock(i + i1, j + j1, k + k1);
						if (l1 != CMContent.cobexleaves) // Change to your leaf block.
						{
							continue;
						}
						int i2 = world.getBlockMetadata(i + i1, j + j1, k + k1);
						if ((i2 & 8) == 0) {
							world.setBlockMetadataWithNotify(i + i1, j + j1, k + k1, i2, 8);
						}
					}
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("mod_cobalt:cobaltlog");
		this.logtop = par1IconRegister.registerIcon("mod_cobalt:cobaltlogtop");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return par1 == 1 ? this.logtop : (par1 == 0 ? this.logtop : (par2 == 2 && par1 == 2 ? this.blockIcon : (par2 == 3 && par1 == 5 ? this.blockIcon
				: (par2 == 0 && par1 == 3 ? this.blockIcon : (par2 == 1 && par1 == 4 ? this.blockIcon : this.blockIcon)))));
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		if (!par1World.isRemote) {
			for (int l = 0; l < 5; ++l) {

				int i1 = par2 + par5Random.nextInt(3) - 1;
				int j1 = par3 + par5Random.nextInt(5) - 3;
				int k1 = par4 + par5Random.nextInt(3) - 1;

				Block spreadable = par1World.getBlock(i1, j1, k1);
				if (CMApiReplace.map.containsKey(spreadable)) {
					par1World.setBlock(i1, j1, k1, CMApiReplace.map.get(spreadable));
				}
			}
		}
	}

	public int damageDropped(int i) {
		return i;
	}

	public boolean canSustainLeaves(World world, int x, int y, int z) {
		return true;
	}

	public boolean isWood(World world, int x, int y, int z) {
		return true;
	}

	@Override
	protected IIcon getSideIcon(int var1) {
		// TODO Auto-generated method stub
		return blockIcon;
	}
}