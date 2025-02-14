package tank.mods.microworld.items.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import tank.mods.microworld.entity.projectiles.PoisonBombProjectileEntity;
import tank.mods.microworld.entity.projectiles.StingingCellProjectileEntity;
import tank.mods.microworld.items.ModItemBase;

public class StingingCellItem extends ModItemBase {

    public StingingCellItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        
        if (!level.isClientSide) {
            var projectile = new StingingCellProjectileEntity(level, player);
            projectile.setItem(itemstack);
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(projectile);
        }

        if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}
