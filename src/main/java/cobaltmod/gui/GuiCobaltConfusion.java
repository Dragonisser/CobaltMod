package cobaltmod.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cobaltmod.main.api.CMContent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCobaltConfusion extends GuiScreen {

	private Minecraft mc;

	public GuiCobaltConfusion(Minecraft mc) {
		super();

		this.mc = mc;
	}

	public String convert(Integer input) {
		return input.toString();
	}

	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent event) {

		if (event.isCancelable() || event.type != ElementType.HELMET) {
			return;
		}

		if (this.mc.thePlayer.isPotionActive(CMContent.potion_cobalt_confusion)) {

			ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
			int k = scaledresolution.getScaledWidth() * (int) 1.5;
			int l = scaledresolution.getScaledHeight() * (int) 1.5;

			float p_130015_1_ = 3.0F;

			if (p_130015_1_ < 1.0F) {
				p_130015_1_ *= p_130015_1_;
				p_130015_1_ *= p_130015_1_;
				p_130015_1_ = p_130015_1_ * 0.8F + 0.2F;
			}

			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glDepthMask(false);
			OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, p_130015_1_);
			IIcon iicon = CMContent.cobaltportal.getBlockTextureFromSide(1);
			this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
			float f1 = iicon.getMinU();
			float f2 = iicon.getMinV();
			float f3 = iicon.getMaxU();
			float f4 = iicon.getMaxV();
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(0.0D, (double) l, -90.0D, (double) f1, (double) f4);
			tessellator.addVertexWithUV((double) k, (double) l, -90.0D, (double) f3, (double) f4);
			tessellator.addVertexWithUV((double) k, 0.0D, -90.0D, (double) f3, (double) f2);
			tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, (double) f1, (double) f2);
			tessellator.draw();
			GL11.glDepthMask(true);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		}

	}
}
