package tank.mods.microworld;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tank.mods.microworld.mobs.ModEntities;
import tank.mods.microworld.mobs.bacteriums.GermEntity;
import tank.mods.microworld.mobs.multicellular.WormEntity;

@Mod.EventBusSubscriber(modid = MicroworldMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.Germ.get(), GermEntity.createAttributes().build());
        event.put(ModEntities.Worm.get(), WormEntity.createAttributes().build());
    }
}