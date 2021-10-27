package net.damqn4etobg.world.biome;

import net.damqn4etobg.oresplus.OresPlus;
import net.damqn4etobg.oresplus.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModConfiguredSurfaceBuilders {

    public static ConfiguredSurfaceBuilder<?> PURPLE_FUNGUS_PLATEAU_SURFACE = register("purple_fungus_plateau_surface",
            SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(
                    ModBlocks.PURPLE_FUNGUS.get().getDefaultState(),
                    Blocks.DIRT.getDefaultState(),
                    Blocks.STONE.getDefaultState()
            )));

    private static <SC extends ISurfaceBuilderConfig>ConfiguredSurfaceBuilder<SC> register(String name,
                                                                                           ConfiguredSurfaceBuilder<SC> csb) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
                new ResourceLocation(OresPlus.MOD_ID, name), csb);
    }
}
