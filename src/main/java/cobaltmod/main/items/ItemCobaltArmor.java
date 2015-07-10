package cobaltmod.main.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cobaltmod.main.api.CMContent;

public class ItemCobaltArmor extends ItemArmor {

	
	
	
	public ItemCobaltArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
		//CMStuff.CobaltOreArmor = par2EnumArmorMaterial;
	}
	
	/**
	*  To Add Armor Texture to Player when worn.
	*/
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == CMContent.cobalthelmet || stack.getItem() == CMContent.cobaltboots || stack.getItem() == CMContent.cobaltplate)
		{
			return "mod_cobalt:textures/armor/cobalt_1.png";
		}
		if(stack.getItem() == CMContent.cobaltlegs)
		{
			return "mod_cobalt:textures/armor/cobalt_2.png";
		}
		else return null;
	}
}
