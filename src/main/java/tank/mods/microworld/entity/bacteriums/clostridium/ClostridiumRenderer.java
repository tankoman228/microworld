package tank.mods.microworld.entity.bacteriums.clostridium;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import tank.mods.microworld.MicroworldMod;
import tank.mods.microworld.entity.ModModelLayers;

public class ClostridiumRenderer extends MobRenderer<ClostridiumEntity, ClostridiumModel<ClostridiumEntity>> {
    
    public ClostridiumRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ClostridiumModel<>(pContext.bakeLayer(ModModelLayers.CLOSTRIDIUM_LAYER)), 0.1f);
    }

    @Override
    public ResourceLocation getTextureLocation(ClostridiumEntity pEntity) {
        return new ResourceLocation(MicroworldMod.MODID, "textures/entity/transparent.png");
    }

    @Override
    public void render(ClostridiumEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}