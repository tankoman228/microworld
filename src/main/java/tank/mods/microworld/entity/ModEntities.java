package tank.mods.microworld.entity;

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
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusEntity;
import tank.mods.microworld.entity.bacteriums.clostridium.ClostridiumEntity;
import tank.mods.microworld.entity.bacteriums.cyanobacteria.CyanobacteriaEntity;
import tank.mods.microworld.entity.bacteriums.e_coli.E_ColiEntity;
import tank.mods.microworld.entity.bacteriums.germ.GermEntity;
import tank.mods.microworld.entity.bacteriums.nocardia.NocardiaEntity;
import tank.mods.microworld.entity.bacteriums.spirillum.SpirillumEntity;
import tank.mods.microworld.entity.bacteriums.staphylococcus.StaphylococcusEntity;
import tank.mods.microworld.entity.multicellular.worm.WormEntity;
import tank.mods.microworld.entity.plants.diatom.DiatomEntity;
import tank.mods.microworld.entity.projectiles.SanitizerProjectileEntity;
import tank.mods.microworld.items.ModItems;


public class ModEntities {
	
	 public static final DeferredRegister<EntityType<?>> MOB_TYPES =
	    DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MicroworldMod.MODID);

			    
		public static final RegistryObject<EntityType<WormEntity>> Worm =
				MOB_TYPES.register("worm", () -> EntityType.Builder.of(WormEntity::new, MobCategory.CREATURE)
					.sized(3f, 3f).build("worm"));

	    public static final RegistryObject<EntityType<GermEntity>> Germ =
	            MOB_TYPES.register("germ", () -> EntityType.Builder.of(GermEntity::new, MobCategory.CREATURE)
	                    .sized(0.3f, 0.3f).build("germ"));

		public static final RegistryObject<EntityType<BacillusEntity>> Bacillus =
		MOB_TYPES.register("bacillus", () -> EntityType.Builder.of(BacillusEntity::new, MobCategory.CREATURE)
				.sized(0.3f, 0.3f).build("bacillus"));

		public static final RegistryObject<EntityType<E_ColiEntity>> E_Coli =
				MOB_TYPES.register("e_coli", () -> EntityType.Builder.of(E_ColiEntity::new, MobCategory.CREATURE)
						.sized(0.1f, 0.1f).build("e_coli"));
	
		public static final RegistryObject<EntityType<StaphylococcusEntity>> Staphylococcus =
				MOB_TYPES.register("staphylococcus", () -> EntityType.Builder.of(StaphylococcusEntity::new, MobCategory.CREATURE)
						.sized(0.2f, 0.2f).build("staphylococcus"));
	
		public static final RegistryObject<EntityType<SpirillumEntity>> Spirillum =
				MOB_TYPES.register("spirillum", () -> EntityType.Builder.of(SpirillumEntity::new, MobCategory.CREATURE)
						.sized(0.25f, 0.25f).build("spirillum"));
	
		public static final RegistryObject<EntityType<NocardiaEntity>> Nocardia =
				MOB_TYPES.register("nocardia", () -> EntityType.Builder.of(NocardiaEntity::new, MobCategory.CREATURE)
						.sized(0.1f, 0.1f).build("nocardia"));
	
		public static final RegistryObject<EntityType<ClostridiumEntity>> Clostridium =
				MOB_TYPES.register("clostridium", () -> EntityType.Builder.of(ClostridiumEntity::new, MobCategory.CREATURE)
						.sized(0.2f, 0.2f).build("clostridium"));
	
		public static final RegistryObject<EntityType<CyanobacteriaEntity>> Cyanobacteria =
				MOB_TYPES.register("cyanobacteria", () -> EntityType.Builder.of(CyanobacteriaEntity::new, MobCategory.CREATURE)
						.sized(0.1f, 0.1f).build("cyanobacteria"));

		public static final RegistryObject<EntityType<DiatomEntity>> Diatom =
				MOB_TYPES.register("diatom", () -> EntityType.Builder.of(DiatomEntity::new, MobCategory.CREATURE)
					.sized(0.4f, 0.4f).build("diatom"));

		
		
		
	public static final DeferredRegister<EntityType<?>> PROJECTILE_TYPES =
		DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MicroworldMod.MODID);

	public static final RegistryObject<EntityType<SanitizerProjectileEntity>> SANITIZER_PROJECTILE =
		PROJECTILE_TYPES.register("sanitizer_projectile", () -> EntityType.Builder.<SanitizerProjectileEntity>of(SanitizerProjectileEntity::new, MobCategory.MISC)
				.sized(0.5f, 0.5f).build("sanitizer_projectile"));


	public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, MicroworldMod.MODID);

	public static void register(IEventBus bus) {

		MOB_TYPES.register(bus);
		PROJECTILE_TYPES.register(bus);

		// Register spawn eggs separately after entities are registered
		for (RegistryObject<EntityType<?>> entity : MOB_TYPES.getEntries()) {

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
