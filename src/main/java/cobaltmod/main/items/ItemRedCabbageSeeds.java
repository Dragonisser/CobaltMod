package cobaltmod.main.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import cobaltmod.main.api.CMContent;

public class ItemRedCabbageSeeds extends Item implements IPlantable
{
    /**
     * The type of block this seed turns into (wheat or pumpkin stems for instance)
     */
    private Block blockType;

    /** BlockID of the block the seeds can be planted on. */

    public ItemRedCabbageSeeds(Block par2, Block par3)
    {
        this.blockType = par2;

        @SuppressWarnings("unused")
		Block soilBlockID = par3;
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 != 1)
        {
            return false;
        }
        else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
        {

            if (par3World.getBlock(par4, par5, par6) == CMContent.cobaltfarmland && par3World.isAirBlock(par4, par5 + 1, par6))
            {
            	//if(par3World.getBiomeGenForCoords(par4, par6) instanceof BiomeGenCobaltHills || par3World.getBiomeGenForCoords(par4, par6) instanceof BiomeGenCobaltPlains)
            	//{
            		par3World.setBlock(par4, par5 + 1, par6, this.blockType);
            		--par1ItemStack.stackSize;
            		return true;
            	//}
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
		//return false;
    }
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return (blockType == Blocks.nether_wart ? EnumPlantType.Nether : EnumPlantType.Crop);
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return blockType;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}
}
