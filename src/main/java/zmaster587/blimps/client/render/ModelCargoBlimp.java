// Date: 1/15/2014 3:35:25 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX


package zmaster587.blimps.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelCargoBlimp extends ModelBlimpBase
{

	protected final IModelCustom modelBlimp = AdvancedModelLoader.loadModel(new ResourceLocation("blimps:models/cargoBlimp.obj"));
	private static final ResourceLocation texture = new ResourceLocation("blimps:textures/entity/CargoBlimp.png");
	//fields
	ModelRenderer propHuba;
	ModelRenderer prop1a;
	ModelRenderer prop2a;
	ModelRenderer prop3a;
	ModelRenderer propHubb;
	ModelRenderer prop1b;
	ModelRenderer prop2b;
	ModelRenderer prop3b;

	public ModelCargoBlimp()
	{
		textureWidth = 128;
		textureHeight = 128;

      propHuba = new ModelRenderer(this, 30, 18);
      propHuba.addBox(-0.5F, -0.5F, 0F, 1, 1, 2);
      propHuba.setRotationPoint(24F, -6.5F, 80F);
      propHuba.setTextureSize(128, 128);
      propHuba.mirror = true;
      setRotation(propHuba, 0F, 0F, 0F);

      prop1a = new ModelRenderer(this, 0, 18);
      prop1a.addBox(0F, -0.5F, 0F, 14, 1, 1);
      prop1a.setRotationPoint(24F, -6.5F, 81F);
      prop1a.setTextureSize(128, 128);
      prop1a.mirror = true;
      setRotation(prop1a, 0F, 0F, 0.5235988F);

      prop2a = new ModelRenderer(this, 0, 18);
      prop2a.addBox(0F, -0.5F, 0F, 14, 1, 1);
      prop2a.setRotationPoint(24F, -6.5F, 81F);
      prop2a.setTextureSize(128, 128);
      prop2a.mirror = true;
      setRotation(prop2a, 0F, 0F, 2.617994F);

      prop3a = new ModelRenderer(this, 0, 18);
      prop3a.addBox(0F, -0.5F, 0F, 14, 1, 1);
      prop3a.setRotationPoint(24F, -6.5F, 81F);
      prop3a.setTextureSize(128, 128);
      prop3a.mirror = true;
      setRotation(prop3a, 0F, 0F, -1.570796F);
      
      propHubb = new ModelRenderer(this, 30, 18);
      propHubb.addBox(-0.5F, -0.5F, 0F, 1, 1, 2);
      propHubb.setRotationPoint(-24F, -6.5F, 80F);
      propHubb.setTextureSize(128, 128);
      propHubb.mirror = true;
      setRotation(propHubb, 0F, 0F, 0F);

      prop1b = new ModelRenderer(this, 0, 18);
      prop1b.addBox(0F, -0.5F, 0F, 14, 1, 1);
      prop1b.setRotationPoint(-24F, -6.5F, 81F);
      prop1b.setTextureSize(128, 128);
      prop1b.mirror = true;
      setRotation(prop1b, 0F, 0F, 0.5235988F);

      prop2b = new ModelRenderer(this, 0, 18);
      prop2b.addBox(0F, -0.5F, 0F, 14, 1, 1);
      prop2b.setRotationPoint(-24F, -6.5F, 81F);
      prop2b.setTextureSize(128, 128);
      prop2b.mirror = true;
      setRotation(prop2a, 0F, 0F, 2.617994F);

      prop3b = new ModelRenderer(this, 0, 18);
      prop3b.addBox(0F, -0.5F, 0F, 14, 1, 1);
      prop3b.setRotationPoint(-24F, -6.5F, 81F);
      prop3b.setTextureSize(128, 128);
      prop3b.mirror = true;
      setRotation(prop3b, 0F, 0F, -1.570796F);

	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		
		setRotationAngles(f, f1, f2, f3, f4, f5,entity);

		propHuba.render(f5);
		prop1a.render(f5);
		prop2a.render(f5);
		prop3a.render(f5);
		propHubb.render(f5);
		prop1b.render(f5);
		prop2b.render(f5);
		prop3b.render(f5);
		modelBlimp.renderAll();
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
	{
		f *= 3;
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);

		setRotation(prop1a, prop1a.rotateAngleX, prop1a.rotateAngleY, f - 1.570796F);
		setRotation(prop2a, prop2a.rotateAngleX, prop2a.rotateAngleY, f + 2.617994F);
		setRotation(prop3a, prop3a.rotateAngleX, prop3a.rotateAngleY, f + 0.5235988F);
		setRotation(propHuba, propHuba.rotateAngleX, propHuba.rotateAngleY, f);
		
		setRotation(prop1b, prop1b.rotateAngleX, prop1b.rotateAngleY, -f - 1.570796F);
		setRotation(prop2b, prop2b.rotateAngleX, prop2b.rotateAngleY, -f + 2.617994F);
		setRotation(prop3b, prop3b.rotateAngleX, prop3b.rotateAngleY, -f + 0.5235988F);
		setRotation(propHubb, propHubb.rotateAngleX, propHubb.rotateAngleY, -f);
	}

	@Override
	public ResourceLocation getTexture() {
		return texture;
	}
}
