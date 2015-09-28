package cobaltmod.main.items;

import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraftforge.oredict.OreDictionary;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CMItems {
	public static void init() {
		// 1.5.1 Pre1

		CMContent.cobaltingot = new ItemCobaltIngot().setUnlocalizedName(CMMain.MODID + ":cobaltingot").setTextureName(CMMain.MODID + ":cobaltingot")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltapple = new ItemCobaltApple(4, false).setUnlocalizedName(CMMain.MODID + ":cobaltapple").setTextureName(CMMain.MODID + ":cobaltapple")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltpickaxe = new ItemCobaltPickaxe(CMContent.CobaltOreTool).setUnlocalizedName(CMMain.MODID + ":cobaltpickaxe")
				.setTextureName(CMMain.MODID + ":cobaltpickaxe").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltaxe = new ItemCobaltAxe(CMContent.CobaltOreTool).setUnlocalizedName(CMMain.MODID + ":cobaltaxe")
				.setTextureName(CMMain.MODID + ":cobaltaxe").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobalthoe = new ItemCobaltHoe(CMContent.CobaltOreTool).setUnlocalizedName(CMMain.MODID + ":cobalthoe")
				.setTextureName(CMMain.MODID + ":cobalthoe").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltshovel = new ItemCobaltShovel(CMContent.CobaltOreTool).setUnlocalizedName(CMMain.MODID + ":cobaltshovel")
				.setTextureName(CMMain.MODID + ":cobaltshovel").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltsword = new ItemCobaltSword(CMContent.CobaltOreTool).setUnlocalizedName(CMMain.MODID + ":cobaltsword")
				.setTextureName(CMMain.MODID + ":cobaltsword").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobexstick = new ItemCobexStick().setUnlocalizedName(CMMain.MODID + ":cobexstick").setTextureName(CMMain.MODID + ":cobexstick")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobexbow = new ItemCobexBow().setUnlocalizedName(CMMain.MODID + ":cobaltbow").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobexarrow = new ItemCobexArrow().setUnlocalizedName(CMMain.MODID + ":cobexarrow").setTextureName(CMMain.MODID + ":cobexarrow")
				.setCreativeTab(CMMain.cobalttabitems);

		// 1.5.1 Pre2
		CMContent.redcabbageseeds = new ItemRedCabbageSeeds(CMContent.redcabbagecrop, CMContent.cobaltfarmland)
				.setUnlocalizedName(CMMain.MODID + ":redcabbageseeds").setTextureName(CMMain.MODID + ":redcabbageseeds").setCreativeTab(CMMain.cobalttabitems);
		CMContent.redcabbage = new ItemRedCabbage(2, false).setUnlocalizedName(CMMain.MODID + ":redcabbage").setTextureName(CMMain.MODID + ":redcabbage")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.cookedredcabbage = new ItemCookedRedCabbage(4, false).setUnlocalizedName(CMMain.MODID + ":cookedredcabbage")
				.setTextureName(CMMain.MODID + ":cookedredcabbage").setCreativeTab(CMMain.cobalttabitems);

		// 1.5.2 Pre1

		CMContent.cobalthelmet = new ItemCobaltArmor(CMContent.CobaltOreArmor, CMMain.proxy.addArmor("Cobalt"), 0)
				.setUnlocalizedName(CMMain.MODID + ":cobalthelmet").setTextureName(CMMain.MODID + ":cobalthelmet").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltplate = new ItemCobaltArmor(CMContent.CobaltOreArmor, CMMain.proxy.addArmor("Cobalt"), 1)
				.setUnlocalizedName(CMMain.MODID + ":cobaltplate").setTextureName(CMMain.MODID + ":cobaltplate").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltlegs = new ItemCobaltArmor(CMContent.CobaltOreArmor, CMMain.proxy.addArmor("Cobalt"), 2)
				.setUnlocalizedName(CMMain.MODID + ":cobaltlegs").setTextureName(CMMain.MODID + ":cobaltlegs").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltboots = new ItemCobaltArmor(CMContent.CobaltOreArmor, CMMain.proxy.addArmor("Cobalt"), 3)
				.setUnlocalizedName(CMMain.MODID + ":cobaltboots").setTextureName(CMMain.MODID + ":cobaltboots").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltnugget = new ItemCobaltNugget().setUnlocalizedName(CMMain.MODID + ":cobaltnugget").setTextureName(CMMain.MODID + ":cobaltnugget")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobexpickaxe = new ItemCobexPickAxe(CMContent.CobexTool).setUnlocalizedName(CMMain.MODID + ":cobexpickaxe")
				.setTextureName(CMMain.MODID + ":cobexpickaxe").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobexaxe = new ItemCobexAxe(CMContent.CobexTool).setUnlocalizedName(CMMain.MODID + ":cobexaxe").setTextureName(CMMain.MODID + ":cobexaxe")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobexhoe = new ItemCobexHoe(CMContent.CobexTool).setUnlocalizedName(CMMain.MODID + ":cobexhoe").setTextureName(CMMain.MODID + ":cobexhoe")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobexshovel = new ItemCobexShovel(CMContent.CobexTool).setUnlocalizedName(CMMain.MODID + ":cobexshovel")
				.setTextureName(CMMain.MODID + ":cobexshovel").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobexsword = new ItemCobexSword(CMContent.CobexTool).setUnlocalizedName(CMMain.MODID + ":cobexsword")
				.setTextureName(CMMain.MODID + ":cobexsword").setCreativeTab(CMMain.cobalttabitems);

		// 1.5.2 Pre2
		CMContent.recipebook = new ItemCobaltRecipeBook().setUnlocalizedName(CMMain.MODID + ":recipebook").setTextureName(CMMain.MODID + ":recipebook")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.foenumstaff = new ItemFoenumStaff(CMContent.MagicRodTool).setUnlocalizedName(CMMain.MODID + ":foenumstaff")
				.setTextureName(CMMain.MODID + ":foenumstaff").setCreativeTab(CMMain.cobalttabitems);
		CMContent.njossstaff = new ItemNjossStaff(CMContent.MagicRodTool).setUnlocalizedName(CMMain.MODID + ":njossstaff")
				.setTextureName(CMMain.MODID + ":njossstaff").setCreativeTab(CMMain.cobalttabitems);
		CMContent.foenumcrystal = new ItemFoenumCrystal().setUnlocalizedName(CMMain.MODID + ":foenumcrystal").setTextureName(CMMain.MODID + ":foenumcrystal")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.njosscrystal = new ItemNjossCrystal().setUnlocalizedName(CMMain.MODID + ":njosscrystal").setTextureName(CMMain.MODID + ":njosscrystal")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltstonefragment = new ItemCobaltStoneFragment().setUnlocalizedName(CMMain.MODID + ":cobaltstonefragment")
				.setTextureName(CMMain.MODID + ":cobaltstonefragment").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltstonecrystal = new ItemCobaltStoneCrystal().setUnlocalizedName(CMMain.MODID + ":cobaltstonecrystal")
				.setTextureName(CMMain.MODID + ":cobaltstonecrystal").setCreativeTab(CMMain.cobalttabitems);
		CMContent.blueessence = new ItemBlueEssence().setUnlocalizedName(CMMain.MODID + ":blueessence").setTextureName(CMMain.MODID + ":blueessence")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.greenessence = new ItemGreenEssence().setUnlocalizedName(CMMain.MODID + ":greenessence").setTextureName(CMMain.MODID + ":greenessence")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.blueberry = new ItemBlueBerry(1, false).setUnlocalizedName(CMMain.MODID + ":blueberry").setTextureName(CMMain.MODID + ":blueberry")
				.setCreativeTab(CMMain.cobalttabitems);

		// 1.6.2
		CMContent.cobaltfertilizer = new ItemCobaltFertilizer().setUnlocalizedName(CMMain.MODID + ":cobaltfertilizer")
				.setTextureName(CMMain.MODID + ":cobaltfertilizer").setCreativeTab(CMMain.cobalttabitems);
		CMContent.fireshard = new ItemFireShard().setUnlocalizedName(CMMain.MODID + ":fireshard").setTextureName(CMMain.MODID + ":fireshard")
				.setCreativeTab(CMMain.cobalttabitems);

		// 1.6.4

		// 1.7.2

		CMContent.cobexdoor1 = new ItemCobexDoor(Material.wood).setUnlocalizedName(CMMain.MODID + ":cobexdoor1").setTextureName(CMMain.MODID + ":cobexdoor1")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltdoor1 = new ItemCobaltDoor(Material.iron).setUnlocalizedName(CMMain.MODID + ":cobaltdoor1")
				.setTextureName(CMMain.MODID + ":cobaltdoor1").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltbed1 = new ItemCobaltBed().setUnlocalizedName(CMMain.MODID + ":cobaltbed1").setTextureName(CMMain.MODID + ":cobaltbed1")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.stonefragment = new ItemStoneFragment().setUnlocalizedName(CMMain.MODID + ":stonefragment").setTextureName(CMMain.MODID + ":stonefragment")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.stonecrystal = new ItemStoneCrystal().setUnlocalizedName(CMMain.MODID + ":stonecrystal").setTextureName(CMMain.MODID + ":stonecrystal")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.bucket_darkwater = new ItemBucket(CMContent.darkwater).setContainerItem(Items.bucket).setUnlocalizedName(CMMain.MODID + ":bucket_darkwater")
				.setTextureName(CMMain.MODID + ":bucket_darkwater").setCreativeTab(CMMain.cobalttabitems);
		CMContent.windaxe = new ItemWindAxe(CMContent.CobaltOreTool).setUnlocalizedName(CMMain.MODID + ":windaxe").setTextureName(CMMain.MODID + ":windaxe")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.lifestealstaff = new ItemLifeStealStaff(CMContent.MagicRodTool).setUnlocalizedName(CMMain.MODID + ":lifestealstaff").setTextureName(
				CMMain.MODID + ":lifestealstaff");

		// 1.7.10
		CMContent.carthuningot = new ItemCarthunIngot().setUnlocalizedName(CMMain.MODID + ":carthuningot").setTextureName(CMMain.MODID + ":carthuningot")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.blueslimeball = new ItemBlueSlimeBall().setUnlocalizedName(CMMain.MODID + ":blueslimeball").setTextureName(CMMain.MODID + ":blueslimeball")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltscythe = new ItemCobaltScythe(CMContent.CobaltOreTool).setUnlocalizedName(CMMain.MODID + ":cobaltscythe")
				.setTextureName(CMMain.MODID + ":cobaltscythe").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltsickle = new ItemCobaltSickle(CMContent.CobaltOreTool).setUnlocalizedName(CMMain.MODID + ":cobaltsickle")
				.setTextureName(CMMain.MODID + ":cobaltsickle").setCreativeTab(CMMain.cobalttabitems);
		CMContent.scroll = new ItemScroll().setUnlocalizedName(CMMain.MODID + ":scroll").setTextureName(CMMain.MODID + ":scroll");
		CMContent.hunterknife = new ItemHunterKnife().setUnlocalizedName(CMMain.MODID + ":hunterknife").setTextureName(CMMain.MODID + ":hunterknife")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.leatherstrips = new ItemLeatherStrips().setUnlocalizedName(CMMain.MODID + ":leatherstrips").setTextureName(CMMain.MODID + ":leatherstrips")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.bluebackpack = new ItemBlueBackpack(CMMain.BackpackArmor, CMMain.proxy.addArmor("Cobalt"), 1)
				.setUnlocalizedName(CMMain.MODID + ":bluebackpack").setTextureName(CMMain.MODID + ":bluebackpack").setCreativeTab(CMMain.cobalttabitems);
		CMContent.cobaltplatebackpack = new ItemCobaltPlateBackpack(CMMain.CobaltBackpackArmor, CMMain.proxy.addArmor("Cobalt"), 1).setUnlocalizedName(
				CMMain.MODID + ":cobaltplatebackpack").setTextureName(CMMain.MODID + ":cobaltplatebackpack");
		CMContent.bluestring = new ItemBlueString().setUnlocalizedName(CMMain.MODID + ":bluestring").setTextureName(CMMain.MODID + ":bluestring")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.bluewool = new ItemBluewool().setUnlocalizedName(CMMain.MODID + ":bluewool").setTextureName(CMMain.MODID + ":bluewool")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.speedcobaltboots = new ItemSpeedCobaltBoots(CMContent.CobaltOreArmor, CMMain.proxy.addArmor("Cobalt"), 3)
				.setUnlocalizedName(CMMain.MODID + ":speedcobaltboots").setTextureName(CMMain.MODID + ":speedcobaltboots")
				.setCreativeTab(CMMain.cobalttabitems);
		CMContent.chestkey = new ItemChestkey().setUnlocalizedName(CMMain.MODID + ":chestkey").setTextureName(CMMain.MODID + ":chestkey")
				.setCreativeTab(CMMain.cobalttabitems);

		register();
		oredictregister();

		if (CMMain.devenabled) {
			initdev();
			registerdev();

		}

	}

	private static void register() {
		GameRegistry.registerItem(CMContent.blueberry, "blueberry");
		GameRegistry.registerItem(CMContent.fireshard, "fireshard");
		GameRegistry.registerItem(CMContent.cobalthelmet, "cobalthelmet");
		GameRegistry.registerItem(CMContent.cobaltplate, "cobaltplate");
		GameRegistry.registerItem(CMContent.cobaltlegs, "cobaltlegs");
		GameRegistry.registerItem(CMContent.cobaltboots, "cobaltboots");
		GameRegistry.registerItem(CMContent.blueessence, "blueessence");
		GameRegistry.registerItem(CMContent.cobaltaxe, "cobaltaxe");
		GameRegistry.registerItem(CMContent.cobaltpickaxe, "cobaltpickaxe");
		GameRegistry.registerItem(CMContent.cobaltshovel, "cobaltshovel");
		GameRegistry.registerItem(CMContent.cobaltsword, "cobaltsword");
		GameRegistry.registerItem(CMContent.cobalthoe, "cobalthoe");
		GameRegistry.registerItem(CMContent.cobexaxe, "cobexwoodaxe");
		GameRegistry.registerItem(CMContent.cobexpickaxe, "cobexwoodpickaxe");
		GameRegistry.registerItem(CMContent.cobexshovel, "cobexwoodshovel");
		GameRegistry.registerItem(CMContent.cobexsword, "cobexwoodsword");
		GameRegistry.registerItem(CMContent.cobexhoe, "cobexwoodhoe");
		GameRegistry.registerItem(CMContent.cobaltfertilizer, "cobaltfertilizer");
		GameRegistry.registerItem(CMContent.cobexbow, "cobexbow");
		GameRegistry.registerItem(CMContent.cobaltingot, "cobaltingot");
		GameRegistry.registerItem(CMContent.cobexarrow, "cobexarrow");
		GameRegistry.registerItem(CMContent.cobaltapple, "cobaltapple");
		GameRegistry.registerItem(CMContent.cobaltnugget, "cobaltnugget");
		GameRegistry.registerItem(CMContent.recipebook, "recipebook");
		GameRegistry.registerItem(CMContent.cobexstick, "cobexstick");
		GameRegistry.registerItem(CMContent.cobaltstonecrystal, "cobaltstonecrystal");
		GameRegistry.registerItem(CMContent.cobaltstonefragment, "cobaltstonefragment");
		GameRegistry.registerItem(CMContent.foenumcrystal, "foenumcrystal");
		GameRegistry.registerItem(CMContent.foenumstaff, "foenumstaff");
		GameRegistry.registerItem(CMContent.greenessence, "greenessence");
		GameRegistry.registerItem(CMContent.njosscrystal, "njosscrystal");
		GameRegistry.registerItem(CMContent.njossstaff, "njossstaff");
		GameRegistry.registerItem(CMContent.redcabbage, "redcabbage");
		GameRegistry.registerItem(CMContent.cookedredcabbage, "cookedredcabbage");
		GameRegistry.registerItem(CMContent.redcabbageseeds, "redcabbageseeds");
		GameRegistry.registerItem(CMContent.cobexdoor1, "cobexwooddoor");
		GameRegistry.registerItem(CMContent.cobaltdoor1, "cobaltdoor");
		GameRegistry.registerItem(CMContent.cobaltbed1, "cobaltbed");
		GameRegistry.registerItem(CMContent.stonecrystal, "stonecrystal");
		GameRegistry.registerItem(CMContent.stonefragment, "stonefragment");
		GameRegistry.registerItem(CMContent.bucket_darkwater, "bucket_darkwater");
		GameRegistry.registerItem(CMContent.windaxe, "windaxe");
		GameRegistry.registerItem(CMContent.lifestealstaff, "lifestealstaff");
		GameRegistry.registerItem(CMContent.carthuningot, "carthuningot");
		GameRegistry.registerItem(CMContent.blueslimeball, "blueslimeball");
		GameRegistry.registerItem(CMContent.cobaltscythe, "cobaltscythe");
		GameRegistry.registerItem(CMContent.cobaltsickle, "cobaltsickle");
		GameRegistry.registerItem(CMContent.scroll, "scroll");
		GameRegistry.registerItem(CMContent.hunterknife, "hunterknife");
		GameRegistry.registerItem(CMContent.leatherstrips, "leatherstrips");
		GameRegistry.registerItem(CMContent.bluebackpack, "bluebackpack");
		GameRegistry.registerItem(CMContent.cobaltplatebackpack, "cobaltplatebackpack");
		GameRegistry.registerItem(CMContent.bluestring, "bluestring");
		GameRegistry.registerItem(CMContent.bluewool, "bluewool");
		GameRegistry.registerItem(CMContent.speedcobaltboots, "speedcobaltboots");
		GameRegistry.registerItem(CMContent.chestkey, "chestkey");
	}

	private static void oredictregister() {
		OreDictionary.registerOre("ingotCobalt", CMContent.cobaltingot);
		OreDictionary.registerOre("nuggetCobalt", CMContent.cobaltnugget);
		OreDictionary.registerOre("foodBlueBerry", CMContent.blueberry);
		OreDictionary.registerOre("foodRedCabbage", CMContent.redcabbage);
		OreDictionary.registerOre("ingotCarthun", CMContent.carthuningot);

	}

	// Dev

	private static void initdev() {
		CMContent.strholdspawner = new ItemStrongHoldSpawner().setUnlocalizedName(CMMain.MODID + ":strongholdspawner")
				.setTextureName(CMMain.MODID + ":strongholdspawner").setCreativeTab(CMMain.cobalttabitems);

	}

	private static void registerdev() {

		GameRegistry.registerItem(CMContent.strholdspawner, "strongholdspawner");
	}
}
