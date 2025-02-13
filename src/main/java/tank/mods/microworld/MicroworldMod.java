package tank.mods.microworld;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tank.mods.microworld.blocks.ModBlocks;
import tank.mods.microworld.items.ModItems;
import tank.mods.microworld.mobs.ModEntities;
import tank.mods.microworld.mobs.bacteriums.bacillus.BacillusRenderer;
import tank.mods.microworld.mobs.bacteriums.clostridium.ClostridiumRenderer;
import tank.mods.microworld.mobs.bacteriums.cyanobacteria.CyanobacteriaRenderer;
import tank.mods.microworld.mobs.bacteriums.e_coli.E_ColiRenderer;
import tank.mods.microworld.mobs.bacteriums.germ.GermRenderer;
import tank.mods.microworld.mobs.bacteriums.nocardia.NocardiaRenderer;
import tank.mods.microworld.mobs.bacteriums.spirillum.SpirillumRenderer;
import tank.mods.microworld.mobs.bacteriums.staphylococcus.StaphylococcusRenderer;
import tank.mods.microworld.mobs.multicellular.worm.WormRenderer;
import tank.mods.microworld.worldgen.ModBiomes;

/**
 * Main class of this mod. Registers all the contents of this mod
 * */

@Mod(MicroworldMod.MODID)
public class MicroworldMod {
    public static final String MODID = "microworld";

    public MicroworldMod() {
    	
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ModItems.register(modEventBus); 	
        ModBlocks.register(modEventBus);   
        ModEntities.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);     
        
        modEventBus.addListener(this::addCreative);
    }

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent event) {
        // Initialization code
    }
    
    
    private void addCreative(BuildCreativeModeTabContentsEvent e) {
    	
    	if (e.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
    		e.accept(ModItems.DARK_CORE);
    	}
    }
    

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
