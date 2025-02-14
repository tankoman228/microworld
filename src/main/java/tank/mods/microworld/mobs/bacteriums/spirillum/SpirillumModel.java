package tank.mods.microworld.mobs.bacteriums.spirillum;

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
import tank.mods.microworld.mobs.bacteriums.e_coli.E_ColiAnimations;
import tank.mods.microworld.mobs.bacteriums.e_coli.E_ColiEntity;

public class SpirillumModel<T extends Entity> extends HierarchicalModel<T>  {

	private final ModelPart root;
	private final ModelPart bone1;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone5;
	private final ModelPart bone6;
	private final ModelPart bone7;
	private final ModelPart bone8;
	private final ModelPart bone9;
	private final ModelPart bone10;
	private final ModelPart bone11;
	private final ModelPart bone12;
	private final ModelPart bone13;
	private final ModelPart bone14;
	private final ModelPart bone15;

	public SpirillumModel(ModelPart root) {
		this.root = root.getChild("root");
		this.bone1 = this.root.getChild("bone1");
		this.bone2 = this.root.getChild("bone2");
		this.bone3 = this.root.getChild("bone3");
		this.bone4 = this.root.getChild("bone4");
		this.bone5 = this.root.getChild("bone5");
		this.bone6 = this.root.getChild("bone6");
		this.bone7 = this.root.getChild("bone7");
		this.bone8 = this.root.getChild("bone8");
		this.bone9 = this.root.getChild("bone9");
		this.bone10 = this.root.getChild("bone10");
		this.bone11 = this.root.getChild("bone11");
		this.bone12 = this.root.getChild("bone12");
		this.bone13 = this.root.getChild("bone13");
		this.bone14 = this.root.getChild("bone14");
		this.bone15 = this.root.getChild("bone15");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -6.0F));

		PartDefinition bone1 = root.addOrReplaceChild("bone1", CubeListBuilder.create().texOffs(2, 2).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone2 = root.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(2, 2).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 1.0F));

		PartDefinition bone3 = root.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(6, 5).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -2.0F, 2.0F));

		PartDefinition bone4 = root.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(7, 9).addBox(-4.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition bone5 = root.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(5, 5).addBox(-3.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition bone6 = root.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(5, 2).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 5.0F));

		PartDefinition bone7 = root.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(5, 2).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition bone8 = root.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(3, 2).addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 7.0F));

		PartDefinition bone9 = root.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(7, 3).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition bone10 = root.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(6, 1).addBox(-2.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

		PartDefinition bone11 = root.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(7, 5).addBox(-2.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 10.0F));

		PartDefinition bone12 = root.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(5, 5).addBox(-2.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 11.0F));

		PartDefinition bone13 = root.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(2, 6).addBox(-2.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 1.0F, 12.0F));

		PartDefinition bone14 = root.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(7, 6).addBox(-4.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 13.0F));

		PartDefinition bone15 = root.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(7, 7).addBox(-3.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 14.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(Entity entity_, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		var entity = (SpirillumEntity) entity_;
		animate(entity.rotateAnimationState, SpirillumAnimations.LOOP, ageInTicks, 1f);
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
