package cobaltmod.handler.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cobaltmod.entity.EntityBlueBuddy;
import cobaltmod.entity.EntityBlueSlime;
import cobaltmod.entity.EntityCobaltGuardian;
import cobaltmod.entity.EntityCobaltGuardianMinion;
import cobaltmod.entity.EntityCobaltZombie;
import cobaltmod.handler.AchievementHandler;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HurtBlocksHandler {

	private int counter = 0;
	
	@SubscribeEvent
	public void onUpdate(LivingUpdateEvent event) {

		double x = event.entity.posX;
		double y = event.entity.posY;
		double z = event.entity.posZ;

		if (!(event.entity.worldObj.getBlock((int) x, (int) y - 1, (int) z) == CMContent.cobaltgrass)) {
			return;
		}
		if (event.entity.chunkCoordX == event.entity.lastTickPosX || event.entity.chunkCoordZ == event.entity.lastTickPosZ) {

			return;
		}

		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;

			player.addStat(AchievementHandler.cobaltachiev, 1);

			ItemStack[] armor = player.inventory.armorInventory;

			if (armor[0] != null) {
				Item item = armor[0].getItem();
				if (item instanceof ItemArmor) {
					ItemArmor itemA = (ItemArmor) item;
					if (itemA.getArmorMaterial() == ItemArmor.ArmorMaterial.CLOTH) {
						player.attackEntityFrom(DamageSource.magic, 2F);
						return;
					}
					if (itemA.getArmorMaterial() == CMContent.CobaltOreArmor || itemA.getArmorMaterial() == ItemArmor.ArmorMaterial.IRON
							|| itemA.getArmorMaterial() == ItemArmor.ArmorMaterial.DIAMOND) {
						return;
					}
				}
			}
		}
		if (event.entity instanceof EntityLivingBase) {
			EntityLivingBase elb = (EntityLivingBase) event.entity;

			if (elb.isPotionActive(CMContent.potion_cobalt_resistance)) {
				return;
			}
		}
		if (event.entity instanceof EntityCobaltZombie) {
			return;
		}
		if (event.entity instanceof EntityCobaltGuardian) {
			return;
		}
		if (event.entity instanceof EntityBlueBuddy) {
			return;
		}
		if (event.entity instanceof EntityCobaltGuardianMinion) {
			return;
		}
		if (event.entity instanceof EntityBlueSlime) {
			return;
		}
		counter++;
		if(counter >= 20) {
			event.entity.attackEntityFrom(DamageSource.magic, 4F);
			counter = 0;
			return;
		}
	}
}
