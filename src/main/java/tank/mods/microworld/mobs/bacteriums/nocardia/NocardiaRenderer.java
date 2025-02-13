package tank.mods.microworld.mobs.bacteriums.nocardia;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import tank.mods.microworld.MicroworldMod;
import tank.mods.microworld.mobs.ModModelLayers;

public class NocardiaRenderer extends MobRenderer<NocardiaEntity, NocardiaModel<NocardiaEntity>> {
    
    public NocardiaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new NocardiaModel<>(pContext.bakeLayer(ModModelLayers.NOCARDIA_LAYER)), 0.1f);
    }

    @Override
    public ResourceLocation getTextureLocation(NocardiaEntity pEntity) {
        return new ResourceLocation(MicroworldMod.MODID, "textures/entity/orange.png");
    }

    @Override
    public void render(NocardiaEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}