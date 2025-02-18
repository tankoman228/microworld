package tank.mods.microworld.entity.bacteriums.clostridium;

import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import tank.mods.microworld.entity.Microorganism;
import tank.mods.microworld.entity.Microorganism.MicroorganismType;

@Microorganism(MicroorganismType.BACTERIUM)
public class ClostridiumEntity extends Dolphin {

    public AnimationState moveAnimationState = new AnimationState();
    
    private int moveFrame = 0;

    public ClostridiumEntity(EntityType<? extends Dolphin> p_28276_, Level p_28277_) {
        super(p_28276_, p_28277_);
    }

    public static AttributeSupplier.Builder MobAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 4D)
                .add(Attributes.FOLLOW_RANGE, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.FLYING_SPEED, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6) {
            this.moveAnimationState.start(moveFrame);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
}
