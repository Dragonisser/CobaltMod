package cobaltmod.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRendererChestHelper;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import cobaltmod.entity.tileentity.TileEntityLockedCobaltChest;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityRendererLockedCobaltChestHelper extends TileEntityRendererChestHelper {
	public static TileEntityRendererLockedCobaltChestHelper instance = new TileEntityRendererLockedCobaltChestHelper();
	private TileEntityLockedCobaltChest lockedcobaltchest = new TileEntityLockedCobaltChest(3);
	private TileEntityLockedCobaltChest cobaltchest = new TileEntityLockedCobaltChest(0);

	// private static final String __OBFID = "CL_00000946";

	/**
	 * Renders a chest at 0,0,0 - used for item rendering
	 */
	public void renderChest(Block p_147715_1_, int p_147715_2_, float p_147715_3_) {
		if (p_147715_1_ == CMContent.lockedcobaltchest) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.lockedcobaltchest, 0.0D, 0.0D, 0.0D, 0.0F);
		} else {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.cobaltchest, 0.0D, 0.0D, 0.0D, 0.0F);
		}
	}
}