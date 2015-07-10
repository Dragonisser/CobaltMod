package cobaltmod.gui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cobaltmod.main.api.CMContent;

public class AltarRecipes
{
    private static final AltarRecipes smeltingBase = new AltarRecipes();
    /**
     * The list of smelting results.
     */
    private Map<ItemStack, ItemStack> smeltingList = new HashMap<ItemStack, ItemStack>();
    private Map<ItemStack, Float> experienceList = new HashMap<ItemStack, Float>();
    
    

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static AltarRecipes smelting()
    {
        return smeltingBase;
    }

    private AltarRecipes()
    {
    }

    public void func_151393_a(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_)
    {
        this.func_151396_a(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_);
    }

    public void func_151396_a(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_)
    {
        this.func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
    }
    
    

    
    
    public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
    }

    /**
     * Returns the smelting result of an item.
     */

    public static ItemStack getSmeltingResult(Item item, Item item2)
    {
             return getOutput(item, item2);
    }
    private static ItemStack getOutput(Item items, Item items2)
    {
             if (items == CMContent.cobaltstonefragment && items2 == CMContent.cobaltstonefragment)
             {
                     return new ItemStack(CMContent.cobaltstonecrystal, 1);
             }
             if (items == CMContent.cobaltstonecrystal && items2 == CMContent.blueessence || items == CMContent.blueessence && items2 == CMContent.cobaltstonecrystal)
             {
                     return new ItemStack(CMContent.njosscrystal, 1);
             }
             if (items == CMContent.njosscrystal && items2 == Item.getItemFromBlock(CMContent.cobaltbrick) || items == Item.getItemFromBlock(CMContent.cobaltbrick) && items2 == CMContent.njosscrystal)
             {
                     return new ItemStack(CMContent.cobaltrune, 1);
             }
             
             //StoneFragment, GreenEssence, CobaltStoneCrystal
             if (items == CMContent.stonefragment && items2 == CMContent.stonefragment)
             {
                     return new ItemStack(CMContent.stonecrystal, 1);
             }
             if (items == CMContent.stonecrystal && items2 == CMContent.greenessence || items == CMContent.greenessence && items2 == CMContent.stonecrystal)
             {
                     return new ItemStack(CMContent.foenumcrystal, 1);
             }
             
             if (items == Item.getItemFromBlock(CMContent.cobaltbrick) && items2 == CMContent.carthundust || items == CMContent.carthundust && items2 == Item.getItemFromBlock(CMContent.cobaltbrick))
             {
                     return new ItemStack(CMContent.carthunbrick, 1);
             }
             
             
             
             
    return null;
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