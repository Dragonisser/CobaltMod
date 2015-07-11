package cobaltmod.main;

//4650873961059636830

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cobaltmod.entity.EntityBlueBuddy;
import cobaltmod.entity.EntityBlueSlime;
import cobaltmod.entity.EntityCobaltGuardian;
import cobaltmod.entity.EntityCobaltGuardianMinion;
import cobaltmod.entity.EntityCobaltTntPrimed;
import cobaltmod.entity.EntityCobaltZombie;
import cobaltmod.entity.EntityCobexArrow;
import cobaltmod.entity.EntityLifeStealBall;
import cobaltmod.entity.TileEntityAltar;
import cobaltmod.entity.TileEntityCobaltFurnace;
import cobaltmod.entity.TileEntityCobexChest;
import cobaltmod.entity.TileEntityCorruptedStoneFurnace;
import cobaltmod.entity.TileEntityLockedCobaltChest;
import cobaltmod.entity.TileEntityRitualStone;
import cobaltmod.handler.AchievementHandler;
import cobaltmod.handler.GuiHandler;
import cobaltmod.handler.MixerCraftingHandler;
import cobaltmod.handler.RecipeHandler;
import cobaltmod.handler.event.BucketHandler;
import cobaltmod.handler.event.CobaltBlockBreakEventHandler;
import cobaltmod.handler.event.CobaltLivingUpdateEventHandler;
import cobaltmod.handler.event.CobaltPlayerTickEventHandler;
import cobaltmod.handler.event.CraftingHandler;
import cobaltmod.handler.event.PickupHandler;
import cobaltmod.handler.event.SmeltingHandler;
import cobaltmod.handler.ic2.IC2SupportHandler;
import cobaltmod.main.api.CMContent;
import cobaltmod.main.blocks.BlockFluidDarkWater;
import cobaltmod.main.blocks.CMBlocks;
import cobaltmod.main.items.CMItems;
import cobaltmod.main.potion.CMPotions;
import cobaltmod.network.CobaltPacketDispatcher;
import cobaltmod.world.biome.BiomeGenBaseCobalt;
import cobaltmod.world.dimension.WorldProviderCobalt;
import cobaltmod.world.gen.WorldGenerator;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = CMMain.MODID, name = "CobaltMod", version = CMMain.VERSION)
public class CMMain {

	// CreativeTab
	public static CreativeTabs cobalttabitems = new CreativeTabCobalt(CreativeTabs.getNextID(), "cobalttabitems", 1);
	public static CreativeTabs cobalttabblocks = new CreativeTabCobalt(CreativeTabs.getNextID(), "cobalttabblocks", 2);

	// Entity
	static int startEntityId = 3000;

	// Armormaterial
	public static ArmorMaterial BackpackArmor;
	public static ArmorMaterial CobaltBackpackArmor;

	// Dimension
	public static int cobaltdimension;
	public static int portaltemple;

	// WindAxe
	public static int forwardspeed;
	public static int upwardspeed;

	// SpeedBoots
	public static double forwardspeedboots;

	// SkyRender
	@SideOnly(Side.CLIENT)
	public static IRenderHandler skyRenderer;

	// Biome
	public static int biomeplainsid;
	public static int biomehillsid;
	public static int biomeswampid;
	public static int biometallid;
	public static int biomemountainsid;

	// Dev
	public static boolean devenabled;
	public static boolean templeenabled;

	@SidedProxy(clientSide = "cobaltmod.main.ClientProxyCobalt", serverSide = "cobaltmod.main.CommonProxyCobalt")
	public static CommonProxyCobalt proxy;
	public static final String MODID = "mod_cobalt";
	public static final String VERSION = "1.5.7";

	@Instance("mod_cobalt")
	public static CMMain instance;

	public static DamageSource causeCobaltArrowDamage(EntityCobexArrow par0EntityArrow, Entity par1Entity) {
		return (new EntityDamageSourceIndirect("cobexarrow", par0EntityArrow, par1Entity)).setProjectile();
	}

