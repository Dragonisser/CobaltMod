package cobaltmod.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCobaltGuardian_new extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer head;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
  
  public ModelCobaltGuardian_new()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Shape1 = new ModelRenderer(this, 0, 104);
      Shape1.addBox(-17F, 0F, -7F, 34, 10, 14);
      Shape1.setRotationPoint(0F, -10F, 0F);
      Shape1.setTextureSize(256, 128);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 90, 14);
      Shape2.addBox(-5F, 0F, -8.5F, 10, 10, 16);
      Shape2.setRotationPoint(-22F, -11F, 0.5F);
      Shape2.setTextureSize(256, 128);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 90, 14);
      Shape3.addBox(-3F, 0F, -8F, 10, 10, 16);
      Shape3.setRotationPoint(20F, -11F, 0.5F);
      Shape3.setTextureSize(256, 128);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 91);
      Shape4.addBox(-7F, 0F, -6F, 14, 1, 12);
      Shape4.setRotationPoint(0F, -11F, 0F);
      Shape4.setTextureSize(256, 128);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      head = new ModelRenderer(this, 0, 72);
      head.addBox(-5F, 0F, -5.5F, 10, 8, 11);
      head.setRotationPoint(0F, -19F, 0.5F);
      head.setTextureSize(256, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 90, 40);
      Shape6.addBox(-4F, 0F, -5.5F, 8, 14, 11);
      Shape6.setRotationPoint(22F, -1F, 0F);
      Shape6.setTextureSize(256, 128);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 90, 40);
      Shape7.addBox(-4F, 0F, -5.5F, 8, 14, 11);
      Shape7.setRotationPoint(-22F, -1F, 0F);
      Shape7.setTextureSize(256, 128);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 90, 65);
      Shape8.addBox(-4.5F, 0F, -6F, 9, 8, 12);
      Shape8.setRotationPoint(22F, 13F, 0F);
      Shape8.setTextureSize(256, 128);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 90, 65);
      Shape9.addBox(-4.5F, 0F, -6F, 9, 8, 12);
      Shape9.setRotationPoint(-22F, 13F, 0F);
      Shape9.setTextureSize(256, 128);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 52, 90);
      Shape10.addBox(-16F, 0F, -6F, 32, 2, 12);
      Shape10.setRotationPoint(0F, 0F, 0F);
      Shape10.setTextureSize(256, 128);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 90, 0);
      Shape11.addBox(-4F, 0F, -6.5F, 8, 1, 13);
      Shape11.setRotationPoint(22F, -12F, 0F);
      Shape11.setTextureSize(256, 128);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 90, 0);
      Shape12.addBox(-4F, 0F, -6.5F, 8, 1, 13);
      Shape12.setRotationPoint(-22F, -12F, 0F);
      Shape12.setTextureSize(256, 128);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    head.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
}
