package tank.mods.microworld.entity.multicellular.rotifer;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import tank.mods.microworld.MicroworldMod;
import tank.mods.microworld.entity.ModModelLayers;

public class RotiferRenderer extends MobRenderer<RotiferEntity,  RotiferModel<RotiferEntity>> {
	
    public RotiferRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RotiferModel<>(pContext.bakeLayer(ModModelLayers.ROTIFER_LAYER)), 0.1f);
    }
    
    @Override
    protected RenderType getRenderType(RotiferEntity entity, boolean visible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(getTextureLocation(entity));
    }

    @Override
    public ResourceLocation getTextureLocation( RotiferEntity pEntity) {
        return new ResourceLocation(MicroworldMod.MODID, "textures/entity/rotifer.png");
    }

    @Override
    public void render( RotiferEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        pMatrixStack.scale(10f, 10f, 10f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
