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

public class GermItem extends ModItemBase {

    public GermItem(Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(6).saturationMod(2f).build()));
    }

    // Test command: /give @p microworld:germ{type:"e_coli"} 1
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            if (stack.hasTag() && stack.getTag().contains("type")) {
                String effect = stack.getTag().getString("type");
                switch (effect.toLowerCase()) {
                    case "e_coli":
                        player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 1000, 2));
                        break;
                    case "staphylococcus":
                        player.addEffect(new MobEffectInstance(MobEffects.POISON, 1000, 2));
                        break;
                    case "spirillum":
                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1000, 2));
                        break;
                    case "nocardia":
                        player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 1000, 2));
                        break;
                    case "bacillus":
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 2));
                        break;
                    case "clostridium":
                        player.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 1000, 2));
                        break;
                    case "cyanobacteria":
                        player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 1000, 2));
                        break;
                    case "germ":
                        player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 1000, 2));
                        break;
                    default:
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 2));
                }
            } else {
                player.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 2000, 2));
            }
        }
        return super.finishUsingItem(stack, level, entity);
    }
    
    @Override
    public int getUseDuration(ItemStack stack) {
        return 8;
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
