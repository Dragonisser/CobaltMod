package cobaltmod.main.items;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import cobaltmod.main.api.CMContent;

import com.google.common.collect.Sets;

public class ItemCobaltAxe extends ItemTool 
{
	private static final Set<Block> field_150917_c = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, CMContent.cobexwood, CMContent.cobexlog, CMContent.cobexdoor, CMContent.cobexchest, CMContent.cobexsingleslab});

	public ItemCobaltAxe(ToolMaterial tool) 
	{
		super(3.0F, tool, field_150917_c);
		this.setHarvestLevel("axe", 4);
	}
	public float func_150893_a(ItemStack p_150893_1_, Block block)
    {
        return block.getMaterial() != Material.wood && block.getMaterial() != Material.plants && block.getMaterial() != Material.vine ? super.func_150893_a(p_150893_1_, block) : this.efficiencyOnProperMaterial;
    }
	public int getItemEnchantability()
    {
        return 1;
    }
}