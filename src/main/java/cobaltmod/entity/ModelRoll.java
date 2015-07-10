package cobaltmod.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRoll extends ModelBase
{
  //fields
    ModelRenderer tube1;
    ModelRenderer tube2;
    ModelRenderer tube3;
    ModelRenderer tube4;
    ModelRenderer tube5;
    ModelRenderer tube6;
    ModelRenderer tube7;
    ModelRenderer tube8;
    ModelRenderer paper1;
  
  public ModelRoll()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      tube1 = new ModelRenderer(this, 0, 0);
      tube1.addBox(0F, -1F, -0.5F, 5, 2, 1);
      tube1.setRotationPoint(0F, 22.5F, 4.5F);
      tube1.setTextureSize(64, 32);
      tube1.mirror = true;
      setRotation(tube1, 1.570796F, 0F, 0F);
      tube2 = new ModelRenderer(this, 0, 0);
      tube2.addBox(0F, -1F, -0.5F, 5, 2, 1);
      tube2.setRotationPoint(0F, 22.5F, 4.5F);
      tube2.setTextureSize(64, 32);
      tube2.mirror = true;
      setRotation(tube2, 0F, 0F, 0F);
      tube3 = new ModelRenderer(this, 0, 0);
      tube3.addBox(0F, -1F, -0.5F, 5, 2, 1);
      tube3.setRotationPoint(0F, 22.5F, 4.5F);
      tube3.setTextureSize(64, 32);
      tube3.mirror = true;
      setRotation(tube3, 0.7853982F, 0F, 0F);
      tube4 = new ModelRenderer(this, 0, 0);
      tube4.addBox(0F, -1F, -0.5F, 5, 2, 1);
      tube4.setRotationPoint(0F, 22.5F, 4.5F);
      tube4.setTextureSize(64, 32);
      tube4.mirror = true;
      setRotation(tube4, -0.7853982F, 0F, 0F);
      tube5 = new ModelRenderer(this, 0, 5);
      tube5.addBox(0F, -1F, -0.5F, 5, 2, 1);
      tube5.setRotationPoint(0F, 22.5F, 0.5F);
      tube5.setTextureSize(64, 32);
      tube5.mirror = true;
      setRotation(tube5, 0F, 0F, 0F);
      tube6 = new ModelRenderer(this, 0, 5);
      tube6.addBox(0F, -1F, -0.5F, 5, 2, 1);
      tube6.setRotationPoint(0F, 22.5F, 0.5F);
      tube6.setTextureSize(64, 32);
      tube6.mirror = true;
      setRotation(tube6, 1.570796F, 0F, 0F);
      tube7 = new ModelRenderer(this, 0, 5);
      tube7.addBox(0F, -1F, -0.5F, 5, 2, 1);
      tube7.setRotationPoint(0F, 22.5F, 0.5F);
      tube7.setTextureSize(64, 32);
      tube7.mirror = true;
      setRotation(tube7, 0.7853982F, 0F, 0F);
      tube8 = new ModelRenderer(this, 0, 5);
      tube8.addBox(0F, -1F, -0.5F, 5, 2, 1);
      tube8.setRotationPoint(0F, 22.5F, 0.5F);
      tube8.setTextureSize(64, 32);
      tube8.mirror = true;
      setRotation(tube8, -0.7853982F, 0F, 0F);
      paper1 = new ModelRenderer(this, 0, 9);
      paper1.addBox(0F, -1F, 0F, 5, 5, 0);
      paper1.setRotationPoint(0F, 23.5F, 1F);
      paper1.setTextureSize(64, 32);
      paper1.mirror = true;
      setRotation(paper1, 1.570796F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    tube1.render(f5);
    tube2.render(f5);
    tube3.render(f5);
    tube4.render(f5);
    tube5.render(f5);
    tube6.render(f5);
    tube7.render(f5);
    tube8.render(f5);
    paper1.render(f5);
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
