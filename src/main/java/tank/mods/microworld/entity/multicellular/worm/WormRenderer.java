package tank.mods.microworld.entity.multicellular.worm;

import java.util.List;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.resources.ResourceLocation;
import tank.mods.microworld.MicroworldMod;

public class WormRenderer extends MobRenderer< WormEntity,  EntityModel<WormEntity>> {
	
    public  WormRenderer(EntityRendererProvider.Context pContext, List<ModelLayerLocation> layers) {
        super(pContext, new  WormModel<>(pContext.bakeLayer(layers.get(0))), 0.1f);
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
