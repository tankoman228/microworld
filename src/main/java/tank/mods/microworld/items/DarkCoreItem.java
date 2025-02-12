package tank.mods.microworld.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import tank.mods.microworld.worldgen.ModDimensions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

public class DarkCoreItem extends Item {
    public DarkCoreItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getPlayer() instanceof ServerPlayer player) {
        	
            ServerLevel currentWorld = player.server.getLevel(player.level().dimension());
            ServerLevel targetWorld = player.server.getLevel(
                player.level().dimension() == ModDimensions.MICROWORLD_LEVEL_KEY
                    ? Level.OVERWORLD
                    : ModDimensions.MICROWORLD_LEVEL_KEY
            );

            if (targetWorld != null) {
                player.teleportTo(targetWorld, player.getX(), 384, player.getZ(), player.getYRot(), player.getXRot());
                
                // Добавляем задержку (перезарядку)
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 5));
                player.getCooldowns().addCooldown(this, 200); // 10 секунд

                // Звук телепортации
                //targetWorld.playSound(null, targetPos, SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
                player.sendSystemMessage(Component.literal("Вы переместились в " + (targetWorld.dimension() == Level.OVERWORLD ? "Обычный мир" : "Микромир")));
            }

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}