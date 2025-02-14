package tank.mods.microworld.items.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import tank.mods.microworld.entity.projectiles.SanitizerProjectileEntity;
import tank.mods.microworld.items.ModItemBase;

public class SanitizerItem extends ModItemBase {
    
    public SanitizerItem(Properties properties) {
        super(properties.durability(64).rarity(Rarity.RARE));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        
        if (!level.isClientSide) {
            // Создаем несколько снарядов с небольшим разбросом
            for (int i = 0; i < 7; i++) {
                SanitizerProjectileEntity projectile = new SanitizerProjectileEntity(level, player);
                float spreadFactor = 10F;
                float xRot = player.getXRot() + (level.getRandom().nextFloat() - 0.5F) * spreadFactor;
                float yRot = player.getYRot() + (level.getRandom().nextFloat() - 0.5F) * spreadFactor;
                projectile.shootFromRotation(player, xRot, yRot, 0.0F, 1.5F, 1.0F);
                projectile.setNoGravity(true);
                level.addFreshEntity(projectile);
            }
            
            level.playSound(null, player.getX(), player.getY(), player.getZ(), 
                        SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 
                        0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

            itemstack.setDamageValue(itemstack.getDamageValue() + 1);
            if (itemstack.getDamageValue() >= itemstack.getMaxDamage()) {
                itemstack.shrink(1);
            }
        }
        
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}
