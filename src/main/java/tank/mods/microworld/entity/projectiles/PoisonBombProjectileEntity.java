package tank.mods.microworld.entity.projectiles;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import tank.mods.microworld.entity.Microorganism;
import tank.mods.microworld.entity.Microorganism.MicroorganismType;
import tank.mods.microworld.entity.ModEntities;
import tank.mods.microworld.items.ModItems;

public class PoisonBombProjectileEntity extends ThrowableItemProjectile  {

    private static final int LIFETIME = 1000; 
    
    private int tickCount = 0;

    @Override
    public void tick() {
        super.tick();
        tickCount++;
        if (tickCount >= LIFETIME) {
            this.discard();
        }
    }
    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (!this.level().isClientSide) {
            poisonNearbyEntities();
            this.discard();
        }
    }

    private void poisonNearbyEntities() {
        double radius = 6.0D;
        for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(radius))) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;
                livingEntity.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                    net.minecraft.world.effect.MobEffects.POISON, 200, 3));
                livingEntity.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                    net.minecraft.world.effect.MobEffects.WITHER, 200, 3));
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (!this.level().isClientSide) {
            poisonNearbyEntities();
            this.discard();
        }
    }

    @Override
    protected float getGravity() {
        return 0.04F;
    }


    public PoisonBombProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public PoisonBombProjectileEntity(Level pLevel) {
        super(ModEntities.POISON_BOMB_PROJECTILE.get(), pLevel);
    }

    public PoisonBombProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.POISON_BOMB_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.poison_bomb.get();
    }
}
