package tank.mods.microworld.entity.bacteriums.germ;
import java.util.List;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import tank.mods.microworld.MicroworldMod;

public class GermRenderer extends MobRenderer<GermEntity, EntityModel<GermEntity>> {
	
    public GermRenderer(EntityRendererProvider.Context pContext, List<ModelLayerLocation> layers) {
        super(pContext, new GermModel<>(pContext.bakeLayer(layers.get(0))), 0.1f);
    }

    @Override
    public ResourceLocation getTextureLocation(GermEntity pEntity) {
        return new ResourceLocation(MicroworldMod.MODID, "textures/entity/blue.png");
    }

    @Override
    public void render(GermEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
