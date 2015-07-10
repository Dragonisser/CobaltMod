package cobaltmod.main.items;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCobaltScythe extends ItemHoe {

	
	public ItemCobaltScythe(ToolMaterial tool)
	{
			super(tool);
	        this.theToolMaterial = tool;
	        this.maxStackSize = 1;
	        this.setMaxDamage(tool.getMaxUses());
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
	         if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par3World.isRemote)
	         {
	                 return false;
	         }
	         else
	         {
        		 for (int x = par4 - 1; x <= par4 + 1; x++)
        		 {	 
        			  for (int z = par6 - 1; z <= par6 + 1; z++) 
        			  {
        				  //System.out.println(x + " " + par5 + " " + z);
        				  //System.out.println(par3World.getBlock(x, par5, z));
        				  if (par3World.getBlock(x, par5, z) == Blocks.tallgrass)
        				  {
        					  //System.out.println("Tallgrass");
        					  par1ItemStack.damageItem(1, par2EntityPlayer);
        					  par3World.getBlock(x, par5, z).dropBlockAsItem(par3World, x, par5, z, 0, 0);
        					  par3World.setBlock(x, par5, z, Blocks.air);
        					  
        				  }
        				  if (par3World.getBlock(x, par5, z).getMaterial() == Material.plants && !(par3World.getBlock(x, par5, z) == Blocks.double_plant) && !(par3World.getBlock(x, par5, z) == Blocks.tallgrass))
        				  {
        					  //System.out.println("Plant");
        					  par1ItemStack.damageItem(1, par2EntityPlayer);
        					  par3World.getBlock(x, par5, z).dropBlockAsItem(par3World, x, par5, z, par3World.getBlockMetadata(x, par5, z), 0);
        					  par3World.setBlock(x, par5, z, Blocks.air);
        				  }
        				  if (par3World.getBlock(x, par5, z) == Blocks.double_plant && par3World.getBlock(x, par5 + 1, z) == Blocks.double_plant)
        				  {
        					  //System.out.println("DoublePlant");
        					  par1ItemStack.damageItem(1, par2EntityPlayer);
        					  par3World.getBlock(x, par5, z).dropBlockAsItem(par3World, x, par5, z, par3World.getBlockMetadata(x, par5, z), 0);
        					  par3World.setBlock(x, par5, z, Blocks.air);
        					  par3World.setBlock(x, par5 + 1, z, Blocks.air);
        				  }
        			  }
        		 } 
	         }
			 return false;
	}
}
