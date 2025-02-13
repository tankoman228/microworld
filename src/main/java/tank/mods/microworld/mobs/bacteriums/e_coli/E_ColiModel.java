package tank.mods.microworld.mobs.bacteriums.e_coli;

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

public class E_ColiModel<T extends Entity> extends HierarchicalModel<T> {
	
	private final ModelPart central;
	private final ModelPart bone1;
	private final ModelPart bone2;

	public E_ColiModel(ModelPart root) {
		this.central = root.getChild("central");
		this.bone1 = this.central.getChild("bone1");
		this.bone2 = this.central.getChild("bone2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Central = partdefinition.addOrReplaceChild("central", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bone1 = Central.addOrReplaceChild("bone1", CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone2 = Central.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		central.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		// TODO Auto-generated method stub
		return central;
	}
}
