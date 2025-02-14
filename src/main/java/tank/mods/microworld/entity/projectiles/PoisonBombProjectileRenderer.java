package tank.mods.microworld.entity.projectiles;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import tank.mods.microworld.MicroworldMod;

public class PoisonBombProjectileRenderer extends EntityRenderer<PoisonBombProjectileEntity> {
    
    public PoisonBombProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(PoisonBombProjectileEntity entity) {
        return new ResourceLocation(MicroworldMod.MODID, "textures/entity/blue.png");
    }
}
