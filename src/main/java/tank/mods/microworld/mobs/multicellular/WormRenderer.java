package tank.mods.microworld.mobs.multicellular;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.resources.ResourceLocation;
import tank.mods.microworld.MicroworldMod;
import tank.mods.microworld.mobs.ModModelLayers;

public class WormRenderer extends MobRenderer< WormEntity,  WormModel< WormEntity>> {
	
    public  WormRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new  WormModel<>(pContext.bakeLayer(ModModelLayers.WORM_LAYER)), 0.1f);
        //SlimeRenderer slimeRenderer;
    }
    
    @Override
    protected RenderType getRenderType(WormEntity entity, boolean visible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(getTextureLocation(entity));
    }

    @Override
    public ResourceLocation getTextureLocation( WormEntity pEntity) {
        return new ResourceLocation(MicroworldMod.MODID, "textures/entity/transparent.png");
    }

    @Override
    public void render( WormEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        pMatrixStack.scale(5f, 5f, 5f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
