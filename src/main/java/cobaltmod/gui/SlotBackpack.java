package cobaltmod.gui;

import cobaltmod.main.items.ItemBlueBackpack;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBackpack extends Slot
{

	public SlotBackpack(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
		super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
		// TODO Auto-generated constructor stub
	}  
	
	public boolean isItemValid(ItemStack itemstack)
    {
		if (itemstack.getItem() instanceof ItemBlueBackpack)
		{
			return false;
		}
        return true;
    }
}