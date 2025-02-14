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

public class DiatomModel3<T extends Entity> extends EntityModel<T> {
	
	private final ModelPart bone;

	public DiatomModel3(ModelPart root) {
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
