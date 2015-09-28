package cobaltmod.main.items;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import cobaltmod.main.api.CMContent;

import com.google.common.collect.Sets;

public class ItemCobexShovel extends ItemTool

{
	private static final Set<Block> field_150916_c = Sets.newHashSet(new Block[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium, CMContent.cobaltgrass, CMContent.cobaltdirt});

    public ItemCobexShovel(Item.ToolMaterial p_i45353_1_)
    {
        super(1.0F, p_i45353_1_, field_150916_c);
        this.setHarvestLevel("shovel", 1);
    }

    public boolean func_150897_b(Block p_150897_1_)
    {
        return p_150897_1_ == Blocks.snow_layer ? true : p_150897_1_ == Blocks.snow;
    }
}