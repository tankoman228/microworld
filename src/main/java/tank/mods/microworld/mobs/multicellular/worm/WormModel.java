// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package tank.mods.microworld.mobs.multicellular.worm;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector3f;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
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
import net.minecraft.network.chat.ChatType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;


public class WormModel<T extends Entity> extends HierarchicalModel<T> {

    private final ModelPart worm;
	private final ModelPart bone1;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone5;
	private final ModelPart bone6;
	private final ModelPart bone7;
	private final ModelPart bone8;
	private final ModelPart bone9;

    public WormModel(ModelPart root) {
		this.worm = root.getChild("root");
        this.bone9 = worm.getChild("bone9");
        this.bone8 = worm.getChild("bone8");
        this.bone7 = worm.getChild("bone7");
        this.bone6 = worm.getChild("bone6");
        this.bone5 = worm.getChild("bone5");
        this.bone4 = worm.getChild("bone4");
        this.bone3 = worm.getChild("bone3");
        this.bone2 = worm.getChild("bone2");
        this.bone1 = worm.getChild("bone1");
    }

    public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(1.0F, 23.0F, -10.0F));
		PartDefinition bone1 = root.addOrReplaceChild("bone1", CubeListBuilder.create().texOffs(2, 5).addBox(-1.5F, -2.5F, -22.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 22.0F));
		PartDefinition bone2 = root.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 5).addBox(-3.5F, -4.5F, -18.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0F, 19.0F));
		PartDefinition bone3 = root.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 4).addBox(-4.0F, -5.0F, -13.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0F, 17.0F));
		PartDefinition bone4 = root.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 5).addBox(-3.5F, -4.5F, -6.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0F, 13.0F));
		PartDefinition bone5 = root.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(0, 4).addBox(-4.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0F, 11.0F));
		PartDefinition bone6 = root.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(0, 4).addBox(-3.5F, -4.5F, 6.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0F, 7.0F));
		PartDefinition bone7 = root.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(0, 3).addBox(-4.0F, -5.0F, 11.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0F, 5.0F));
		PartDefinition bone8 = root.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(-5, -3).addBox(-3.5F, -4.5F, 18.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0F, 1.0F));
		PartDefinition bone9 = root.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(6, 7).addBox(-1.5F, -2.5F, 22.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(T entity_, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {    
		this.root().getAllParts().forEach(ModelPart::resetPose);
        
        var entity = (WormEntity) entity_;
		
        animate(entity.idleAnimationState, WormAnimations.WORM_IDLE, ageInTicks, 1f);
        animate(entity.attackAnimationState, WormAnimations.WORM_ATTACK, ageInTicks, 1f);
        animate(entity.damagedAnimationState, WormAnimations.WORM_DAMAGED, ageInTicks, 1f);
        animate(entity.swimAnimationState, WormAnimations.WORM_SWEEM, ageInTicks, 1f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        
    	worm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    	
    	

    	/*
    	bone9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha * 0.5f);
        bone8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha  * 0.5f);
        bone7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha  * 0.5f);
        bone6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha  * 0.5f);
           	bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha  * 0.5f);
        bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha  * 0.5f);
        bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha  * 0.5f);
        bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha  * 0.5f);
        bone1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha  * 0.5f);*/
    }

	@Override
	public ModelPart root() {
		return worm;
	}
}
