package cobaltmod.world.biome;

import cobaltmod.main.api.CMContent;

public class BiomeGenCobaltCaves extends BiomeGenBaseCobalt {
	public BiomeGenCobaltCaves(int par1) {
		super(par1);
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

		// this.spawnableMonsterList.add(new
		// BiomeGenBaseCobalt.SpawnListEntry(EntityCobaltZombie.class, 100, 3,
		// 5));
		// this.spawnableCreatureList.add(new
		// BiomeGenBaseCobalt.SpawnListEntry(EntityBlueBuddy.class, 100, 5, 5));

		this.topBlock = CMContent.corruptedstone;
		this.fillerBlock = CMContent.hardendcorruptedstone;
		this.temperature = 0.7F;
		this.theBiomeDecorator.treesPerChunk = 6;
		this.enableRain = false;
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.mushroomsPerChunk = 0;
	}

	// public WorldGenerator getRandomWorldGenForGrass(Random p_76730_1_)
	// {
	// return new WorldGenTallGrass(CMContent.bluetallgrass, 0); //BlueTallgrass
	// }
}
