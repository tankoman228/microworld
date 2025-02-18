package tank.mods.microworld.entity.ciliates.shoe;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import tank.mods.microworld.entity.Microorganism;

public class ShoeModel <T extends Entity> extends HierarchicalModel<T> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "shoe"), "main");
	private final ModelPart root;
	private final ModelPart organs;
	private final ModelPart jimjim_vacuole;
	private final ModelPart bone1;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone5;
	private final ModelPart nucleus;
	private final ModelPart nucleus2;
	private final ModelPart other_decorations;
	private final ModelPart body;

	public ShoeModel(ModelPart root) {
        
		this.root = root.getChild("root");
		this.organs = this.root.getChild("organs");
		this.jimjim_vacuole = this.organs.getChild("jimjim_vacuole");
		this.bone1 = this.jimjim_vacuole.getChild("bone1");
		this.bone2 = this.jimjim_vacuole.getChild("bone2");
		this.bone3 = this.jimjim_vacuole.getChild("bone3");
		this.bone4 = this.jimjim_vacuole.getChild("bone4");
		this.bone5 = this.jimjim_vacuole.getChild("bone5");
		this.nucleus = this.organs.getChild("nucleus");
		this.nucleus2 = this.organs.getChild("nucleus2");
		this.other_decorations = this.organs.getChild("other_decorations");
		this.body = this.root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(-2.0F, 24.0F, 7.0F));

		PartDefinition organs = root.addOrReplaceChild("organs", CubeListBuilder.create(), PartPose.offset(1.0F, -1.0F, -6.0F));

		PartDefinition jimjim_vacuole = organs.addOrReplaceChild("jimjim_vacuole", CubeListBuilder.create(), PartPose.offset(-1.5F, -1.0F, 7.0F));

		PartDefinition bone1 = jimjim_vacuole.addOrReplaceChild("bone1", CubeListBuilder.create().texOffs(58, 61).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 1.0F));

		PartDefinition bone2 = jimjim_vacuole.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(58, 61).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition bone3 = jimjim_vacuole.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(58, 61).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 2.0F));

		PartDefinition bone4 = jimjim_vacuole.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(58, 61).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition bone5 = jimjim_vacuole.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(58, 61).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition nucleus = organs.addOrReplaceChild("nucleus", CubeListBuilder.create().texOffs(57, 60).addBox(0.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(59, 61).addBox(0.5F, -2.5F, 0.6F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(57, 59).addBox(0.5F, -1.5F, -0.4F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(58, 61).addBox(-0.5F, -1.5F, 0.6F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -0.1F, 2.0F));

		PartDefinition nucleus2 = organs.addOrReplaceChild("nucleus2", CubeListBuilder.create().texOffs(57, 60).addBox(0.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(59, 61).addBox(0.5F, -2.5F, 0.6F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(57, 59).addBox(0.5F, -1.5F, -0.4F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(58, 61).addBox(-0.5F, -1.5F, 0.6F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.3F, 0.9F, -12.5F));

		PartDefinition other_decorations = organs.addOrReplaceChild("other_decorations", CubeListBuilder.create().texOffs(55, 60).addBox(5.0F, 1.0F, -6.7F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(55, 60).addBox(5.6F, 0.7F, 4.2F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(55, 60).addBox(0.0F, -1.4F, -10.7F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 60).addBox(-1.0F, 2.6F, -6.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 60).addBox(-1.0F, 1.6F, 0.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 58).addBox(3.9F, 0.6F, 0.3F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(54, 58).addBox(0.9F, 2.9F, -1.7F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -1.0F, 7.0F));

		PartDefinition cube_r1 = other_decorations.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(56, 60).addBox(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 5.0F, -14.7F, 0.0F, 0.0F, 0.2182F));

		PartDefinition cube_r2 = other_decorations.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(54, 59).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -16.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 6).addBox(-2.0F, 0.0F, 13.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, -1).addBox(-3.0F, 0.3F, -2.0F, 6.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -2).addBox(-2.7F, -1.9F, -3.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(1, 1).addBox(-4.0F, -1.2F, -8.8F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -1.0F, -9.0F, 2.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(-1, -1).addBox(-4.0F, -1.0F, -14.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(11, 13).addBox(-4.0F, -1.2F, -16.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 12).addBox(-3.0F, -1.0F, -16.7F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(16, 14).addBox(-3.0F, 0.0F, 12.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 3).addBox(-4.0F, -1.0F, 6.0F, 10.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, -2.0F, 0.9F, 4.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(1, 2).addBox(-2.0F, -2.8F, 1.0F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(2, 3).addBox(1.0F, -1.5F, 2.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, -6.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-3, 0).addBox(-2.0F, -2.0F, 2.0F, 4.0F, 2.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 1.6F, -16.0F, 0.0F, 0.2182F, 0.0F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(16, 13).addBox(1.0F, -1.0F, 12.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, 2.0F, -10.5F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(2, 2).addBox(1.0F, -2.0F, 3.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 1.3F, -16.0F, 0.0F, 0.0873F, 0.0F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(19, 3).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.9F, -14.0F, 0.0F, 0.1309F, 0.0F));

		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(28, 3).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -6.0F, 0.0F, 0.1309F, 0.0F));

		PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(7, 4).addBox(-1.0F, -1.0F, -3.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, 0.2F, -4.0F, 0.0F, 0.1309F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        
        this.root().getAllParts().forEach(ModelPart::resetPose);
        var shoe = (ShoeEntity) entity;
        
        animate(shoe.animationState, ShoeAnimations.ANIMATION, ageInTicks, 1f);

        root().xRot = shoe.rotationXRad;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

    @Override
    public ModelPart root() {
        return root;
    }
}
