package cobaltmod.main.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCookedRedCabbage extends ItemFood {
	public ItemCookedRedCabbage(int j, boolean B) {
		super(j, B);
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		--par1ItemStack.stackSize;
		par3EntityPlayer.getFoodStats().func_151686_a(this, par1ItemStack);
		par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
		return par1ItemStack;
	}
}