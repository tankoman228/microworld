package tank.mods.microworld.entity.ciliates.paramecium_x;

import java.util.Random;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import tank.mods.microworld.entity.ciliates.shoe.ShoeAnimations;
import tank.mods.microworld.entity.ciliates.shoe.ShoeEntity;
import net.minecraft.client.model.geom.builders.CubeDeformation;

public class ParameciumXModel<T extends ParameciumXEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "paramecium_x"), "main");
	
    private final ModelPart root;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone5;

	public ParameciumXModel(ModelPart root) {
		this.root = root.getChild("root");
		this.bone = this.root.getChild("bone");
		this.bone2 = this.root.getChild("bone2");
		this.bone3 = this.root.getChild("bone3");
		this.bone4 = this.root.getChild("bone4");
		this.bone5 = this.root.getChild("bone5");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 1.0F));

		PartDefinition bone = root.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(2, 20).addBox(-2.0F, -4.0F, -9.0F, 5.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition bone2 = root.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(2, 33).addBox(-1.0F, -4.0F, -9.0F, 3.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone3 = root.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(2, 5).addBox(-1.0F, -3.0F, -10.0F, 3.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone4 = root.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bone4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 33).addBox(0.0F, -4.0F, -10.0F, 3.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.75F, -5.0F, 0.0F, 2.4871F, 0.0F));

		PartDefinition bone5 = root.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -1.0F));

		PartDefinition cube_r2 = bone5.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 5).addBox(0.0F, -4.0F, -10.0F, 3.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.75F, -2.0F, 2.7053F, -0.3927F, 3.1416F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(ParameciumXEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.getAllParts().forEach(ModelPart::resetPose);
        var p = (ParameciumXEntity) entity;
        
        animate(p.animationState, ParameciumXAnimations.ANIMATION, ageInTicks, 1f);
		root().xRot = entity.xRotAdd * ((float) Math.PI / 180F); // Преобразуем в радианы для рендера	
	}
    
    
    float r = 1, g = 1, b = 1;
    Random random = new Random();

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        
        r += (random.nextDouble() - 0.5) * 0.02; 
        g += (random.nextDouble() - 0.5) * 0.03; 
        b += (random.nextDouble() - 0.5) * 0.04;  

        if (r > 1) r = 1;
        if (g > 1) g = 1;
        if (b > 1) b = 1;

        if (r < 0) r = 0;
        if (g < 0) g = 0;
        if (b < 0) b = 0;

        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, 
        
        red * r, 
        green * g, 
        blue * b, 

        alpha
        
        );
	}

    @Override
    public ModelPart root() {
        return this.root;
    }
}