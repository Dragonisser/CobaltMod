package cobaltmod.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cobaltmod.entity.ModelRoll;


public class RenderItemScroll implements IItemRenderer {


    protected ModelRoll model;
    
    public RenderItemScroll(){
        model = new ModelRoll();
    }
    

//Prüft ob das Item Equiped, also in der Hand, ist.
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        if(Minecraft.isFancyGraphicsEnabled()){
        switch(type){
        case EQUIPPED_FIRST_PERSON: return true;
        case EQUIPPED: return true;
        //case INVENTORY: return true;
        default: return false;
        }        
        }
        return false;
    }


    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {


        return false;
    }

    public static final ResourceLocation scroll_texture = new ResourceLocation("mod_cobalt:textures/models/scroll.png");

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        
        switch(type){
        case EQUIPPED_FIRST_PERSON:{
            GL11.glPushMatrix();
//Hier wird die Textur festgelegt.
            Minecraft.getMinecraft().renderEngine.bindTexture(scroll_texture);
            
            float scale = 1.0F;
            GL11.glScalef(scale, scale, scale);


            //Hier müsst ihr ein wenig mit den Zahlen rumprobieren, bis das Modell an der Richtige stelle ist. Die Roten Zahlen könnt ihr bearbeiten.
            if(data[1] != null && data[1] instanceof EntityPlayer){
                if(!((EntityPlayer)data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && !((Minecraft.getMinecraft().currentScreen instanceof GuiInventory || Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) && RenderManager.instance.playerViewY == 180.0F))){
                    GL11.glRotatef(4000.0F, 4000.0F, -7000.0F, -9000.0F);
                    GL11.glRotatef(240.0F, 0.0F, -0.0F, 20.0F);
                    GL11.glTranslatef(-0.6F, -1.4F, -0.35F);
                    
                    
                }
                       //Dies wird ausgeführt, wenn der Spieler in First Person ist.
                else{
                    GL11.glScalef(1.0F, 2.0F, 2.0F);
                    GL11.glRotatef(31.0F, 800.0F, 90.0F, 99999.0F);
                    GL11.glRotatef(-200.0F, 240.0F, 50.0F, 20.0F);
                    GL11.glTranslatef(0.7F, -0.65F, 0.05F);    
                    model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                }
            }
            /*else
            {
            
            GL11.glRotatef(50.0F, 700.0F, 700.0F, 1520.0F);
            GL11.glRotatef(-40.0F, 20.0F, 0.0F, 1.0F);
            GL11.glTranslatef(1.1F, -0.2F, 0.15F);
            }*/
            
            
            GL11.glPopMatrix();
        }
        case EQUIPPED:{
            GL11.glPushMatrix();
//Hier wird die Textur festgelegt.
            Minecraft.getMinecraft().renderEngine.bindTexture(scroll_texture);
            
            float scale = 1.5F;
            GL11.glScalef(scale, scale, scale);


            //Hier müsst ihr ein wenig mit den Zahlen rumprobieren, bis das Modell an der Richtige stelle ist. Die Roten Zahlen könnt ihr bearbeiten.
            if(data[1] != null && data[1] instanceof EntityPlayer){
                if(!((EntityPlayer)data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && !((Minecraft.getMinecraft().currentScreen instanceof GuiInventory || Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) && RenderManager.instance.playerViewY == 180.0F))){
                    GL11.glRotatef(4000.0F, 4000.0F, -7000.0F, -9000.0F);
                    GL11.glRotatef(240.0F, 0.0F, -0.0F, 20.0F);
                    GL11.glTranslatef(-0.6F, -1.4F, -0.35F);
                    model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                }
                       //Dies wird ausgeführt, wenn der Spieler in First Person ist.
                else{
                    GL11.glScalef(1.0F, 2.0F, 2.0F);
                    GL11.glRotatef(31.0F, 800.0F, 90.0F, 99999.0F);
                    GL11.glRotatef(-200.0F, 240.0F, 50.0F, 20.0F);
                    GL11.glTranslatef(0.7F, -0.65F, 0.05F); 
                }
            }
            GL11.glPopMatrix();
        }
        default:
            break;
        }       
    }
}