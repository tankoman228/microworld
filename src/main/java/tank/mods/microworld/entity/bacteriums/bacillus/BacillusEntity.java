package tank.mods.microworld.entity.bacteriums.bacillus;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import tank.mods.microworld.entity.Microorganism;
import tank.mods.microworld.entity.Microorganism.MicroorganismType;

@Microorganism(MicroorganismType.BACTERIUM)
public class BacillusEntity extends Cod {
    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout;
    private boolean hasBeenFed = false;
    private int spawnChildrenTimer = 0;

    public BacillusEntity(EntityType<? extends Cod> p_28276_, Level p_28277_) {
        super(p_28276_, p_28277_);
    }
    
    public static AttributeSupplier.Builder createAttributes() {
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

        if (this.level().isClientSide()) {
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = 400;
                this.idleAnimationState.start(this.tickCount);

                this.setDeltaMovement(
                    (random.nextDouble() - 0.5) * 1.5,
                    (random.nextDouble() - 0.5) * 1.5,
                    (random.nextDouble() - 0.5) * 1.5
                );
            } else {
                --this.idleAnimationTimeout;
            }
            if (hasBeenFed) {

                this.level().addParticle(
                    ParticleTypes.END_ROD,
                    this.getX(), this.getY(), this.getZ(),
                    0, 0, 0
                );
            }
        }
        else {
            if (hasBeenFed) {
                spawnChildrenTimer++;
                
                if (spawnChildrenTimer >= 35) { 
                    spawnChildren();
                    hasBeenFed = false;
                    this.kill();
                }
            }
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.is(Items.SUGAR) && !hasBeenFed) {
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }
            hasBeenFed = true;
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    private void spawnChildren() {

        for (int i = 0; i < 2; i++) {
            BacillusEntity child = (BacillusEntity) this.getType().create(this.level());
            if (child != null) {
                child.moveTo(this.getX(), this.getY(), this.getZ());
                this.level().addFreshEntity(child);
            }
        }
    }
}