package cobaltmod.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import cobaltmod.entity.EntityBlueBuddy;
import cobaltmod.entity.ModelBlueBuddy;

public class RenderBlueBuddy extends RenderLiving 
{

	protected ModelBlueBuddy model;

	public RenderBlueBuddy(ModelBlueBuddy modelbluebuddy, float f) 
	{
		super(modelbluebuddy, f);
		model = ((ModelBlueBuddy) mainModel);
	}

	public static final ResourceLocation resourcebb = new ResourceLocation("mod_cobalt:textures/mobs/bluebuddy.png");
	public static final ResourceLocation resourcebb_panic = new ResourceLocation("mod_cobalt:textures/mobs/bluebuddy_panic.png");

	public void renderBlueBuddy(EntityBlueBuddy entity, double par2, double par4, double par6, float par8, float par9) 
	{
		super.doRender(entity, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) 
	{
		renderBlueBuddy((EntityBlueBuddy) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) 
	{
		renderBlueBuddy((EntityBlueBuddy) par1Entity, par2, par4, par6, par8, par9);
	}
	
	protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEntityTexture((EntityBlueBuddy)par1Entity);
    }

	protected ResourceLocation getEntityTexture(EntityBlueBuddy par1BlueBuddy) {
		return (par1BlueBuddy.isPanic() ? resourcebb_panic : resourcebb);
	}
}