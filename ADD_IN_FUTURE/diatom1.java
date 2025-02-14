// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class diatom1<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "diatom1"), "main");
	private final ModelPart root;
	private final ModelPart root2;

	public diatom1(ModelPart root) {
		this.root = root.getChild("root");
		this.root2 = root.getChild("root2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(2, 14).addBox(-16.0F, -2.0F, -7.0F, 3.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = root.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(2, 5).addBox(-6.0F, -2.0F, -7.0F, 3.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, -0.3F, -2.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition root2 = partdefinition.addOrReplaceChild("root2", CubeListBuilder.create().texOffs(2, 18).addBox(-16.0F, -2.0F, -7.0F, 3.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(15.0F, 24.0F, 0.0F));

		PartDefinition cube_r2 = root2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(1, 17).addBox(-6.0F, -2.0F, -7.0F, 3.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.1F, -0.2F, -2.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r3 = root2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(2, 15).addBox(-6.0F, -2.0F, -7.0F, 3.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 0.3F, -2.0F, 0.0F, 3.1416F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		root2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}