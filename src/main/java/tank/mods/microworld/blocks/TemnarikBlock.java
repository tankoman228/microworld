package tank.mods.microworld.blocks;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.FastColor;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.items.ItemStackHandler;

public class TemnarikBlock extends Block {
    
    public TemnarikBlock(Properties properties) {
        super(properties.lightLevel(l -> -10));
    }
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TemnarikBlock.class);

    
    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    	
    	
        MakeParticles(state, level, pos);

        if (level.getGameTime() % 20 == 0) {
            applyDarknessEffect(level, pos);
        }

        level.scheduleTick(pos, this, 1);
    }

    private void applyDarknessEffect(ServerLevel level, BlockPos pos) {
        // Применяем эффект тьмы к игрокам
        for (Player player : level.players()) {
        	var dist = player.distanceToSqr(pos.getX(), pos.getY(), pos.getZ());
            if (dist <= 30) {             	
            	if (player.getActiveEffects().isEmpty()) {
                    player.addEffect(new MobEffectInstance(MobEffects.DARKNESS,  600, 100, false, false));
                    player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 600, 100, false, false));
            	}
            }
        }
    }
    
    private void MakeParticles(BlockState state, ServerLevel level, BlockPos pos) {
    	
        for (double j = 0; j < 2; j += 0.04) { 
        	       	
            double xOffset = x(j);
            double yOffset = y(j);
            double zOffset = z(j);

            double x = pos.getX() + xOffset;
            double y = pos.getY() + yOffset; 
            double z = pos.getZ() + zOffset;

            makeParticle(level, x, y, z);           
        }      

        for (double j = 0; j < 0.2; j += 0.03) { 
	       	
            double xOffset = x(j) / 5;
            double yOffset = y(j) * 2;
            double zOffset = z(j) / 5;

            double x = pos.getX() + xOffset;
            double y = pos.getY() + yOffset; 
            double z = pos.getZ() + zOffset;

            makeParticle(level, x, y, z);         
        }
        
        tickChange += 0.05;
    }
    
    private double spiralRadius = 0.7; 
    private double tickChange = 0;
    
    private double x(double i) {	  	
        
    	//return Math.cos(i) * spiralRadius * (Math.sin(i) + 1) / 2; 
    	 return Math.tan(i + tickChange) * spiralRadius * (Math.sin(tickChange) + 1);
    }

    private double y(double i) {
        return Math.cos(i/10 + tickChange / 10) * 1.2;
    }

    private double z(double i) {
        //return Math.sin(i) * spiralRadius * (Math.cos(i) + 1) / 2; 
    	 return Math.tan(i + tickChange + 2) * spiralRadius * (Math.sin(tickChange) + 1);
    }

    
    private void makeParticle(ServerLevel level, double x, double y, double z) {
    	LOGGER.info("Summon at " + x + " " + y + " " + z);
        level.sendParticles(ParticleTypes.SQUID_INK, x + 0.5, y + 0.5, z + 0.5, 2, 0.8f, 0.2f, 0.8f, 0);
    }
    
    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, world, pos, oldState, isMoving);   
        LOGGER.info("TemnarikBlock placed at " + pos); 
        world.scheduleTick(pos, this, 20);  // Сразу установить тик после размещения
    }
    
    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
    	LOGGER.info("TemnarikBlock removed from " + pos); // Отладочный вывод
        super.onRemove(state, world, pos, newState, isMoving);
    }

}
