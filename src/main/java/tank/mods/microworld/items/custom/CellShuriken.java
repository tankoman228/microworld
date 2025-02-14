package tank.mods.microworld.items.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import tank.mods.microworld.entity.projectiles.CellShurikenProjectileEntity;
import tank.mods.microworld.entity.projectiles.PoisonBombProjectileEntity;
import tank.mods.microworld.items.ModItemBase;

public class CellShuriken extends ModItemBase {

    public CellShuriken(Properties properties) {
        super(properties.rarity(Rarity.RARE));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        
        if (!level.isClientSide) {
            var s = new CellShurikenProjectileEntity(level, player);
            s.setItem(itemstack);
            s.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(s);
        }

        if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}
