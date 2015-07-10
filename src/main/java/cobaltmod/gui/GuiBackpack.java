package cobaltmod.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiBackpack extends GuiContainer
{
	/** ResourceLocation takes 2 parameters: ModId, path to texture at the location:
	 * "src/minecraft/assets/modid/"
	 * 
	 * I have provided a sample texture file that works with this tutorial. Download it
	 * from Forge_Tutorials/textures/gui/
	 */
	private static final ResourceLocation iconLocation = new ResourceLocation("mod_cobalt", "textures/gui/backpack_inventory.png");

	/** The inventory to render on screen */
	private final InventoryBackpack inventory;

	public GuiBackpack(ContainerBackpack containerItem)
	{
		super(containerItem);
		this.inventory = containerItem.inventory;
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	public void drawScreen(int par1, int par2, float par3)
	{
		super.drawScreen(par1, par2, par3);
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String s = this.inventory.hasCustomInventoryName() ? this.inventory.getInventoryName() : I18n.format(this.inventory.getInventoryName());
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2 - 9, 2, 4210752);
		//this.fontRendererObj.drawString(I18n.format("container.inventory"), 26, this.ySize - 96 + 4, 4210752);
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the items)
	 */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(iconLocation);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);		
	}
}
