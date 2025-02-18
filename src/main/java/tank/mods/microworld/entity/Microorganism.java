package tank.mods.microworld.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.eventbus.api.IEventBus;

/**
 * Для того, чтобы пометить все микроорганизмы. Например, только на них реагирует Лупа
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Microorganism {
    
    public enum MicroorganismType {
        CILLATE,
        BACTERIUM,
        MULTICELLULAR,
        PLANT,
        AMOEBA
    }
    
    MicroorganismType value();

    Class<?> attributeSupplier() default AttributeSupplier.Builder.class;


}