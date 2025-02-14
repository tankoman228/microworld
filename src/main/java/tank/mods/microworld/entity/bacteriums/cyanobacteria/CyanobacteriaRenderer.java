package tank.mods.microworld.entity.bacteriums.cyanobacteria;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import tank.mods.microworld.MicroworldMod;
import tank.mods.microworld.entity.ModModelLayers;

public class CyanobacteriaRenderer extends MobRenderer<CyanobacteriaEntity, CyanobacteriaModel<CyanobacteriaEntity>> {
    
    public CyanobacteriaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CyanobacteriaModel<>(pContext.bakeLayer(ModModelLayers.CYANOBACTERIA_LAYER)), 0.1f);
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