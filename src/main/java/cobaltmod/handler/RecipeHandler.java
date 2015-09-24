package cobaltmod.handler;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler 
{
	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(CMContent.cobaltblock, 1), new Object [] {"###", "###", "###", Character.valueOf('#'), CMContent.cobaltingot});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltpickaxe, 1), new Object [] {"###", " % ", " % ", Character.valueOf('#'), CMContent.cobaltingot, Character.valueOf('%'), CMContent.cobexstick});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltaxe, 1), new Object [] {"## ", "#% ", " % ", Character.valueOf('#'), CMContent.cobaltingot, Character.valueOf('%'), CMContent.cobexstick});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobalthoe, 1), new Object [] {"## ", " % ", " % ", Character.valueOf('#'), CMContent.cobaltingot, Character.valueOf('%'), CMContent.cobexstick});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltshovel, 1), new Object [] {"#", "%", "%", Character.valueOf('#'), CMContent.cobaltingot, Character.valueOf('%'), CMContent.cobexstick});
	    GameRegistry.addRecipe(new ItemStack(CMContent.cobaltsword, 1), new Object [] {"#", "#", "%", Character.valueOf('#'), CMContent.cobaltingot, Character.valueOf('%'), CMContent.cobexstick});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltingot, 9), new Object [] {"#", Character.valueOf('#'), CMContent.cobaltblock});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltapple, 1), new Object [] {"###", "#%#", "###", Character.valueOf('#'), CMContent.blueessence, Character.valueOf('%'), Items.apple});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobexstick, 4), new Object [] {"#", "#", Character.valueOf('#'), CMContent.cobexwood});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobexwood, 4), new Object [] {"#", Character.valueOf('#'), CMContent.cobexlog});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltbricksingleslab, 3), new Object [] {"###", Character.valueOf('#'), CMContent.cobaltbrick});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobexbow, 1), new Object [] {" #%", "# %", " #%", Character.valueOf('#'), CMContent.cobexstick, Character.valueOf('%'), Items.string});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobexarrow, 5), new Object [] {"%", "#", "$", Character.valueOf('#'), CMContent.cobexstick, Character.valueOf('%'), Items.flint, Character.valueOf('$'), Items.feather});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltingot, 1), new Object [] {"###", "###", "###", Character.valueOf('#'), CMContent.cobaltnugget});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobexpickaxe, 1), new Object [] {"###", " % ", " % ", Character.valueOf('#'), CMContent.cobexwood, Character.valueOf('%'), CMContent.cobexstick});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobexaxe, 1), new Object [] {"## ", "#% ", " % ", Character.valueOf('#'), CMContent.cobexwood, Character.valueOf('%'), CMContent.cobexstick});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobexhoe, 1), new Object [] {"## ", " % ", " % ", Character.valueOf('#'), CMContent.cobexwood, Character.valueOf('%'), CMContent.cobexstick});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobexshovel, 1), new Object [] {"#", "%", "%", Character.valueOf('#'), CMContent.cobexwood, Character.valueOf('%'), CMContent.cobexstick});
	    GameRegistry.addRecipe(new ItemStack(CMContent.cobexsword, 1), new Object [] {"#", "#", "%", Character.valueOf('#'), CMContent.cobexwood, Character.valueOf('%'), CMContent.cobexstick});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.njossstaff, 1), new Object [] {"#", "%", "%", Character.valueOf('#'), CMContent.njosscrystal, Character.valueOf('%'), CMContent.cobexstick});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.foenumstaff, 1), new Object [] {"#", "%", "%", Character.valueOf('#'), CMContent.foenumcrystal, Character.valueOf('%'), CMContent.cobexstick});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobexsingleslab, 3), new Object [] {"###", Character.valueOf('#'), CMContent.cobexwood});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltbrickstair, 4), new Object [] {"#  ", "## ", "###", Character.valueOf('#'), CMContent.cobaltbrick});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobexstair, 4), new Object [] {"#  ", "## ", "###", Character.valueOf('#'), CMContent.cobexwood});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobextorch, 4), new Object [] {"#", "%", Character.valueOf('#'), CMContent.blueslimeball, Character.valueOf('%'), CMContent.cobexstick});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.altarofassociation, 1), new Object [] {"#%#", " # ", "###", Character.valueOf('#'), Blocks.stone, Character.valueOf('%'), CMContent.cobaltingot});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.ritualstone, 1), new Object [] {"$ $", "#%#", "###", Character.valueOf('#'), CMContent.cobaltbrick, Character.valueOf('%'), CMContent.cobaltstonecrystal, Character.valueOf('$'), CMContent.cobaltingot});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobexchest, 1), new Object [] {"###", "# #", "###", Character.valueOf('#'), CMContent.cobexwood});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltfurnace_idle, 1), new Object [] {"###", "# #", "###", Character.valueOf('#'), CMContent.cobaltingot});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.bouncycobalt, 1), new Object [] {"###", "$%$", "$&$", Character.valueOf('#'), CMContent.blueslimeball, Character.valueOf('%'), CMContent.cobaltstonecrystal, Character.valueOf('$'), CMContent.cobaltbrick, Character.valueOf('&'), Items.redstone});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.fireshard, 1), new Object [] {"###", "#%#", "###", Character.valueOf('#'), CMContent.cobaltnugget, Character.valueOf('%'), Items.flint});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltdoor1, 1), new Object [] {"##", "##", "##", Character.valueOf('#'), CMContent.cobaltingot});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobexdoor1, 1), new Object [] {"##", "##", "##", Character.valueOf('#'), CMContent.cobexwood});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobexworkbench, 1), new Object [] {"##", "##", Character.valueOf('#'), CMContent.cobexwood});	
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobalthelmet, 1), new Object [] {"###", "# #", Character.valueOf('#'), CMContent.cobaltingot});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltplate, 1), new Object [] {"# #", "###", "###", Character.valueOf('#'), CMContent.cobaltingot});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltlegs, 1), new Object [] {"###", "# #", "# #", Character.valueOf('#'), CMContent.cobaltingot});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltboots, 1), new Object [] {"# #", "# #", Character.valueOf('#'), CMContent.cobaltingot});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltbed1, 1), new Object [] {"%%%", "###", '#', CMContent.cobaltbrick, '%', Blocks.wool});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltfertilizer, 4), new Object [] {"$#$", "#%#", "$#$", '#', CMContent.cobexsapling, '%', new ItemStack(Items.dye, 1 ,15 ), '$', CMContent.blueessence});
	  	GameRegistry.addShapelessRecipe(new ItemStack(CMContent.leatherstrips, 4), new ItemStack(CMContent.hunterknife, 1, OreDictionary.WILDCARD_VALUE), Items.leather);
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltsickle, 1), new Object [] {"%%%", "  %", "##%", '#', CMContent.cobexstick, '%', CMContent.cobaltingot});
	  	GameRegistry.addRecipe(new ItemStack(CMContent.cobaltscythe, 1), new Object [] {"%%#", " # ", "#  ", '#', CMContent.cobexstick, '%', CMContent.cobaltingot});
	  	GameRegistry.addShapelessRecipe(new ItemStack(CMContent.hunterknife, 1), Items.stick, Items.iron_ingot);
	  	GameRegistry.addShapelessRecipe(new ItemStack(CMContent.bluestring, 4), new ItemStack(Blocks.wool, 1, 11));
	  	GameRegistry.addShapelessRecipe(new ItemStack(CMContent.bluewool, 1), CMContent.bluestring, CMContent.bluestring);
	  	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 1, 11), Blocks.wool, CMContent.bellflower);
	  	GameRegistry.addRecipe(new ItemStack(CMContent.bluebackpack, 1), new Object [] {"#%#", "#%#", "#%#", '#', CMContent.bluewool, '%', CMContent.leatherstrips});
	  	GameRegistry.addShapelessRecipe(new ItemStack(CMContent.cobaltplatebackpack, 1), CMContent.cobaltplate, CMContent.bluebackpack);
	  	GameRegistry.addRecipe(new ItemStack(CMContent.corruptedstonefurnace_idle, 1), new Object [] {"###", "# #", "###", Character.valueOf('#'), CMContent.corruptedstone});
	  	
	  	
	  	GameRegistry.addSmelting(CMContent.cobaltore, new ItemStack(CMContent.cobaltingot, 1), 1.0F);
	  	GameRegistry.addSmelting(CMContent.carthunore, new ItemStack(CMContent.carthuningot, 1), 1.0F);
	}
}
