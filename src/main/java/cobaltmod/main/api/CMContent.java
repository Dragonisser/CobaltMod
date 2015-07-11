package cobaltmod.main.api;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraftforge.fluids.Fluid;

/**
 * Contains all of the Blocks or Item the Mod has added
 */
public enum CMContent {
	INSTANCE;

	// ToolMaterial
	public static ToolMaterial CobaltOreTool;
	public static ToolMaterial CobexTool;
	public static ToolMaterial MagicRodTool;

	// ArmorMaterial
	public static ArmorMaterial CobaltOreArmor;

	// Fluid
	public static Fluid darkwater_fluid;

	// Blocks
	public static Block cobaltore;
	public static Block cobaltgrass;
	public static Block cobaltblock;
	public static Block cobexlog;
	public static Block cobexwood;
	public static Block cobexleaves;
	public static Block cobexsapling;
	public static BlockSlab cobaltbricksingleslab;
	public static BlockSlab cobaltbrickdoubleslab;
	public static Block clematisflower;
	public static Block redcabbagecrop;
	public static Block cobaltbrick;
	public static Block cobaltbrickstair;
	public static Block cobaltstone;
	public static BlockPortal cobaltportal;
	public static Block cobextorch;
	public static Block blueberrybush_full;
	public static Block blueberrybush_empty;
	public static Block ritualstone;
	public static Block altarofassociation;
	public static Block cobexstair;
	public static BlockSlab cobexsingleslab;
	public static BlockSlab cobexdoubleslab;
	public static Block bluefire;
	public static Block bellflower;
	public static Block bouncycobalt;
	public static Block cobaltfurnace_idle;
	public static Block cobaltfurnace_burning;
	public static Block cobexchest;
	public static Block cobexdoor;
	public static Block cobaltdoor;
	public static Block portalframe;
	public static Block cobexworkbench;
	public static Block cobaltbed;
	public static Block darkwater;
	public static Block cobaltrune;
	public static Block carthunore;
	public static Block carthunblock;
	public static Block carthunbrick;
	public static Block carthunbrickstair;
	public static BlockSlab carthunbricksingleslab;
	public static BlockSlab carthunbrickdoubleslab;
	public static Block glowflower;
	public static Block bluevine;
	public static Block waterthorn;
	public static Block corruptedstone;
	public static Block cobaltdirt;
	public static Block cobaltfarmland;
	public static Block podium;
	public static Block bigcobexsapling;
	public static Block bigcobexleaves;
	public static Block bluetallgrass;
	public static Block corruptedstonefurnace_burning;
	public static Block corruptedstonefurnace_idle;
	public static Block lockedcobaltchest;
	public static Block cobaltchest;

	// Items
	public static Item cobaltpickaxe;
	public static Item cobaltaxe;
	public static Item cobaltshovel;
	public static Item cobaltsword;
	public static Item cobalthoe;
	public static Item cobaltingot;
	public static Item cobaltapple;
	public static Item cobexstick;
	public static Item cobexbow;
	public static Item cobexarrow;
	public static Item redcabbageseeds;
	public static Item redcabbage;
	public static Item redcabbagejuice;
	public static Item cocktailglass;
	public static Item cobalthelmet;
	public static Item cobaltplate;
	public static Item cobaltlegs;
	public static Item cobaltboots;
	public static Item cobaltnugget;
	public static Item cobexpickaxe;
	public static Item cobexaxe;
	public static Item cobexshovel;
	public static Item cobexsword;
	public static Item cobexhoe;
	public static Item recipebook;
	public static Item foenumstaff;
	public static Item njossstaff;
	public static Item foenumcrystal;
	public static Item njosscrystal;
	public static Item cobaltstonefragment;
	public static Item cobaltstonecrystal;
	public static Item blueessence;
	public static Item greenessence;
	public static Item blueberry;
	public static Item cobaltfertilizer;
	public static Item fireshard;
	public static Item cobexdoor1;
	public static Item cobaltdoor1;
	public static Item cobaltbed1;
	public static Item stonefragment;
	public static Item stonecrystal;
	public static Item bucket_darkwater;
	public static Item cobaltdivinggoggles;
	public static Item windaxe;
	public static Item lifestealstaff;
	public static Item carthuningot;
	public static Item blueslimeball;
	public static Item cobaltscythe;
	public static Item cobaltsickle;
	public static Item scroll;
	public static Item hunterknife;
	public static Item leatherstrips;
	public static Item bluebackpack;
	public static Item cobaltplatebackpack;
	public static Item bluestring;
	public static Item bluewool;
	public static Item speedcobaltboots;
	public static Item chestkey;
	
	
	
	public static Potion potion_cobalt_resistance;
	public static Potion potion_cobalt_confusion;
	
	// USE ONLY WHEN IC2 IS INSTALLED
	public static Item cobaltdust;
	public static Item cobaltdusttiny;
	public static Item crushed_cobaltore;
	public static Item purified_crushed_cobaltore;
	public static Item carthundust;
	public static Item carthundusttiny;
	public static Item crushed_carthunore;
	public static Item purified_crushed_carthunore;
	
	
	//USE ONLY IF DEVELOPMENT IS ENABLED
	public static Item strholdspawner;
}
