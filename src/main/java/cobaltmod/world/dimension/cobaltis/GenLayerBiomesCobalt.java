package cobaltmod.world.dimension.cobaltis;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import cobaltmod.world.biome.BiomeGenBaseCobalt;

public class GenLayerBiomesCobalt extends GenLayer {

protected BiomeGenBase[] allowedBiomes = {BiomeGenBaseCobalt.biomehills, BiomeGenBaseCobalt.biomeplains, BiomeGenBaseCobalt.biomeswamp, BiomeGenBaseCobalt.biometall, BiomeGenBaseCobalt.biomemountains}; 

public GenLayerBiomesCobalt(long seed, GenLayer genlayer) {
	super(seed);
	this.parent = genlayer;
}

public GenLayerBiomesCobalt(long seed) {
	super(seed);
}

@Override
public int[] getInts(int x, int z, int width, int depth)
{
	int[] dest = IntCache.getIntCache(width*depth);
	
		for (int dz=0; dz<depth; dz++)
		{
			for (int dx=0; dx<width; dx++)
			{
				this.initChunkSeed(dx+x, dz+z);
				dest[(dx+dz*width)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
			}
		}
	return dest;
	}
}