package tank.mods.microworld.items.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import tank.mods.microworld.entity.Microorganism;
import tank.mods.microworld.entity.Microorganism.MicroorganismType;
import tank.mods.microworld.items.ModItemBase;

public class SpiritBubbleItem extends ModItemBase {

    public SpiritBubbleItem(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        
        var type = target.getClass().getAnnotation(Microorganism.class);
        if (type != null) {

            if (type.value() == MicroorganismType.BACTERIUM) {
                target.hurt(target.damageSources().magic(), 100.0F);
            } else {
                target.hurt(target.damageSources().magic(), 10.0F);
            }
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
