package cobaltmod.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPodium extends ModelBase
{
  //fields
    ModelRenderer Foot1;
    ModelRenderer Foot2;
    ModelRenderer Pillar1;
    ModelRenderer Table1;
  
    public ModelPodium()
    {
      textureWidth = 64;
      textureHeight = 128;
      
        Foot1 = new ModelRenderer(this, 0, 0);
        Foot1.addBox(-5.5F, 0F, -5.5F, 11, 1, 11);
        Foot1.setRotationPoint(0F, 23F, 0F);
        Foot1.setTextureSize(64, 32);
        Foot1.mirror = true;
        setRotation(Foot1, 0F, 0F, 0F);
        Foot2 = new ModelRenderer(this, 0, 13);
        Foot2.addBox(-4F, 0F, -4F, 8, 1, 8);
        Foot2.setRotationPoint(0F, 22F, 0F);
        Foot2.setTextureSize(64, 32);
        Foot2.mirror = true;
        setRotation(Foot2, 0F, 0F, 0F);
        Pillar1 = new ModelRenderer(this, 0, 23);
        Pillar1.addBox(-3F, 0F, -3F, 6, 15, 6);
        Pillar1.setRotationPoint(0F, 7F, 0F);
        Pillar1.setTextureSize(64, 32);
        Pillar1.mirror = true;
        setRotation(Pillar1, 0F, 0F, 0F);
        Table1 = new ModelRenderer(this, 0, 45);
        Table1.addBox(-6F, 0F, -6F, 12, 1, 12);
        Table1.setRotationPoint(0F, 6.5F, 0F);
        Table1.setTextureSize(64, 32);
        Table1.mirror = true;
        setRotation(Table1, 0.0872665F, 0F, 0F);
    }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Foot1.render(f5);
    Foot2.render(f5);
    Pillar1.render(f5);
    Table1.render(f5);
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
  public void renderModel (float f1)
	{
		Foot1.render(f1);
		Foot2.render(f1);
		Pillar1.render(f1);
		Table1.render(f1);
	}

}
