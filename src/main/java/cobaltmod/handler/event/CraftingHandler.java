package cobaltmod.handler.event;

import net.minecraft.item.Item;
import cobaltmod.handler.AchievementHandler;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandler
{
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) 
    {
		
            if (event.crafting.getItem() == Item.getItemFromBlock(CMContent.cobaltblock))
            {
                    event.player.addStat(AchievementHandler.cobaltachiev3, 1);
            }
            else if (event.crafting.getItem() == CMContent.cobaltapple)
            {
                    event.player.addStat(AchievementHandler.cobaltachiev2, 1);
            }
            else if (event.crafting.getItem() == Item.getItemFromBlock(CMContent.altarofassociation))
            {
            	event.player.addStat(AchievementHandler.cobaltachiev5, 1);
            }
            else if (event.crafting.getItem() == Item.getItemFromBlock(CMContent.ritualstone))
            {
            	event.player.addStat(AchievementHandler.cobaltachiev6, 1);
            }
            else if (event.crafting.getItem() == CMContent.cobalthoe || event.crafting.getItem() == CMContent.cobaltshovel || event.crafting.getItem() == CMContent.cobaltaxe || event.crafting.getItem() == CMContent.cobaltpickaxe)
            {
            	event.player.addStat(AchievementHandler.cobaltachiev16, 1);
            }
            else if (event.crafting.getItem() == CMContent.cobaltsword || event.crafting.getItem() == CMContent.cobexbow)
            {
            	event.player.addStat(AchievementHandler.cobaltachiev17, 1);
            }
            else if (event.crafting.getItem() == CMContent.cobaltboots || event.crafting.getItem() == CMContent.cobaltlegs || event.crafting.getItem() == CMContent.cobalthelmet || event.crafting.getItem() == CMContent.cobaltplate)
            {
            	event.player.addStat(AchievementHandler.cobaltachiev18, 1);
            }
            else if (event.crafting.getItem() == CMContent.njossstaff)
            {
                    event.player.addStat(AchievementHandler.cobaltachiev8, 1);
            }
    }  
}
