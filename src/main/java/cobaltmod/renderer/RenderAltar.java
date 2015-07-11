package cobaltmod.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cobaltmod.entity.ModelAltar;
import cobaltmod.entity.tileentity.TileEntityAltar;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderAltar extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler{
 
	protected ModelAltar modelMixer = new ModelAltar();
	public static int altarRenderId = RenderingRegistry.getNextAvailableRenderId();
	
	protected Minecraft mc;
	
//	public RenderMixer() {
//		this.modelMixer = new ModelMixer();
//		
//	}
	
	public static final ResourceLocation altar_texture = new ResourceLocation("mod_cobalt:textures/models/altarofassociation.png");
	
	public void renderTileEntityAt(TileEntityAltar entity, double d, double d1, double d2, float f) {
		int side = entity.getBlockMetadata();
		int rot = 0;
		
		if (side == 2){
	      rot = 180;
	    }
	    if (side == 5){
	      rot = 90;
	    }
	    if (side == 3){
	      rot = 0;
	    }
	    if (side == 4){
	      rot = 270;
	    }
	    Minecraft.getMinecraft().renderEngine.bindTexture(altar_texture);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
		GL11.glRotatef(rot, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(0, 0.0F, 1.0F, 0.0F);
		GL11.glPushMatrix();
		modelMixer.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)0.0F, (float)1.0F, (float)0.0F);
		GL11.glRotatef(180f, 0f, 0f, 1f);
		GL11.glRotatef(180f, 0f, 1f, 0f);
		
		
		/*TextureObject textureObject = this.mc.renderEngine.getTexture(Index.MIXER_TEXTURE);
		int textureInt = textureObject.getGlTextureId();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureInt);*/
		
		Minecraft.getMinecraft().renderEngine.bindTexture(altar_texture);
		
		modelMixer.renderModel(0.0625F);
		GL11.glPopMatrix();
		
		
	}
	
	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
	{
		renderTileEntityAt((TileEntityAltar)tileentity, d, d1, d2, f);
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public int getRenderId() {
		return altarRenderId;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		// TODO Auto-generated method stub
		return true;
	}
}
