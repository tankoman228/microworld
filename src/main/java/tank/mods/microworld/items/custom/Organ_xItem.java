package tank.mods.microworld.items.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.minecraft.core.Registry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import tank.mods.microworld.items.ModItemBase;

public class Organ_xItem extends ModItemBase {

    public Organ_xItem(Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(6).saturationMod(2f).build()));
    }

    private final MobEffect[] allEffects = {
        MobEffects.ABSORPTION,
        MobEffects.DAMAGE_BOOST,
        MobEffects.DAMAGE_RESISTANCE,
        MobEffects.DIG_SPEED,
        MobEffects.FIRE_RESISTANCE,
        MobEffects.HEALTH_BOOST,
        MobEffects.INVISIBILITY,
        MobEffects.JUMP,
        MobEffects.MOVEMENT_SPEED,
        MobEffects.MOVEMENT_SPEED,
        MobEffects.NIGHT_VISION,
        MobEffects.REGENERATION,
        MobEffects.WATER_BREATHING,
        MobEffects.SATURATION,
        MobEffects.SATURATION,
        MobEffects.SLOW_FALLING,
        MobEffects.CONDUIT_POWER,
        MobEffects.DOLPHINS_GRACE,
        MobEffects.LUCK,
        MobEffects.HERO_OF_THE_VILLAGE,

        MobEffects.WEAKNESS,
        MobEffects.GLOWING,
        MobEffects.LEVITATION,
        MobEffects.DARKNESS,
        MobEffects.HARM,
        MobEffects.BLINDNESS,
        MobEffects.CONFUSION,
        MobEffects.HUNGER,
        MobEffects.POISON,
        MobEffects.WITHER,
        MobEffects.BAD_OMEN,
        MobEffects.DARKNESS,
        MobEffects.MOVEMENT_SLOWDOWN,
        MobEffects.WEAKNESS,

    };    

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player player) {        
            Collections.shuffle(Arrays.asList(allEffects));
            
            for (int i = 0; i < 3 && i < allEffects.length; i++) {
                MobEffect effect = allEffects[i];
                player.addEffect(new MobEffectInstance(effect, 2000, i));
            }        
        }
        return super.finishUsingItem(stack, level, entity);
    }
    
    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
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
