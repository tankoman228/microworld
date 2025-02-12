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
	
	/*
	 * Код сгенерировал при помощи формулы в табличках. Да здравствует мощь экселя, ой, гугл доков!
	 * */
	
	public static final RegistryObject<Item> microportal = ITEMS.register("microportal", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> magnifier = ITEMS.register("magnifier", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> endoplasm = ITEMS.register("endoplasm", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> lysosome = ITEMS.register("lysosome", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> nucleus = ITEMS.register("nucleus", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> chitin = ITEMS.register("chitin", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> sticky_stuff = ITEMS.register("sticky_stuff", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ribosome = ITEMS.register("ribosome", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> organ_x = ITEMS.register("organ_x", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> membrane_piece = ITEMS.register("membrane_piece", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> vacuole = ITEMS.register("vacuole", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> strange_cell = ITEMS.register("strange_cell", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> chlorophyll = ITEMS.register("chlorophyll", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> flagellum = ITEMS.register("flagellum", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> funiculus = ITEMS.register("funiculus", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> spirit_bubble = ITEMS.register("spirit_bubble", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> germ = ITEMS.register("germ", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> amoebic_slurry = ITEMS.register("amoebic_slurry", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> rotifier_fan = ITEMS.register("rotifier_fan", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> microdudka = ITEMS.register("microdudka", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> stinging_cell = ITEMS.register("stinging_cell", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> worm_fragment = ITEMS.register("worm_fragment", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> bedroсk_piece = ITEMS.register("bedrock_piece", () -> new Item(new Item.Properties()));


	public static final RegistryObject<Item> flagellar_motor = ITEMS.register("flagellar_motor", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> food_pouch = ITEMS.register("food_pouch", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> germ_boots = ITEMS.register("germ_boots", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> poison_bomb = ITEMS.register("poison_bomb", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> sanitizer = ITEMS.register("sanitizer", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> stinging_sword = ITEMS.register("stinging_sword", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> cell_shuriken = ITEMS.register("cell_shuriken", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> superpipe = ITEMS.register("superpipe", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> anti_infusor_spike = ITEMS.register("anti_infusor_spike", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> microbial_builder = ITEMS.register("microbial_builder", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> sticky_shield = ITEMS.register("sticky_shield", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> nematode_pick = ITEMS.register("nematode_pick", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> ayubov_submarine = ITEMS.register("ayubov_submarine", () -> new Item(new Item.Properties()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
