package cobaltmod.main;

import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cobaltmod.entity.EntityBlueBuddy;
import cobaltmod.entity.EntityBlueSlime;
import cobaltmod.entity.EntityCobaltGuardian;
import cobaltmod.entity.EntityCobaltGuardianMinion;
import cobaltmod.entity.EntityCobaltZombie;
import cobaltmod.entity.EntityCobexArrow;
import cobaltmod.entity.EntityLifeStealBall;
import cobaltmod.entity.ModelBlueBuddy;
import cobaltmod.entity.ModelCobaltGuardian;
import cobaltmod.entity.ModelCobaltGuardianMinion;
import cobaltmod.entity.ModelCobaltZombie;
import cobaltmod.entity.tileentity.TileEntityAltar;
import cobaltmod.entity.tileentity.TileEntityCobexChest;
import cobaltmod.entity.tileentity.TileEntityLockedCobaltChest;
import cobaltmod.entity.tileentity.TileEntityPodium;
import cobaltmod.entity.tileentity.TileEntityRitualStone;
import cobaltmod.gui.GuiCobaltConfusion;
import cobaltmod.handler.event.CobaltKeyHandler;
import cobaltmod.main.api.CMContent;
import cobaltmod.renderer.RenderAltar;
import cobaltmod.renderer.RenderBlueBuddy;
import cobaltmod.renderer.RenderBlueSlime;
import cobaltmod.renderer.RenderCobaltGuardian;
import cobaltmod.renderer.RenderCobaltGuardianMinion;
import cobaltmod.renderer.RenderCobaltZombie;
import cobaltmod.renderer.RenderCobexArrow;
import cobaltmod.renderer.RenderCobexChest;
import cobaltmod.renderer.RenderItemScroll;
import cobaltmod.renderer.RenderLifeStealBall;
import cobaltmod.renderer.RenderPodium;
import cobaltmod.renderer.RenderRitualStone;
import cobaltmod.renderer.TileEntityCobexChestRenderer;
import cobaltmod.renderer.TileEntityLockedCobaltChestRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ClientProxyCobalt extends CommonProxyCobalt
{
	@Override
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	
	
	public void AddRenderer(Map<?, ?> map)
    {
            //map.put(EntityCobaltArrow.class, new RenderCobaltArrow());
    }
	public void registerClientStuff()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityCobaltZombie.class, new RenderCobaltZombie(new ModelCobaltZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCobaltGuardian.class, new RenderCobaltGuardian(new ModelCobaltGuardian(), 0.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlueBuddy.class, new RenderBlueBuddy(new ModelBlueBuddy(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCobexArrow.class, new RenderCobexArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityCobaltGuardianMinion.class, new RenderCobaltGuardianMinion(new ModelCobaltGuardianMinion(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLifeStealBall.class, new RenderLifeStealBall());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlueSlime.class, new RenderBlueSlime(new ModelSlime(16), new ModelSlime(0), 0.3F));
		
		RenderingRegistry.registerBlockHandler(RenderAltar.altarRenderId, new RenderAltar());
		RenderingRegistry.registerBlockHandler(RenderRitualStone.ritualRenderId, new RenderRitualStone());
		RenderingRegistry.registerBlockHandler(new RenderCobexChest());
		RenderingRegistry.registerBlockHandler(new TileEntityLockedCobaltChestRenderer());
		RenderingRegistry.registerBlockHandler(RenderPodium.podiumRenderId, new RenderPodium());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, new RenderAltar());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCobexChest.class, new TileEntityCobexChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLockedCobaltChest.class, new TileEntityLockedCobaltChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRitualStone.class, new RenderRitualStone());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPodium.class, new RenderPodium());
		
		
		TileEntity.addMapping(TileEntityCobexChest.class, "CobexChest");
		TileEntity.addMapping(TileEntityLockedCobaltChest.class, "LockedCobaltChest");
		TileEntity.addMapping(TileEntityPodium.class, "Podium");
		
		MinecraftForgeClient.registerItemRenderer(CMContent.scroll, (IItemRenderer) new RenderItemScroll());
		FMLCommonHandler.instance().bus().register(new CobaltKeyHandler());
		MinecraftForge.EVENT_BUS.register(new GuiCobaltConfusion(Minecraft.getMinecraft()));
	}
	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		// Note that if you simply return 'Minecraft.getMinecraft().thePlayer',
		// your packets will not work as expected because you will be getting a
		// client player even when you are on the server!
		// Sounds absurd, but it's true.

		// Solution is to double-check side before returning the player:
		return (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
	}
}