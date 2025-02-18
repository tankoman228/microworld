package tank.mods.microworld.entity.multicellular.rotifer;

import org.slf4j.LoggerFactory;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import tank.mods.microworld.entity.AdvancedAnimationState;
import tank.mods.microworld.entity.Microorganism;
import tank.mods.microworld.entity.Microorganism.MicroorganismType;
import tank.mods.microworld.entity.bacteriums.bacillus.BacillusEntity;
import tank.mods.microworld.entity.bacteriums.clostridium.ClostridiumEntity;
import tank.mods.microworld.entity.bacteriums.cyanobacteria.CyanobacteriaEntity;
import tank.mods.microworld.entity.bacteriums.e_coli.E_ColiEntity;
import tank.mods.microworld.entity.bacteriums.germ.GermEntity;
import tank.mods.microworld.entity.bacteriums.nocardia.NocardiaEntity;
import tank.mods.microworld.entity.bacteriums.spirillum.SpirillumEntity;
import tank.mods.microworld.entity.bacteriums.staphylococcus.StaphylococcusEntity;
@Microorganism(MicroorganismType.MULTICELLULAR)
public class RotiferEntity extends Dolphin {

    // Анимации
    public AdvancedAnimationState animation_swim = new AdvancedAnimationState(40);
    public AdvancedAnimationState animation_eat = new AdvancedAnimationState(40);
    public AdvancedAnimationState animation_left_flex = new AdvancedAnimationState(40);
    public AdvancedAnimationState animation_right_flex = new AdvancedAnimationState(32);
    public AdvancedAnimationState animation_flex = new AdvancedAnimationState(1*20);
    public AdvancedAnimationState animation_rotate = new AdvancedAnimationState(1*20);
    public AdvancedAnimationState animation_antiflex = new AdvancedAnimationState(1*20);

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RotiferEntity.class);

    private final ServerBossEvent bossEvent = new ServerBossEvent(
        Component.translatable("entity.microworld.rotifer"),
        BossEvent.BossBarColor.RED,
        BossEvent.BossBarOverlay.PROGRESS
    );

    private boolean enraged = false;
    private Entity target;
    private float lastDamageTime = 0;

    public float xRotAdd = 0;

    public RotiferEntity(EntityType<? extends Dolphin> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 90.0F));
    }

    @Override
    public void tick() {
        super.tick();
        this.animation_swim.startIfStopped(this.tickCount);

        // Проверка на стадию
        if (this.getHealth() <= this.getMaxHealth() * 0.5 && !enraged) {
            enrage();
        }    
        if (enraged) {
            if (random.nextInt(50) == 0) {
                animation_left_flex.startIfStoppedOrFinished(this.tickCount);
            }
            else if (random.nextInt(50) == 0) {
                animation_right_flex.startIfStoppedOrFinished(this.tickCount);
            }
        } 
        else {
            if (random.nextInt(50) == 0) {
                animation_flex.startIfStoppedOrFinished(this.tickCount);
            }
            else if (random.nextInt(50) == 0) {
                animation_antiflex.startIfStoppedOrFinished(this.tickCount);
            }
        }

        // Поиск цели
        var search = this.level().getEntities(this, this.getBoundingBox().inflate(50.0D), entity -> 
            (entity instanceof Player && !((Player)entity).getAbilities().flying) || 
            (entity.getClass().getAnnotation(Microorganism.class) != null && 
                entity.getClass().getAnnotation(Microorganism.class).value() == MicroorganismType.BACTERIUM));
    
        if (search.size() > 0) {
            target = search.get(0);  
            this.lookAt(target, 360, 360);    
        } else {
            target = null;
        }

        if (target != null) {
            // Расчёт углов наводки
            double dx = target.getX() - getX();
            double dy = target.getY() - getY();
            double dz = target.getZ() - getZ();
            float targetPitch = (float) -(Mth.atan2(dy, Math.sqrt(dx * dx + dz * dz)) * (180F / Math.PI));
            xRotAdd += (targetPitch - xRotAdd) * 0.2F;

            // Атака и движение к цели
            if (tickCount % 30 == 0) {

                target.hurt(this.damageSources().mobAttack(this), 1);
            }

            // Если цель близко, наносим больший урон
            if (this.distanceTo(target) < 7 && tickCount % 30 == 0) {
                target.hurt(this.damageSources().mobAttack(this), 10);
                animation_flex.startIfStoppedOrFinished(this.tickCount);
            }

            // Добавление случайных отклонений
            dx += (random.nextDouble() - 0.5) * 12;
            dy += (random.nextDouble() - 0.5) * 12;
            dz += (random.nextDouble() - 0.5) * 12;
            
            // Нормализация вектора
            double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
            dx /= distance;
            dy /= distance;
            dz /= distance;

            // Рывок в сторону цели
            if (tickCount % 200 == 0) {
                if (target != null) {
                    double speed = 4.0;
                    setDeltaMovement(dx * speed, dy * speed, dz * speed);
                }          
            }
            else {
                double speed = 0.1;
                setDeltaMovement(dx * speed, dy * speed, dz * speed);
            }

        } else {
            xRotAdd += (0 - xRotAdd) * 0.1F;
            return;
        }

        // Притяжение цели
        pullTarget();
    }

    final double MAX_SPEED_PULL = 0.01;
    private void pullTarget() {
        if (target == null) return;

        double dx = getX() - target.getX();
        double dy = getY() - target.getY();
        double dz = getZ() - target.getZ();
        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

        double strength = 0.5 / distance / distance;
        strength = Math.signum(strength) * Math.min(Math.abs(strength), MAX_SPEED_PULL);

        target.push(dx * strength, dy * strength, dz * strength);
    }

    private void enrage() {
        enraged = true;
        bossEvent.setColor(BossEvent.BossBarColor.WHITE);
        this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 2));
        animation_rotate.startIfStopped(this.tickCount);
    }

    @Override
    public void startSeenByPlayer(ServerPlayer pServerPlayer) {
        super.startSeenByPlayer(pServerPlayer);
        this.bossEvent.addPlayer(pServerPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer pServerPlayer) {
        super.stopSeenByPlayer(pServerPlayer);
        this.bossEvent.removePlayer(pServerPlayer);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    public static AttributeSupplier.Builder MobAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 200.0)
            .add(Attributes.ATTACK_DAMAGE, 10.0)
            .add(Attributes.MOVEMENT_SPEED, 0.2)
            .add(Attributes.FOLLOW_RANGE, 60);
    }

    // Пример методов для проверки типа блока
    private boolean isWater(BlockPos pos) {
        return level().getBlockState(pos).getBlock() instanceof LiquidBlock; // Проверка водного блока
    }

    private boolean isSolid(BlockPos pos) {
        return level().getBlockState(pos).isSolid(); // Проверка твёрдого блока
    }

    // Ограничение урона
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getEntity() instanceof Player) {
            if (System.currentTimeMillis() - lastDamageTime < 1000) {
                // Ограничиваем урон до 20 единиц в секунду
                amount = Math.min(amount, 20);
            }
            lastDamageTime = System.currentTimeMillis();
        }
        animation_antiflex.startIfStopped(tickCount);
        return super.hurt(source, amount);
    }
}