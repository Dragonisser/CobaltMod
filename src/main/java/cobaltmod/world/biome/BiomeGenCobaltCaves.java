package cobaltmod.world.biome;

import cobaltmod.main.api.CMContent;

public class BiomeGenCobaltCaves extends BiomeGenBaseCobalt {
	public BiomeGenCobaltCaves(int par1, boolean register) {
		super(par1, register);
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

		this.topBlock = CMContent.corruptedstone;
		this.fillerBlock = CMContent.hardendcorruptedstone;
		this.temperature = 0.7F;
		this.theBiomeDecorator.treesPerChunk = 6;
		this.enableRain = false;
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.mushroomsPerChunk = 0;
	}
}
