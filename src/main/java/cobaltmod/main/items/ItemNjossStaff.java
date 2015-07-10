package cobaltmod.main.items;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNjossStaff extends Item
{
	protected ToolMaterial theToolMaterial;

	public ItemNjossStaff(ToolMaterial tool)
	{
	         super();//ignore the wood it will have no effect on the actual tool as that is determined in EnumTestMaterial
	         this.theToolMaterial = tool;
	         this.maxStackSize = 1;
	         this.setMaxDamage(tool.getMaxUses());
	}
	public int partikel = 0;
	
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

                 if (par7 == 0 || var12 != Blocks.air || var11 != Blocks.grass)
                 {
                         return false;
                 }
                 else
                 {
                         Block var13 = CMContent.cobaltgrass;
                         par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), var13.stepSound.getBreakSound(), (var13.stepSound.getVolume() + 1.0F) / 2.0F, var13.stepSound.getPitch() * 0.8F);

                         if (par3World.isRemote)
                         {
                                 return true;
                         }
                         else
                         {
                        	 	par3World.setBlock(par4, par5, par6, var13);
                                 partikel = 1;
                                  
                                 if (var14 == Blocks.grass)
                                 {
                                	 par3World.setBlock(par4 + 1, par5, par6, var13);                                	
                                 }
                                 if (var15 == Blocks.grass)
                                 {
                                	 par3World.setBlock(par4 - 1, par5, par6, var13);
                                 }
                                 if (var16 == Blocks.grass)
                                 {
                                	 par3World.setBlock(par4, par5, par6 + 1, var13);
                                 }
                                 if (var17 == Blocks.grass)
                                 {
                                	 par3World.setBlock(par4, par5, par6 - 1, var13);
                                 }
                                 if (var18 == Blocks.grass)
                                 {
                                	 par3World.setBlock(par4 + 1, par5, par6 + 1, var13);
                                 }
                                 if (var19 == Blocks.grass)
                                 {
                                	 par3World.setBlock(par4 - 1, par5, par6 + 1, var13);
                                 }
                                 if (var20 == Blocks.grass)
                                 {
                                	 par3World.setBlock(par4 + 1, par5, par6 - 1, var13);
                                 }
                                 if (var21 == Blocks.grass)
                                 {
                                	 par3World.setBlock(par4 - 1, par5, par6 - 1, var13);
                                 }
                                 par1ItemStack.damageItem(1, par2EntityPlayer);
                                 
                                 return true;
                                 
                                
                         }
                 }
         }
}
@SideOnly(Side.CLIENT)

/**
 * A randomly called display update to be able to add particles or other items for display
 */
public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
{
        par1World.getBlockMetadata(par2, par3, par4);
        float f = (float)par2 + 0.5F;
        float f1 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
        float f2 = (float)par4 + 0.5F;
        float f3 = 0.52F;
        float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

        if (partikel == 1)
        {
            par1World.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            
        }
}

public boolean isFull3D()
{
         return true;
}
public int textureID = 0;


}