package cobaltmod.world.gen;

import java.util.Random;

import cobaltmod.main.api.CMContent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;

public class WorldGenCobaltPortalTemple extends WorldGenerator
{
	protected Block[] GetValidSpawnBlocks() {
		return new Block[] 
		{
				Blocks.grass
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		Block checkID = world.getBlock(i, j, k);

		while (checkID != Blocks.air){
			distanceToAir++;
			checkID = world.getBlock(i, j + distanceToAir, k);
		}

		if (distanceToAir > 3){
			return false;
		}
		j += distanceToAir - 1;

		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j+1, k);
		Block blockIDBelow = world.getBlock(i, j-1, k);
		for (Block x : GetValidSpawnBlocks()){
			if (blockIDAbove != Blocks.air){
				return false;
			}
			if (blockID == x){
				return true;
			}else if (blockID == Blocks.snow && blockIDBelow == x){
				return true;
			}
		}
		return false;
	}

	public WorldGenCobaltPortalTemple() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 7, j, k) || !LocationIsValidSpawn(world, i + 7, j, k + 11) || !LocationIsValidSpawn(world, i, j, k + 11))
		{
			return false;
		}
		
		
		//System.out.println("[CobaltMod] Spawning Temple at x:" + i + " y:" + j + " z:" + k);
		//System.out.println(world.getBiomeGenForCoords(i, k));
		world.setBlock(i + 0, j + 0, k + 0, Blocks.grass);
		world.setBlock(i + 0, j + 0, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 0, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 0, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 0, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 0, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 0, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 0, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 0, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 0, k + 9, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 0, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 0, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 1, k + 0, CMContent.cobaltbrickstair, 2, 2);
		world.setBlock(i + 0, j + 1, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 1, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 1, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 1, k + 4, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 0, j + 1, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 1, k + 6, CMContent.cobaltbrickstair, 3, 2);
		world.setBlock(i + 0, j + 1, k + 7, CMContent.cobaltbrickstair, 2, 2);
		world.setBlock(i + 0, j + 1, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 1, k + 9, CMContent.cobaltbrickstair, 3, 2);
		world.setBlock(i + 0, j + 1, k + 10, CMContent.cobaltbrickstair, 2, 2);
		world.setBlock(i + 0, j + 1, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 2, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 2, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 2, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 2, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 2, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 2, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 3, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 3, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 3, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 3, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 3, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 3, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 4, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 4, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 4, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 4, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 4, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 4, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 5, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 5, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 5, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 5, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 5, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 5, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 6, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 6, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 6, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 6, k + 4, CMContent.cobaltbricksingleslab, 13, 2);
		world.setBlock(i + 0, j + 6, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 6, k + 6, CMContent.cobaltbrickstair, 7, 2);
		world.setBlock(i + 0, j + 6, k + 7, CMContent.cobaltbrickstair, 6, 2);
		world.setBlock(i + 0, j + 6, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 6, k + 9, CMContent.cobaltbrickstair, 7, 2);
		world.setBlock(i + 0, j + 6, k + 10, CMContent.cobaltbrickstair, 6, 2);
		world.setBlock(i + 0, j + 6, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 0, j + 7, k + 1, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 0, j + 7, k + 2, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 0, j + 7, k + 3, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 0, j + 7, k + 4, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 0, j + 7, k + 5, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 0, j + 7, k + 6, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 0, j + 7, k + 7, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 0, j + 7, k + 8, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 0, j + 7, k + 9, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 0, j + 7, k + 10, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 0, j + 7, k + 11, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 1, j + 0, k + 0,Blocks.grass);
		world.setBlock(i + 1, j + 0, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 0, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 0, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 0, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 0, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 0, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 0, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 0, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 0, k + 9, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 0, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 0, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 1, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 1, k + 11, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 1, j + 2, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 3, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 4, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 5, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 6, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 6, k + 11, CMContent.cobaltbricksingleslab, 13, 2);
		world.setBlock(i + 1, j + 7, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 7, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 7, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 7, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 7, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 7, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 7, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 7, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 7, k + 9, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 7, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 1, j + 7, k + 11, CMContent.cobaltbrick);
		
		
		world.setBlock(i + 1, j + 1, k + 9, Blocks.mob_spawner);
		TileEntityMobSpawner spawner = (TileEntityMobSpawner)world.getTileEntity(i + 1, j + 1, k + 9);
		spawner.func_145881_a().setEntityName("CobaltZombie");
		
		
		
		world.setBlock(i + 6, j + 1, k + 9, Blocks.mob_spawner);
		TileEntityMobSpawner spawner1 = (TileEntityMobSpawner)world.getTileEntity(i + 6, j + 1, k + 9);
		spawner1.func_145881_a().setEntityName("CobaltZombie");
		
		
		world.setBlock(i + 2, j + 0, k + 0,Blocks.grass);
		world.setBlock(i + 2, j + 0, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 0, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 0, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 0, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 0, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 0, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 0, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 0, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 0, k + 9, CMContent.portalframe);
		world.setBlock(i + 2, j + 0, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 0, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 1, k + 9, CMContent.portalframe);
		world.setBlock(i + 2, j + 1, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 2, k + 9, CMContent.portalframe);
		world.setBlock(i + 2, j + 2, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 3, k + 9, CMContent.portalframe);
		world.setBlock(i + 2, j + 3, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 4, k + 3, CMContent.cobaltbrickstair, 5, 2);
		world.setBlock(i + 2, j + 4, k + 9, CMContent.portalframe);
		world.setBlock(i + 2, j + 4, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 5, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 5, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 6, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 6, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 7, k + 1, CMContent.cobaltbricksingleslab, 13, 2);
		world.setBlock(i + 2, j + 7, k + 2, CMContent.cobaltbricksingleslab, 13, 2);
		world.setBlock(i + 2, j + 7, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 7, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 7, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 7, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 7, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 7, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 7, k + 9, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 7, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 7, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 2, j + 8, k + 1, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 2, j + 8, k + 2, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 2, j + 8, k + 3, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 2, j + 8, k + 4, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 2, j + 8, k + 5, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 2, j + 8, k + 6, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 2, j + 8, k + 7, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 2, j + 8, k + 8, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 2, j + 8, k + 9, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 2, j + 8, k + 10, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 2, j + 8, k + 11, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 3, j + 0, k + 0,Blocks.grass);
		world.setBlock(i + 3, j + 0, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 0, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 0, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 0, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 0, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 0, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 0, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 0, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 0, k + 9, CMContent.portalframe);
		world.setBlock(i + 3, j + 0, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 0, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 1, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 2, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 3, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 4, k + 9, CMContent.portalframe);
		world.setBlock(i + 3, j + 4, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 5, k + 3, CMContent.cobaltbrickstair, 5, 2);
		world.setBlock(i + 3, j + 5, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 6, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 6, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 7, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 7, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 7, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 7, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 7, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 7, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 7, k + 9, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 7, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 7, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 8, k + 1, CMContent.cobaltbrickstair, 5, 2);
		world.setBlock(i + 3, j + 8, k + 2, CMContent.cobaltbrickstair, 5, 2);
		world.setBlock(i + 3, j + 8, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 8, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 8, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 8, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 8, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 8, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 8, k + 9, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 8, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 3, j + 8, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 0, k + 0,Blocks.grass);
		world.setBlock(i + 4, j + 0, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 0, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 0, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 0, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 0, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 0, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 0, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 0, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 0, k + 9, CMContent.portalframe);
		world.setBlock(i + 4, j + 0, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 0, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 1, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 2, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 3, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 4, k + 9, CMContent.portalframe);
		world.setBlock(i + 4, j + 4, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 5, k + 3, CMContent.cobaltbrickstair, 4, 2);
		world.setBlock(i + 4, j + 5, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 6, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 6, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 7, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 7, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 7, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 7, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 7, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 7, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 7, k + 9, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 7, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 7, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 8, k + 1, CMContent.cobaltbrickstair, 4, 2);
		world.setBlock(i + 4, j + 8, k + 2, CMContent.cobaltbrickstair, 4, 2);
		world.setBlock(i + 4, j + 8, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 8, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 8, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 8, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 8, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 8, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 8, k + 9, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 8, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 4, j + 8, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 0, k + 0,Blocks.grass);
		world.setBlock(i + 5, j + 0, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 0, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 0, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 0, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 0, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 0, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 0, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 0, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 0, k + 9, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 0, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 0, k + 9, CMContent.portalframe);
		world.setBlock(i + 5, j + 0, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 1, k + 9, CMContent.portalframe);
		world.setBlock(i + 5, j + 1, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 2, k + 9, CMContent.portalframe);
		world.setBlock(i + 5, j + 2, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 3, k + 9, CMContent.portalframe);
		world.setBlock(i + 5, j + 3, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 4, k + 3, CMContent.cobaltbrickstair, 4, 2);
		world.setBlock(i + 5, j + 4, k + 9, CMContent.portalframe);
		world.setBlock(i + 5, j + 4, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 5, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 5, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 6, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 6, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 7, k + 1, CMContent.cobaltbricksingleslab, 13, 2);
		world.setBlock(i + 5, j + 7, k + 2, CMContent.cobaltbricksingleslab, 13, 2);
		world.setBlock(i + 5, j + 7, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 7, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 7, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 7, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 7, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 7, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 7, k + 9, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 7, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 7, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 5, j + 8, k + 1, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 5, j + 8, k + 2, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 5, j + 8, k + 3, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 5, j + 8, k + 4, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 5, j + 8, k + 5, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 5, j + 8, k + 6, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 5, j + 8, k + 7, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 5, j + 8, k + 8, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 5, j + 8, k + 9, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 5, j + 8, k + 10, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 5, j + 8, k + 11, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 6, j + 0, k + 0,Blocks.grass);
		world.setBlock(i + 6, j + 0, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 0, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 0, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 0, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 0, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 0, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 0, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 0, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 0, k + 9, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 0, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 0, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 1, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 1, k + 11, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 6, j + 2, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 3, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 4, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 5, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 6, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 6, k + 11, CMContent.cobaltbricksingleslab, 13, 2);
		world.setBlock(i + 6, j + 7, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 7, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 7, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 7, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 7, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 7, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 7, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 7, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 7, k + 9, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 7, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 6, j + 7, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 0, k + 0,Blocks.grass);
		world.setBlock(i + 7, j + 0, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 0, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 0, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 0, k + 4, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 0, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 0, k + 6, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 0, k + 7, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 0, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 0, k + 9, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 0, k + 10, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 0, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 1, k + 0, CMContent.cobaltbrickstair, 2, 2);
		world.setBlock(i + 7, j + 1, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 1, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 1, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 1, k + 4, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 7, j + 1, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 1, k + 6, CMContent.cobaltbrickstair, 3, 2);
		world.setBlock(i + 7, j + 1, k + 7, CMContent.cobaltbrickstair, 2, 2);
		world.setBlock(i + 7, j + 1, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 1, k + 9, CMContent.cobaltbrickstair, 3, 2);
		world.setBlock(i + 7, j + 1, k + 10, CMContent.cobaltbrickstair, 2, 2);
		world.setBlock(i + 7, j + 1, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 2, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 2, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 2, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 2, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 2, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 2, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 3, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 3, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 3, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 3, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 3, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 3, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 4, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 4, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 4, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 4, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 4, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 4, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 5, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 5, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 5, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 5, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 5, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 5, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 6, k + 1, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 6, k + 2, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 6, k + 3, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 6, k + 4, CMContent.cobaltbricksingleslab, 13, 2);
		world.setBlock(i + 7, j + 6, k + 5, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 6, k + 6, CMContent.cobaltbrickstair, 7, 2);
		world.setBlock(i + 7, j + 6, k + 7, CMContent.cobaltbrickstair, 6, 2);
		world.setBlock(i + 7, j + 6, k + 8, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 6, k + 9, CMContent.cobaltbrickstair, 7, 2);
		world.setBlock(i + 7, j + 6, k + 10, CMContent.cobaltbrickstair, 6, 2);
		world.setBlock(i + 7, j + 6, k + 11, CMContent.cobaltbrick);
		world.setBlock(i + 7, j + 7, k + 1, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 7, j + 7, k + 2, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 7, j + 7, k + 3, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 7, j + 7, k + 4, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 7, j + 7, k + 5, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 7, j + 7, k + 6, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 7, j + 7, k + 7, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 7, j + 7, k + 8, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 7, j + 7, k + 9, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 7, j + 7, k + 10, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 7, j + 7, k + 11, CMContent.cobaltbricksingleslab, 5, 2);
		world.setBlock(i + 1, j + 3, k + 2, CMContent.cobextorch, 4, 2);
		world.setBlock(i + 1, j + 3, k + 5, CMContent.cobextorch, 1, 2);
		world.setBlock(i + 6, j + 3, k + 2, CMContent.cobextorch, 4, 2);
		world.setBlock(i + 6, j + 3, k + 5, CMContent.cobextorch, 2, 2);

		return true;
	}
}