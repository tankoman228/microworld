package tank.mods.microworld.mobs.bacteriums.germ;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import tank.mods.microworld.mobs.Microorganism;

public class GermEntity extends Microorganism {

	public GermEntity(EntityType<? extends Axolotl> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, MicroorganismType.BACTERIUM);
        this.moveControl = new GermMoveControl(this, 0, 150);
    }
	
    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 2D)
                .add(Attributes.FOLLOW_RANGE, 2D)
                .add(Attributes.MOVEMENT_SPEED, 2D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.FLYING_SPEED, 2f);
    }
    
    @Override
    public void tick() {
        super.tick();

        // Сглаживание поворота
        if (this.isInWater()) {
            Vec3 velocity = this.getDeltaMovement();
            if (velocity.lengthSqr() > 0.001) { // Проверяем, движется ли он вообще
                double angle = Math.toDegrees(Math.atan2(velocity.z, velocity.x)) - 90; // Направление движения
                this.setYRot((float) angle);
                this.yBodyRot = this.getYRot(); // Устанавливаем поворот тела
            }
        }
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
        
        // Смотрит по сторонам
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));

        // Преследует игрока в радиусе 6 блоков
        this.targetSelector.addGoal(30, new NearestAttackableTargetGoal<>(this, Player.class, true));

        // Атакует игрока, если рядом (радиус 1 блока)
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 2.2, false));

        // Избегает спрутов (Squid) в радиусе 8 блоков
        this.goalSelector.addGoal(5, new AvoidEntityGoal<>(this, Squid.class, 8.0F, 1.5, 2.0));
    }
}
