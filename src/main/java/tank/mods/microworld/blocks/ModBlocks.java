package tank.mods.microworld.blocks;

import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tank.mods.microworld.MicroworldMod;
import tank.mods.microworld.items.ModItems;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;


public class ModBlocks {
	
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MicroworldMod.MODID);

    public static final RegistryObject<Block> TEMNARIK_BLOCK = registerBlock("temnarik",
            () -> new TemnarikBlock(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE)));
    
    public static final RegistryObject<Block> bioblock = registerBlock("bioblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    
    public static final RegistryObject<Block> biofence = registerBlock("biofence",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE)));
    
    public static final RegistryObject<Block> bioglass = registerBlock("bioglass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    
    public static final RegistryObject<Block> dark_soil = registerBlock("dark_soil",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    
    public static final RegistryObject<Block> fungal_cell = registerBlock("fungal_cell",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    
    public static final RegistryObject<Block> leaf_block = registerBlock("leaf_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    
    public static final RegistryObject<Block> membrane = registerBlock("membrane",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    
    public static final RegistryObject<Block> mineral = registerBlock("mineral",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    
    public static final RegistryObject<Block> mote = registerBlock("mote",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    
    public static final RegistryObject<Block> organics = registerBlock("organics",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    
    public static final RegistryObject<Block> shells = registerBlock("shells",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    
    public static final RegistryObject<Block> soil = registerBlock("soil",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    
    public static final RegistryObject<Block> stem = registerBlock("stem",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    
    public static final RegistryObject<Block> substratum = registerBlock("substratum",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    
    public static final RegistryObject<Block> sugar = registerBlock("sugar",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    
    public static final RegistryObject<Block> wrack = registerBlock("wrack",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
   
    
    public static void register(IEventBus bus) { 	
        BLOCKS.register(bus);
    }
    

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        // Any setup code if necessary
    }
}