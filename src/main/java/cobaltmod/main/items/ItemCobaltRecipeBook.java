package cobaltmod.main.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cobaltmod.handler.AchievementHandler;
import cobaltmod.handler.GuiHandler;
import cobaltmod.main.CMMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCobaltRecipeBook extends Item
{
    public ItemCobaltRecipeBook()
    {
        super();
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	par3EntityPlayer.openGui(CMMain.instance, GuiHandler.RecipeBookId, par2World, par3EntityPlayer.chunkCoordX, par3EntityPlayer.chunkCoordY, par3EntityPlayer.chunkCoordZ);
    	par3EntityPlayer.addStat(AchievementHandler.cobaltachiev10, 1);
		return par1ItemStack;
    	
    }

    /**
     * Checks isDamagable and if it cannot be stacked
     */
    public boolean isItemTool(ItemStack par1ItemStack)
    {
        return par1ItemStack.stackSize == 1;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
    @SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List list, boolean i)
    {
    list.add("In this Book you will ");
    list.add("find all the Recipes");
    list.add("and Infos about the Mod");
    }
}
