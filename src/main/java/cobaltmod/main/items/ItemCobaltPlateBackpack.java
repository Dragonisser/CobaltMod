package cobaltmod.main.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCobaltPlateBackpack extends ItemBlueBackpack {

	public ItemCobaltPlateBackpack(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);

		// ItemStacks that store an NBT Tag Compound are limited to stack size
		// of 1
		setMaxStackSize(1);
		// you'll want to set a creative tab as well, so you can get your item
		setCreativeTab(CMMain.cobalttabitems);
	}

	// Without this method, your inventory will NOT work!!!
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1; // return any value greater than zero
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		return itemstack;
	}


	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == CMContent.cobaltplatebackpack) {
			return "mod_cobalt:textures/armor/platebackpack.png";
		} else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List list, boolean i)
    {
    list.add("Cobaltplate combined with a neat Backpack");
    }

}
