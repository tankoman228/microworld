package tank.mods.microworld.mobs;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Помечаем все микроорганизмы. Например, только на них реагирует Лупа
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Microorganism {
    
    public enum MicroorganismType {
        CILLATE,
        BACTERIUM,
        MULTICELLULAR
    }
    
    MicroorganismType value();
}