package cobaltmod.main.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemScroll extends Item {
	
	public static final String[] itemMetaNames = new String[] {"regen", "resistance"};
	//public static final String[] item_a = new String[] {"itemMeta_regen", "itemMeta_resistance"};
	
	
	public ItemScroll() {
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack is) {
		
		int i = MathHelper.clamp_int(is.getItemDamage(), 0, 1);
		return super.getUnlocalizedName() + "_" + itemMetaNames[i];
		
		
	}
	
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
	{
		 for (int j = 0; j < 2; ++j)
		 {
			 par3List.add(new ItemStack(this, 1, j));
		 }
	}

}
