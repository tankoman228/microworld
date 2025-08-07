package tank.mods.microworld.entity;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Supplier;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tank.mods.microworld.MicroworldMod;
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusEntity;
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusModel;
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusRenderer;
import tank.mods.microworld.entity.bacteriums.clostridium.ClostridiumEntity;
import tank.mods.microworld.entity.bacteriums.clostridium.ClostridiumModel;
import tank.mods.microworld.entity.bacteriums.clostridium.ClostridiumRenderer;
import tank.mods.microworld.entity.bacteriums.cyanobacteria.CyanobacteriaEntity;
import tank.mods.microworld.entity.bacteriums.cyanobacteria.CyanobacteriaModel;
import tank.mods.microworld.entity.bacteriums.cyanobacteria.CyanobacteriaRenderer;
import tank.mods.microworld.entity.bacteriums.e_coli.E_ColiEntity;
import tank.mods.microworld.entity.bacteriums.e_coli.E_ColiModel;
import tank.mods.microworld.entity.bacteriums.e_coli.E_ColiRenderer;
import tank.mods.microworld.entity.bacteriums.germ.GermEntity;
import tank.mods.microworld.entity.bacteriums.germ.GermModel;
import tank.mods.microworld.entity.bacteriums.germ.GermRenderer;
import tank.mods.microworld.entity.bacteriums.nocardia.NocardiaEntity;
import tank.mods.microworld.entity.bacteriums.nocardia.NocardiaModel;
import tank.mods.microworld.entity.bacteriums.nocardia.NocardiaRenderer;
import tank.mods.microworld.entity.bacteriums.spirillum.SpirillumEntity;
import tank.mods.microworld.entity.bacteriums.spirillum.SpirillumModel;
import tank.mods.microworld.entity.bacteriums.spirillum.SpirillumRenderer;
import tank.mods.microworld.entity.bacteriums.staphylococcus.StaphylococcusEntity;
import tank.mods.microworld.entity.bacteriums.staphylococcus.StaphylococcusModel;
import tank.mods.microworld.entity.bacteriums.staphylococcus.StaphylococcusRenderer;
import tank.mods.microworld.entity.ciliates.paramecium_x.ParameciumXEntity;
import tank.mods.microworld.entity.ciliates.paramecium_x.ParameciumXModel;
import tank.mods.microworld.entity.ciliates.paramecium_x.ParameciumXRenderer;
import tank.mods.microworld.entity.ciliates.shoe.ShoeEntity;
import tank.mods.microworld.entity.ciliates.shoe.ShoeModel;
import tank.mods.microworld.entity.ciliates.shoe.ShoeRenderer;
import tank.mods.microworld.entity.multicellular.rotifer.RotiferEntity;
import tank.mods.microworld.entity.multicellular.rotifer.RotiferModel;
import tank.mods.microworld.entity.multicellular.rotifer.RotiferRenderer;
import tank.mods.microworld.entity.multicellular.worm.WormEntity;
import tank.mods.microworld.entity.multicellular.worm.WormModel;
import tank.mods.microworld.entity.multicellular.worm.WormRenderer;
import tank.mods.microworld.entity.plants.diatom.DiatomEntity;
import tank.mods.microworld.entity.plants.diatom.DiatomModel1;
import tank.mods.microworld.entity.plants.diatom.DiatomModel2;
import tank.mods.microworld.entity.plants.diatom.DiatomModel3;
import tank.mods.microworld.entity.plants.diatom.DiatomRenderer;
import tank.mods.microworld.entity.projectiles.CellShurikenProjectileEntity;
import tank.mods.microworld.entity.projectiles.PoisonBombProjectileEntity;
import tank.mods.microworld.entity.projectiles.SanitizerProjectileEntity;
import tank.mods.microworld.entity.projectiles.StingingCellProjectileEntity;
import tank.mods.microworld.items.ModItems;


