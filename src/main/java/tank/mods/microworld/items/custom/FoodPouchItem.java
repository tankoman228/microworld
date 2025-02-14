package tank.mods.microworld.items.custom;

import java.util.Properties;

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

public class FoodPouchItem extends ModItemBase {
        
    private static final int MIN_DURABILITY = 1;
    
    public FoodPouchItem(Properties properties) {
        super(properties.durability(Integer.MAX_VALUE));
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack pouchStack = player.getItemInHand(hand);

        
        boolean foundFood = false;
        for (int i = 0; i < 9; i++) {
            ItemStack hotbarStack = player.getInventory().getItem(i);
            if (hotbarStack.isEdible()) {
                if (!level.isClientSide) {
                    int repair = hotbarStack.getItem().getFoodProperties().getNutrition() + 
                                (int)(hotbarStack.getItem().getFoodProperties().getSaturationModifier() * 2);

                    pouchStack.setDamageValue(pouchStack.getDamageValue() - repair);
                    hotbarStack.shrink(1);
                    foundFood = true;
                    break;
                }
                return InteractionResultHolder.consume(pouchStack);
            }
        }
        
        if (pouchStack.getDamageValue() >= pouchStack.getMaxDamage() - MIN_DURABILITY) {
            return InteractionResultHolder.fail(pouchStack);
        }
        if (foundFood) {
            return InteractionResultHolder.success(pouchStack);
        }       
        return ItemUtils.startUsingInstantly(level, player, hand);
    }    
    
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            int storedNutrition = stack.getMaxDamage() - stack.getDamageValue();
            if (storedNutrition > 0) {
                int foodLevel = player.getFoodData().getFoodLevel();
                float saturationLevel = player.getFoodData().getSaturationLevel();
                
                int nutritionToUse = Math.min(storedNutrition, 20 - foodLevel);
                if (nutritionToUse > 0) {
                    player.getFoodData().setFoodLevel(foodLevel + nutritionToUse);
                    player.getFoodData().setSaturation(saturationLevel + nutritionToUse * 0.5f);
                    stack.setDamageValue(stack.getDamageValue() + nutritionToUse);
                }
            }
        }
        return stack;
    }
    
    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }
    
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }
        
}
