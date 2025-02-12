package tank.mods.microworld.mobs;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tank.mods.microworld.MicroworldMod;
import tank.mods.microworld.mobs.bacteriums.GermEntity;
import tank.mods.microworld.mobs.multicellular.WormEntity;

public class ModEntities {
	
	 public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
	            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MicroworldMod.MODID);

	    public static final RegistryObject<EntityType<GermEntity>> Germ =
	            ENTITY_TYPES.register("germ", () -> EntityType.Builder.of(GermEntity::new, MobCategory.CREATURE)
	                    .sized(0.3f, 0.3f).build("germ"));
	    
	    public static final RegistryObject<EntityType<WormEntity>> Worm =
	            ENTITY_TYPES.register("worm", () -> EntityType.Builder.of(WormEntity::new, MobCategory.CREATURE)
	                    .sized(3f, 3f).build("worm"));


	    public static void register(IEventBus eventBus) {
	        ENTITY_TYPES.register(eventBus);
	    }
}
