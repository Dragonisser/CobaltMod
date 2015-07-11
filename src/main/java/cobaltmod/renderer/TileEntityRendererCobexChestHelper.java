package cobaltmod.renderer;

import cobaltmod.entity.tileentity.TileEntityCobexChest;
import cobaltmod.main.api.CMContent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRendererChestHelper;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

@SideOnly(Side.CLIENT)
public class TileEntityRendererCobexChestHelper extends TileEntityRendererChestHelper
{
    public static TileEntityRendererCobexChestHelper instance = new TileEntityRendererCobexChestHelper();
    private TileEntityCobexChest cobaltchest = new TileEntityCobexChest();
    //private static final String __OBFID = "CL_00000946";

    /**
     * Renders a chest at 0,0,0 - used for item rendering
     */
    public void renderChest(Block p_147715_1_, int p_147715_2_, float p_147715_3_)
    {
        if (p_147715_1_ == CMContent.cobexchest)
        {
           TileEntityRendererDispatcher.instance.renderTileEntityAt(this.cobaltchest, 0.0D, 0.0D, 0.0D, 0.0F);
        }
        else
        {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.cobaltchest, 0.0D, 0.0D, 0.0D, 0.0F);
        }
    }
}