package tank.mods.microworld.entity.ciliates.shoe;

import java.util.List;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import tank.mods.microworld.MicroworldMod;

public class ShoeRenderer extends MobRenderer<ShoeEntity, EntityModel<ShoeEntity>> {
	
    public ShoeRenderer(EntityRendererProvider.Context pContext, List<ModelLayerLocation> layers) {
        super(pContext, new ShoeModel<>(pContext.bakeLayer(layers.get(0))), 0.1f);
    }
    
    @Override
    protected RenderType getRenderType(ShoeEntity entity, boolean visible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(getTextureLocation(entity));
    }

    @Override
    public ResourceLocation getTextureLocation(ShoeEntity pEntity) {
        return new ResourceLocation(MicroworldMod.MODID, "textures/entity/shoe.png");
    }

    @Override
    public void render( ShoeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        pMatrixStack.scale(10f, 10f, 10f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
