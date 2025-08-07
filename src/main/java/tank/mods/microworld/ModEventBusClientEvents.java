package tank.mods.microworld;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tank.mods.microworld.entity.ModEntities;
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
import tank.mods.microworld.entity.multicellular.rotifer.RotiferModel;
import tank.mods.microworld.entity.multicellular.rotifer.RotiferRenderer;
import tank.mods.microworld.entity.multicellular.worm.WormModel;
import tank.mods.microworld.entity.multicellular.worm.WormRenderer;
import tank.mods.microworld.entity.plants.diatom.DiatomModel1;
import tank.mods.microworld.entity.plants.diatom.DiatomModel2;
import tank.mods.microworld.entity.plants.diatom.DiatomModel3;
import tank.mods.microworld.entity.plants.diatom.DiatomRenderer;


@Mod.EventBusSubscriber(modid = MicroworldMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {

        for (var entity : ModEntities.REGISTERED_MOBS) {
            entity.RegisterClientBus(event);
        }

    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.SANITIZER_PROJECTILE.get(), 
            (context) -> new ThrownItemRenderer<>(context, 1.0F, true));
        event.registerEntityRenderer(ModEntities.POISON_BOMB_PROJECTILE.get(), 
            (context) -> new ThrownItemRenderer<>(context, 1.0F, true));
        event.registerEntityRenderer(ModEntities.STINGING_CELL_PROJECTILE.get(), 
            (context) -> new ThrownItemRenderer<>(context, 1.0F, true));
        event.registerEntityRenderer(ModEntities.CELL_SHURIKEN_PROJECTILE.get(), 
            (context) -> new ThrownItemRenderer<>(context, 2.0F, true));
    }
}

    