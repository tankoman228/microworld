package tank.mods.microworld.items.custom;

import java.util.Properties;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import tank.mods.microworld.items.ModItemBase;

public class GermBootsItem extends ModItemBase {
    
    public GermBootsItem(Properties properties) {
        super(properties.rarity(Rarity.EPIC));
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.displayClientMessage(Component.translatable("microworld.germ_boots.use"), false);
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
