package cobaltmod.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.OreDictionary;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;
import cobaltmod.main.items.ItemCarthunSlab;
import cobaltmod.main.items.ItemCobaltSlab;
import cobaltmod.main.items.ItemCobexSlab;
import cobaltmod.main.items.ItemWaterThorn;
import cpw.mods.fml.common.registry.GameRegistry;

public class CMBlocks {

	public static void init() {
		// 1.5.1 Pre1
		CMContent.cobaltore = new BlockCobaltOre().setBlockTextureName(CMMain.MODID + ":cobaltore").setBlockName("cobaltore")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobaltblock = new BlockCobaltBlock().setBlockTextureName(CMMain.MODID + ":cobaltblock").setBlockName("cobaltblock")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobaltgrass = new BlockCobaltGrass().setBlockName("cobaltgrass").setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobexlog = new BlockCobexLog().setBlockName("cobexlog").setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobexleaves = new BlockCobexLeaves().setBlockTextureName(CMMain.MODID + ":cobexleaves").setBlockName("cobexleaves")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobexsapling = new BlockCobexSapling().setBlockName("cobexsapling").setStepSound(Block.soundTypeGrass)
				.setBlockTextureName(CMMain.MODID + ":cobexsapling").setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobexwood = new BlockCobexWood().setBlockName("cobexwood").setBlockTextureName(CMMain.MODID + ":cobexwood")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobaltbricksingleslab = (BlockSlab) new BlockCobaltBrickSlab(false).setBlockName("").setBlockTextureName(CMMain.MODID + ":cobaltbrick")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobaltbrickdoubleslab = (BlockSlab) new BlockCobaltBrickSlab(true).setBlockName("").setBlockTextureName(CMMain.MODID + ":cobaltbrick");
		CMContent.clematisflower = new BlockFlowerClematis(Material.plants).setBlockName("clematisflower")
				.setBlockTextureName(CMMain.MODID + ":clematisflower").setCreativeTab(CMMain.cobalttabblocks);

		// 1.5.1 Pre2
		CMContent.redcabbagecrop = new BlockRedCabbageCrop().setBlockName("redcabbagecrop").setBlockTextureName(CMMain.MODID + ":redcabbagecrop");

		// 1.5.2 Pre1
		CMContent.cobaltbrick = new BlockCobaltBrick().setBlockName("cobaltbrick").setBlockTextureName(CMMain.MODID + ":cobaltbrick")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobaltbrickstair = new BlockCobaltBrickStair(CMContent.cobaltbrick, 0).setBlockName("cobaltbrickstair")
				.setBlockTextureName(CMMain.MODID + ":cobaltbrick").setCreativeTab(CMMain.cobalttabblocks);

		// 1.5.2 Pre2

		CMContent.cobaltstone = new BlockCobaltStone().setBlockName("cobaltstone").setBlockTextureName(CMMain.MODID + ":cobaltstone")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobextorch = new BlockCobexTorch().setBlockName("cobextorch").setBlockTextureName(CMMain.MODID + ":cobalttorch")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.blueberrybush_full = new BlockBlueBerryBushFull(Material.grass).setBlockName("blueberrybushfull").setBlockTextureName(
				CMMain.MODID + ":blueberrybushfull");
		CMContent.blueberrybush_empty = new BlockBlueBerryBushEmpty().setBlockName("blueberrybushempty")
				.setBlockTextureName(CMMain.MODID + ":blueberrybushempty").setCreativeTab(CMMain.cobalttabblocks);
		CMContent.altarofassociation = new BlockAltarOfAssociation(Material.rock).setBlockName("altarofassociation").setBlockTextureName("stone")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.ritualstone = new BlockRitualStone(Material.rock).setBlockName("ritualstone").setBlockTextureName(CMMain.MODID + ":cobaltbrick")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobexstair = new BlockCobexStair(CMContent.cobexwood, 0).setBlockName("cobexstair").setBlockTextureName(CMMain.MODID + ":cobexwood")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobexsingleslab = (BlockSlab) new BlockCobexSlab(false).setBlockName("").setBlockTextureName(CMMain.MODID + ":cobexwood")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobexdoubleslab = (BlockSlab) new BlockCobexSlab(true).setBlockName("").setBlockTextureName(CMMain.MODID + ":cobexwood");

		// 1.6.2
		CMContent.bluefire = new BlockBlueFire().setBlockName("bluefire").setBlockTextureName(CMMain.MODID + ":bluefire_0");

		// 1.6.4
		CMContent.bellflower = new BlockFlowerBell().setBlockName("bellflower").setBlockTextureName(CMMain.MODID + ":bellflower")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.bouncycobalt = new BlockBouncyCobalt().setBlockName("bouncycobalt").setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobaltfurnace_idle = new BlockCobaltFurnace(false).setBlockName("cobaltfurnace_i").setBlockTextureName(CMMain.MODID + ":cobaltfurnace_i")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobaltfurnace_burning = new BlockCobaltFurnace(true).setBlockName("cobaltfurnace_b").setBlockTextureName(CMMain.MODID + ":cobaltfurnace_b");
		CMContent.cobaltportal = (BlockPortal) new BlockCobaltPortal().setBlockName("cobaltportal").setBlockTextureName(CMMain.MODID + ":cobaltportal")
				.setHardness(-1.0F);
		CMContent.cobexchest = new BlockCobexChest(0).setBlockName("cobexchest").setBlockTextureName(CMMain.MODID + ":normal")
				.setCreativeTab(CMMain.cobalttabblocks);

		// 1.7.2

		CMContent.cobexdoor = new BlockCobexDoor(Material.wood).setBlockName("cobexdoor");
		CMContent.cobaltdoor = new BlockCobaltDoor(Material.iron).setBlockName("cobaltdoor");
		CMContent.portalframe = new BlockCobaltPortalFrame().setBlockName("portalframe").setBlockTextureName(CMMain.MODID + ":portalframe")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobexworkbench = new BlockCobexWorkBench().setBlockName("cobexworkbench").setBlockTextureName(CMMain.MODID + ":bluewoodworkbench_side")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobaltbed = new BlockCobaltBed().setBlockName("cobaltbed");
		CMContent.darkwater = new BlockDarkWater(CMContent.darkwater_fluid, Material.water).setHardness(100.0F).setLightOpacity(3).setBlockName("darkwater");
		CMContent.cobaltrune = new BlockCobaltRune().setBlockName("cobaltrune").setBlockTextureName(CMMain.MODID + ":cobaltbrick")
				.setCreativeTab(CMMain.cobalttabblocks);

		// 1.7.10

		CMContent.carthunore = new BlockCarthunOre().setBlockName("carthunore").setBlockTextureName(CMMain.MODID + ":carthunore")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.carthunblock = new BlockCarthunBlock().setBlockName("carthunblock").setBlockTextureName(CMMain.MODID + ":carthunblock")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.carthunbrick = new BlockCarthunBrick().setBlockName("carthunbrick").setBlockTextureName(CMMain.MODID + ":carthunbrick")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.carthunbrickstair = new BlockCarthunBrickStair(CMContent.carthunbrick, 0).setBlockName("carthunbrickstair")
				.setBlockTextureName(CMMain.MODID + ":carthunbrick").setCreativeTab(CMMain.cobalttabblocks);
		CMContent.carthunbricksingleslab = (BlockSlab) new BlockCarthunBrickSlab(false).setBlockName("").setBlockTextureName(CMMain.MODID + ":carthunbrick")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.carthunbrickdoubleslab = (BlockSlab) new BlockCarthunBrickSlab(true).setBlockName("").setBlockTextureName(CMMain.MODID + ":carthunbrick");
		CMContent.glowflower = new BlockGlowFlower().setBlockName("glowflower").setBlockTextureName(CMMain.MODID + ":glowflower")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.bluevine = new BlockBlueVine().setBlockName("bluevine").setBlockTextureName(CMMain.MODID + ":bluevine")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.waterthorn = new BlockWaterThorn().setBlockName("waterthorn").setBlockTextureName(CMMain.MODID + ":waterthorn")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.corruptedstone = new BlockCorruptedStone().setBlockName("corruptedstone").setBlockTextureName(CMMain.MODID + ":corruptedstone")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobaltdirt = new BlockCobaltDirt().setBlockName("cobaltdirt").setBlockTextureName(CMMain.MODID + ":cobaltdirt")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.cobaltfarmland = new BlockCobaltFarmland().setBlockName("cobaltfarmland").setBlockTextureName(CMMain.MODID + ":cobaltfarmland");
		CMContent.podium = new BlockPodium(Material.rock).setBlockName("podium").setBlockTextureName("");

		CMContent.bigcobexsapling = new BlockBigCobexSapling().setBlockName("bigcobexsapling").setStepSound(Block.soundTypeGrass)
				.setBlockTextureName(CMMain.MODID + ":bigcobexsapling").setCreativeTab(CMMain.cobalttabblocks);
		CMContent.bigcobexleaves = new BlockBigCobexLeaves().setBlockTextureName(CMMain.MODID + ":bigcobexleaves").setBlockName("bigcobexleaves")
				.setCreativeTab(CMMain.cobalttabblocks);
		CMContent.bluetallgrass = new BlockBlueTallGrass().setBlockName("bluetallgrass").setBlockTextureName(CMMain.MODID + ":bluetallgrass")
				.setCreativeTab(CMMain.cobalttabblocks);

		CMContent.corruptedstonefurnace_idle = new BlockCorruptedStoneFurnace(false).setBlockName("corruptedstonefurnace_i")
				.setBlockTextureName(CMMain.MODID + ":corruptedstonefurnace_i").setCreativeTab(CMMain.cobalttabblocks);
		CMContent.corruptedstonefurnace_burning = new BlockCorruptedStoneFurnace(true).setBlockName("corruptedstonefurnace_b").setBlockTextureName(
				CMMain.MODID + ":corruptedstonefurnace_b");
		CMContent.cobaltchest = new BlockLockedCobaltChest(0, false).setBlockName("cobaltchest").setCreativeTab(CMMain.cobalttabblocks);
		CMContent.lockedcobaltchest = new BlockLockedCobaltChest(3, true).setBlockName("lockedcobaltchest").setHardness(-1.0F)
				.setCreativeTab(CMMain.cobalttabblocks);

		register();
		setFireInfo();
		oredictregister();

	}

