package tank.mods.microworld.entity.projectiles;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import tank.mods.microworld.blocks.ModBlocks;
import tank.mods.microworld.entity.Microorganism;
import tank.mods.microworld.entity.Microorganism.MicroorganismType;
import tank.mods.microworld.entity.ModEntities;
import tank.mods.microworld.items.ModItems;

public class SanitizerProjectileEntity extends ThrowableItemProjectile {
private static final int LIFETIME = 100; // 5 seconds (20 ticks per second)
    
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
            this.discard();
        }
    }

    public SanitizerProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SanitizerProjectileEntity(Level pLevel) {
        super(ModEntities.SANITIZER_PROJECTILE.get(), pLevel);
    }

    public SanitizerProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.SANITIZER_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        
        Entity entity = entityHitResult.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            Class<?> entityClass = livingEntity.getClass();
            Microorganism microorganism = entityClass.getAnnotation(Microorganism.class);
            
            if (microorganism != null) {
                float damage = 10.0F;
                if (microorganism.value() == MicroorganismType.BACTERIUM) {
                    damage = 666.0F;
                }
                livingEntity.hurt(this.damageSources().thrown(this, this.getOwner()), damage);
            }
        }
    }
    @Override
    protected Item getDefaultItem() {
        return ModItems.spirit_bubble.get();
    }
}
