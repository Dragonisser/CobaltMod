package cobaltmod.main.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cobaltmod.world.gen.structure.stronghold.SingleStrongholdGenerator;

public class ItemStrongHoldSpawner extends Item {

	public ItemStrongHoldSpawner() {
		super();
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8,
			float par9, float par10) {

		System.out.println("CLICKED");

		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
			return false;
		} else {
			SingleStrongholdGenerator.getInstance().generate(par3World, itemRand, par4, par6, 1.0D);
		}
		return false;

	}

}
