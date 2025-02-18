package tank.mods.microworld.entity.ciliates.shoe;


import net.minecraft.world.BossEvent;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeEntity;
import tank.mods.microworld.entity.AdvancedAnimationState;
import tank.mods.microworld.entity.Microorganism;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;

import java.util.Random;

@Microorganism(Microorganism.MicroorganismType.CILIATE)
public class ShoeEntity extends Dolphin implements IForgeEntity {

    private static final double MAX_DISTANCE_TO_PLAYER = 60.0;
    private static final double AVOID_DISTANCE = 5.0;
    private static final int ATTACK_DIRECTION_CHANGE_INTERVAL = 200;
    
    public AdvancedAnimationState animationState = new AdvancedAnimationState(160);
    
    private final ServerBossEvent bossBar = new ServerBossEvent(
        Component.translatable("entity.microworld.shoe"),
        BossEvent.BossBarColor.RED,
        BossEvent.BossBarOverlay.PROGRESS
    );

    private final Random random = new Random();

    public float rotationXRad;
    public float rotationYRad;
    public float rotationZRad;
    public float spinRad = 0;

    public float speed = 0.5f;

    private boolean isBattling;
    
    public ShoeEntity(EntityType<? extends Dolphin> type, Level level) {
        super(type, level);
        updateDirection();
    }
    
    public static AttributeSupplier.Builder MobAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 200.0)
                .add(Attributes.ATTACK_DAMAGE, 10.0)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.FOLLOW_RANGE, MAX_DISTANCE_TO_PLAYER);
    }
    
    @Override
    public void tick() {
        super.tick();
        
        if (!level().isClientSide) {
            Player target = level().getNearestPlayer(this, MAX_DISTANCE_TO_PLAYER);
            if (target != null) {
                if (!isBattling && lastHurtByPlayer != null) {
                    isBattling = true;
                    bossBar.addPlayer((ServerPlayer) target);
                }   
                if (isBattling && tickCount % ATTACK_DIRECTION_CHANGE_INTERVAL == 0) {
                    changeDirectionTowards(target);
                }
            } 
        } else {
            animationState.startIfStopped(tickCount);
        }
        
        if (isNearBlock() && tickCount % 20 == 0) {
            avoidObstacle();
        }
        
        spinRad += 0.02f;
        move();
        
        if (tickCount % 2000 == 0) {
            updateDirection();
        }
    }
    
    private void updateDirection() {
        rotationYRad = (float) Math.toRadians(random.nextInt(360));
        rotationXRad = (float) Math.toRadians(random.nextInt(360));
        rotationZRad = (float) Math.toRadians(random.nextInt(360));
    }

    private void changeDirectionTowards(Player target) {
        Vec3 direction = target.position().subtract(this.position()).normalize();
        rotationYRad = (float) Math.atan2(direction.x, direction.z);
        rotationXRad = (float) Math.asin(direction.y);
        rotationZRad = (float) Math.toRadians(random.nextInt(360)); // Добавляем случайность
    }
    
    private boolean isNearBlock() {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    if (level().getBlockState(blockPosition().offset(dx, dy, dz)).isSolid()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void avoidObstacle() {
        rotationYRad += Math.toRadians(90 + random.nextInt(180));
        rotationXRad += Math.toRadians(90 + random.nextInt(180));
        rotationZRad += Math.toRadians(90 + random.nextInt(180));
    }

    private void move() {
        if (!this.isInWater()) return;

        float dx = speed * (float) Math.sin(rotationYRad) * (float) Math.cos(rotationZRad);
        float dy = speed * (float) Math.sin(rotationZRad);
        float dz = speed * (float) Math.cos(rotationYRad) * (float) Math.cos(rotationZRad);
    
        setDeltaMovement(dx, dy, dz);
    }
    
    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        bossBar.removePlayer(player);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.bossBar.setProgress(this.getHealth() / this.getMaxHealth());
    }
}
