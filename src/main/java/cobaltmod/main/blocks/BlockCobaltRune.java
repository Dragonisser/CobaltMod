package cobaltmod.main.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cobaltmod.entity.EntityCobaltGuardian;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCobaltRune extends Block {

	protected BlockCobaltRune() {
		super(Material.rock);

	}

	@SideOnly(Side.CLIENT)
	IIcon top_bottom;

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("mod_cobalt:cobaltrune_side");
		this.top_bottom = par1IconRegister.registerIcon("mod_cobalt:cobaltrune_top");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return par1 == 1 ? this.top_bottom : (par1 == 0 ? this.top_bottom : (par2 == 2 && par1 == 2 ? this.blockIcon : (par2 == 3 && par1 == 5 ? this.blockIcon
				: (par2 == 0 && par1 == 3 ? this.blockIcon : (par2 == 1 && par1 == 4 ? this.blockIcon : this.blockIcon)))));
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	public boolean onBlockActivated(World par3World, int par4, int par5, int par6, EntityPlayer par2EntityPlayer, int p_149727_6_, float p_149727_7_,
			float p_149727_8_, float p_149727_9_) {
		if (!par3World.isRemote) {
			if (par3World.getBlock(par4, par5 - 1, par6) == CMContent.cobaltbrick && par3World.getBlock(par4, par5 + 1, par6) == CMContent.cobaltbrick
					&& par3World.getBlock(par4, par5 + 2, par6) == CMContent.cobaltbrick) {
				if (par3World.getBlock(par4 + 1, par5 + 1, par6) == CMContent.cobaltbrick
						&& par3World.getBlock(par4 - 1, par5 + 1, par6) == CMContent.cobaltbrick
						&& par3World.getBlock(par4, par5 + 1, par6 + 1) == CMContent.cobaltbrick
						&& par3World.getBlock(par4, par5 + 1, par6 - 1) == CMContent.cobaltbrick) {

					EntityCobaltGuardian entityCG = new EntityCobaltGuardian(par3World);
					entityCG.setLocationAndAngles(par4 + 0.5D, par5 - 1.0D, par6 + 0.5D, 0F, 0F);
					par3World.spawnEntityInWorld(entityCG);

					for (int i = par4 - 1; i < par4 + 2; i++) {
						for (int i1 = par5 - 1; i1 < par5 + 3; i1++) {
							for (int i2 = par6 - 1; i2 < par6 + 2; i2++) {
								par3World.setBlock(i, i1, i2, Blocks.air);
							}
						}
					}
				}
			}

		}
		return false;
	}

}
