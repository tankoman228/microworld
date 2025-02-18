package tank.mods.microworld.entity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.ArrayList;
import java.util.List;

import org.stringtemplate.v4.compiler.CodeGenerator.primary_return;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import tank.mods.microworld.MicroworldMod;
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusEntity;
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusModel;
import tank.mods.microworld.entity.bacteriums.germ.GermRenderer;
import tank.mods.microworld.entity.projectiles.PoisonBombProjectileEntity;


public class AutoregisteredRegistryObjectMob
< EntityClass extends Mob,
  EntityRendererClass extends MobRenderer<EntityClass, EntityModel<EntityClass>>> {
    
    private EntityType<EntityClass> type;
    private String name;
    private Class<EntityRendererClass> rendererClass;
    private List<Class<? extends EntityModel<?>>> modelClasses;
    private RegistryObject<EntityType<EntityClass>> registryObject;
    private Class<EntityClass> entityClass;

    public AutoregisteredRegistryObjectMob(
        RegistryObject<EntityType<EntityClass>> registryObject, 
        Class<EntityClass> entityClass,
        Class<EntityRendererClass> rendererClass,
        List<Class<? extends EntityModel<?>>> modelClasses,
        String name) {

        this.name = name;
        this.rendererClass = rendererClass;
        this.modelClasses = modelClasses;
        this.registryObject = registryObject;
        this.entityClass = entityClass;
    }

    public void RegisterBus(EntityAttributeCreationEvent event) {
        type = registryObject.get();

        try {
            // Форсирование загрузки
            ClassLoader classLoader = getClass().getClassLoader();
            classLoader.loadClass(entityClass.getName());

            // Ищем метод createAttributes в классе существа
            Method createAttributesMethod = entityClass.getMethod("MobAttributes");
            
            // Вызываем метод createAttributes() для данного класса
            AttributeSupplier.Builder attributesBuilder = (AttributeSupplier.Builder) createAttributesMethod.invoke(null);
            
            // Регистрируем атрибуты
            event.put(type, attributesBuilder.build());
        } catch (Exception e) {

            var getDeclared = entityClass.getMethods();
            String bibki = "Found only methods of " + entityClass.getName() + " : " ;
            for (var field : getDeclared) {
                bibki += field.getName() + "\n";
            }

            throw new RuntimeException("атрибуты башка кирпич савсэм мёртвый " + e.getClass().getName() + " " + e.getMessage() + " " + bibki);
        }
    }

    public void RegisterClientBus(EntityRenderersEvent.RegisterLayerDefinitions event) {
        type = registryObject.get();
        List<ModelLayerLocation> layers = new ArrayList<>();
        try {         
            int i = 0;
            for (var modelClass : modelClasses) {
                i++;
                var layer = new ModelLayerLocation(
                    new ResourceLocation(MicroworldMod.MODID, name + "_layer" + i),
                    "main");
                event.registerLayerDefinition(
                    layer,
                    () -> {
                        try {
                            return (LayerDefinition) modelClass.getDeclaredMethod("createBodyLayer").invoke(null);
                        } catch (Exception e) {
                            throw new RuntimeException("Ошибка при регистрации слоя модели " + name, e);
                        }
                    }
                );
                layers.add(layer);
            }
            if (i == 0) {
                throw new RuntimeException("Нифига не нашёл слоёв" + name);
            }

            EntityRenderers.register(type, ctx -> {
                try {
                    return rendererClass.getDeclaredConstructor(EntityRendererProvider.Context.class, List.class).newInstance(ctx, layers);
                } catch (Exception e) {
                    throw new RuntimeException("Error creating renderer instance for " + name, e);
                }
            });

        } catch (Exception e) {
            throw new RuntimeException("Ошибка при регистрации " + name, e);
        }
    }
}