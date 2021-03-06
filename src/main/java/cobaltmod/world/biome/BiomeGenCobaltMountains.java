package cobaltmod.world.biome;

import java.util.Random;

import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import cobaltmod.entity.EntityBlueBuddy;
import cobaltmod.entity.EntityCobaltZombie;
import cobaltmod.main.api.CMContent;

public class BiomeGenCobaltMountains extends BiomeGenBaseCobalt {
	@SuppressWarnings("unchecked")
	public BiomeGenCobaltMountains(int par1, boolean register) {
		super(par1, register);
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

		this.spawnableMonsterList.add(new BiomeGenBaseCobalt.SpawnListEntry(EntityCobaltZombie.class, 100, 3, 5));
		this.spawnableCreatureList.add(new BiomeGenBaseCobalt.SpawnListEntry(EntityBlueBuddy.class, 100, 5, 5));

		this.topBlock = CMContent.cobaltgrass;
		this.fillerBlock = CMContent.cobaltdirt;
		this.setHeight(height_Default);
		this.temperature = 0.7F;
		this.theBiomeDecorator.treesPerChunk = 6;
		this.enableRain = false;
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.mushroomsPerChunk = 0;
	}

	protected static final BiomeGenBaseCobalt.Height height_Default = new BiomeGenBaseCobalt.Height(1.5F, 0.8F);

	public WorldGenerator getRandomWorldGenForGrass(Random p_76730_1_) {
		return new WorldGenTallGrass(CMContent.bluetallgrass, 0); // BlueTallgrass
	}
}