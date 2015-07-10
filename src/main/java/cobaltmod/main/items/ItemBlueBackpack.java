package cobaltmod.main.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;

public class ItemBlueBackpack extends ItemArmor {
	public ItemBlueBackpack(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
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
		if (!world.isRemote) {
			// If player not sneaking, open the inventory gui
			if (!player.isSneaking()) {
				player.openGui(CMMain.instance, 5, world, (int) player.posX, (int) player.posY, (int) player.posZ);
			}
		}

		return itemstack;
	}


	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == CMContent.bluebackpack) {
			return "mod_cobalt:textures/armor/backpack.png";
		} else
			return null;
	}
}