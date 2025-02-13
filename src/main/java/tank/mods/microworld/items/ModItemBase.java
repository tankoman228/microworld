package tank.mods.microworld.items;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

/**
 * Для автоматической загрузки из строк для описаний предметов
 */
public class ModItemBase extends Item {

    public ModItemBase(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level pLevel, List<Component> tooltip, TooltipFlag flag ) {        
        tooltip.add(Component.translatable("tooltip.microworld." + tooltip.get(0).getString().toLowerCase().replace(" ", "_")));
        super.appendHoverText(stack, pLevel, tooltip, flag);
    }
}
