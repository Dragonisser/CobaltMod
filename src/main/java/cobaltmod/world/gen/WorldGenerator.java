package cobaltmod.world.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import cobaltmod.main.CMMain;
import cobaltmod.main.api.CMContent;
import cobaltmod.world.biome.BiomeGenCobaltMountains;
import cobaltmod.world.biome.BiomeGenCobaltPlains;
import cobaltmod.world.biome.BiomeGenCobaltSwamp;
import cobaltmod.world.biome.BiomeGenCobaltTall;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		generateSurface(world, random, chunkX * 16, chunkZ * 16);

	}

	public void generateSurface(World world, Random rand, int x, int z) {

		// System.out.println("GENERATE");
		if (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltMountains
				|| (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltPlains || (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltSwamp))
				|| !(world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltTall)) {
			int RandPosX = x + rand.nextInt(16);
			int RandPosZ = z + rand.nextInt(16);
			int j1 = world.getHeightValue(RandPosX, RandPosZ);

			int randomnes1 = rand.nextInt(8);

			if (world.getBlock(x, j1, z) == CMContent.cobaltgrass) {
				if (randomnes1 == 0) {
					new WorldGenFlowers(CMContent.clematisflower).generate(world, rand, RandPosX, j1, RandPosZ); // Clematis
				}
				if (randomnes1 == 1) {
					new WorldGenFlowers(CMContent.redcabbagecrop).generate(world, rand, RandPosX, j1, RandPosZ); // Redgabage
				}
				if (randomnes1 == 2) {
					new WorldGenFlowers(CMContent.bellflower).generate(world, rand, RandPosX, j1, RandPosZ); // Bellflower
				}
				if (randomnes1 == 3) {
					new WorldGenFlowers(CMContent.glowflower).generate(world, rand, RandPosX, j1, RandPosZ); // Glowflower
				}
				if (randomnes1 == 4) {
					new WorldGenFlowers(CMContent.blueberrybush_empty).generate(world, rand, RandPosX, j1, RandPosZ); // BlueBerryBush
				}
				if (randomnes1 == 5) {
					new WorldGenFlowers(CMContent.waterthorn).generate(world, rand, RandPosX, j1, RandPosZ); // WaterThorn
				}
				if (randomnes1 == 6) {
					new WorldGenCobaltDungeonTree().generate(world, rand, RandPosX, j1 - 1, RandPosZ); // TreeDungeon
				}
			}

		}

		int RandPosX = x + rand.nextInt(16);
		int RandPosZ = z + rand.nextInt(16);
		int j1 = world.getHeightValue(RandPosX, RandPosZ);
		int randomnes = rand.nextInt(CMMain.portaltemple) + 2;
		if (randomnes == 2) {
			if (CMMain.templeenabled) {
				new WorldGenCobaltPortalTemple().generate(world, rand, RandPosX, j1 - 1, RandPosZ);
			}

		}

		if (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltMountains
				|| (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltPlains || (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltSwamp) || world
						.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltTall)) {
			for (int k = 0; k < 2; k++) // How often it tries to spawn in a
										// chunk
			{
				int cobaltoreXCoord = x + rand.nextInt(16);
				int cobaltoreYCoord = rand.nextInt(25); // Ebene 0 - 25
				int cobaltoreZCoord = z + rand.nextInt(16);

				new WorldGenMineableCobalt(CMContent.cobaltore, 4).generate(world, rand, cobaltoreXCoord, cobaltoreYCoord, cobaltoreZCoord); // Erz
			}
			for (int i = 0; i < 3; i++) // How often it tries to spawn in a
										// chunk
			{
				// int RandPosX = x + rand.nextInt(16);
				// int RandPosZ = z + rand.nextInt(16);
				// int j1 = world.getHeightValue(RandPosX, RandPosZ); //Auf den
				// ersten Block, der Solide ist. Also Grass, Stein, etc

				if (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltMountains || (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltPlains)) {
					new WorldGenCobaltTree(true, 4 + rand.nextInt(3), 0, 0, false).generate(world, rand, RandPosX, j1, RandPosZ); // Baum
				}
				if (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltSwamp) {
					new WorldGenCobaltTree(true, 4 + rand.nextInt(3), 0, 0, true).generate(world, rand, RandPosX, j1, RandPosZ); // Baum
				}

			}
			for (int i = 0; i < 7; i++) // How often it tries to spawn in a
										// chunk
			{
				// int RandPosX = x + rand.nextInt(16);
				// int RandPosZ = z + rand.nextInt(16);
				// int j1 = world.getHeightValue(RandPosX, RandPosZ); //Auf den
				// ersten Block, der Solide ist. Also Grass, Stein, etc

				if (world.getBiomeGenForCoords(x, z) instanceof BiomeGenCobaltTall) {
					// System.out.println("SPAWNED WorldGenerator");
					new WorldGenBigCobaltTree(true, 11 + rand.nextInt(3), 0, 0, false).generate(world, rand, RandPosX, j1, RandPosZ); // Baum
				}

			}
			for (int k = 0; k < 5; k++) // How often it tries to spawn in a
										// chunk

			{
				int cobaltoreXCoord = x + rand.nextInt(16);
				int cobaltoreYCoord = rand.nextInt(120);
				int cobaltoreZCoord = z + rand.nextInt(16);

				new WorldGenMineableCobalt(CMContent.cobaltstone, 14).generate(world, rand, cobaltoreXCoord, cobaltoreYCoord, cobaltoreZCoord); // Stein
			}
			for (int k = 0; k < 5; k++) // How often it tries to spawn in a
										// chunk
			{
				int cobaltoreXCoord = x + rand.nextInt(16);
				int cobaltoreYCoord = rand.nextInt(180);
				int cobaltoreZCoord = z + rand.nextInt(16);

				new WorldGenMineableCobalt(CMContent.carthunore, 10).generate(world, rand, cobaltoreXCoord, cobaltoreYCoord, cobaltoreZCoord); // Erz2
			}
		}
	}
}