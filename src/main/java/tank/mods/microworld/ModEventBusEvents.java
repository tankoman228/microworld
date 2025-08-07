package tank.mods.microworld;

import java.rmi.registry.Registry;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import tank.mods.microworld.entity.ModEntities;
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusEntity;
import tank.mods.microworld.entity.bacteriums.clostridium.ClostridiumEntity;
import tank.mods.microworld.entity.bacteriums.cyanobacteria.CyanobacteriaEntity;
import tank.mods.microworld.entity.bacteriums.e_coli.E_ColiEntity;
import tank.mods.microworld.entity.bacteriums.germ.GermEntity;
import tank.mods.microworld.entity.bacteriums.nocardia.NocardiaEntity;
import tank.mods.microworld.entity.bacteriums.spirillum.SpirillumEntity;
import tank.mods.microworld.entity.bacteriums.staphylococcus.StaphylococcusEntity;
import tank.mods.microworld.entity.multicellular.rotifer.RotiferEntity;
import tank.mods.microworld.entity.multicellular.worm.WormEntity;
import tank.mods.microworld.entity.plants.diatom.DiatomEntity;

@Mod.EventBusSubscriber(modid = MicroworldMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {

        for (var entity : ModEntities.REGISTERED_MOBS) {
            entity.RegisterBus(event);;
        }
    }
}
