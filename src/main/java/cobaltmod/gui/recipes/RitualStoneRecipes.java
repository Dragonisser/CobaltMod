package cobaltmod.gui.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cobaltmod.main.api.CMContent;

public class RitualStoneRecipes
{
    private static final RitualStoneRecipes smeltingBase = new RitualStoneRecipes();
    /**
     * The list of smelting results.
     */
    private Map<ItemStack, ItemStack> smeltingList = new HashMap<ItemStack, ItemStack>();
    private Map<ItemStack, Float> experienceList = new HashMap<ItemStack, Float>();
    

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static RitualStoneRecipes smelting()
    {
        return smeltingBase;
    }

    private RitualStoneRecipes()
    {
    	//BLueEssence
    	this.func_151393_a(CMContent.cobaltgrass, new ItemStack(CMContent.blueessence), 0.1F);
    	this.func_151393_a(CMContent.cobexleaves, new ItemStack(CMContent.blueessence, 2), 0.1F);
    	this.func_151396_a(CMContent.blueberry, new ItemStack(CMContent.blueessence), 0.1F);
    	this.func_151393_a(CMContent.bellflower, new ItemStack(CMContent.blueessence), 0.1F);
    	
    	
    	
    	//GreenEssence
    	this.func_151393_a(Blocks.grass, new ItemStack(CMContent.greenessence), 0.1F);
    	this.func_151394_a(new ItemStack(Blocks.leaves), new ItemStack(CMContent.greenessence, 2), 0.1F);
    	this.func_151394_a(new ItemStack(Blocks.leaves, 1, 1), new ItemStack(CMContent.greenessence, 2), 0.1F);
    	this.func_151394_a(new ItemStack(Blocks.leaves, 1, 2), new ItemStack(CMContent.greenessence, 2), 0.1F);
    	this.func_151394_a(new ItemStack(Blocks.leaves, 1, 3), new ItemStack(CMContent.greenessence, 2), 0.1F);
    	
    	
    	//Glowstone
    	this.func_151393_a(CMContent.glowflower, new ItemStack(Items.glowstone_dust), 0.1F);
    	
    }

    public void func_151393_a(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_)
    {
        this.func_151396_a(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_);
    }

    public void func_151396_a(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_)
    {
        this.func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
    }
    
    
    
    
    /*public void smeltCombine(ItemStack par1ItemStack, ItemStack par2ItemStack, ItemStack par3ItemStack, float par4)
    {
    	//this.smeltinglist2.add(new ItemStack[] {par1ItemStack, par2ItemStack});
        //this.smeltingList.put();
        this.smeltingList.put(new Object[] {par1ItemStack, par2ItemStack}, par3ItemStack);
        this.experienceList.put(par3ItemStack, Float.valueOf(par4));
        
        
    }*/
    
    

    
    
    public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack p_151395_1_)
    {
        Iterator<?> iterator = this.smeltingList.entrySet().iterator();
        Entry<?, ?> entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry<?, ?>)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }
    
    

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }

    public Map<ItemStack, ItemStack> getSmeltingList()
    {
        return this.smeltingList;
    }

    public float func_151398_b(ItemStack p_151398_1_)
    {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
        if (ret != -1) return ret;

        Iterator<?> iterator = this.experienceList.entrySet().iterator();
        Entry<?, ?> entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry<?, ?>)iterator.next();
        }
        while (!this.func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}