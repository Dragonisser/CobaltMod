package cobaltmod.main.potions;

import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class PotionCobalt extends Potion {

	protected PotionCobalt(int p_i1573_1_, boolean p_i1573_2_, int p_i1573_3_) {
		super(p_i1573_1_, p_i1573_2_, p_i1573_3_);
	}
	
	
	@SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, net.minecraft.client.Minecraft mc) { 
		if(effect.getEffectName().equals(CMContent.potion_cobalt_resistance.getName())) {
			//TODO add texture for potion effects
			//System.out.println("yes");
		}
	}
}
