package cobaltmod.handler.event;

import java.util.UUID;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.item.ItemStack;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class CobaltPlayerTickEventHandler {

	private static final UUID cobaltspeedBootsMoveBonusUUID = UUID.fromString("36A0FC05-50EB-460B-8961-615633A6D813");

	private static final AttributeModifier cobaltspeedBootsMoveBonus = (new AttributeModifier(cobaltspeedBootsMoveBonusUUID, "Cobalt Speed Boots Speed Bonus",
			CMMain.forwardspeedboots, 2)).setSaved(false);

	@SuppressWarnings("unused")
	private boolean bootson = false;

	private int i = 0;

	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event) {

		// ItemStack item = event.player.getHeldItem() ;
		// if (item != null && item.getItem() instanceof ItemTool) {
		// System.out.println(item.getItem().getHarvestLevel(item, "pickaxe"));
		// System.out.println(item.getItem().getHarvestLevel(item, "shovel"));
		// System.out.println(item.getItem().getHarvestLevel(item, "axe"));
		// }

		if (event.side.isClient() && event.phase.equals(TickEvent.Phase.START)) {
			IAttributeInstance movement = event.player.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			ItemStack[] is = event.player.inventory.armorInventory;

			if (is[0] != null) {

				if (is[0].getItem() == CMContent.speedcobaltboots) {

					this.bootson = true;

					if (movement.getModifier(cobaltspeedBootsMoveBonusUUID) != null) {
						movement.removeModifier(cobaltspeedBootsMoveBonus);
					}
					movement.applyModifier(cobaltspeedBootsMoveBonus);

					double d0 = event.player.worldObj.rand.nextGaussian() * 0.02D;
					double d1 = event.player.worldObj.rand.nextGaussian() * 0.02D;
					double d2 = event.player.worldObj.rand.nextGaussian() * 0.02D;

					double dx = event.player.posX;
					double dy = event.player.posY - 1.7;
					double dz = event.player.posZ + 0.2;

					this.i++;

					if ((!(event.player.motionZ == 0.0) || !(event.player.motionZ == 0.0)) && !event.player.isWet()
							&& !event.player.capabilities.isCreativeMode && !event.player.isSneaking()) {
						if (this.i >= 3) {
							event.player.worldObj.spawnParticle("cloud", dx, dy, dz, d0, d1, d2);
							this.i = 0;
						}
					} else if (event.player.capabilities.isCreativeMode || this.i >= 10) {
						this.i = 0;
					}
				}
			} else {
				if (this.bootson = true) {
					this.bootson = false;
					movement.removeModifier(cobaltspeedBootsMoveBonus);
				}
			}
		}
	}
}
