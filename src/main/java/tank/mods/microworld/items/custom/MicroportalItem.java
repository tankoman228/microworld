package tank.mods.microworld.items.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import tank.mods.microworld.blocks.ModBlocks;
import tank.mods.microworld.items.ModItemBase;
import tank.mods.microworld.worldgen.ModDimensions;

public class MicroportalItem extends ModItemBase {

    public MicroportalItem(Properties properties) {
        super(properties.rarity(Rarity.RARE));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer() instanceof ServerPlayer player) {

            // Проверяем, использован ли портал на допустимом блоке
            if (player.level().dimension() == ModDimensions.MICROWORLD_LEVEL_KEY || 
                context.getLevel().getBlockState(context.getClickedPos()).is(ModBlocks.substratum.get())) {
                
                ServerLevel targetWorld = player.server.getLevel(
                    player.level().dimension() == ModDimensions.MICROWORLD_LEVEL_KEY
                        ? Level.OVERWORLD
                        : ModDimensions.MICROWORLD_LEVEL_KEY
                );
                
                if (targetWorld != null) {
                    double targetY;
                    if (targetWorld.dimension() == Level.OVERWORLD) {
                        // Находим безопасную позицию для телепортации в обычном мире
                        BlockPos targetPos = targetWorld.getHeightmapPos(net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 
                            new BlockPos((int)player.getX(), 0, (int)player.getZ()));
                        targetY = targetPos.getY() + 1;
                    } else {
                        // Для микромира используем фиксированную высоту
                        targetY = 374;
                    }

                    player.teleportTo(targetWorld, player.getX(), targetY, player.getZ(), player.getYRot(), player.getXRot());
                    
                    player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 5));
                    
                    if (targetWorld.dimension() == Level.OVERWORLD) {
                        player.getCooldowns().addCooldown(this, 1000);   
                    }
                    else {
                        player.getCooldowns().addCooldown(this, 10000); 
                    }
                    player.sendSystemMessage(Component.literal(targetWorld.dimension() == Level.OVERWORLD ? "🌍" : "🦠"));
                }

                return InteractionResult.SUCCESS;
            } else {
                player.sendSystemMessage(Component.translatable("item.microworld.microportal.error"));
                return InteractionResult.FAIL;
            }
        }
        return InteractionResult.PASS;
    }}
