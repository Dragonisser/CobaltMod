package cobaltmod.handler;

import java.lang.reflect.Method;
import net.minecraft.item.ItemStack;

public class MixerCraftingHandler {
	
	/**
	 * Try to add an Recipe to the BlenderRecipeList
	 * 
	 * @param output 		the Output
	 * @param input 		(Optional) an Bonus Material like Bottles
	 * @param inputArray 	the 3x3 inputGrid
	 */
	public static void addRecipe(ItemStack output, ItemStack input, ItemStack[] inputArray ){
		try{
			Class<?> clas = Class.forName("at.tk911.bartender.recipe.CraftingHandler");
			Method method = clas.getMethod("addRecipe", ItemStack.class, ItemStack.class, ItemStack[].class);
			method.invoke(null, output, input, inputArray);
		}catch(Throwable err){
			System.err.println("Couldn't add an Recipe. BartenderMod isn't installed");
		}
	}
}
