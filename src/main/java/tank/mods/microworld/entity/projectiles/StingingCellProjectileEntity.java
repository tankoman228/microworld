package tank.mods.microworld.entity.projectiles;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import tank.mods.microworld.entity.Microorganism;
import tank.mods.microworld.entity.Microorganism.MicroorganismType;
import tank.mods.microworld.entity.ModEntities;
import tank.mods.microworld.items.ModItems;

public class StingingCellProjectileEntity extends ThrowableItemProjectile {

    private static final int LIFETIME = 100;
    private int tickCount = 0;

    @Override
    public void tick() {
        super.tick();
        tickCount++;
        if (tickCount >= LIFETIME) {
            this.discard();
        }
        this.setDeltaMovement(this.getDeltaMovement().x * 1.3, this.getDeltaMovement().y * 1.3, this.getDeltaMovement().z * 1.3);     
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (!this.level().isClientSide) {
            this.discard();
        }
    }

    public StingingCellProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public StingingCellProjectileEntity(Level pLevel) {
        super(ModEntities.STINGING_CELL_PROJECTILE.get(), pLevel);
    }

    public StingingCellProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.STINGING_CELL_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        
        Entity entity = entityHitResult.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            Class<?> entityClass = livingEntity.getClass();
            Microorganism microorganism = entityClass.getAnnotation(Microorganism.class);
            
            float damage = 40.0F;
            if (microorganism != null) {
                damage = 80.0F;      
            }
            livingEntity.hurt(this.damageSources().thrown(this, this.getOwner()), damage);

            livingEntity.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                    net.minecraft.world.effect.MobEffects.POISON, 200, 3));
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.stinging_cell.get();
    }
}
