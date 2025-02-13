package tank.mods.microworld.items.custom;

import java.util.Arrays;
import java.util.Collections;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import tank.mods.microworld.items.ModItemBase;

public class VacuoleItem extends ModItemBase {
    
    public VacuoleItem(Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(6).saturationMod(2f).build()));
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1)); 
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0)); 
            player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2400, 0)); 
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 0));
        }
        return super.finishUsingItem(stack, level, entity);
    }
    
    @Override
    public int getUseDuration(ItemStack stack) {
        return 64;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }
}
