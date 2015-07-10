package cobaltmod.world.gen.structure.stronghold;

import java.util.LinkedList;
import java.util.Random;

import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cobaltmod.world.gen.structure.stronghold.component.Corridor;

public class SingleStrongholdGenerator {

	private static SingleStrongholdGenerator instance;

	private SingleStrongholdGenerator() {
		instance = this;
	}

	public static SingleStrongholdGenerator getInstance() {
		if (instance == null)
			return new SingleStrongholdGenerator();
		else
			return instance;
	}

	// chance to generate a structure
	public static final double CHANCE = 0.2D; // should spawn with 20%
												// probability
	public static final byte RANGE = 100;
	private static LinkedList<ChunkCoordIntPair> structuresList = new LinkedList<ChunkCoordIntPair>();

	public boolean generate(World world, Random rand, int x, int z, double chance) {
		if (canSpawnStructureAtCoords(world, x, z, chance)) {
			int direction = rand.nextInt(4);
			/* Corridor corridor = */new Corridor(direction, rand, x, z).addComponentParts(world, rand);
			System.out.println("------------------------*------------------------------------------");
			System.out.println("Generating at x " + x + "|z" + z);
			System.out.println("---------------------*--*------------------------------------------");

			structuresList.add(new ChunkCoordIntPair(x, z));
			return true;
		}

		return false;
	}

	protected static boolean canSpawnStructureAtCoords(World world, int x, int z, double chance) {
		return true;// chance < CHANCE /*&& isBiomeAllowed(world, x, z)*/ &&
					// noAnyInRange(x, z);
	}

	protected static boolean isBiomeAllowed(World world, int x, int z) {
		if (world.getBiomeGenForCoords(x, z) != BiomeGenBase.mesa || world.getBiomeGenForCoords(x, z) != BiomeGenBase.mesaPlateau
				|| world.getBiomeGenForCoords(x, z) != BiomeGenBase.mesaPlateau_F)
			return false;

		return true;
	}

	protected static boolean noAnyInRange(int x, int z) {
		for (ChunkCoordIntPair position : structuresList) {
			if (position.chunkXPos > x - RANGE && position.chunkXPos < x + RANGE && position.chunkZPos > z - RANGE && position.chunkZPos < z + RANGE)
				return false;
		}

		return true;
	}

	public static LinkedList<ChunkCoordIntPair> getStructuresList() {
		return structuresList;
	}
}