package tank.mods.microworld.items;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tank.mods.microworld.MicroworldMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ModItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MicroworldMod.MODID);
	
	
	public static final RegistryObject<Item> DARK_CORE = ITEMS.register("dark_core",
	        () -> new DarkCoreItem(new Item.Properties().stacksTo(1).durability(10)));
	
	public static final RegistryObject<Item> RAW_DARK_CORE = ITEMS.register("raw_dark_core", 
			() -> new Item(new Item.Properties()));
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
