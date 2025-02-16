// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class bacillus<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "bacillus"), "main");
	private final ModelPart root;
	private final ModelPart tails;
	private final ModelPart top;
	private final ModelPart bottom;
	private final ModelPart right;
	private final ModelPart front;
	private final ModelPart but;
	private final ModelPart left;

	public bacillus(ModelPart root) {
		this.root = root.getChild("root");
		this.tails = this.root.getChild("tails");
		this.top = this.tails.getChild("top");
		this.bottom = this.tails.getChild("bottom");
		this.right = this.tails.getChild("right");
		this.front = this.tails.getChild("front");
		this.but = this.tails.getChild("but");
		this.left = this.tails.getChild("left");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(-14, -12).addBox(-3.0F, -5.0F, -7.0F, 6.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition tails = root.addOrReplaceChild("tails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition top = tails.addOrReplaceChild("top", CubeListBuilder.create().texOffs(-1, 1).addBox(-6.0F, -3.0F, -18.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-3.0F, -3.0F, -18.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-3.0F, -3.0F, -15.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-6.0F, -3.0F, -15.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-6.0F, -3.0F, -13.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-3.0F, -3.0F, -12.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-6.0F, -3.0F, -10.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-3.0F, -3.0F, -10.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-6.0F, -3.0F, -7.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-3.0F, -3.0F, -7.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -5.0F, 12.0F));

		PartDefinition bottom = tails.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(-1, 1).addBox(-3.0F, -3.0F, 4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-6.0F, -3.0F, 4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-3.0F, -3.0F, 1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-6.0F, -3.0F, 1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-6.0F, -3.0F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-3.0F, -3.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-6.0F, -3.0F, -4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-6.0F, -3.0F, -7.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-3.0F, -3.0F, -4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-3.0F, -3.0F, -7.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 3.0F, 1.0F));

		PartDefinition right = tails.addOrReplaceChild("right", CubeListBuilder.create().texOffs(-3, 1).addBox(-5.0F, 3.0F, -7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 3.0F, 4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 3.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 3.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 0.0F, 4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 0.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 0.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 0.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 0.0F, -7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -4.0F, 1.0F));

		PartDefinition front = tails.addOrReplaceChild("front", CubeListBuilder.create().texOffs(-2, -1).addBox(-2.0F, -3.0F, -9.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -1).addBox(1.0F, -3.0F, -9.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -1).addBox(1.0F, 0.0F, -9.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -1).addBox(-2.0F, 0.0F, -9.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -1.0F));

		PartDefinition but = tails.addOrReplaceChild("but", CubeListBuilder.create().texOffs(-2, -1).addBox(-2.0F, -3.0F, -27.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -1).addBox(-5.0F, -3.0F, -27.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -1).addBox(-5.0F, 0.0F, -27.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -1).addBox(-2.0F, 0.0F, -27.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -1.0F, 34.0F));

		PartDefinition left = tails.addOrReplaceChild("left", CubeListBuilder.create().texOffs(-3, 1).addBox(-5.0F, 3.0F, 4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 0.0F, 4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 3.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 0.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 3.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 0.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 0.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 3.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 3.0F, -7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-3, 1).addBox(-5.0F, 0.0F, -7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -4.0F, 1.0F));

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