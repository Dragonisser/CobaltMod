package cobaltmod.renderer;

import cobaltmod.entity.EntityCobaltZombie;
import cobaltmod.entity.ModelCobaltZombie;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;



public class RenderCobaltZombie extends RenderLiving
{
	
 protected ModelCobaltZombie model;
 public RenderCobaltZombie (ModelCobaltZombie modelCobaltZombie, float f)
 {
  super(modelCobaltZombie, f);
  model = ((ModelCobaltZombie)mainModel);
 }
 public static final ResourceLocation resourcecz = new ResourceLocation("mod_cobalt:textures/mobs/cobaltzombie.png");
 
 public void renderCobaltZombie(EntityCobaltZombie entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }
 
 public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderCobaltZombie((EntityCobaltZombie)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderCobaltZombie((EntityCobaltZombie)par1Entity, par2, par4, par6, par8, par9);
    }
@Override
protected ResourceLocation getEntityTexture(Entity entity) {
	// TODO Auto-generated method stub
	return resourcecz;
}
}