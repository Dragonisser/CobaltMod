package cobaltmod.main.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCobexHoe extends ItemHoe {
	protected ToolMaterial theToolMaterial;

	public ItemCobexHoe(ToolMaterial tool) {
		super(tool);
		this.theToolMaterial = tool;
		this.maxStackSize = 1;
		this.setMaxDamage(tool.getMaxUses());
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8,
			float par9, float par10) {
		if (par7 == 0) return false;
		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
			return false;
		} else {
			Block var11 = par3World.getBlock(par4, par5, par6);
			Block var12 = par3World.getBlock(par4, par5 + 1, par6);

			if (var12 == Blocks.air && (var11 == CMContent.cobaltgrass || var11 == CMContent.cobaltdirt)) {
				System.out.println("cobalt");
				Block var13 = CMContent.cobaltfarmland;
				par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F),
						var13.stepSound.getBreakSound(), (var13.stepSound.getVolume() + 1.0F) / 2.0F, var13.stepSound.getPitch() * 0.8F);

				if (par3World.isRemote) {
					return true;
				} else {
					par3World.setBlock(par4, par5, par6, var13);
					par1ItemStack.damageItem(1, par2EntityPlayer);
					return true;
				}
			} else if ((par7 != 0 || var12 == Blocks.air) && var11 == Blocks.grass || var11 == Blocks.dirt) {
				System.out.println("normal");
				Block var14 = Blocks.farmland;
				par3World.playSoundEffect((double) ((float) par4 + 0.5F), (double) ((float) par5 + 0.5F), (double) ((float) par6 + 0.5F),
						var14.stepSound.getBreakSound(), (var14.stepSound.getVolume() + 1.0F) / 2.0F, var14.stepSound.getPitch() * 0.8F);

				if (par3World.isRemote) {
					return true;
					
				} else {
					
					par3World.setBlock(par4, par5, par6, var14);
					par1ItemStack.damageItem(1, par2EntityPlayer);
					return true;
				}
			}
			return false;
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	public String func_77842_f() {
		return this.theToolMaterial.toString();
	}

	public int textureID = 0;

}