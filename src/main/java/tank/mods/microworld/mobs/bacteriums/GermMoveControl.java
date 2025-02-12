package tank.mods.microworld.mobs.bacteriums;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.world.entity.ai.control.MoveControl;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class GermMoveControl extends MoveControl {
    
    private final GermEntity germ;
    private final double minDepth;
    private final double maxDepth;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GermMoveControl.class);

    static double xt = 0, yt = 0;
    int dragTimer = 0;
    static int ttimer = 0;
    static int germs = 0;
    
    private static final double SPEED = 1; // Скорость движения к игроку
    private static final double GROUP_DISTANCE = 1.0; // Минимальное расстояние между микробами в группе


    public GermMoveControl(GermEntity germ, double minDepth, double maxDepth) {
        super(germ);
        this.germ = germ;
        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
        germs++;
    }

    @Override
    public void tick() {
        dragTimer++;

        avoidAndAttractGerms();
        
        if (pursuePlayer()) {
        	LOGGER.info("player found!"); 
        } else {
            randomSwimming();
        }

        ttimer++;
        if (ttimer % (50 * germs) == 1) {
            xt = (this.germ.getRandom().nextDouble() - 0.5) * 0.3;
            yt = (this.germ.getRandom().nextDouble() - 0.5) * 0.3;
            LOGGER.info("Move!"); 
        } else if (ttimer % (50 * germs) == 500 * germs) {
            xt = 0;
            yt = 0;
            LOGGER.info("Stop!"); 
        }

        super.tick();
    }

    private void randomSwimming() {
    	
        if (dragTimer % 5 == 0 && this.germ.isInWater()) {
            double y = this.germ.getY();
            double dy = (this.germ.getRandom().nextDouble() - 0.1) * 0.07; 

            if (y < minDepth) {
                dy += 0.4; 
            }
            else if (y > maxDepth) {
                dy -= 0.4; 
            }

            this.germ.setDeltaMovement(
                this.germ.getDeltaMovement().add(
                    xt, 
                    dy, 
                    yt 
                )
            );
        }
    }

    private boolean pursuePlayer() {
    	
        Player nearestPlayer = this.germ.level().getNearestPlayer(this.germ, 10); // Найдём игрока в радиусе 10 блоков
        if (nearestPlayer != null) {
            Vec3 playerPosition = nearestPlayer.position();
            Vec3 germPosition = this.germ.position();

            if (germ.distanceTo(nearestPlayer) <= 2)
            	return false;
            
            // Рассчитываем вектор направления к игроку
            Vec3 direction = playerPosition.subtract(germPosition).normalize();
            
            this.germ.setDeltaMovement(
                direction.x * SPEED * (germ.getRandom().nextDouble() + 0.5) / germ.distanceTo(nearestPlayer), 
                direction.y * SPEED * (germ.getRandom().nextDouble() + 0.5) / germ.distanceTo(nearestPlayer),
                direction.z * SPEED * (germ.getRandom().nextDouble() + 0.5) / germ.distanceTo(nearestPlayer)
            );
            return true;
        }
        return false;
    }
    

    // Поведение при группировании с другими микробами
    private void avoidAndAttractGerms() {
        List<GermEntity> nearbyGerms = this.germ.level().getEntitiesOfClass(GermEntity.class, this.germ.getBoundingBox().inflate(5.0)); // Найдем все микробы в радиусе 5 блоков

        Vec3 attraction = Vec3.ZERO;
        Vec3 repulsion = Vec3.ZERO;
        int count = 0;

        for (GermEntity otherGerm : nearbyGerms) {
            if (otherGerm != this.germ) {
                double distance = this.germ.distanceTo(otherGerm);

                // Если микробы слишком близки, они будут отталкиваться
                if (distance < GROUP_DISTANCE) {
                    Vec3 repelDir = this.germ.position().subtract(otherGerm.position()).normalize().scale(0.1); // Отталкивание
                    repulsion = repulsion.add(repelDir);
                }
                // Если микробы слишком далеко друг от друга, они будут притягиваться
                else if (distance > GROUP_DISTANCE * 2) {
                    Vec3 attractDir = otherGerm.position().subtract(this.germ.position()).normalize().scale(0.05); // Притяжение
                    attraction = attraction.add(attractDir);
                }
                count++;
            }
        }

        // Применяем отталкивание и притяжение
        if (count > 0) {
            this.germ.setDeltaMovement(this.germ.getDeltaMovement().add(attraction).add(repulsion));
        }
    }
}

