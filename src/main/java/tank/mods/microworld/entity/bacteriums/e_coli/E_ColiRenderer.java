package tank.mods.microworld.entity.bacteriums.e_coli;

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
import tank.mods.microworld.entity.multicellular.worm.WormEntity;


public class E_ColiRenderer extends MobRenderer<E_ColiEntity, EntityModel<E_ColiEntity>> {
    
    public E_ColiRenderer(EntityRendererProvider.Context pContext, List<ModelLayerLocation> layers) {
        super(pContext, new E_ColiModel<>(pContext.bakeLayer(layers.get(0))), 0.1f);
    }

    @Override
    protected RenderType getRenderType(E_ColiEntity entity, boolean visible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(getTextureLocation(entity));
    }

    @Override
    public ResourceLocation getTextureLocation(E_ColiEntity pEntity) {
        return new ResourceLocation(MicroworldMod.MODID, "textures/entity/red.png");
    }

    @Override
    public void render(E_ColiEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        
        pMatrixStack.scale(0.5f, 0.5f, 0.5f);    
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
