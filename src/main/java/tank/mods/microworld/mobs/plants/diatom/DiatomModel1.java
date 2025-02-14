package tank.mods.microworld.mobs.plants.diatom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
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

public class DiatomModel1<T extends Entity> extends EntityModel<T> {

	private final ModelPart root;
	private final ModelPart root2;

	public DiatomModel1(ModelPart root) {
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
