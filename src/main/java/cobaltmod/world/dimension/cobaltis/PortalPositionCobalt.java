package cobaltmod.world.dimension.cobaltis;

import net.minecraft.util.ChunkCoordinates;

public class PortalPositionCobalt extends ChunkCoordinates
{
    /** The worldtime at which this PortalPosition was last verified */
    public long lastUpdateTime;

    /** The teleporter to which this PortalPosition applies */
    final TeleporterCobalt teleporterInstance;

    public PortalPositionCobalt(TeleporterCobalt teleporterCobalt, int par2, int par3, int par4, long par5)
    {
        super(par2, par3, par4);
        this.teleporterInstance = teleporterCobalt;
        this.lastUpdateTime = par5;
    }
}
