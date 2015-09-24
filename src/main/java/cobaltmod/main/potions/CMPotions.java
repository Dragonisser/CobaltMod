package cobaltmod.main.potions;

import cobaltmod.main.api.CMContent;

public class CMPotions {
	public static void init() {
		CMContent.potion_cobalt_resistance = new PotionCobalt(40, false, 0).setPotionName("potion.cobalt_resistance");
		CMContent.potion_cobalt_confusion = new PotionCobalt(41, false, 0).setPotionName("potion.cobalt_confusion");
	}
}
