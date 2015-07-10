package cobaltmod.main.potion;

import cobaltmod.main.api.CMContent;

public class CMPotions {
	public static void init() {
		CMContent.potion_cobalt_resistance = new PotionCobaltResistance(40, false, 0).setPotionName("potion.cobalt_resistance");
	}
}
