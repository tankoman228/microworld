package tank.mods.microworld.items.custom;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import tank.mods.microworld.items.ModItemBase;
import tank.mods.microworld.worldgen.ModDimensions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

public class DarkCoreItem extends ModItemBase {
    
    public DarkCoreItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
    
        if (context.getPlayer() instanceof ServerPlayer player) {
            player.disconnect();
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}