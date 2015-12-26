package cobaltmod.handler.ic2;

import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;
import cobaltmod.main.items.ItemCarthunDust;
import cobaltmod.main.items.ItemCarthunDustTiny;
import cobaltmod.main.items.ItemCobaltDust;
import cobaltmod.main.items.ItemCobaltDustTiny;
import cobaltmod.main.items.ItemCrushedCarthun;
import cobaltmod.main.items.ItemCrushedCobalt;
import cobaltmod.main.items.ItemPurifiedCrushedCarthun;
import cobaltmod.main.items.ItemPurifiedCrushedCobalt;
import cpw.mods.fml.common.registry.GameRegistry;

public class IC2SupportHandler {
	public static void isIC2Installed() {
		try {
			// Definition
			CMContent.crushed_cobaltore = new ItemCrushedCobalt().setUnlocalizedName(CMMain.MODID + ":crushed_cobaltore")
					.setTextureName(CMMain.MODID + ":crushed_cobaltore").setCreativeTab(CMMain.cobalttabitems);
			CMContent.purified_crushed_cobaltore = new ItemPurifiedCrushedCobalt().setUnlocalizedName(CMMain.MODID + ":purified_crushed_cobaltore")
					.setTextureName(CMMain.MODID + ":purified_crushed_cobaltore").setCreativeTab(CMMain.cobalttabitems);
			CMContent.cobaltdust = new ItemCobaltDust().setUnlocalizedName(CMMain.MODID + ":cobaltdust").setTextureName(CMMain.MODID + ":cobaltdust")
					.setCreativeTab(CMMain.cobalttabitems);
			CMContent.cobaltdusttiny = new ItemCobaltDustTiny().setUnlocalizedName(CMMain.MODID + ":cobaltdusttiny")
					.setTextureName(CMMain.MODID + ":cobaltdusttiny").setCreativeTab(CMMain.cobalttabitems);

			CMContent.carthundust = new ItemCarthunDust().setUnlocalizedName(CMMain.MODID + ":carthundust").setTextureName(CMMain.MODID + ":carthundust")
					.setCreativeTab(CMMain.cobalttabitems);
			CMContent.carthundusttiny = new ItemCarthunDustTiny().setUnlocalizedName(CMMain.MODID + ":carthundusttiny")
					.setTextureName(CMMain.MODID + ":carthundusttiny").setCreativeTab(CMMain.cobalttabitems);
			CMContent.crushed_carthunore = new ItemCrushedCarthun().setUnlocalizedName(CMMain.MODID + ":crushed_carthunore")
					.setTextureName(CMMain.MODID + ":crushed_carthunore").setCreativeTab(CMMain.cobalttabitems);
			CMContent.purified_crushed_carthunore = new ItemPurifiedCrushedCarthun().setUnlocalizedName(CMMain.MODID + ":purified_crushed_carthunore")
					.setTextureName(CMMain.MODID + ":purified_crushed_carthunore").setCreativeTab(CMMain.cobalttabitems);

			// Registry
			GameRegistry.registerItem(CMContent.crushed_cobaltore, "crushed_cobalt");
			GameRegistry.registerItem(CMContent.purified_crushed_cobaltore, "purified_crushed_cobalt");
			GameRegistry.registerItem(CMContent.cobaltdust, "cobaltdust");
			GameRegistry.registerItem(CMContent.cobaltdusttiny, "cobaltdusttiny");

			GameRegistry.registerItem(CMContent.crushed_carthunore, "crushed_carthun");
			GameRegistry.registerItem(CMContent.purified_crushed_carthunore, "purified_crushed_carthun");
			GameRegistry.registerItem(CMContent.carthundust, "carthundust");
			GameRegistry.registerItem(CMContent.carthundusttiny, "carthundusttiny");

			// OrediRegistry
			OreDictionary.registerOre("dustCobalt", CMContent.cobaltdust);
			OreDictionary.registerOre("dustCobaltTiny", CMContent.cobaltdusttiny);
			OreDictionary.registerOre("dustCarthun", CMContent.carthundust);
			OreDictionary.registerOre("dustCarthunTiny", CMContent.carthundusttiny);

			// Recipe
			GameRegistry.addRecipe(new ItemStack(CMContent.cobaltdust, 1),
					new Object[] { "###", "###", "###", Character.valueOf('#'), CMContent.cobaltdusttiny });
			GameRegistry.addRecipe(new ItemStack(CMContent.carthundust, 1), new Object[] { "###", "###", "###", Character.valueOf('#'),
					CMContent.carthundusttiny });

			// RecipeIc2
			Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(CMContent.cobaltore)), null, new ItemStack(CMContent.crushed_cobaltore, 2));
			Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(CMContent.cobaltingot)), null, new ItemStack(CMContent.crushed_cobaltore, 1));

			NBTTagCompound metadata = new NBTTagCompound();
			metadata.setInteger("minHeat", 1500);
			Recipes.centrifuge.addRecipe(new RecipeInputItemStack(new ItemStack(CMContent.crushed_cobaltore)), metadata, new ItemStack(CMContent.cobaltdust),
					new ItemStack(CMContent.cobaltdusttiny, 1));

			NBTTagCompound metadata1 = new NBTTagCompound();
			metadata1.setInteger("amount", 1000);
			Recipes.oreWashing.addRecipe(new RecipeInputItemStack(new ItemStack(CMContent.crushed_cobaltore)), metadata, new ItemStack(
					CMContent.purified_crushed_cobaltore), new ItemStack(CMContent.cobaltdusttiny, 2));

			Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(CMContent.carthunore)), null, new ItemStack(CMContent.crushed_carthunore, 2));
			Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(CMContent.carthuningot)), null, new ItemStack(CMContent.crushed_carthunore, 1));

			NBTTagCompound metadata3 = new NBTTagCompound();
			metadata3.setInteger("minHeat", 1500);
			Recipes.centrifuge.addRecipe(new RecipeInputItemStack(new ItemStack(CMContent.crushed_carthunore)), metadata, new ItemStack(CMContent.carthundust),
					new ItemStack(CMContent.carthundusttiny, 1));

			NBTTagCompound metadata4 = new NBTTagCompound();
			metadata4.setInteger("amount", 1000);
			Recipes.oreWashing.addRecipe(new RecipeInputItemStack(new ItemStack(CMContent.crushed_carthunore)), metadata, new ItemStack(
					CMContent.purified_crushed_carthunore), new ItemStack(CMContent.carthundusttiny, 2));

			// Smelting
			GameRegistry.addSmelting(CMContent.crushed_cobaltore, new ItemStack(CMContent.cobaltingot, 1), 1.0F);
			GameRegistry.addSmelting(CMContent.purified_crushed_cobaltore, new ItemStack(CMContent.cobaltingot, 1), 1.0F);
			GameRegistry.addSmelting(CMContent.cobaltdust, new ItemStack(CMContent.cobaltingot, 1), 1.0F);

			GameRegistry.addSmelting(CMContent.crushed_carthunore, new ItemStack(CMContent.carthuningot, 1), 1.0F);
			GameRegistry.addSmelting(CMContent.purified_crushed_carthunore, new ItemStack(CMContent.carthuningot, 1), 1.0F);
			GameRegistry.addSmelting(CMContent.cobaltdust, new ItemStack(CMContent.carthuningot, 1), 1.0F);
		} catch (Exception e) {
		}
	}
}
