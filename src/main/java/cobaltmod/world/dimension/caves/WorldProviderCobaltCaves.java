package cobaltmod.world.dimension.caves;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.ForgeHooksClient;
import cobaltmod.main.CMMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderCobaltCaves extends WorldProvider {
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerCobaltCaves(worldObj.getSeed(), terrainType);
		this.dimensionId = CMMain.cobaltdimension1;
		this.hasNoSky = true;
	}

	public String getDimensionName() {
		return "Deep Caves";
	}

	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderCobaltCaves(worldObj, worldObj.getSeed());
	}

	public String getSaveFolder() {
		return "Deep Caves";
	}

	public boolean isSurfaceWorld() {
		return true;
	}

	public boolean canRespawnHere() {
		return false;
	}

	public float getCelestialAngle(float p_72826_1_) {
		return this.calculateCelestialAngle(this.getWorldTime(), p_72826_1_);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
		float f1 = this.getCelestialAngle(partialTicks);
		float f2 = MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.5F;

		if (f2 < 0.0F) {
			f2 = 0.0F;
		}

		if (f2 > 1.0F) {
			f2 = 1.0F;
		}

		int i = MathHelper.floor_double(cameraEntity.posX);
		int j = MathHelper.floor_double(cameraEntity.posY);
		int k = MathHelper.floor_double(cameraEntity.posZ);
		int l = ForgeHooksClient.getSkyBlendColour(this.worldObj, i, j, k);
		float f4 = (float) (l >> 16 & 255) / 255.0F;
		float f5 = (float) (l >> 8 & 255) / 255.0F;
		float f6 = (float) (l & 255) / 255.0F;
		f4 *= f2;
		f5 *= f2;
		f6 *= f2;

		return Vec3.createVectorHelper((double) f4 - 0.8, (double) f5 - 0.7, (double) f6 - 0.8);
	}

	@SideOnly(Side.CLIENT)
	public boolean isSkyColored() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float par1, float par2) {
		float f2 = MathHelper.cos(par1 * (float) Math.PI * 2.0F) * 2.0F + 0.5F;

		if (f2 < 0.0F) {
			f2 = 0.0F;
		}

		if (f2 > 1.0F) {
			f2 = 1.0F;
		}

		float f3 = 0.7529412F;
		float f4 = 0.84705883F;
		float f5 = 1.0F;
		f3 *= f2 * 0.94F + 0.06F;
		f4 *= f2 * 0.94F + 0.06F;
		f5 *= f2 * 0.91F + 0.F;
		return Vec3.createVectorHelper((double) f3 - 0.5, (double) f4 - 0.5, (double) f5 - 0.4);
	}

	public String getWelcomeMessage() {

		return "Entering the Deep Caves";
	}
}
