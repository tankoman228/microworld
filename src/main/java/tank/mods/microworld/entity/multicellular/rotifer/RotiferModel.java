package tank.mods.microworld.entity.multicellular.rotifer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

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
import tank.mods.microworld.entity.multicellular.worm.WormAnimations;
import tank.mods.microworld.entity.multicellular.worm.WormEntity;

public class RotiferModel <T extends Entity> extends HierarchicalModel<T>  {

	private final ModelPart root;
	private final ModelPart central_body;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone5;
	private final ModelPart bone6;
	private final ModelPart bone7;
	private final ModelPart bone8;
	private final ModelPart bone9;
	private final ModelPart central_body2;
	private final ModelPart bone18;
	private final ModelPart bone19;
	private final ModelPart bone20;
	private final ModelPart bone21;
	private final ModelPart bone22;
	private final ModelPart bone23;
	private final ModelPart bone24;
	private final ModelPart central_body3;
	private final ModelPart bone10;
	private final ModelPart bone11;
	private final ModelPart bone12;
	private final ModelPart bone13;
	private final ModelPart bone14;
	private final ModelPart bone15;
	private final ModelPart bone16;
	private final ModelPart bone17;
	private final ModelPart mouth;
	private final ModelPart bone25;
	private final ModelPart bone26;
	private final ModelPart bone28;
	private final ModelPart bone29;
	private final ModelPart bone30;
	private final ModelPart tail;
	private final ModelPart bone31;
	private final ModelPart bone32;

