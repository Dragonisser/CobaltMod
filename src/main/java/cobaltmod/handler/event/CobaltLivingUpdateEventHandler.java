package cobaltmod.handler.event;

import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class CobaltLivingUpdateEventHandler {

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) {
		if (event.entityLiving.isPotionActive(CMContent.potion_cobalt_resistance)) {
			if (event.entityLiving.getActivePotionEffect(CMContent.potion_cobalt_resistance).getDuration() == 0) {
				event.entityLiving.removePotionEffect(CMContent.potion_cobalt_resistance.id);
				return;
			}
		}
	}
}
