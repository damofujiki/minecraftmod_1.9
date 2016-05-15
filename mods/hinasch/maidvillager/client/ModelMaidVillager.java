package mods.hinasch.maidvillager.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelMaidVillager extends ModelBase{

    /** The head box of the VillagerModel */
    public ModelRenderer villagerHead;
    public ModelRenderer villagerHeadwear;
    public ModelRenderer villagerBody;
    public ModelRenderer villagerRightArm;
    public ModelRenderer villagerLeftArm;
    public ModelRenderer villagerRightLeg;
    public ModelRenderer villagerLeftLeg;
    public ModelRenderer Skirt;
	public ModelRenderer ChignonR;
	public ModelRenderer ChignonL;
	public ModelRenderer ChignonB;
	public ModelRenderer Tail;
	public ModelRenderer SideTailR;
	public ModelRenderer SideTailL;

	public ModelMaidVillager(){
		this(0.0F);
	}

	public ModelMaidVillager(float f){
//		this(f, 0.0F, 64, 64);	// �f�t�H���l
		this(f, 0.0F, 64, 32);	// ���C�h(�e�N�X�`���T�C�Y?)
	}

	// ���f������
    public ModelMaidVillager(float f, float f1, int f2, int f3)
    {
        this.villagerHead = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.villagerHead.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        this.villagerHead.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);

        this.villagerHeadwear = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.villagerHeadwear.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        this.villagerHeadwear.setTextureOffset(24, 0).addBox(-4.0F, 0.0F, 1.0F, 8, 4, 3, f);

        this.villagerBody = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.villagerBody.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        this.villagerBody.setTextureOffset(32, 8).addBox(-3.0F, 0.0F, -2.0F, 6, 7, 4, f);

        this.villagerRightArm = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.villagerRightArm.setRotationPoint(-3.0F, 10F + f1, 0.0F);
        this.villagerRightArm.setTextureOffset(48, 0).addBox(-2.0F, -1.0F, -1.0F, 2, 8, 2, f);

        this.villagerLeftArm = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.villagerLeftArm.setRotationPoint(3.0F, 10F + f1, 0.0F);
        this.villagerLeftArm.setTextureOffset(56, 0).addBox(0.0F, -1.0F, -1.0F, 2, 8, 2, f);

        this.villagerRightLeg = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.villagerRightLeg.setRotationPoint(-1.0F, 7.0F + f1, 0.0F);
        this.villagerRightLeg.setTextureOffset(32, 19).addBox(-2.0F, -0.0F, -2.0F, 3, 9, 4, f);

        this.villagerLeftLeg = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.villagerLeftLeg.setRotationPoint(1.0F, 7.0F + f1, 0.0F);
        this.villagerLeftLeg.setTextureOffset(32, 19).addBox(-1.0F, -0.0F, -2.0F, 3, 9, 4, f);

        this.Skirt = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.Skirt.setRotationPoint(0.0F, 7.0F + f1, 0.0F);
        this.Skirt.setTextureOffset(0, 16).addBox(-4.0F, -2.0F, -4.0F, 8, 8, 8, f);

        this.ChignonR = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.ChignonR.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        this.ChignonR.setTextureOffset(24, 18).addBox(-5.0F, -7.0F, -0.2F, 1, 3, 3, f);

        this.ChignonL = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.ChignonL.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        this.ChignonL.setTextureOffset(24, 18).addBox(4.0F, -7.0F, 0.2F, 1, 3, 3, f);

        this.ChignonB = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.ChignonB.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        this.ChignonB.setTextureOffset(52, 10).addBox(-2.0F, -7.2F, 4.0F, 4, 4, 2, f);

        this.Tail = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.Tail.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        this.Tail.setTextureOffset(46, 20).addBox(-1.5F, -6.8F, 4.0F, 3, 9, 3, f);

        this.SideTailR = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.SideTailR.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        this.SideTailR.setTextureOffset(58, 21).addBox(-5.5F, -6.8F, 0.9F, 1, 8, 2, f);

        this.SideTailL = (new ModelRenderer(this)).setTextureSize(f2, f3);
        this.SideTailL.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
        this.SideTailL.setTextureOffset(58, 21).addBox(4.5F, -6.8F, 0.9F, 1, 8, 2, f);

	}

    // �`��
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.villagerHead.render(f5);
        this.villagerHeadwear.render(f5);
        this.villagerBody.render(f5);
        this.villagerRightArm.render(f5);
        this.villagerLeftArm.render(f5);
        this.villagerRightLeg.render(f5);
        this.villagerLeftLeg.render(f5);
        this.Skirt.render(f5);
        this.ChignonR.render(f5);
        this.ChignonL.render(f5);
        this.ChignonB.render(f5);
        this.Tail.render(f5);
        this.SideTailR.render(f5);
        this.SideTailL.render(f5);
    }

	// ����
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        this.villagerHead.rotateAngleY = f3 / 57.29578F;
        this.villagerHead.rotateAngleX = f4 / 57.29578F;
        this.villagerHeadwear.rotateAngleY = villagerHead.rotateAngleY;
        this.villagerHeadwear.rotateAngleX = villagerHead.rotateAngleX;

        this.villagerRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F;
        this.villagerLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.villagerRightArm.rotateAngleZ = 0.0F;
        this.villagerLeftArm.rotateAngleZ = 0.0F;

        this.villagerRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.villagerLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        this.villagerRightLeg.rotateAngleY = 0.0F;
        this.villagerLeftLeg.rotateAngleY = 0.0F;

        // ���Ɣ���ڑ�
        parentModel(villagerHeadwear);
        parentModel(ChignonR);
        parentModel(ChignonL);
        parentModel(ChignonB);
        parentModel(Tail);
        parentModel(SideTailR);
        parentModel(SideTailL);

    	// �ʏ헧��
        villagerBody.rotateAngleX = 0.0F;
        villagerBody.rotationPointY = 8.0F;
        villagerRightLeg.rotationPointZ = 0.0F;
        villagerLeftLeg.rotationPointZ = 0.0F;
        villagerRightLeg.rotationPointY = 7F + 8F;
        villagerLeftLeg.rotationPointY = 7F + 8F;
        villagerHead.rotationPointY = 0.0F + 8F;
        villagerHeadwear.rotationPointY = 0.0F + 8F;
        Skirt.rotationPointY = 15.0F;
        Skirt.rotationPointZ = 0.0F;
        Skirt.rotateAngleX = 0.0F;

		// �ʏ�
        villagerRightArm.rotateAngleZ += 0.5F;
        villagerLeftArm.rotateAngleZ -= 0.5F;
        villagerRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        villagerLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        villagerRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
        villagerLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
    }

    //�@���Ɣ���ڑ�
    private void parentModel(ModelRenderer Model){
    	Model.rotationPointX = villagerHead.rotationPointX;
    	Model.rotationPointY = villagerHead.rotationPointY;
    	Model.rotationPointZ = villagerHead.rotationPointZ;
    	Model.rotateAngleX = villagerHead.rotateAngleX;
    	Model.rotateAngleY = villagerHead.rotateAngleY;
    	Model.rotateAngleZ = villagerHead.rotateAngleZ;
    }

}
