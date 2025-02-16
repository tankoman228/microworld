package tank.mods.microworld.entity.multicellular.rotifer;

import java.util.logging.Logger;

import javax.annotation.Nullable;

import org.slf4j.LoggerFactory;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import tank.mods.microworld.blocks.TemnarikBlock;
import tank.mods.microworld.entity.Microorganism;
import tank.mods.microworld.entity.Microorganism.MicroorganismType;
import tank.mods.microworld.entity.bacteriums.germ.GermEntity;
import tank.mods.microworld.entity.multicellular.worm.WormAttackGoal;

@Microorganism(MicroorganismType.MULTICELLULAR)
public class RotiferEntity extends Guardian {

    public AnimationState swim = new AnimationState();
    public AnimationState eat = new AnimationState();
    public AnimationState left_flex = new AnimationState();
    public AnimationState right_flex = new AnimationState();
    public AnimationState flex = new AnimationState();
    public AnimationState rotate = new AnimationState();
    public AnimationState antiflex = new AnimationState();

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RotiferEntity.class);

    private final ServerBossEvent bossEvent = new ServerBossEvent(
        Component.translatable("entity.microworld.rotifer"),
        BossEvent.BossBarColor.RED,
        BossEvent.BossBarOverlay.PROGRESS
    );

    private boolean enraged = false;
    public Entity target;

    public RotiferEntity(EntityType<? extends Guardian> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 15.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void tick() {
        super.tick();
        this.swim.startIfStopped(this.tickCount);

        if (this.getHealth() <= this.getMaxHealth() * 0.5 && !enraged) {
            enrage();
        }

        var search = this.level().getEntities(this, this.getBoundingBox().inflate(50.0D), entity -> 
            entity instanceof Player && !((Player)entity).getAbilities().instabuild || 
            (entity.getClass().getAnnotation(Microorganism.class) != null && 
             entity.getClass().getAnnotation(Microorganism.class).value() == MicroorganismType.BACTERIUM));
   
        if (search.size() > 0) {
            target = search.get(0);
            //LOGGER.info("Цель задана!");
            setTarget((LivingEntity)target);           
        }
        else {
            target = null;
        }
        pullTarget();
    }

    private void pullTarget() {

        if (target == null) return;
        double dx = getX() - target.getX();
        double dy = getY() - target.getY();
        double dz = getZ() - target.getZ();
        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

        double strength = 0.1;
        target.push(
            dx / distance * strength,
            dy / distance * strength,
            dz / distance * strength
        );
    }

    
    private void enrage() {
        enraged = true;
        bossEvent.setColor(BossEvent.BossBarColor.WHITE);
        this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 2));
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

        if (target != null) {
            double distance = this.distanceTo(target);

            this.lookAt(target, 30.0F, 30.0F);

            if (this.tickCount % 40 == 0) {
                this.eat.startIfStopped(this.tickCount);

                if (distance < 2) {
                    target.hurt(this.damageSources().mobAttack(this), 10.0F);
                }
            }
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 200.0)
            .add(Attributes.ATTACK_DAMAGE, 10.0)
            .add(Attributes.MOVEMENT_SPEED, 0.2)
            .add(Attributes.FOLLOW_RANGE, 60);
    }
}
