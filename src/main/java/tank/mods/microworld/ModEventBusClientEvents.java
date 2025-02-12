package tank.mods.microworld;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tank.mods.microworld.mobs.ModModelLayers;
import tank.mods.microworld.mobs.bacteriums.GermModel;
import tank.mods.microworld.mobs.multicellular.WormModel;


@Mod.EventBusSubscriber(modid = MicroworldMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.GERM_LAYER, GermModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.WORM_LAYER, WormModel::createBodyLayer);
    }
}