	public static DamageSource causeLifeStealDamage(EntityLifeStealBall par0EntityArrow, Entity par1Entity) {
		return (new EntityDamageSourceIndirect("lifesteal", par0EntityArrow, par1Entity)).setProjectile();
	}

	@SuppressWarnings("static-access")
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event) {

		// Config
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		cobaltdimension = config.get("Dimension", "Cobalt", 20).getInt();
		config.get("Dimension", "Cobalt", 20).comment = "Which ID the Dimension has. Change it if you have problems with other Mods.";

		portaltemple = config.get("PortalTemple", "Spawnrate", 30).getInt();
		config.get("PortalTemple", "Spawnrate", 30).comment = "The Spawnrate of the CobaltTemple. Change it to a low number if you want to find it easier.";

		forwardspeed = config.get("WindAxe", "ForWardSpeed", 1).getInt();
		config.get("WindAxe", "ForWardSpeed", 1).comment = "The forwardspeed the windaxe provides if you rightclick.";

		upwardspeed = config.get("WindAxe", "UpWardSpeed", 1).getInt();
		config.get("WindAxe", "UpWardSpeed", 1).comment = "The upwardspeed the windaxe provides if you rightclick.";

		forwardspeedboots = config.get("Speed_Cobaltboots", "ForWardSpeed", 0.3).getDouble();
		config.get("Speed_Cobaltboots", "ForWardSpeed", 0.3).comment = "The forwardspeed the Cobaltboots of Speed provides. 0.3 will be 30% faster.";

		devenabled = config.get("Development", "Dev Enabled", false).getBoolean(false);
		config.get("Development", "Dev Enabled", false).comment = "To enable the Development Items/Blocks.";

		templeenabled = config.get("Structures", "Temple Enabled", true).getBoolean(true);
		config.get("Structures", "Temple Enabled", true).comment = "To enable the spawning of the Temple.";

		biomehillsid = config.get("BiomeId", "Blue Hills", 50).getInt();
		biomeplainsid = config.get("BiomeId", "Cobalt Plains", 51).getInt();
		biomeswampid = config.get("BiomeId", "Deep Swamp", 52).getInt();
		biometallid = config.get("BiomeId", "Tall Forest", 53).getInt();
		biometallid = config.get("BiomeId", "Highlands", 54).getInt();

		config.get("BiomeId", "Blue Hills", 50).comment = "Change the BiomesIds here if it conflicts with others.";

		config.save();

		BiomeGenBaseCobalt.init();

		this.potionArray();

		// Fluid
		CMContent.darkwater_fluid = new BlockFluidDarkWater("darkwater_fluid");
		FluidRegistry.registerFluid(CMContent.darkwater_fluid);

		// EnumMaterial
		CMContent.CobaltOreArmor = EnumHelper.addArmorMaterial("Cobalt Armor", 50, new int[] { 4, 9, 7, 4 }, 7);
		this.BackpackArmor = EnumHelper.addArmorMaterial("Backpack Armor", -1, new int[] { 0, 1, 0, 0 }, 0);
		this.CobaltBackpackArmor = EnumHelper.addArmorMaterial("Cobalt Backpack Armor", -1, new int[] { 4, 9, 7, 4 }, 0);
		CMContent.CobaltOreTool = EnumHelper.addToolMaterial("CobaltOre Tool", 3, 2000, 15.0F, 4.0F, 20);
		CMContent.CobexTool = EnumHelper.addToolMaterial("CobaltWood Tool", 1, 150, 6.0F, 1.0F, 10);
		CMContent.MagicRodTool = EnumHelper.addToolMaterial("MagicRod Tool", 1, 10, 0.0F, 0.0F, 0);

		// Blocks/Items
		CMBlocks.init();
		CMItems.init();
		CMPotions.init();

		// Proxy
		proxy.registerClientStuff();

		// Handler
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		FMLCommonHandler.instance().bus().register(new PickupHandler());
		FMLCommonHandler.instance().bus().register(new SmeltingHandler());
		FMLCommonHandler.instance().bus().register(new CobaltPlayerTickEventHandler());

		MinecraftForge.EVENT_BUS.register(new CobaltBlockBreakEventHandler());
		MinecraftForge.EVENT_BUS.register(new CobaltLivingUpdateEventHandler());

		// Fluid
		BucketHandler.INSTANCE.buckets.put(CMContent.darkwater, CMContent.bucket_darkwater);
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		CMContent.darkwater_fluid.setBlock(CMContent.darkwater);
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("darkwater_fluid", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(
				CMContent.bucket_darkwater), new ItemStack(Items.bucket));

		// Achievement
		AchievementHandler.init();

		// Dimension
		DimensionManager.registerProviderType(cobaltdimension, WorldProviderCobalt.class, true);
		DimensionManager.registerDimension(cobaltdimension, cobaltdimension);

		// Recipe
		RecipeHandler.init();

		// Mixxer Recipe
		ItemStack[] bartendertest = new ItemStack[9];
		bartendertest[1] = new ItemStack(CMContent.redcabbage);
		MixerCraftingHandler.addRecipe(new ItemStack(CMContent.redcabbagejuice), new ItemStack(CMContent.cocktailglass), bartendertest);

		// GuiHandler
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		CobaltPacketDispatcher.registerPackets();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		// CobaltZombie
		EntityRegistry.registerModEntity(EntityCobaltZombie.class, "CobaltZombie", 1, this, 80, 2, true);
		EntityList.addMapping(EntityCobaltZombie.class, "CobaltZombie", CMMain.getUniqueEntityId());
		registerEntityEgg(EntityCobaltZombie.class, 0x006633, 0x0033CC);

		// CobaltGuardian
		EntityRegistry.registerModEntity(EntityCobaltGuardian.class, "CobaltGuardian", 2, this, 50, 2, true);
		EntityList.addMapping(EntityCobaltGuardian.class, "CobaltGuardian", CMMain.getUniqueEntityId());
		registerEntityEgg(EntityCobaltGuardian.class, 0x999999, 0x0033CC);

		// EntityBlueBuddy
		EntityRegistry.registerModEntity(EntityBlueBuddy.class, "BlueBuddy", 3, this, 50, 2, true);
		EntityList.addMapping(EntityBlueBuddy.class, "BlueBuddy", CMMain.getUniqueEntityId());
		registerEntityEgg(EntityBlueBuddy.class, 0x00CCFF, 0x0033CC);

		// EntityCobaltGuardianMinion
		EntityRegistry.registerModEntity(EntityCobaltGuardianMinion.class, "CobaltGuardianMinion", 4, this, 50, 2, true);
		EntityList.addMapping(EntityCobaltGuardianMinion.class, "CobaltGuardianMinion", CMMain.getUniqueEntityId());
		registerEntityEgg(EntityCobaltGuardianMinion.class, 0x00CCFF, 0xFF0000);

		// EntityBlueSlime
		EntityRegistry.registerModEntity(EntityBlueSlime.class, "BlueSlime", 5, this, 50, 2, true);
		EntityList.addMapping(EntityBlueSlime.class, "BlueSlime", CMMain.getUniqueEntityId());
		registerEntityEgg(EntityBlueSlime.class, 0x99FFFF, 0x0033CC);

		// EntityCobaltTntPrimed
		EntityRegistry.registerModEntity(EntityCobaltTntPrimed.class, "CobaltTntPrimed", 6, this, 50, 2, true);
		EntityList.addMapping(EntityCobaltTntPrimed.class, "CobaltTntPrimed", CMMain.getUniqueEntityId());
		// registerEntityEgg(EntityCobaltTntPrimed.class, 0x99FFFF, 0x0033CC);

		// CobaltArrow
		EntityRegistry.registerModEntity(EntityCobexArrow.class, "CobexArrow", 7, this, 128, 1, true);
		EntityList.addMapping(EntityCobexArrow.class, "CobexArrow", CMMain.getUniqueEntityId());

		// Altar
		GameRegistry.registerTileEntity(TileEntityAltar.class, "tileentityaltar");

		// RitualStone
		GameRegistry.registerTileEntity(TileEntityRitualStone.class, "tileentityritualstone");

		// CobexChest
		GameRegistry.registerTileEntity(TileEntityCobexChest.class, "tileentitycobexchest");

		// Furnace
		GameRegistry.registerTileEntity(TileEntityCobaltFurnace.class, "tileentitycobaltfurnace");

		// Stone Furnace
		GameRegistry.registerTileEntity(TileEntityCorruptedStoneFurnace.class, "tileentitycorruptedstonefurnace");

		// CobaltChest
		GameRegistry.registerTileEntity(TileEntityLockedCobaltChest.class, "tileentitylockedcobaltchest");

		// Worldgenerator Registration
		GameRegistry.registerWorldGenerator(new WorldGenerator(), 0);

		/**
		 * Reason because it lags so intense. Not so good .-.
		 */

		// CMApiReplace.addSpreadingBlock(Blocks.grass, CMContent.cobaltgrass);
		// CMApiReplace.addSpreadingBlock(Blocks.dirt, CMContent.cobaltgrass);
		// CMApiReplace.addSpreadingBlock(Blocks.dirt, CMContent.cobaltdirt);
		// CMApiReplace.addSpreadingBlock(CMContent.cobaltdirt,
		// CMContent.cobaltgrass);
		// CMApiReplace.addSpreadingBlock(Blocks.log, CMContent.cobexlog);
		// CMApiReplace.addSpreadingBlock(Blocks.log2, CMContent.cobexlog);
		// CMApiReplace.addSpreadingBlock(Blocks.leaves, CMContent.cobexleaves);
		// CMApiReplace.addSpreadingBlock(Blocks.leaves2,
		// CMContent.cobexleaves);
		// CMApiReplace.addSpreadingBlock(Blocks.red_flower,
		// CMContent.clematisflower);
		// CMApiReplace.addSpreadingBlock(Blocks.water, CMContent.darkwater);
		// CMApiReplace.addSpreadingBlock(Blocks.vine, CMContent.bluevine);
		// CMApiReplace.addSpreadingBlock(Blocks.waterlily,
		// CMContent.waterthorn);
		// CMApiReplace.addSpreadingBlock(Blocks.yellow_flower,
		// CMContent.glowflower);
		// CMApiReplace.addSpreadingBlock(Blocks.tallgrass,
		// CMContent.bluetallgrass);
	}

	// Entity Egg
	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);
		return startEntityId;
	}

	@SuppressWarnings("unchecked")
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}

	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent evt) {
		// Ic²
		if (Loader.isModLoaded("IC2")) {
			System.out.println("[CobaltMod] Found IC2. Enabling support");
			try {
				IC2SupportHandler.isIC2Installed();
			} catch (Exception e) {
			}
		}
		if (Loader.isModLoaded("NotEnoughItems")) {
			System.out.println("[CobaltMod] Found NEI. Enabling support");
			try {
				// NEISupportHandler.isNEIInstalled();
			} catch (Exception e) {
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void textureHook(TextureStitchEvent.Post event) {
		if (event.map.getTextureType() == 0) {
			CMContent.darkwater_fluid.setIcons(CMContent.darkwater.getIcon(0, 0), CMContent.darkwater.getIcon(1, 0));

		}
	}

	public void potionArray() {
		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

					potionTypes = (Potion[]) f.get(null);
					final Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
					f.set(null, newPotionTypes);
				}
			} catch (Exception e) {
				System.err.println("Severe error, please report this to the mod author:");
				System.err.println(e);
			}
		}
	}
}