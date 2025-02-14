package tank.mods.microworld.entity.plants.diatom;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import tank.mods.microworld.MicroworldMod;
import tank.mods.microworld.entity.ModModelLayers;
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusEntity;
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusModel;

public class DiatomRenderer extends MobRenderer<DiatomEntity, EntityModel<DiatomEntity>> {
    
    private final EntityModel<DiatomEntity> model1;
    private final EntityModel<DiatomEntity> model2;
    private final EntityModel<DiatomEntity> model3;

    public DiatomRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BacillusModel<>(pContext.bakeLayer(ModModelLayers.BACILLUS_LAYER)), 0.1f);

        this.model1 = new DiatomModel1<>(pContext.bakeLayer(ModModelLayers.DIATOM_LAYER_1));
        this.model2 = new DiatomModel2<>(pContext.bakeLayer(ModModelLayers.DIATOM_LAYER_2));
        this.model3 = new DiatomModel3<>(pContext.bakeLayer(ModModelLayers.DIATOM_LAYER_3));
    }

    @Override
    public ResourceLocation getTextureLocation(DiatomEntity pEntity) {
        return new ResourceLocation(MicroworldMod.MODID, "textures/entity/diatom.png");
    }

        @Override
    protected RenderType getRenderType(DiatomEntity entity, boolean visible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(getTextureLocation(entity));
    }


    @Override
    public void render(DiatomEntity entity, float yaw, float partialTicks, PoseStack matrixStack,
                       MultiBufferSource buffer, int light) {
                        
        this.model = switch(entity.getShapeVariant()) {
            case 0 -> model1;
            case 1 -> model2;
            case 2 -> model3;
            default -> model3;
        };
        
        super.render(entity, yaw, partialTicks, matrixStack, buffer, light);
    }
}
