package tank.mods.microworld.entity.ciliates.paramecium_x;

import java.util.List;

import org.joml.Matrix3f;
import org.joml.Matrix4f;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import tank.mods.microworld.MicroworldMod;

public class ParameciumXRenderer extends MobRenderer<ParameciumXEntity, EntityModel<ParameciumXEntity>> {
	
    public ParameciumXRenderer(EntityRendererProvider.Context pContext, List<ModelLayerLocation> layers) {
        super(pContext, new ParameciumXModel<>(pContext.bakeLayer(layers.get(0))), 0.1f);
    }
    
    @Override
    protected RenderType getRenderType(ParameciumXEntity entity, boolean visible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(getTextureLocation(entity));
    }

    @Override
    public ResourceLocation getTextureLocation(ParameciumXEntity pEntity) {
        return new ResourceLocation(MicroworldMod.MODID, "textures/entity/paramecium_x.png");
    }

    @Override
    public void render(ParameciumXEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        pMatrixStack.scale(10f, 10f, 10f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}