package tank.mods.microworld;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tank.mods.microworld.entity.ModEntities;
import tank.mods.microworld.entity.ModModelLayers;
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusModel;
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusRenderer;
import tank.mods.microworld.entity.bacteriums.clostridium.ClostridiumModel;
import tank.mods.microworld.entity.bacteriums.clostridium.ClostridiumRenderer;
import tank.mods.microworld.entity.bacteriums.cyanobacteria.CyanobacteriaModel;
import tank.mods.microworld.entity.bacteriums.cyanobacteria.CyanobacteriaRenderer;
import tank.mods.microworld.entity.bacteriums.e_coli.E_ColiModel;
import tank.mods.microworld.entity.bacteriums.e_coli.E_ColiRenderer;
import tank.mods.microworld.entity.bacteriums.germ.GermModel;
import tank.mods.microworld.entity.bacteriums.germ.GermRenderer;
import tank.mods.microworld.entity.bacteriums.nocardia.NocardiaModel;
import tank.mods.microworld.entity.bacteriums.nocardia.NocardiaRenderer;
import tank.mods.microworld.entity.bacteriums.spirillum.SpirillumModel;
import tank.mods.microworld.entity.bacteriums.spirillum.SpirillumRenderer;
import tank.mods.microworld.entity.bacteriums.staphylococcus.StaphylococcusModel;
import tank.mods.microworld.entity.bacteriums.staphylococcus.StaphylococcusRenderer;
import tank.mods.microworld.entity.multicellular.worm.WormModel;
import tank.mods.microworld.entity.multicellular.worm.WormRenderer;
import tank.mods.microworld.entity.plants.diatom.DiatomModel1;
import tank.mods.microworld.entity.plants.diatom.DiatomModel2;
import tank.mods.microworld.entity.plants.diatom.DiatomModel3;
import tank.mods.microworld.entity.plants.diatom.DiatomRenderer;
import tank.mods.microworld.entity.projectiles.SanitizerProjectileRenderer;


@Mod.EventBusSubscriber(modid = MicroworldMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {

        EntityRenderers.register(ModEntities.Germ.get(), GermRenderer::new);
        EntityRenderers.register(ModEntities.E_Coli .get(), E_ColiRenderer::new);
        EntityRenderers.register(ModEntities.Staphylococcus.get(), StaphylococcusRenderer::new);
        EntityRenderers.register(ModEntities.Spirillum.get(), SpirillumRenderer::new);
        EntityRenderers.register(ModEntities.Nocardia.get(), NocardiaRenderer::new);
        EntityRenderers.register(ModEntities.Clostridium.get(), ClostridiumRenderer::new);
        EntityRenderers.register(ModEntities.Cyanobacteria.get(), CyanobacteriaRenderer::new);
        EntityRenderers.register(ModEntities.Bacillus.get(), BacillusRenderer::new);
        
        EntityRenderers.register(ModEntities.Diatom.get(), DiatomRenderer::new);

        EntityRenderers.register(ModEntities.Worm.get(), WormRenderer::new);

        //EntityRenderers.register(ModEntities.SANITIZER_PROJECTILE.get(), SanitizerProjectileRenderer::new);
        
        event.registerLayerDefinition(ModModelLayers.BACILLUS_LAYER, BacillusModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.E_COLI_LAYER, E_ColiModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.STAPHYLOCOCCUS_LAYER, StaphylococcusModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SPIRILLUM_LAYER, SpirillumModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.NOCARDIA_LAYER, NocardiaModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CYANOBACTERIA_LAYER, CyanobacteriaModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GERM_LAYER, GermModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CLOSTRIDIUM_LAYER, ClostridiumModel::createBodyLayer);
        
        event.registerLayerDefinition(ModModelLayers.DIATOM_LAYER_1, DiatomModel1::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.DIATOM_LAYER_2, DiatomModel2::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.DIATOM_LAYER_3, DiatomModel3::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.WORM_LAYER, WormModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.SANITIZER_PROJECTILE.get(), 
            (context) -> new ThrownItemRenderer<>(context, 1.0F, true));
        event.registerEntityRenderer(ModEntities.POISON_BOMB_PROJECTILE.get(), 
            (context) -> new ThrownItemRenderer<>(context, 1.0F, true));
    }
}

    