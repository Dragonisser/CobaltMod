package cobaltmod.main.items;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockLog;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class ItemCobaltFertilizer extends Item
{   
    public ItemCobaltFertilizer()
    {
    	super();
    }


    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
                if (applyBonemeal(par1ItemStack, par3World, par4, par5, par6, par2EntityPlayer))
                {
                    if (!par3World.isRemote)
                    {
                        par3World.playAuxSFX(2005, par4, par5, par6, 0);
                    }

                    return true;
            }
            else if (par1ItemStack.getItemDamage() == 3)
            {
                Block block = par3World.getBlock(par4, par5, par6);
                int i1 = par3World.getBlockMetadata(par4, par5, par6);

                if (block == Blocks.log && BlockLog.func_150165_c(i1) == 3)
                {
                    if (par7 == 0)
                    {
                        return false;
                    }

                    if (par7 == 1)
                    {
                        return false;
                    }

                    if (par7 == 2)
                    {
                        --par6;
                    }

                    if (par7 == 3)
                    {
                        ++par6;
                    }

                    if (par7 == 4)
                    {
                        --par4;
                    }

                    if (par7 == 5)
                    {
                        ++par4;
                    }

                    if (par3World.isAirBlock(par4, par5, par6))
                    {
                        int j1 = Blocks.cocoa.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, 0);
                        par3World.setBlock(par4, par5, par6, Blocks.cocoa, j1, 2);

                        if (!par2EntityPlayer.capabilities.isCreativeMode)
                        {
                            --par1ItemStack.stackSize;
                        }
                    }

                    return true;
                }
            }

            return false;
        }
    }

    public static boolean func_150919_a(ItemStack p_150919_0_, World p_150919_1_, int p_150919_2_, int p_150919_3_, int p_150919_4_)
    {
        if (p_150919_1_ instanceof WorldServer)
            return applyBonemeal(p_150919_0_, p_150919_1_, p_150919_2_, p_150919_3_, p_150919_4_, FakePlayerFactory.getMinecraft((WorldServer)p_150919_1_));
        return false;
    }

    public static boolean applyBonemeal(ItemStack p_150919_0_, World p_150919_1_, int p_150919_2_, int p_150919_3_, int p_150919_4_, EntityPlayer player)
    {
        Block block = p_150919_1_.getBlock(p_150919_2_, p_150919_3_, p_150919_4_);

        BonemealEvent event = new BonemealEvent(player, p_150919_1_, block, p_150919_2_, p_150919_3_, p_150919_4_);
        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return false;
        }

        if (event.getResult() == Result.ALLOW)
        {
            if (!p_150919_1_.isRemote)
            {
                p_150919_0_.stackSize--;
            }
            return true;
        }

        if (block instanceof IGrowable)
        {
            IGrowable igrowable = (IGrowable)block;

            if (igrowable.func_149851_a(p_150919_1_, p_150919_2_, p_150919_3_, p_150919_4_, p_150919_1_.isRemote))
            {
                if (!p_150919_1_.isRemote)
                {
                    if (igrowable.func_149852_a(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_))
                    {
                        igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);
                    }

                    --p_150919_0_.stackSize;
                }

                return true;
            }
        }

        return false;
    }

    @SideOnly(Side.CLIENT)
    public static void func_150918_a(World p_150918_0_, int p_150918_1_, int p_150918_2_, int p_150918_3_, int p_150918_4_)
    {
        if (p_150918_4_ == 0)
        {
            p_150918_4_ = 15;
        }

        Block block = p_150918_0_.getBlock(p_150918_1_, p_150918_2_, p_150918_3_);

        if (block.getMaterial() != Material.air)
        {
            block.setBlockBoundsBasedOnState(p_150918_0_, p_150918_1_, p_150918_2_, p_150918_3_);

            for (int i1 = 0; i1 < p_150918_4_; ++i1)
            {
                double d0 = itemRand.nextGaussian() * 0.02D;
                double d1 = itemRand.nextGaussian() * 0.02D;
                double d2 = itemRand.nextGaussian() * 0.02D;
                p_150918_0_.spawnParticle("happyVillager", (double)((float)p_150918_1_ + itemRand.nextFloat()), (double)p_150918_2_ + (double)itemRand.nextFloat() * block.getBlockBoundsMaxY(), (double)((float)p_150918_3_ + itemRand.nextFloat()), d0, d1, d2);
            }
        }
        else
        {
            for (int i1 = 0; i1 < p_150918_4_; ++i1)
            {
                double d0 = itemRand.nextGaussian() * 0.02D;
                double d1 = itemRand.nextGaussian() * 0.02D;
                double d2 = itemRand.nextGaussian() * 0.02D;
                p_150918_0_.spawnParticle("happyVillager", (double)((float)p_150918_1_ + itemRand.nextFloat()), (double)p_150918_2_ + (double)itemRand.nextFloat() * 1.0f, (double)((float)p_150918_3_ + itemRand.nextFloat()), d0, d1, d2);
            }
        }
    }

    /**
     * Returns true if the item can be used on the given entity, e.g. shears on sheep.
     */
    public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase)
    {
        if (par3EntityLivingBase instanceof EntitySheep)
        {
            EntitySheep entitysheep = (EntitySheep)par3EntityLivingBase;
            int i = BlockColored.func_150032_b(par1ItemStack.getItemDamage());

            if (!entitysheep.getSheared() && entitysheep.getFleeceColor() != i)
            {
                entitysheep.setFleeceColor(i);
                --par1ItemStack.stackSize;
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}