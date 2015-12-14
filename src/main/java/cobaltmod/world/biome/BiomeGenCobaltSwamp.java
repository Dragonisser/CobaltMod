package cobaltmod.world.biome;

import cobaltmod.entity.EntityBlueBuddy;
import cobaltmod.entity.EntityBlueSlime;
import cobaltmod.main.api.CMContent;

public class BiomeGenCobaltSwamp extends BiomeGenBaseCobalt {
	@SuppressWarnings("unchecked")
	public BiomeGenCobaltSwamp(int par1, boolean register) {
		super(par1, register);
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

		this.spawnableCreatureList.add(new BiomeGenBaseCobalt.SpawnListEntry(EntityBlueBuddy.class, 50, 5, 5));
		this.spawnableMonsterList.add(new BiomeGenBaseCobalt.SpawnListEntry(EntityBlueSlime.class, 100, 2, 3));

		this.topBlock = CMContent.cobaltgrass;
		this.fillerBlock = CMContent.cobaltdirt;
		this.setHeight(BiomeGenBaseCobalt.height_PartiallySubmerged);
		this.temperature = 0.8F;
		this.theBiomeDecorator.treesPerChunk = 0;
		this.enableRain = false;
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.mushroomsPerChunk = 0;
	}
}