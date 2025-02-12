package tank.mods.microworld;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import tank.mods.microworld.blocks.ModBlocks;
import tank.mods.microworld.items.ModItems;

public class ModCreativeModTabs {

	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MicroworldMod.MODID);
	
    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("microworld_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DARK_CORE.get()))
                    .title(Component.translatable("microworld.tab"))
                    .displayItems((pParameters, pOutput) -> {
                    	
                    	for (var x: ModBlocks.BLOCKS.getEntries()) {
                    		 pOutput.accept(x.get());
                    	}
                    	
                    	for (var x: ModItems.ITEMS.getEntries()) {
                    		pOutput.accept(x.get());
                    	}
                    })
                    .build());
	
	
	public static void register(IEventBus e) {
		CREATIVE_MODE_TABS.register(e);
	}
}
