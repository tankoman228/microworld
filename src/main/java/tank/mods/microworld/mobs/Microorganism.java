package tank.mods.microworld.mobs;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

/**
 * Базовый класс для микроорганизмов, содержит интерфейс для лупы (и пупы).
 * Хранится тип микроорганизма, в будущем расширю
 */
public abstract class Microorganism extends Axolotl {

    public enum MicroorganismType {
        CILLATE,
        BACTERIUM,
        MULTICELLULAR
    }

    public MicroorganismType m_type;

    protected Microorganism(EntityType<? extends Axolotl> entityType, Level level, MicroorganismType type) {
        super(entityType, level);
        this.m_type = type;
    }

    public void ViewDescriptionForMagnifier(Player player) {
        player.displayClientMessage(Component.translatable("microworld.type." + m_type.toString().toLowerCase()), false);
        player.displayClientMessage(GetDescriptionForMagnifier(), false);
    }

    protected MutableComponent GetDescriptionForMagnifier() {
        return Component.translatable("microworld.description." + this.getClass().getSimpleName().toLowerCase().replace("entity", ""));
    }
}
