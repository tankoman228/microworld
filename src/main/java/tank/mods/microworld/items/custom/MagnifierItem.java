package tank.mods.microworld.items.custom;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import tank.mods.microworld.items.ModItemBase;
import tank.mods.microworld.mobs.Microorganism;

public class MagnifierItem extends ModItemBase {

    public MagnifierItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
       
        Vec3 lookVec = player.getLookAngle();
        Vec3 startVec = player.getEyePosition();

        double distance = 0;
        List<Entity> entities = new ArrayList();
        
        while (entities.isEmpty() && distance < 30) {

            distance += 1.5;
            Vec3 endVec = startVec.add(lookVec.x * distance, lookVec.y * distance, lookVec.z * distance);
            AABB searchBox = new AABB(
                Math.min(startVec.x, endVec.x),
                Math.min(startVec.y, endVec.y),
                Math.min(startVec.z, endVec.z),
                Math.max(startVec.x, endVec.x),
                Math.max(startVec.y, endVec.y),
                Math.max(startVec.z, endVec.z)
            );
            entities = level.getEntities(player, searchBox);          
        }
        
        if (!entities.isEmpty()) {
            if (!level.isClientSide) {
                for (Entity entity : entities) {
                    Microorganism annotation = entity.getClass().getAnnotation(Microorganism.class);
                    if (annotation != null) {
                        ViewDescriptionForMagnifier(entity, player, annotation.value());
                    } else {
                        player.displayClientMessage(Component.translatable("microworld.magnifier.no_microorganism"), false);
                    }
                }
            }
            player.getCooldowns().addCooldown(this, 100);
            return InteractionResultHolder.success(player.getItemInHand(hand));
        }

        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }

    private void ViewDescriptionForMagnifier(Entity m, Player player, Microorganism.MicroorganismType type) {
        player.displayClientMessage(Component.translatable("microworld.type." + type.toString().toLowerCase()), false);
        player.displayClientMessage(GetDescriptionForMagnifier(m), false);
    }

    protected MutableComponent GetDescriptionForMagnifier(Entity m) {
        return Component.translatable("microworld.description." + m.getClass().getSimpleName().toLowerCase().replace("entity", ""));
    }
}
