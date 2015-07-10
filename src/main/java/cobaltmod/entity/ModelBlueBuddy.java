package cobaltmod.entity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBlueBuddy extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer footright;
    ModelRenderer footleft;
    ModelRenderer armleft;
    ModelRenderer armright;
  
  public ModelBlueBuddy()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-5F, -5F, -5F, 10, 10, 10);
      head.setRotationPoint(0F, 15F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      footright = new ModelRenderer(this, 40, 7);
      footright.addBox(-1F, 0F, -1F, 2, 4, 2);
      footright.setRotationPoint(-2F, 20F, 0F);
      footright.setTextureSize(64, 32);
      footright.mirror = true;
      setRotation(footright, 0F, 0F, 0F);
      footleft = new ModelRenderer(this, 40, 7);
      footleft.addBox(-1F, 0F, -1F, 2, 4, 2);
      footleft.setRotationPoint(2F, 20F, 0F);
      footleft.setTextureSize(64, 32);
      footleft.mirror = true;
      setRotation(footleft, 0F, 0F, 0F);
      armleft = new ModelRenderer(this, 40, 0);
      armleft.addBox(0F, -1F, -1F, 2, 5, 2);
      armleft.setRotationPoint(5F, 14F, 0F);
      armleft.setTextureSize(64, 32);
      armleft.mirror = true;
      setRotation(armleft, 0F, 0F, 0F);
      armright = new ModelRenderer(this, 40, 0);
      armright.addBox(-2F, -1F, -1F, 2, 5, 2);
      armright.setRotationPoint(-5F, 14F, 0F);
      armright.setTextureSize(64, 32);
      armright.mirror = true;
      setRotation(armright, 0F, 0F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
	super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
	
	if (isChild)
	{
		float f6 = 2.0F;
        GL11.glPushMatrix();
        GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
        GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
        this.head.render(par7);
        this.footright.render(par7);
        this.footleft.render(par7);
        this.armleft.render(par7);
        this.armright.render(par7);
        GL11.glPopMatrix();
	}
	
    head.render(par7);
    footright.render(par7);
    footleft.render(par7);
    armleft.render(par7);
    armright.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
      this.armright.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
      this.armleft.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
      this.armright.rotateAngleZ = 0.0F;
      this.armleft.rotateAngleZ = 0.0F;
      this.footright.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.footleft.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      this.footright.rotateAngleY = 0.0F;
      this.footleft.rotateAngleY = 0.0F;
  }

}
