package tank.mods.microworld.entity.plants.diatom;

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
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusEntity;
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusModel;

public class DiatomRenderer extends MobRenderer<DiatomEntity, EntityModel<DiatomEntity>> {
    
    private final EntityModel<DiatomEntity> model1;
    private final EntityModel<DiatomEntity> model2;
    private final EntityModel<DiatomEntity> model3;

    public DiatomRenderer(EntityRendererProvider.Context pContext, List<ModelLayerLocation> layers) {
        super(pContext, new DiatomModel1<>(pContext.bakeLayer(layers.get(0))), 0.1f);

        this.model1 = new DiatomModel1<>(pContext.bakeLayer(layers.get(0)));
        this.model2 = new DiatomModel2<>(pContext.bakeLayer(layers.get(1)));
        this.model3 = new DiatomModel3<>(pContext.bakeLayer(layers.get(2)));
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
