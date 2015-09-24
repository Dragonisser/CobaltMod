package cobaltmod.handler.event;

import cobaltmod.handler.AchievementHandler;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class SmeltingHandler {
	@SubscribeEvent
	public void onSmelting(ItemSmeltedEvent event) {
		if (event.smelting.getItem() == CMContent.blueessence || event.smelting.getItem() == CMContent.greenessence) {
			event.player.addStat(AchievementHandler.cobaltachiev15, 1);
		}
	}
}
