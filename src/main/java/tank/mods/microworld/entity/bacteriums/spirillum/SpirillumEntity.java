package tank.mods.microworld.entity.bacteriums.spirillum;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import tank.mods.microworld.entity.Microorganism;
import tank.mods.microworld.entity.Microorganism.MicroorganismType;

@Microorganism(MicroorganismType.BACTERIUM)
public class SpirillumEntity extends Dolphin {

    public AnimationState rotateAnimationState = new AnimationState();
    private int rotateFrame = 0; 

    public SpirillumEntity(EntityType<? extends Dolphin> p_28276_, Level p_28277_) {
        super(p_28276_, p_28277_);
    }
    public static AttributeSupplier.Builder MobAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 4D)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.FLYING_SPEED, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();

        rotateFrame++;

        if (this.getDeltaMovement().length() > 0.01)
            rotateAnimationState.startIfStopped(rotateFrame);

        if (rotateFrame > 55) {
            rotateFrame = 0;
            rotateAnimationState.stop();
        }


        if (!level().isClientSide()) {
            Player player = level().getNearestPlayer(this, 12.0D);
            if (player != null) {
               player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100, 2));           
            }
        }
    }
}
