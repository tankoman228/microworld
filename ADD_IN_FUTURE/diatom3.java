// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class diatom3<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "diatom3"), "main");
	private final ModelPart bone;

	public diatom3(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(20, 55).addBox(-6.0F, -4.0F, -2.0F, 11.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(15, 14).addBox(-5.0F, -3.0F, -6.0F, 9.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(31, 42).addBox(-5.0F, -3.0F, 2.0F, 9.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 11).addBox(-4.0F, -3.0F, -11.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(25, 19).addBox(-4.0F, -3.0F, 6.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(23, 55).addBox(-3.0F, -2.0F, -19.0F, 5.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(17, 55).addBox(-3.0F, -3.0F, 11.0F, 5.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}