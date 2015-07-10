package cobaltmod.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCobaltZombie extends ModelBase
{
  //fields
    ModelRenderer FootRight;
    ModelRenderer Body;
    ModelRenderer ArmLeft;
    ModelRenderer Head;
    ModelRenderer FootLeft;
    ModelRenderer ArmRight;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
  
  public ModelCobaltZombie()
  {
    textureWidth = 64;
    textureHeight = 32;
    
    FootRight = new ModelRenderer(this, 0, 16);
    FootRight.addBox(-2F, 0F, -2F, 4, 12, 4);
    FootRight.setRotationPoint(-2F, 12F, 1F);
    FootRight.setTextureSize(64, 32);
    FootRight.mirror = true;
    setRotation(FootRight, 0F, 0F, 0F);
    FootRight.mirror = false;
    Body = new ModelRenderer(this, 16, 16);
    Body.addBox(-4F, -8F, -2F, 8, 12, 4);
    Body.setRotationPoint(0F, 9F, 1F);
    Body.setTextureSize(64, 32);
    Body.mirror = true;
    setRotation(Body, 0F, 0F, 0F);
    ArmLeft = new ModelRenderer(this, 40, 16);
    ArmLeft.addBox(-4F, -1F, -2F, 4, 12, 4);
    ArmLeft.setRotationPoint(-4F, 2F, 1F);
    ArmLeft.setTextureSize(64, 32);
    ArmLeft.mirror = true;
    setRotation(ArmLeft, 0F, 0F, 0F);
    ArmLeft.mirror = false;
    Head = new ModelRenderer(this, 0, 0);
    Head.addBox(-4F, -8F, -4F, 8, 8, 8);
    Head.setRotationPoint(0F, 1F, 1F);
    Head.setTextureSize(64, 32);
    Head.mirror = true;
    setRotation(Head, 0F, 0F, 0F);
    FootLeft = new ModelRenderer(this, 0, 16);
    FootLeft.addBox(-2F, 0F, -2F, 4, 12, 4);
    FootLeft.setRotationPoint(2F, 12F, 1F);
    FootLeft.setTextureSize(64, 32);
    FootLeft.mirror = true;
    setRotation(FootLeft, 0F, 0F, 0F);
    ArmRight = new ModelRenderer(this, 40, 0);
    ArmRight.addBox(0F, -1F, -2F, 4, 12, 4);
    ArmRight.setRotationPoint(4F, 2F, 1F);
    ArmRight.setTextureSize(64, 32);
    ArmRight.mirror = true;
    setRotation(ArmRight, 0F, 0F, 0F);
    Shape1 = new ModelRenderer(this, 32, 0);
    Shape1.addBox(0F, 0F, -2F, 2, 2, 2);
    Shape1.setRotationPoint(-5.6F, 3F, 1F);
    Shape1.setTextureSize(64, 32);
    Shape1.mirror = true;
    setRotation(Shape1, -0.8551081F, 2.156359F, 0.0743572F);
    Shape1.mirror = false;
    Shape2 = new ModelRenderer(this, 32, 0);
    Shape2.addBox(0F, 0F, 0F, 2, 2, 2);
    Shape2.setRotationPoint(5.5F, 8F, 0.4F);
    Shape2.setTextureSize(64, 32);
    Shape2.mirror = true;
    setRotation(Shape2, 0.9294653F, 0.5576792F, 0.0743572F);
    Shape3 = new ModelRenderer(this, 32, 0);
    Shape3.addBox(0F, 0F, 0F, 2, 2, 2);
    Shape3.setRotationPoint(-2.4F, -6F, 4F);
    Shape3.setTextureSize(64, 32);
    Shape3.mirror = true;
    setRotation(Shape3, -0.8551081F, 2.156359F, 0.0743572F);
    Shape4 = new ModelRenderer(this, 32, 0);
    Shape4.addBox(0F, 0F, 0F, 2, 2, 2);
    Shape4.setRotationPoint(3F, 9F, 0F);
    Shape4.setTextureSize(64, 32);
    Shape4.mirror = true;
    setRotation(Shape4, -0.8551081F, 2.602503F, 0.0743572F);
}
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
	super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    FootRight.render(par7);
    Body.render(par7);
    ArmLeft.render(par7);
    Head.render(par7);
    FootLeft.render(par7);
    ArmRight.render(par7);
    Shape1.render(par7);
    Shape2.render(par7);
    //Shape3.render(par7);
    Shape4.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
      this.Head.rotateAngleY = par4 / (180F / (float)Math.PI);
      this.Head.rotateAngleX = par5 / (180F / (float)Math.PI);
      this.ArmRight.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
      this.ArmLeft.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
      this.ArmRight.rotateAngleZ = 0.0F;
      this.ArmLeft.rotateAngleZ = 0.0F;
      this.FootRight.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.FootLeft.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      this.FootRight.rotateAngleY = 0.0F;
      this.FootLeft.rotateAngleY = 0.0F;
  }
}
