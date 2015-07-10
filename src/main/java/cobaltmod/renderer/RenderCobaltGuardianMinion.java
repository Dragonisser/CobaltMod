package cobaltmod.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import cobaltmod.entity.EntityCobaltGuardianMinion;
import cobaltmod.entity.ModelCobaltGuardianMinion;

public class RenderCobaltGuardianMinion extends RenderLiving 
{

	protected ModelCobaltGuardianMinion model;

	public RenderCobaltGuardianMinion(ModelCobaltGuardianMinion modelbluebuddy, float f) 
	{
		super(modelbluebuddy, f);
		model = ((ModelCobaltGuardianMinion) mainModel);
	}

	public static final ResourceLocation resourcecgm = new ResourceLocation("mod_cobalt:textures/mobs/cobaltguardianminion.png");

	public void renderBlueBuddy(EntityCobaltGuardianMinion entity, double par2, double par4, double par6, float par8, float par9) 
	{
		super.doRender(entity, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) 
	{
		renderBlueBuddy((EntityCobaltGuardianMinion) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) 
	{
		renderBlueBuddy((EntityCobaltGuardianMinion) par1Entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return resourcecgm;
	}
}