	public static void setFireInfo() {
		Blocks.fire.setFireInfo(CMContent.cobexlog, 5, 20);
		Blocks.fire.setFireInfo(CMContent.cobexleaves, 30, 60);
		Blocks.fire.setFireInfo(CMContent.bigcobexleaves, 30, 60);
		Blocks.fire.setFireInfo(CMContent.cobexwood, 5, 20);
		Blocks.fire.setFireInfo(CMContent.cobexchest, 5, 20);
		Blocks.fire.setFireInfo(CMContent.bluevine, 30, 60);
	}

	public static void register() {
		GameRegistry.registerBlock(CMContent.cobaltore, "cobaltore");
		GameRegistry.registerBlock(CMContent.cobaltgrass, "cobaltgrass");
		GameRegistry.registerBlock(CMContent.cobaltblock, "cobaltblock");
		GameRegistry.registerBlock(CMContent.cobexlog, "cobexlog");
		GameRegistry.registerBlock(CMContent.cobexwood, "cobexwood");
		GameRegistry.registerBlock(CMContent.cobexleaves, "cobexleaves");
		GameRegistry.registerBlock(CMContent.cobexsapling, "cobexsapling");
		GameRegistry.registerBlock(CMContent.cobaltbricksingleslab, ItemCobaltSlab.class, "cobaltbrickslab");
		GameRegistry.registerBlock(CMContent.cobaltbrickdoubleslab, ItemCobaltSlab.class, "cobaltbrickdoubleslab");
		GameRegistry.registerBlock(CMContent.clematisflower, "blueclematis");
		GameRegistry.registerBlock(CMContent.redcabbagecrop, "redcabbagecrop");
		GameRegistry.registerBlock(CMContent.cobaltbrick, "cobaltbrick");
		GameRegistry.registerBlock(CMContent.cobaltbrickstair, "cobaltbrickstair");
		GameRegistry.registerBlock(CMContent.cobaltstone, "cobaltstone");
		GameRegistry.registerBlock(CMContent.cobaltportal, "cobaltportal");
		GameRegistry.registerBlock(CMContent.cobextorch, "cobextorch");
		GameRegistry.registerBlock(CMContent.blueberrybush_full, "blueberrybush_full");
		GameRegistry.registerBlock(CMContent.blueberrybush_empty, "blueberrybush_empty");
		GameRegistry.registerBlock(CMContent.altarofassociation, "altar_of_association");
		GameRegistry.registerBlock(CMContent.ritualstone, "ritualstone");
		GameRegistry.registerBlock(CMContent.cobexstair, "cobexwoodstair");
		GameRegistry.registerBlock(CMContent.cobexsingleslab, ItemCobexSlab.class, "cobexwoodslab");
		GameRegistry.registerBlock(CMContent.cobexdoubleslab, ItemCobexSlab.class, "cobexwooddoubleslab");
		GameRegistry.registerBlock(CMContent.bluefire, "bluefire");
		GameRegistry.registerBlock(CMContent.bellflower, "bellflower");
		GameRegistry.registerBlock(CMContent.bouncycobalt, "bouncycobalt");
		GameRegistry.registerBlock(CMContent.cobaltfurnace_idle, "cobaltfurnace");
		GameRegistry.registerBlock(CMContent.cobaltfurnace_burning, "cobaltfurnace_burning");
		GameRegistry.registerBlock(CMContent.cobexchest, "cobexchest");
		GameRegistry.registerBlock(CMContent.cobexdoor, "cobexwooddoor_b");
		GameRegistry.registerBlock(CMContent.cobaltdoor, "cobaltdoor_b");
		GameRegistry.registerBlock(CMContent.portalframe, "portalframe");
		GameRegistry.registerBlock(CMContent.cobexworkbench, "cobexwoodworkbench");
		GameRegistry.registerBlock(CMContent.cobaltbed, "cobaltbed_b");
		GameRegistry.registerBlock(CMContent.darkwater, "darkwater");
		GameRegistry.registerBlock(CMContent.cobaltrune, "cobaltrune");
		GameRegistry.registerBlock(CMContent.carthunore, "carthunore");
		GameRegistry.registerBlock(CMContent.carthunblock, "carthunblock");
		GameRegistry.registerBlock(CMContent.carthunbrick, "carthunbrick");
		GameRegistry.registerBlock(CMContent.carthunbrickstair, "carthunbrickstair");
		GameRegistry.registerBlock(CMContent.carthunbricksingleslab, ItemCarthunSlab.class, "carthunbricksingleslab");
		GameRegistry.registerBlock(CMContent.carthunbrickdoubleslab, ItemCarthunSlab.class, "carthunbrickdoubleslab");
		GameRegistry.registerBlock(CMContent.glowflower, "glowflower");
		GameRegistry.registerBlock(CMContent.bluevine, "bluevine");
		GameRegistry.registerBlock(CMContent.waterthorn, ItemWaterThorn.class, "waterthorn");
		GameRegistry.registerBlock(CMContent.cobaltdirt, "cobaltdirt");
		GameRegistry.registerBlock(CMContent.corruptedstone, "corruptedstone");
		GameRegistry.registerBlock(CMContent.cobaltfarmland, "cobaltfarmland");
		GameRegistry.registerBlock(CMContent.podium, "podium");
		GameRegistry.registerBlock(CMContent.bigcobexsapling, "bigcobexsapling");
		GameRegistry.registerBlock(CMContent.bigcobexleaves, "bigcobexleaves");
		GameRegistry.registerBlock(CMContent.bluetallgrass, "bluetallgrass");
		GameRegistry.registerBlock(CMContent.corruptedstonefurnace_idle, "corruptedstonefurnace");
		GameRegistry.registerBlock(CMContent.corruptedstonefurnace_burning, "corruptedstonefurnace_burning");
		GameRegistry.registerBlock(CMContent.cobaltchest, "cobaltchest");
		GameRegistry.registerBlock(CMContent.lockedcobaltchest, "lockedcobaltchest");
	}

	public static void oredictregister() {
		OreDictionary.registerOre("oreCobalt", CMContent.cobaltore);
		OreDictionary.registerOre("oreCarthun", CMContent.carthunore);
		OreDictionary.registerOre("treeCobex", CMContent.cobexlog);
		OreDictionary.registerOre("plankCobex", CMContent.cobexwood);

	}

}
