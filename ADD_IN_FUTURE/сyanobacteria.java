// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class сyanobacteria<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "сyanobacteria"), "main");
	private final ModelPart root;

	public сyanobacteria(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -11.0F, -6.0F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = root.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -4.0F, -4.0F, 13.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-7.0F, -3.0F, -3.0F, 15.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 6).addBox(-8.0F, -2.0F, -2.0F, 17.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r2 = root.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(3, 6).addBox(-8.0F, -2.0F, -2.0F, 17.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(-7.0F, -3.0F, -3.0F, 15.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(1, 2).addBox(-6.0F, -4.0F, -4.0F, 13.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, 1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}