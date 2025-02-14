package tank.mods.microworld.mobs;

import com.google.common.base.Supplier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tank.mods.microworld.MicroworldMod;
import tank.mods.microworld.items.ModItems;
import tank.mods.microworld.mobs.bacteriums.bacillus.BacillusEntity;
import tank.mods.microworld.mobs.bacteriums.clostridium.ClostridiumEntity;
import tank.mods.microworld.mobs.bacteriums.cyanobacteria.CyanobacteriaEntity;
import tank.mods.microworld.mobs.bacteriums.e_coli.E_ColiEntity;
import tank.mods.microworld.mobs.bacteriums.germ.GermEntity;
import tank.mods.microworld.mobs.bacteriums.nocardia.NocardiaEntity;
import tank.mods.microworld.mobs.bacteriums.spirillum.SpirillumEntity;
import tank.mods.microworld.mobs.bacteriums.staphylococcus.StaphylococcusEntity;
import tank.mods.microworld.mobs.multicellular.worm.WormEntity;
import tank.mods.microworld.mobs.plants.diatom.DiatomEntity;


public class ModEntities {
	
	 public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
	    DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MicroworldMod.MODID);

			    
		public static final RegistryObject<EntityType<WormEntity>> Worm =
				ENTITY_TYPES.register("worm", () -> EntityType.Builder.of(WormEntity::new, MobCategory.CREATURE)
					.sized(3f, 3f).build("worm"));

	    public static final RegistryObject<EntityType<GermEntity>> Germ =
	            ENTITY_TYPES.register("germ", () -> EntityType.Builder.of(GermEntity::new, MobCategory.CREATURE)
	                    .sized(0.3f, 0.3f).build("germ"));

		public static final RegistryObject<EntityType<BacillusEntity>> Bacillus =
		ENTITY_TYPES.register("bacillus", () -> EntityType.Builder.of(BacillusEntity::new, MobCategory.CREATURE)
				.sized(0.3f, 0.3f).build("bacillus"));

		public static final RegistryObject<EntityType<E_ColiEntity>> E_Coli =
				ENTITY_TYPES.register("e_coli", () -> EntityType.Builder.of(E_ColiEntity::new, MobCategory.CREATURE)
						.sized(0.1f, 0.1f).build("e_coli"));
	
		public static final RegistryObject<EntityType<StaphylococcusEntity>> Staphylococcus =
				ENTITY_TYPES.register("staphylococcus", () -> EntityType.Builder.of(StaphylococcusEntity::new, MobCategory.CREATURE)
						.sized(0.2f, 0.2f).build("staphylococcus"));
	
		public static final RegistryObject<EntityType<SpirillumEntity>> Spirillum =
				ENTITY_TYPES.register("spirillum", () -> EntityType.Builder.of(SpirillumEntity::new, MobCategory.CREATURE)
						.sized(0.25f, 0.25f).build("spirillum"));
	
		public static final RegistryObject<EntityType<NocardiaEntity>> Nocardia =
				ENTITY_TYPES.register("nocardia", () -> EntityType.Builder.of(NocardiaEntity::new, MobCategory.CREATURE)
						.sized(0.1f, 0.1f).build("nocardia"));
	
		public static final RegistryObject<EntityType<ClostridiumEntity>> Clostridium =
				ENTITY_TYPES.register("clostridium", () -> EntityType.Builder.of(ClostridiumEntity::new, MobCategory.CREATURE)
						.sized(0.2f, 0.2f).build("clostridium"));
	
		public static final RegistryObject<EntityType<CyanobacteriaEntity>> Cyanobacteria =
				ENTITY_TYPES.register("cyanobacteria", () -> EntityType.Builder.of(CyanobacteriaEntity::new, MobCategory.CREATURE)
						.sized(0.1f, 0.1f).build("cyanobacteria"));

		public static final RegistryObject<EntityType<DiatomEntity>> Diatom =
				ENTITY_TYPES.register("diatom", () -> EntityType.Builder.of(DiatomEntity::new, MobCategory.CREATURE)
					.sized(0.4f, 0.4f).build("diatom"));

	public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, MicroworldMod.MODID);

	public static void register(IEventBus bus) {

		ENTITY_TYPES.register(bus);

		// Register spawn eggs separately after entities are registered
		for (RegistryObject<EntityType<?>> entity : ENTITY_TYPES.getEntries()) {
			SPAWN_EGGS.register(entity.getId().getPath() + "_spawn_egg",
				() -> new ForgeSpawnEggItem(
					() -> (EntityType<? extends Mob>) entity.get(),
					0x148813,
					666,
					new Item.Properties()
				)
			);
		}

		SPAWN_EGGS.register(bus);
	}
}
