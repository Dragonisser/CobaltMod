package cobaltmod.main.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cobaltmod.main.api.CMContent;

public class ItemCobaltApple extends ItemFood {
	public ItemCobaltApple(int j, boolean B) {
		super(j, B);
		this.setAlwaysEdible();
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		--par1ItemStack.stackSize;
		par3EntityPlayer.getFoodStats().func_151686_a(this, par1ItemStack);
		par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
		// par3EntityPlayer.addPotionEffect(new
		// PotionEffect(Potion.nightVision.id, 300 * 20, 6));
		// par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 300
		// * 20, 6));
		par3EntityPlayer.addPotionEffect(new PotionEffect(CMContent.potion_cobalt_resistance.id, 150 * 20, 1));

		return par1ItemStack;
	}
}