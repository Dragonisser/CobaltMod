package cobaltmod.main.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cobaltmod.main.api.CMContent;

public class ItemFoenumStaff extends Item
{
	protected ToolMaterial theToolMaterial;

	public ItemFoenumStaff(ToolMaterial MagicRodTool)
	{
	         super();//ignore the wood it will have no effect on the actual tool as that is determined in EnumTestMaterial
	         this.theToolMaterial = MagicRodTool;
	         this.maxStackSize = 1;
	         this.setMaxDamage(MagicRodTool.getMaxUses());
	}
public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
{
         if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
         {
                 return false;
         }
         else
         {
                 Block var11 = par3World.getBlock(par4, par5, par6);
                 Block var12 = par3World.getBlock(par4, par5 + 1, par6);
                 //edit 
                 Block var14 = par3World.getBlock(par4 + 1, par5, par6);
                 Block var15 = par3World.getBlock(par4 - 1, par5, par6);
                 Block var16 = par3World.getBlock(par4, par5, par6 + 1);
                 Block var17 = par3World.getBlock(par4, par5, par6 - 1);
                 Block var18 = par3World.getBlock(par4 + 1, par5, par6 + 1);
                 Block var19 = par3World.getBlock(par4 - 1, par5, par6 + 1);
                 Block var20 = par3World.getBlock(par4 + 1, par5, par6 - 1);
                 Block var21 = par3World.getBlock(par4 - 1, par5, par6 - 1);

                 if (par7 == 0 || var12 != Blocks.air || var11 != CMContent.cobaltgrass)
                 {
                         return false;
                 }
                 else
                 {
                         Block var13 = Blocks.grass;
                         par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), var13.stepSound.getBreakSound(), (var13.stepSound.getVolume() + 1.0F) / 2.0F, var13.stepSound.getPitch() * 0.8F);

                         if (par3World.isRemote)
                         {
                                 return true;
                         }
                         else
                         {
                                 par3World.setBlock(par4, par5, par6, var13);
                                 if (var14 == CMContent.cobaltgrass)
                                 {
                                	 par3World.setBlock(par4 + 1, par5, par6, var13);
                                	
                                 }
                                 if (var15 == CMContent.cobaltgrass)
                                 {
                                	 par3World.setBlock(par4 - 1, par5, par6, var13);
                                 }
                                 if (var16 == CMContent.cobaltgrass)
                                 {
                                	 par3World.setBlock(par4, par5, par6 + 1, var13);
                                 }
                                 if (var17 == CMContent.cobaltgrass)
                                 {
                                	 par3World.setBlock(par4, par5, par6 - 1, var13);
                                 }
                                 if (var18 == CMContent.cobaltgrass)
                                 {
                                	 par3World.setBlock(par4 + 1, par5, par6 + 1, var13);
                                 }
                                 if (var19 == CMContent.cobaltgrass)
                                 {
                                	 par3World.setBlock(par4 - 1, par5, par6 + 1, var13);
                                 }
                                 if (var20 == CMContent.cobaltgrass)
                                 {
                                	 par3World.setBlock(par4 + 1, par5, par6 - 1, var13);
                                 }
                                 if (var21 == CMContent.cobaltgrass)
                                 {
                                	 par3World.setBlock(par4 - 1, par5, par6 - 1, var13);
                                 }
                                 par1ItemStack.damageItem(1, par2EntityPlayer);
                                 return true;
                         }
                 }
         }
}
public boolean isFull3D()
{
         return true;
}
public int textureID = 0;


}