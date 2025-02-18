package tank.mods.microworld.entity.bacteriums.cyanobacteria;

import java.util.List;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import tank.mods.microworld.MicroworldMod;

public class CyanobacteriaRenderer extends MobRenderer<CyanobacteriaEntity, EntityModel<CyanobacteriaEntity>> {
    
    public CyanobacteriaRenderer(EntityRendererProvider.Context pContext, List<ModelLayerLocation> layers) {
        super(pContext, new CyanobacteriaModel<>(pContext.bakeLayer(layers.get(0))), 0.1f);
    }

    @Override
    public ResourceLocation getTextureLocation(CyanobacteriaEntity pEntity) {
        return new ResourceLocation(MicroworldMod.MODID, "textures/entity/green.png");
    }

    @Override
    public void render(CyanobacteriaEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.scale(0.1f, 0.1f, 0.1f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}