	public RotiferModel(ModelPart root) {
		this.root = root.getChild("root");
		this.central_body = this.root.getChild("central_body");
		this.bone2 = this.central_body.getChild("bone2");
		this.bone3 = this.central_body.getChild("bone3");
		this.bone4 = this.central_body.getChild("bone4");
		this.bone5 = this.central_body.getChild("bone5");
		this.bone6 = this.central_body.getChild("bone6");
		this.bone7 = this.central_body.getChild("bone7");
		this.bone8 = this.central_body.getChild("bone8");
		this.bone9 = this.central_body.getChild("bone9");
		this.central_body2 = this.root.getChild("central_body2");
		this.bone18 = this.central_body2.getChild("bone18");
		this.bone19 = this.central_body2.getChild("bone19");
		this.bone20 = this.central_body2.getChild("bone20");
		this.bone21 = this.central_body2.getChild("bone21");
		this.bone22 = this.central_body2.getChild("bone22");
		this.bone23 = this.central_body2.getChild("bone23");
		this.bone24 = this.central_body2.getChild("bone24");
		this.central_body3 = this.root.getChild("central_body3");
		this.bone10 = this.central_body3.getChild("bone10");
		this.bone11 = this.central_body3.getChild("bone11");
		this.bone12 = this.central_body3.getChild("bone12");
		this.bone13 = this.central_body3.getChild("bone13");
		this.bone14 = this.central_body3.getChild("bone14");
		this.bone15 = this.central_body3.getChild("bone15");
		this.bone16 = this.central_body3.getChild("bone16");
		this.bone17 = this.central_body3.getChild("bone17");
		this.mouth = this.root.getChild("mouth");
		this.bone25 = this.mouth.getChild("bone25");
		this.bone26 = this.mouth.getChild("bone26");
		this.bone28 = this.mouth.getChild("bone28");
		this.bone29 = this.mouth.getChild("bone29");
		this.bone30 = this.mouth.getChild("bone30");
		this.tail = this.root.getChild("tail");
		this.bone31 = this.tail.getChild("bone31");
		this.bone32 = this.tail.getChild("bone32");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 5.0F));

		PartDefinition central_body = root.addOrReplaceChild("central_body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 13.0F));

		PartDefinition bone2 = central_body.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(-4, -1).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition bone3 = central_body.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(2, 13).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

		PartDefinition bone4 = central_body.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(12, 12).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -12.0F));

		PartDefinition bone5 = central_body.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(22, 52).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -20.0F));

		PartDefinition bone6 = central_body.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(4, 9).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -16.0F));

		PartDefinition bone7 = central_body.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(-1, 1).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

		PartDefinition bone8 = central_body.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(-4, 0).addBox(-5.0F, -1.0F, -2.0F, 10.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition bone9 = central_body.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(0, 1).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition central_body2 = root.addOrReplaceChild("central_body2", CubeListBuilder.create(), PartPose.offset(0.5F, 1.0F, 12.6F));

		PartDefinition bone18 = central_body2.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(-4, -1).addBox(-4.0F, -3.0F, -2.0F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition bone19 = central_body2.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(2, 13).addBox(-4.0F, -3.0F, -3.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

		PartDefinition bone20 = central_body2.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(12, 12).addBox(-3.0F, -3.0F, -3.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -12.0F));

		PartDefinition bone21 = central_body2.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(22, 52).addBox(-3.0F, -3.0F, -3.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -20.0F));

		PartDefinition bone22 = central_body2.addOrReplaceChild("bone22", CubeListBuilder.create().texOffs(4, 9).addBox(-2.0F, -3.0F, -3.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -16.0F));

		PartDefinition bone23 = central_body2.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(-1, 1).addBox(-3.0F, -3.0F, -1.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

		PartDefinition bone24 = central_body2.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(-4, 0).addBox(-5.0F, -3.0F, -2.0F, 9.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition central_body3 = root.addOrReplaceChild("central_body3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.3F, 13.0F));

		PartDefinition bone10 = central_body3.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(10, 5).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition bone11 = central_body3.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(8, 3).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -6.0F));

		PartDefinition bone12 = central_body3.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(16, 19).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

		PartDefinition bone13 = central_body3.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(26, 18).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -12.0F));

		PartDefinition bone14 = central_body3.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(36, 58).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -20.0F));

		PartDefinition bone15 = central_body3.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(3, 0).addBox(-1.0F, -4.0F, -5.0F, 2.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -16.0F));

		PartDefinition bone16 = central_body3.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(13, 7).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

		PartDefinition bone17 = central_body3.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(10, 6).addBox(-4.0F, -3.0F, -2.0F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition mouth = root.addOrReplaceChild("mouth", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -10.0F));

		PartDefinition bone25 = mouth.addOrReplaceChild("bone25", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, -0.1F));

		PartDefinition cube_r1 = bone25.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 22).mirror().addBox(1.0F, -1.0F, -4.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r2 = bone25.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(57, 59).mirror().addBox(1.0F, -1.4F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.9F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bone26 = mouth.addOrReplaceChild("bone26", CubeListBuilder.create(), PartPose.offset(0.0F, 0.5F, -0.1F));

		PartDefinition cube_r3 = bone26.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(32, 22).mirror().addBox(1.0F, -1.0F, -4.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r4 = bone26.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(57, 59).mirror().addBox(1.0F, -1.4F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.9F, -1.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition bone28 = mouth.addOrReplaceChild("bone28", CubeListBuilder.create().texOffs(50, 53).mirror().addBox(0.0F, -1.4F, -5.1F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(32, 22).mirror().addBox(0.0F, -1.0F, -5.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -0.5F, -0.1F));

		PartDefinition bone29 = mouth.addOrReplaceChild("bone29", CubeListBuilder.create().texOffs(57, 59).addBox(-1.0F, -1.4F, -5.2F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 22).addBox(-1.0F, -1.0F, -5.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -0.5F, -0.1F));

		PartDefinition bone30 = mouth.addOrReplaceChild("bone30", CubeListBuilder.create().texOffs(36, 26).addBox(-1.0F, -0.5F, 0.7F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.6F, -2.5F));

		PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone31 = tail.addOrReplaceChild("bone31", CubeListBuilder.create().texOffs(-3, -4).addBox(0.3F, -1.0F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 12.0F));

		PartDefinition bone32 = tail.addOrReplaceChild("bone32", CubeListBuilder.create().texOffs(-3, -4).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.3F, 0.0F, 12.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity_, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

         var entity = (RotiferEntity) entity_;
         animate(entity.swim, RotiferAnimations.SWIM, ageInTicks, 1f);
         animate(entity.eat, RotiferAnimations.EAT, ageInTicks, 1f);
         animate(entity.left_flex, RotiferAnimations.LEFT_FLEX, ageInTicks, 1f);
         animate(entity.right_flex, RotiferAnimations.RIGHT_FLEX, ageInTicks, 1f);
         animate(entity.flex, RotiferAnimations.FLEX, ageInTicks, 1f);
         animate(entity.rotate, RotiferAnimations.ROTATE, ageInTicks, 1f);
         animate(entity.antiflex, RotiferAnimations.ANTIFLEX, ageInTicks, 1f);
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
