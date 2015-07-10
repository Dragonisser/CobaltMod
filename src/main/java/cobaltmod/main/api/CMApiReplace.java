package cobaltmod.main.api;


import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;

public class CMApiReplace {

	
	//Spreading Api
	public static Map<Block, Block> map = new HashMap<Block, Block>();	
	
	/**
	 * CMApiReplace.addSpreadingBlock(Blocks.grass, CMApiBlock_Item.cobaltgrass);
	 * 
	 * It searches for Block.Grass (Vanilla Grass) and replaces it with CMApiBlock_Item.cobaltgrass (CobaltMod Grass)
	 * 
	 * Thats all you need to do to add your custom block to the Spreading of the Mod.
	 * 
	 * @param spreadable is the Block it searching for
	 * @param replaced is the Block it gets replaced with
	 */
	public static void addSpreadingBlock(Block spreadable, Block replaced)
    {
		map.put(spreadable, replaced);	
	}	
}
