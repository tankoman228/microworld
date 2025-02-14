package tank.mods.microworld.entity.projectiles;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import tank.mods.microworld.entity.ModEntities;
import tank.mods.microworld.items.ModItems;

public class CellShurikenProjectileEntity extends ThrowableItemProjectile {
    
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
        double radius = 2.0D;
        for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(radius))) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;
                livingEntity.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                    net.minecraft.world.effect.MobEffects.POISON, 200, 7));
                livingEntity.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                    net.minecraft.world.effect.MobEffects.WITHER, 200, 7));
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


    public CellShurikenProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public CellShurikenProjectileEntity(Level pLevel) {
        super(ModEntities.CELL_SHURIKEN_PROJECTILE.get(), pLevel);
    }

    public CellShurikenProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.CELL_SHURIKEN_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.cell_shuriken.get();
    }
}
