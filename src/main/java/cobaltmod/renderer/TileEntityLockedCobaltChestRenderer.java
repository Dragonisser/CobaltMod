package cobaltmod.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cobaltmod.entity.tileentity.TileEntityLockedCobaltChest;
import cobaltmod.main.blocks.BlockLockedCobaltChest;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityLockedCobaltChestRenderer extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {

	public static int chestRenderId = RenderingRegistry.getNextAvailableRenderId();
	private static final ResourceLocation RES_NORMAL_SINGLE = new ResourceLocation("mod_cobalt:textures/models/cobalt.png");
	private static final ResourceLocation RES_NORMAL_SINGLE_LOCKED = new ResourceLocation("mod_cobalt:textures/models/cobalt_locked.png");

	/** The normal small chest model. */
	private ModelChest chestModel = new ModelChest();

	public TileEntityLockedCobaltChestRenderer() {

	}
	
	public void renderInventoryBlock(Block var1, int var2, int var3, RenderBlocks var4) {
		if (var3 == this.getRenderId()) {
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			TileEntityRendererLockedCobaltChestHelper.instance.renderChest(var1, var2, 0.0F);
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		}
	}
	
	public boolean renderWorldBlock(IBlockAccess var1, int var2, int var3, int var4, Block var5, int var6, RenderBlocks var7) {
		return false;
	}

	public int getRenderId() {
		return chestRenderId;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	/**
	 * Renders the TileEntity for the chest at a position.
	 */
	public void render(TileEntityLockedCobaltChest par1TileEntityChest, double par2, double par4, double par6, float par8) {
		int i;

		if (!par1TileEntityChest.hasWorldObj()) {
			i = 0;
		} else {
			Block block = par1TileEntityChest.getBlockType();
			i = par1TileEntityChest.getBlockMetadata();

			if (block instanceof BlockLockedCobaltChest && i == 0) {
				i = par1TileEntityChest.getBlockMetadata();
			}

		}
		ModelChest modelchest = this.chestModel;
		

		if (par1TileEntityChest.func_145980_j() == 3) {
			this.bindTexture(RES_NORMAL_SINGLE_LOCKED);
		} else {
			this.bindTexture(RES_NORMAL_SINGLE);
		}

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) par2, (float) par4 + 1.0F, (float) par6 + 1.0F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		short short1 = 0;

		if (i == 2) {
			short1 = 180;
		}

		if (i == 3) {
			short1 = 0;
		}

		if (i == 4) {
			short1 = 90;
		}

		if (i == 5) {
			short1 = -90;
		}

		GL11.glRotatef((float) short1, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		float f1 = par1TileEntityChest.prevLidAngle + (par1TileEntityChest.lidAngle - par1TileEntityChest.prevLidAngle) * par8;

		f1 = 1.0F - f1;
		f1 = 1.0F - f1 * f1 * f1;
		modelchest.chestLid.rotateAngleX = -(f1 * (float) Math.PI / 2.0F);
		modelchest.renderAll();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
		this.render((TileEntityLockedCobaltChest) par1TileEntity, par2, par4, par6, par8);
	}
}
