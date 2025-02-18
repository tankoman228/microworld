package tank.mods.microworld.items.custom;

import java.util.Random;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import tank.mods.microworld.entity.projectiles.StingingCellProjectileEntity;
import tank.mods.microworld.items.ModItemBase;

public class StingingSwordItem extends ModItemBase {

    Random Random = new Random();

    public StingingSwordItem(Properties properties) {
        super(properties.durability(2500).rarity(Rarity.EPIC));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        
        if (!level.isClientSide) {
            StingingCellProjectileEntity projectile = new StingingCellProjectileEntity(level, player);
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(projectile);
            
            // Damage the sword by 1/8 of its max durability
            double damage = itemstack.getMaxDamage() / 8D * Random.nextDouble();
            itemstack.hurtAndBreak((int)damage, player, (p) -> p.broadcastBreakEvent(hand));
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        float maxHealth = target.getMaxHealth();
        float currentHealth = target.getHealth();
        float damage = Math.max(Math.min(currentHealth * 0.1f, 20.0f), 10f); // 10% health but max 10 hearts (20 health points)
        
        target.hurt(target.damageSources().generic(), damage);
        stack.hurtAndBreak(1, attacker, (p) -> p.broadcastBreakEvent(InteractionHand.MAIN_HAND));
        
        return true;
    }
}