public class ModEntities {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ModEntities.class);

	 public static final DeferredRegister<EntityType<?>> MOB_TYPES =
	    DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MicroworldMod.MODID);

	
	public static final RegistryObject<EntityType<WormEntity>> Worm = registerMob(
		WormRenderer.class, 
		List.of(
			(Class<? extends EntityModel<? extends Entity>>) (Class<?>) WormModel.class
		),
		WormEntity.class, 
		"worm", 3f, 3f, MobCategory.CREATURE
	);

	public static final RegistryObject<EntityType<RotiferEntity>> Rotifer = registerMob(
		RotiferRenderer.class, 
		List.of(
			(Class<? extends EntityModel<?>>) (Class<?>) RotiferModel.class
		),
		RotiferEntity.class, 
		"rotifer", 7f, 4f, MobCategory.CREATURE
	);


	public static final RegistryObject<EntityType<GermEntity>> Germ = registerMob(
		GermRenderer.class, 
		List.of(
			(Class<? extends EntityModel<?>>) (Class<?>) GermModel.class),
		GermEntity.class, 
		"germ", 0.3f, 0.3f, MobCategory.WATER_AMBIENT
	);

	public static final RegistryObject<EntityType<BacillusEntity>> Bacillus = registerMob(
		BacillusRenderer.class, 
		List.of(
			(Class<? extends EntityModel<?>>) (Class<?>) BacillusModel.class
		),
		BacillusEntity.class, 
		"bacillus", 0.3f, 0.3f, MobCategory.WATER_AMBIENT
	);

	public static final RegistryObject<EntityType<E_ColiEntity>> E_Coli = registerMob(
		E_ColiRenderer.class, 
		List.of(
			(Class<? extends EntityModel<?>>) (Class<?>) E_ColiModel.class
		),
		E_ColiEntity.class, 
		"e_coli", 0.1f, 0.1f, MobCategory.WATER_AMBIENT
	);

	public static final RegistryObject<EntityType<StaphylococcusEntity>> Staphylococcus = registerMob(
		StaphylococcusRenderer.class, 
		List.of(
			(Class<? extends EntityModel<?>>) (Class<?>) StaphylococcusModel.class
		),
		StaphylococcusEntity.class, 
		"staphylococcus", 0.2f, 0.2f, MobCategory.WATER_AMBIENT
	);

	public static final RegistryObject<EntityType<SpirillumEntity>> Spirillum = registerMob(
		SpirillumRenderer.class, 
		List.of(
			(Class<? extends EntityModel<?>>) (Class<?>) SpirillumModel.class
		),
		SpirillumEntity.class, 
		"spirillum", 0.25f, 0.25f, MobCategory.WATER_AMBIENT
	);

	public static final RegistryObject<EntityType<NocardiaEntity>> Nocardia = registerMob(
		NocardiaRenderer.class, 
		List.of(
			(Class<? extends EntityModel<?>>) (Class<?>) NocardiaModel.class
		),
		NocardiaEntity.class, 
		"nocardia", 0.1f, 0.1f, MobCategory.WATER_AMBIENT
	);

	public static final RegistryObject<EntityType<ClostridiumEntity>> Clostridium = registerMob(
		ClostridiumRenderer.class, 
		List.of(
			(Class<? extends EntityModel<?>>) (Class<?>) ClostridiumModel.class
		),
		ClostridiumEntity.class, 
		"clostridium", 0.2f, 0.2f, MobCategory.WATER_AMBIENT
	);

	public static final RegistryObject<EntityType<CyanobacteriaEntity>> Cyanobacteria = registerMob(
		CyanobacteriaRenderer.class,
		List.of(
			(Class<? extends EntityModel<?>>) (Class<?>) CyanobacteriaModel.class
		),
		CyanobacteriaEntity.class,
		"cyanobacteria", 0.1f, 0.1f, MobCategory.WATER_AMBIENT
	);
 
	public static final RegistryObject<EntityType<DiatomEntity>> DIATOM = registerMob(
		DiatomRenderer.class, 
		List.of(
			(Class<? extends EntityModel<?>>) (Class<?>) DiatomModel1.class, 
			(Class<? extends EntityModel<?>>) (Class<?>) DiatomModel2.class, 
			(Class<? extends EntityModel<?>>) (Class<?>) DiatomModel3.class
		),
		DiatomEntity.class, 
		"diatom", 0.4f, 0.4f, MobCategory.CREATURE
	);
	 

	// Инфузории
	public static final RegistryObject<EntityType<ShoeEntity>> SHOE = registerMob(
		ShoeRenderer.class, 
		List.of(
			(Class<? extends EntityModel<?>>) (Class<?>) ShoeModel.class
		),
		ShoeEntity.class, 
		"shoe", 8f, 4f, MobCategory.CREATURE
	);
	public static final RegistryObject<EntityType<ParameciumXEntity>> PARAMECIUM_X = registerMob(
		ParameciumXRenderer.class, 
		List.of(
			(Class<? extends EntityModel<?>>) (Class<?>) ParameciumXModel.class
		),
		ParameciumXEntity.class, 
		"paramecium_x", 8f, 4f, MobCategory.CREATURE
	);
		
		
	public static final DeferredRegister<EntityType<?>> PROJECTILE_TYPES =
		DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MicroworldMod.MODID);

	public static final RegistryObject<EntityType<SanitizerProjectileEntity>> SANITIZER_PROJECTILE =
		PROJECTILE_TYPES.register("sanitizer_projectile", () -> EntityType.Builder.<SanitizerProjectileEntity>of(SanitizerProjectileEntity::new, MobCategory.MISC)
				.sized(0.5f, 0.5f).build("sanitizer_projectile"));

	public static final RegistryObject<EntityType<PoisonBombProjectileEntity>> POISON_BOMB_PROJECTILE =
		PROJECTILE_TYPES.register("poison_bomb_projectile", () -> EntityType.Builder.<PoisonBombProjectileEntity>of(PoisonBombProjectileEntity::new, MobCategory.MISC)
			.sized(0.5f, 0.5f).build("poison_bomb_projectile"));

	public static final RegistryObject<EntityType<StingingCellProjectileEntity>> STINGING_CELL_PROJECTILE =
		PROJECTILE_TYPES.register("stinging_cell_projectile", () -> EntityType.Builder.<StingingCellProjectileEntity>of(StingingCellProjectileEntity::new, MobCategory.MISC)
			.sized(0.5f, 0.5f).build("stinging_cell_projectile"));

	public static final RegistryObject<EntityType<CellShurikenProjectileEntity>> CELL_SHURIKEN_PROJECTILE =
		PROJECTILE_TYPES.register("cell_shuriken_projectile", () -> EntityType.Builder.<CellShurikenProjectileEntity>of(CellShurikenProjectileEntity::new, MobCategory.MISC)
			.sized(2f, 2f).build("cell_shuriken_projectile"));
	
	
	public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, MicroworldMod.MODID);
	public static volatile List<AutoregisteredRegistryObjectMob<?, ?>> REGISTERED_MOBS;

	private static <EntityClass extends Mob, 
		EntityRendererClass extends MobRenderer<EntityClass, EntityModel<EntityClass>>> 
		RegistryObject<EntityType<EntityClass>> registerMob(
		Class<EntityRendererClass> rendererClass,
		List<Class<? extends EntityModel<?>>> modelClasses, // Оставляем тип, как есть
		Class<EntityClass> entityClass,
		String name, 
		float size1, float size2,
		MobCategory category) {
		
		RegistryObject<EntityType<EntityClass>> registryObject = MOB_TYPES.register(name, () -> EntityType.Builder.<EntityClass>of((type, world) -> {
			try {
				return entityClass.getConstructor(EntityType.class, Level.class).newInstance(type, world);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}, category).sized(size1, size2).build(name));

		if (REGISTERED_MOBS == null)
			REGISTERED_MOBS = new ArrayList<>();

		REGISTERED_MOBS.add(new AutoregisteredRegistryObjectMob<>(registryObject, entityClass, rendererClass, modelClasses, name));

		return registryObject;
	}

	public static void register(IEventBus bus) {

		MOB_TYPES.register(bus);
		PROJECTILE_TYPES.register(bus);

		// Register spawn eggs separately after entities are registered
		for (RegistryObject<EntityType<?>> entityRegistry : MOB_TYPES.getEntries()) {

			SPAWN_EGGS.register(entityRegistry.getId().getPath() + "_spawn_egg",
				() -> new ForgeSpawnEggItem(
					() -> (EntityType<? extends Mob>) entityRegistry.get(),
					0x148813,
					666,
					new Item.Properties()
				)
			);			
		}

		SPAWN_EGGS.register(bus);
	}
}
