package tank.mods.microworld.entity.plants.diatom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.level.Level;
import tank.mods.microworld.entity.Microorganism;
import tank.mods.microworld.entity.Microorganism.MicroorganismType;

@Microorganism(MicroorganismType.PLANT)
public class DiatomEntity extends Cod {

    private static final EntityDataAccessor<Integer> SHAPE_VARIANT = 
        SynchedEntityData.defineId(DiatomEntity.class, EntityDataSerializers.INT);

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHAPE_VARIANT, 0);
    }

    public DiatomEntity(EntityType<? extends Cod> p_28276_, Level p_28277_) {
        super(p_28276_, p_28277_);
    } 
    
    @Override
    public void tick() {
        super.tick();
        
        if (!this.level().isClientSide) {
            // Very slow movement
            this.setDeltaMovement(this.getDeltaMovement().scale(0.2));
            
            // Minimal random movement
            if (this.random.nextInt(100) == 2) {
                double moveX = (this.random.nextDouble() - 0.5) * 0.02;
                double moveY = (this.random.nextDouble() - 0.5) * 0.01;
                double moveZ = (this.random.nextDouble() - 0.5) * 0.02;
                this.setDeltaMovement(moveX, moveY, moveZ);
            }
        }
    }

    @Override
    public void travel(net.minecraft.world.phys.Vec3 travelVector) {
        // Reduce speed and rotation
        this.setSpeed(0.02f);
        super.travel(travelVector);
    }

    @Override
    public boolean canBeLeashed(net.minecraft.world.entity.player.Player player) {
        return false;
    }

    // Set random shape variant on spawn
    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        if (!level().isClientSide) {
            setShapeVariant(this.random.nextInt(3)); // For 3 different shapes
        }
    }

    public int getShapeVariant() {
        return this.entityData.get(SHAPE_VARIANT);
    }

    public void setShapeVariant(int variant) {
        this.entityData.set(SHAPE_VARIANT, variant);
    }
}
