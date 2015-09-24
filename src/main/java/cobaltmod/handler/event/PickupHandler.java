package cobaltmod.handler.event;

import net.minecraft.item.Item;
import cobaltmod.handler.AchievementHandler;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;

public class PickupHandler {
	@SubscribeEvent
	public void onPickup(ItemPickupEvent event) {

		if (event.pickedUp.getEntityItem().getItem() == Item.getItemFromBlock(CMContent.cobaltore)) {
			event.player.addStat(AchievementHandler.cobaltachiev1, 1);
		} else if (event.pickedUp.getEntityItem().getItem() == CMContent.cobaltstonefragment) {
			event.player.addStat(AchievementHandler.cobaltachiev4, 1);
		} else if (event.pickedUp.getEntityItem().getItem() == CMContent.redcabbage) {
			event.player.addStat(AchievementHandler.cobaltachiev11, 1);
		} else if (event.pickedUp.getEntityItem().getItem() == CMContent.recipebook) {
			event.player.addStat(AchievementHandler.cobaltachiev10, 1);
		}
	}
}
