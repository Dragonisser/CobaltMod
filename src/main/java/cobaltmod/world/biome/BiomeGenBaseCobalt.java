package cobaltmod.world.biome;

import net.minecraft.world.biome.BiomeGenBase;
import cobaltmod.main.CMMain;
import cpw.mods.fml.common.FMLLog;

public class BiomeGenBaseCobalt extends BiomeGenBase {
	/** The biome decorator. */

	public static BiomeGenBase biomeplains;
	public static BiomeGenBase biomemountains;
	public static BiomeGenBase biomeswamp;
	public static BiomeGenBase biometall;
	public static BiomeGenBase biomehills;

	public BiomeGenBaseCobalt(int biomeId) {
		super(biomeId);
		this.rainfall = 0.6F;
	}

	public static boolean checkForBiomeConflicts() {
		boolean noConflict = true;
		noConflict &= checkBiomeIDisClearOrOurs(CMMain.biomehillsid);
		noConflict &= checkBiomeIDisClearOrOurs(CMMain.biomeplainsid);
		noConflict &= checkBiomeIDisClearOrOurs(CMMain.biomeswampid);
		noConflict &= checkBiomeIDisClearOrOurs(CMMain.biometallid);
		noConflict &= checkBiomeIDisClearOrOurs(CMMain.biomemountainsid);

		if (!noConflict) {
			FMLLog.warning("[CobaltMod] Biome ID conflict detected.  Edit the CobaltMod config to give all biomes unique IDs.", new Object[0]);
		}

		return noConflict;
	}

	public static boolean checkBiomeIDisClearOrOurs(int id) {
		BiomeGenBase biomeAt = BiomeGenBase.getBiome(id);

		if (biomeAt == null || (biomeAt instanceof BiomeGenBaseCobalt)) {
			return true;
		} else {
			FMLLog.warning("[CobaltMod] Biome ID conflict.  Biome ID %d contains a biome named %s, but CobaltMod is set to use that ID.", new Object[] {
					Integer.valueOf(id), biomeAt.biomeID });
			return false;
		}
	}

	public static void init() {
		biomemountains = (new BiomeGenCobaltMountains(CMMain.biomemountainsid)).setBiomeName("Highlands");
		biomeplains = (new BiomeGenCobaltPlains(CMMain.biomeplainsid)).setBiomeName("Cobex Forest");
		biomeswamp = (new BiomeGenCobaltSwamp(CMMain.biomeswampid)).setBiomeName("Deep Swamp");
		biometall = (new BiomeGenCobaltTall(CMMain.biometallid)).setBiomeName("Tall Forest");
		biomehills = (new BiomeGenCobaltHills(CMMain.biomehillsid)).setBiomeName("Blue Mountains");

		registerWithBiomeDictionary();
	}

	public static void registerWithBiomeDictionary() {
	}
}