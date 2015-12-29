package cobaltmod.world.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;
import cobaltmod.world.biome.BiomeGenBaseCobalt;
import cobaltmod.world.biome.BiomeGenCobaltMountains;
import cobaltmod.world.biome.BiomeGenCobaltPlains;
import cobaltmod.world.biome.BiomeGenCobaltSwamp;
import cobaltmod.world.biome.BiomeGenCobaltTall;
import cobaltmod.world.gen.worldgen.WorldGenMineableCobalt;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorDim implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		if (world.provider.dimensionId == CMMain.cobaltdimension || world.provider.dimensionId == CMMain.cobaltdimension1) {
			generateCobaltis(world, random, chunkX * 16, chunkZ * 16);
		}
		if (world.provider.dimensionId == 0) {
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateCobaltis(World world, Random random, int x, int z) {
		int RandPosX = x + random.nextInt(16);
		int RandPosZ = z + random.nextInt(16);
		int j1 = world.getHeightValue(RandPosX, RandPosZ);

		if (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltMountains
				|| (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltPlains || (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltSwamp))
				|| !(world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltTall)) {

			int randomnes1 = random.nextInt(8);

			if (world.getBlock(x, j1, z) == CMContent.cobaltgrass) {
				if (randomnes1 == 0) {
					new WorldGenFlowers(CMContent.clematisflower).generate(world, random, RandPosX, j1, RandPosZ); // Clematis
				}
				if (randomnes1 == 1) {
					new WorldGenFlowers(CMContent.redcabbagecrop).generate(world, random, RandPosX, j1, RandPosZ); // Redgabage
				}
				if (randomnes1 == 2) {
					new WorldGenFlowers(CMContent.bellflower).generate(world, random, RandPosX, j1, RandPosZ); // Bellflower
				}
				if (randomnes1 == 3) {
					new WorldGenFlowers(CMContent.glowflower).generate(world, random, RandPosX, j1, RandPosZ); // Glowflower
				}
				if (randomnes1 == 4) {
					new WorldGenFlowers(CMContent.blueberrybush_empty).generate(world, random, RandPosX, j1, RandPosZ); // BlueBerryBush
				}
				if (randomnes1 == 5) {
					new WorldGenFlowers(CMContent.waterthorn).generate(world, random, RandPosX, j1, RandPosZ); // WaterThorn
				}
				if (randomnes1 == 6) {
					new WorldGenCobaltDungeonTree().generate(world, random, RandPosX, j1 - 1, RandPosZ); // TreeDungeon
				}
			}
		}

		if (world.getBiomeGenForCoords(x, z) instanceof BiomeGenBaseCobalt) {
			for (int k = 0; k < 2; k++) // How often it tries to spawn in a
										// chunk
			{
				int cobaltoreXCoord = x + random.nextInt(16);
				int cobaltoreYCoord = random.nextInt(25); // Ebene 0 - 25
				int cobaltoreZCoord = z + random.nextInt(16);

				new WorldGenMineableCobalt(CMContent.cobaltore, 4).generate(world, random, cobaltoreXCoord, cobaltoreYCoord, cobaltoreZCoord); // Erz
			}
			for (int i = 0; i < 3; i++) // How often it tries to spawn in a
										// chunk
			{
				if (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltMountains || (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltPlains)) {
					new WorldGenCobaltTree(true, 4 + random.nextInt(3), 0, 0, false).generate(world, random, RandPosX, j1, RandPosZ); // Baum
				}
				if (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltSwamp) {
					new WorldGenCobaltTree(true, 4 + random.nextInt(3), 0, 0, true).generate(world, random, RandPosX, j1, RandPosZ); // Baum
				}

			}
			for (int i = 0; i < 7; i++) // How often it tries to spawn in a
										// chunk
			{
				if (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltTall) {
					new WorldGenBigCobaltTree(true, 11 + random.nextInt(3), 0, 0, false).generate(world, random, RandPosX, j1, RandPosZ); // Baum
				}

			}
			for (int k = 0; k < 5; k++) // How often it tries to spawn in a
										// chunk
			{
				int cobaltoreXCoord = x + random.nextInt(16);
				int cobaltoreYCoord = random.nextInt(120);
				int cobaltoreZCoord = z + random.nextInt(16);

				new WorldGenMineableCobalt(CMContent.cobaltstone, 14).generate(world, random, cobaltoreXCoord, cobaltoreYCoord, cobaltoreZCoord); // Stein
			}
			for (int k = 0; k < 5; k++) // How often it tries to spawn in a
										// chunk
			{
				int cobaltoreXCoord = x + random.nextInt(16);
				int cobaltoreYCoord = random.nextInt(180);
				int cobaltoreZCoord = z + random.nextInt(16);

				new WorldGenMineableCobalt(CMContent.carthunore, 10).generate(world, random, cobaltoreXCoord, cobaltoreYCoord, cobaltoreZCoord); // Erz2
			}
		}
	}

	public void generateSurface(World world, Random rand, int x, int z) {

		int RandPosX = x + rand.nextInt(16);
		int RandPosZ = z + rand.nextInt(16);
		int j1 = world.getHeightValue(RandPosX, RandPosZ);

		double d = Math.random();
		double chance = CMMain.portaltemple / 100;
		if (chance > 1.0 || chance <= 0.0) {
			return;
		}

		if (d <= chance && CMMain.templeenabled) {
			new WorldGenCobaltPortalTemple().generate(world, rand, RandPosX, j1 - 1, RandPosZ);
		}
	}
}