package tank.mods.microworld.items.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import tank.mods.microworld.items.ModItemBase;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class FlagellarMotorItem extends ModItemBase {

    public FlagellarMotorItem(Properties properties) {
        super(properties.durability(64));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (player instanceof Player && player.isInWater()) {
            Vec3 lookVec = player.getLookAngle();
            double speed = 1.5;
            
            player.setDeltaMovement(
                player.getDeltaMovement().add(
                    lookVec.x * speed,
                    lookVec.y * speed,
                    lookVec.z * speed
                )
            );
            
            ItemStack itemstack = player.getItemInHand(hand);
            ItemStack sugarStack = findSugar(player);
            
            if (sugarStack != null && !sugarStack.isEmpty()) {
                sugarStack.shrink(1);
            } else {
                itemstack.hurtAndBreak(1, player, (p_41288_) -> {
                    p_41288_.broadcastBreakEvent(hand);
                });
            }

            return InteractionResultHolder.success(player.getItemInHand(hand));
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }

    private ItemStack findSugar(Player player) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (stack.getItem() == net.minecraft.world.item.Items.SUGAR) {
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }
}
