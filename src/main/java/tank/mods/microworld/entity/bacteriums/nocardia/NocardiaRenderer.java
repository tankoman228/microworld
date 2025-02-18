package tank.mods.microworld.entity.bacteriums.nocardia;

import java.util.List;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import tank.mods.microworld.MicroworldMod;

public class NocardiaRenderer extends MobRenderer<NocardiaEntity, EntityModel<NocardiaEntity>> {
    
    public NocardiaRenderer(EntityRendererProvider.Context pContext, List<ModelLayerLocation> layers) {
        super(pContext, new NocardiaModel<>(pContext.bakeLayer(layers.get(0))), 0.1f);
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