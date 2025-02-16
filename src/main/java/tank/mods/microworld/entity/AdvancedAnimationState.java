package tank.mods.microworld.entity;

import net.minecraft.world.entity.AnimationState;

/**
 * Класс, расширяющий AnimationState из Minecraft, помогает автоматически останавливать анаимацию
 * для начала сначала
 */
public class AdvancedAnimationState extends AnimationState {
    private final long duration;
    private long startTick = 0;

    // Конструктор, который принимает продолжительность анимации в тиках
    public AdvancedAnimationState(long duration) {
        this.duration = duration;
    }

    // Метод для начала анимации, если она остановлена или завершена
    public void startIfStoppedOrFinished(int currentTick) {
        if (currentTick >= startTick + duration) {
            this.startTick = currentTick;  
            stop();
            startIfStopped(currentTick); 
        } 
    }
}
