package tank.mods.microworld.mobs.bacteriums.e_coli;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import tank.mods.microworld.mobs.Microorganism;
import tank.mods.microworld.mobs.Microorganism.MicroorganismType;
import tank.mods.microworld.mobs.bacteriums.bacillus.BacillusEntity;

@Microorganism(MicroorganismType.BACTERIUM)
public class E_ColiEntity extends Turtle {

    public AnimationState rotateAnimationState = new AnimationState();
    public AnimationState divideAnimationState = new AnimationState();

    private int divideFrame = DIVIDE_ANIMATION_LENGTH + 1;

    public E_ColiEntity(EntityType<? extends Turtle> p_28276_, Level p_28277_) {
        super(p_28276_, p_28277_);
    }

    private boolean isTamed = false;
    private static final int DIVIDE_ANIMATION_LENGTH = 35;
    
    @Override
    public void tick() {
        super.tick();
        
        if (this.level().isClientSide && this.random.nextFloat() < 0.001f) {
            this.rotateAnimationState.stop();
            this.rotateAnimationState.startIfStopped(this.tickCount);          
        }
        
        if (divideFrame < DIVIDE_ANIMATION_LENGTH) {      
            
            divideFrame++;
            if (this.level().isClientSide) {
                this.divideAnimationState.startIfStopped(this.tickCount);
            }
            else if (divideFrame == DIVIDE_ANIMATION_LENGTH) {
                E_ColiEntity newEColi = (E_ColiEntity) this.getType().create(this.level());
                if (newEColi != null) {
                    newEColi.moveTo(this.getX(), this.getY(), this.getZ());
                    this.level().addFreshEntity(newEColi);
                }
            }         
        }
        if (isTamed) {
            Player player = level().getNearestPlayer(this, 24.0D);
            if (player != null) {
                this.getNavigation().moveTo(player, 1.0D);
                LivingEntity lastHurtByMob = player.getLastHurtByMob();
                if (lastHurtByMob != null) {
                    this.getNavigation().moveTo(lastHurtByMob, 3.0D);
                    if (this.distanceTo(lastHurtByMob) <= 2.0D) {
                        lastHurtByMob.hurt(this.damageSources().mobAttack(this), 2.0F);
                    }
                }
            }
        }
    }
    
    @Override
    public InteractionResult mobInteract(@javax.annotation.Nonnull Player player, @javax.annotation.Nonnull InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.is(Items.SUGAR)) {
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);

                if (this.random.nextFloat() < 0.2f) {
                    divideFrame = -1;
                }
                
                if (!this.isTamed && this.random.nextFloat() < 0.1f) {
                    this.isTamed = true;
                    this.level().addParticle(net.minecraft.core.particles.ParticleTypes.HEART, 
                        this.getX(), this.getY() + 0.5D, this.getZ(),
                        0.0D, 0.0D, 0.0D);
                }

                for (int i = 0; i < 7; i++) {
                    this.level().addParticle(net.minecraft.core.particles.ParticleTypes.HAPPY_VILLAGER,
                        this.getX() + (this.random.nextDouble() - 0.5D) * 0.5D,
                        this.getY() + 0.5D,
                        this.getZ() + (this.random.nextDouble() - 0.5D) * 0.5D,
                        0.0D, 0.0D, 0.0D);
                }
            }           
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 4D)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.MOVEMENT_SPEED, 0.1D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.FLYING_SPEED, 0.01f);
    }
}