package cobaltmod.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import cobaltmod.entity.EntityCobaltGuardian;
import cobaltmod.entity.ModelCobaltGuardian;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class RenderCobaltGuardian extends RenderLiving {

	protected ModelBase model;
	public static final ResourceLocation resourcecg = new ResourceLocation("mod_cobalt:textures/mobs/cobaltguardian.png");

	public RenderCobaltGuardian(ModelCobaltGuardian par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = new ModelCobaltGuardian();
	}

	public void renderCobaltGuardian(EntityCobaltGuardian entity, double par2, double par4, double par6, float par8, float par9) {
		BossStatus.setBossStatus(entity, true);
		
		float f2 = (float)entity.innerRotation/* + par9*/;

        float f3 = MathHelper.sin(f2 * 0.2F) / 2.0F + 0.5F;
        //f3 += f3 * f3;
        f3 = Math.abs(f3);

		
        
		super.doRender(entity, par2, par4 + f3, par6, par8, par9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		renderCobaltGuardian((EntityCobaltGuardian) par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {

		return resourcecg;
	}
}