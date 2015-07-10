package cobaltmod.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCobexChest implements ISimpleBlockRenderingHandler 
{
	protected ModelChest modelMixer = new ModelChest();
	public static int chestRenderId = RenderingRegistry.getNextAvailableRenderId();
	public static final ResourceLocation altar_texture = new ResourceLocation("mod_cobalt:textures/models/normal.png");
	
	public void renderInventoryBlock(Block var1, int var2, int var3, RenderBlocks var4)
	{
         if (var3 == this.getRenderId())
         {
                 GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                 GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                 TileEntityRendererCobexChestHelper.instance.renderChest(var1, var2, 0.0F);
                 GL11.glEnable(GL12.GL_RESCALE_NORMAL);
         }
	}
	
	public boolean renderWorldBlock(IBlockAccess var1, int var2, int var3, int var4, Block var5, int var6, RenderBlocks var7)
	{
         return false;
	}
	public int getRenderId()
	{
         return chestRenderId;
	}
	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		// TODO Auto-generated method stub
		return true;
	}
}