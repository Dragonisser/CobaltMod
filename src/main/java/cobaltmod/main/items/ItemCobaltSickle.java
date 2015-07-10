package cobaltmod.main.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCobaltSickle extends ItemHoe {

	
	public ItemCobaltSickle(ToolMaterial tool)
	{
			super(tool);
	        this.theToolMaterial = tool;
	        this.maxStackSize = 1;
	        this.setMaxDamage(tool.getMaxUses());
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
	    {
			return false;
	    }
		else
		{
			//System.out.println("Used");
 
			if (!par3World.isRemote)
			{
				Block blo = par3World.getBlock(par4, par5, par6);
			  
				if (blo == Blocks.leaves || blo == Blocks.leaves2)
				{
					//System.out.println("Block");
					par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), blo.stepSound.getBreakSound(), (blo.stepSound.getVolume() + 1.0F) / 2.0F, blo.stepSound.getPitch() * 0.8F);
					par1ItemStack.damageItem(1, par2EntityPlayer);
					
					
					Entity entity = new EntityItem(par3World, par4, par5, par6, new ItemStack(Items.string, itemRand.nextInt(3)));
					par3World.spawnEntityInWorld(entity);
					
					Entity entity1 = new EntityItem(par3World, par4, par5, par6, new ItemStack(Item.getItemFromBlock(par3World.getBlock(par4, par5, par6)), 1, par3World.getBlockMetadata(par4, par5, par6)));
					par3World.spawnEntityInWorld(entity1);
					par3World.setBlock(par4, par5, par6, Blocks.air, 0, 2);
				}
			}
		}    
		return false;
	}
}
