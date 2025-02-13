// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class e_coli<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "e_coli"), "main");
	private final ModelPart Central;
	private final ModelPart bone1;
	private final ModelPart bone2;

	public e_coli(ModelPart root) {
		this.Central = root.getChild("Central");
		this.bone1 = this.Central.getChild("bone1");
		this.bone2 = this.Central.getChild("bone2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Central = partdefinition.addOrReplaceChild("Central", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bone1 = Central.addOrReplaceChild("bone1", CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone2 = Central.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Central.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}