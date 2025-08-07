package tank.mods.microworld.entity.ciliates.paramecium_x;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import tank.mods.microworld.entity.AdvancedAnimationState;
import tank.mods.microworld.entity.Microorganism;
import tank.mods.microworld.entity.Microorganism.MicroorganismType;

@Microorganism(Microorganism.MicroorganismType.CILIATE)
public class ParameciumXEntity extends Dolphin {

	public AdvancedAnimationState animationState = new AdvancedAnimationState(180);

    private final ServerBossEvent bossEvent = new ServerBossEvent(
        Component.translatable("entity.microworld.paramecium_x"),
        BossEvent.BossBarColor.RED,
        BossEvent.BossBarOverlay.PROGRESS
    );

	public ParameciumXEntity(EntityType<? extends Dolphin> p_28316_, Level p_28317_) {
		super(p_28316_, p_28317_);
	}

    public static AttributeSupplier.Builder MobAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 200.0)
            .add(Attributes.ATTACK_DAMAGE, 10.0)
            .add(Attributes.MOVEMENT_SPEED, 0.8)
            .add(Attributes.FOLLOW_RANGE, 60);
    }

	@Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 90.0F));
    }


    private Entity target;
    public float xRotAdd = 0;
    int hurt = 0;

    @Override
    public void tick() {
        super.tick();

        if (hurt > 0) hurt--;

		if (!animationState.isStarted()) {
			animationState.start(180);
		}

        // Поиск цели
        var search = this.level().getEntities(this, this.getBoundingBox().inflate(50.0D), entity -> 
            (entity instanceof Player && !((Player)entity).getAbilities().flying) || 
            (entity.getClass().getAnnotation(Microorganism.class) != null && 
                entity.getClass().getAnnotation(Microorganism.class).value() == MicroorganismType.CILIATE));
    
        if (search.size() > 0) {
            target = search.get(0);  
            this.lookAt(target, 360, 360);    
        } else {
            target = null;
        }

        if (target != null && hurt <= 0) {

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
            if (!level().isClientSide()) {
                Player player = level().getNearestPlayer(this, 12.0D);
                if (player != null) {
                   player.addEffect(new MobEffectInstance(MobEffects.WITHER, 300, 4));                  
                }
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
            if (tickCount % 20 == 0) {
                if (target != null) {
                    double speed = 20.0;
                    setDeltaMovement(dx * speed, dy * speed, dz * speed);
                }          
            }
            else {
                double speed = 3;
                setDeltaMovement(dx * speed, dy * speed, dz * speed);
            }
        } 
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

    @Override
    public boolean hurt(DamageSource source, float amount) {
        hurt += 50;
        this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3000, 4));
        return super.hurt(source, amount);
    }
}
