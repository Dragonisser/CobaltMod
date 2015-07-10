package cobaltmod.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import cobaltmod.entity.TileEntityAltar;

@SideOnly(Side.CLIENT)
public class GuiAltar extends GuiContainer
{
    private TileEntityAltar altarInventory;

    public GuiAltar(InventoryPlayer par1InventoryPlayer, TileEntityAltar par2TileEntityAltar)
    {
        super(new ContainerAltar(par1InventoryPlayer, par2TileEntityAltar));
        this.altarInventory = par2TileEntityAltar;
    }
    
    public static final ResourceLocation resourcealtar = new ResourceLocation("mod_cobalt", "textures/gui/altar.png");

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String s = this.altarInventory.isInvNameLocalized() ? this.altarInventory.getInvName() : StatCollector.translateToLocal(this.altarInventory.getInvName());
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(resourcealtar);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        i1 = this.altarInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
        
        this.drawTexturedModalRect(k + 56, l + 36 + 16, 20, 14, 16, 16);
        //RenderItem itemRender = new RenderItem();
        //itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.renderEngine, new ItemStack(Blocks.fire, 1, 0), k + 56, l + 36 + 16);
    }
}
