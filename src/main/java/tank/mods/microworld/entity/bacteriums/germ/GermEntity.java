package tank.mods.microworld.entity.bacteriums.germ;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import tank.mods.microworld.entity.Microorganism;
import tank.mods.microworld.entity.Microorganism.MicroorganismType;

@Microorganism(MicroorganismType.BACTERIUM)
public class GermEntity extends Pufferfish {

	public GermEntity(EntityType<? extends Pufferfish> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
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
    public MobType getMobType() {
        return MobType.WATER;
    }

    /*
	@Override
	public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob p_146744_) {
		return ModEntities.Germ.get().create(pLevel);
	}
	
	@Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.SUGAR);
    }*/
	
    @Override
    protected void registerGoals() {
        // Плавает случайным образом
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1.0, 10));

        // Преследует игрока в радиусе 6 блоков
        this.targetSelector.addGoal(30, new NearestAttackableTargetGoal<>(this, Player.class, true));

        // Атакует игрока, если рядом (радиус 1 блока)
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 2.2, false));

        // Избегает спрутов (Squid) в радиусе 8 блоков
        this.goalSelector.addGoal(5, new AvoidEntityGoal<>(this, Squid.class, 8.0F, 1.5, 2.0));
    }

    
}
