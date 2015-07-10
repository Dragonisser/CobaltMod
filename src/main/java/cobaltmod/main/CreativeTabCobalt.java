package cobaltmod.main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cobaltmod.main.api.CMContent;

public class CreativeTabCobalt extends CreativeTabs 
{

	private int tab;

	public CreativeTabCobalt(int par1, String par2Str, int par3) {
		super(par1, par2Str);
		tab = par3;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		
		if (tab == 1)
		{
			return CMContent.cobaltingot;
		}
		else
		{
			return Item.getItemFromBlock(CMContent.cobaltore);
		}
		
		
	}
	
}


