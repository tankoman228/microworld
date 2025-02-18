package tank.mods.microworld.entity.multicellular.worm;

import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.level.Level;
import tank.mods.microworld.entity.Microorganism;
import tank.mods.microworld.entity.Microorganism.MicroorganismType;
import tank.mods.microworld.entity.bacteriums.germ.GermEntity;
import net.minecraft.world.BossEvent;

@Microorganism(MicroorganismType.MULTICELLULAR)
public class WormEntity extends Axolotl {

    public static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(WormEntity.class, EntityDataSerializers.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    
    public final AnimationState swimAnimationState = new AnimationState();
    public final AnimationState damagedAnimationState = new AnimationState();
    
    public WormEntity(EntityType<? extends Axolotl> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    
    public static AttributeSupplier.Builder MobAttributes() {

        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.ARMOR_TOUGHNESS, 1f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 5f);
    }
    
    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }
    
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 80; 
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()) {
            attackAnimationState.stop();
        }
        
        if (this.isInWater()) {
        
        	
            swimAnimationState.start(300);
        } else {
            swimAnimationState.stop();
        }
    }
    
    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.SWIMMING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean flag = super.hurt(source, amount);
        if (flag) {
            damagedAnimationState.start(this.tickCount);
        }
            
        return flag;
    }
    
    /*
    @Override
    protected ResourceLocation getDefaultLootTable() {
        return new ResourceLocation(MicroworldMod.MODID, MicroworldMod.MODID + "loot_tables/entity/germ");
    }*/

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }
    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }
    
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }
    
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new WormAttackGoal(this, 2, true));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1.0, 10));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, GermEntity.class, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 12.2, false));
    }
    
    @Override
    public boolean isPersistenceRequired() {
        return true; // Запрещает исчезновение при удалении игроков
    }

}

