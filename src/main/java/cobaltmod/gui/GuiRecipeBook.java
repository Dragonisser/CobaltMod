package cobaltmod.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiRecipeBook extends GuiScreen
{
    /** The player editing the book */
    public final EntityPlayer editingPlayer;

    /** Update ticks since the gui was opened */
    public int updateCount;
    private int bookImageWidth = 192;
    private int bookImageHeight = 192;
    private int bookTotalPages = 3;
    private int currPage;
    private int aPage = 0;
    public NBTTagList bookPages;
    public String bookTitle = "";
    public GuiRecipeNextPage buttonNextPage;
    public GuiRecipeNextPage buttonPreviousPage;
    public GuiButton buttonDone;


    public final ResourceLocation resourcesite0 = new ResourceLocation("mod_cobalt", "textures/gui/rbpage0.png");
    public final ResourceLocation resourcesite1 = new ResourceLocation("mod_cobalt", "textures/gui/rbpage1.png");
    public final ResourceLocation resourcesite2 = new ResourceLocation("mod_cobalt", "textures/gui/rbpage2.png");
    
    
    public GuiRecipeBook(EntityPlayer par1EntityPlayer)
    {
        this.editingPlayer = par1EntityPlayer;
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
        ++this.updateCount;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @SuppressWarnings("unchecked")
	public void initGui()
    {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.buttonList.add(this.buttonDone = new GuiButton(0, this.width / 2 - 100, 4 + this.bookImageHeight, 200, 20, StatCollector.translateToLocal("gui.done")));

        int i = (this.width - this.bookImageWidth) / 2;
        byte b0 = 2;
        this.buttonList.add(this.buttonNextPage = new GuiRecipeNextPage(1, i + 120, b0 + 154, true));
        this.buttonList.add(this.buttonPreviousPage = new GuiRecipeNextPage(2, i + 38, b0 + 154, false));
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            if (par1GuiButton.id == 0)
            {
                this.mc.displayGuiScreen((GuiScreen)null);
               // this.sendBookToServer(false);
            }
            else if (par1GuiButton.id == 1)
            {
                if (this.currPage < this.bookTotalPages - 1)
                {
                    ++this.currPage;
                    ++this.aPage;
                }
            }
            else if (par1GuiButton.id == 2)
            {
                if (this.currPage > 0)
                {
                    --this.currPage;
                    --this.aPage;
                }
            }
            //this.updateButtons();
        }
    }


    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(this.resourcesite0);
        int k = (this.width - this.bookImageWidth) / 2;
        byte b0 = 2;
        this.drawTexturedModalRect(k, b0, 0, 0, this.bookImageWidth, this.bookImageHeight);
        String s;
        String s1;
        int l;

        if (aPage == 0) {
         s = EnumChatFormatting.BOLD + "Cobalt Recipe Book";
         s1 = "In this Recipebook you will find all the recipes of the Mod.";

            l = this.fontRendererObj.getStringWidth(s);
            this.fontRendererObj.drawString(s, k - l + this.bookImageWidth - 44, b0 + 16, 0);
            this.fontRendererObj.drawSplitString(s1, k + 36, b0 + 16 + 16, 116, 0);
        }
        if (aPage == 1 ){
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.getTextureManager().bindTexture(this.resourcesite1);
            k = (this.width - this.bookImageWidth) / 2;
            b0 = 2;
            this.drawTexturedModalRect(k, b0, 0, 0, this.bookImageWidth, this.bookImageHeight);
            
         s = EnumChatFormatting.BOLD + "Blocks";
         s1 = "The following pages cotains recipes about the Blocks.";

            l = this.fontRendererObj.getStringWidth(s);
            this.fontRendererObj.drawString(s, k - l / 2 + this.bookImageWidth / 2, b0 + 16, 0);
            this.fontRendererObj.drawSplitString(s1, k + 36, b0 + 16 + 16, 116, 0);
        }
        if (aPage == 2) {
        	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        	this.mc.getTextureManager().bindTexture(this.resourcesite2);
            k = (this.width - this.bookImageWidth) / 2;
            b0 = 2;
            this.drawTexturedModalRect(k, b0, 0, 0, this.bookImageWidth, this.bookImageHeight);
            
         s = EnumChatFormatting.BOLD + "Cobaltblock";
         s1 = "";

            l = this.fontRendererObj.getStringWidth(s);
            this.fontRendererObj.drawString(s, k - l / 2 + this.bookImageWidth / 2, b0 + 16, 0);
            this.fontRendererObj.drawSplitString(s1, k + 36, b0 + 16 + 16, 116, 0);
        }
        super.drawScreen(par1, par2, par3);
    }
}