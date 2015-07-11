package cobaltmod.handler.event;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cobaltmod.main.api.CMContent;
import cobaltmod.main.blocks.BlockCobaltPortal;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class CobaltLivingUpdateEventHandler {

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) {

		if (event.entity instanceof EntityPlayerMP) {
			EntityPlayerMP thePlayer = (EntityPlayerMP) event.entity;
			if (!thePlayer.getEntityData().hasKey("TpTime")) {
				thePlayer.getEntityData().setInteger("TpTime", BlockCobaltPortal.getCoolDown());
			}
		}

		if (event.entityLiving.isPotionActive(CMContent.potion_cobalt_resistance)) {
			if (event.entityLiving.getActivePotionEffect(CMContent.potion_cobalt_resistance).getDuration() == 0) {
				event.entityLiving.removePotionEffect(CMContent.potion_cobalt_resistance.id);
				return;
			}
		}
		if (event.entityLiving.isPotionActive(CMContent.potion_cobalt_confusion)) {
			if (event.entityLiving.getActivePotionEffect(CMContent.potion_cobalt_confusion).getDuration() == 0) {
				event.entityLiving.removePotionEffect(CMContent.potion_cobalt_confusion.id);
				return;
			}
		}
	}
}
