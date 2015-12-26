package cobaltmod.handler.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class CobaltBlockBreakEventHandler {

	@SubscribeEvent
	public void CobaltPlayerHarvestEvent(HarvestDropsEvent event) {
		if (event.harvester != null) {
			if (event.block == Blocks.stone) {
				Entity entity = new EntityItem(event.world, event.x, event.y, event.z, new ItemStack(CMContent.stonefragment, 1));

				double d = Math.random();
				if (d < 0.01) {
					event.world.spawnEntityInWorld(entity);
				}
			}
		}
	}
	@SubscribeEvent
	public void CobaltPlayerHarvessdasdtEvent(BiomeEvent event) {
	}
}
