package tank.mods.microworld;

import java.rmi.registry.Registry;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import tank.mods.microworld.mobs.ModEntities;
import tank.mods.microworld.mobs.bacteriums.bacillus.BacillusEntity;
import tank.mods.microworld.mobs.bacteriums.clostridium.ClostridiumEntity;
import tank.mods.microworld.mobs.bacteriums.cyanobacteria.CyanobacteriaEntity;
import tank.mods.microworld.mobs.bacteriums.e_coli.E_ColiEntity;
import tank.mods.microworld.mobs.bacteriums.germ.GermEntity;
import tank.mods.microworld.mobs.bacteriums.nocardia.NocardiaEntity;
import tank.mods.microworld.mobs.bacteriums.spirillum.SpirillumEntity;
import tank.mods.microworld.mobs.bacteriums.staphylococcus.StaphylococcusEntity;
import tank.mods.microworld.mobs.multicellular.worm.WormEntity;

@Mod.EventBusSubscriber(modid = MicroworldMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        
        event.put(ModEntities.Bacillus.get(), BacillusEntity.createAttributes().build());
        event.put(ModEntities.Germ.get(), GermEntity.createAttributes().build());
        event.put(ModEntities.E_Coli.get(), E_ColiEntity.createAttributes().build());
        event.put(ModEntities.Staphylococcus.get(), StaphylococcusEntity.createAttributes().build());
        event.put(ModEntities.Spirillum.get(), SpirillumEntity.createAttributes().build());
        event.put(ModEntities.Nocardia.get(), NocardiaEntity.createAttributes().build());
        event.put(ModEntities.Clostridium.get(), ClostridiumEntity.createAttributes().build());
        event.put(ModEntities.Cyanobacteria.get(), CyanobacteriaEntity.createAttributes().build());
    
        event.put(ModEntities.Worm.get(), WormEntity.createAttributes().build());
    }
}