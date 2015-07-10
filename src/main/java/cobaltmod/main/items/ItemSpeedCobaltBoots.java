package cobaltmod.main.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpeedCobaltBoots extends ItemArmor {
	
	
	public ItemSpeedCobaltBoots(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
		super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
		// TODO Auto-generated constructor stub
	}
	
	/**
	*  To Add Armor Texture to Player when worn.
	*/
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == CMContent.speedcobaltboots)
		{
			return "mod_cobalt:textures/armor/cobalt_1.png";
		}
		else return null;
	}
	
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
	    return EnumRarity.epic;
	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
	    return true;
	}
	
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List list, boolean i)
    {
    list.add(StatCollector.translateToLocal("tooltip.speedboots.first_line"));
    list.add("");
    list.add(StatCollector.translateToLocal("tooltip.speedboots.second_line"));
    }

}
