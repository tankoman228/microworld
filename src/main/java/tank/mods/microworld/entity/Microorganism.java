package tank.mods.microworld.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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
}