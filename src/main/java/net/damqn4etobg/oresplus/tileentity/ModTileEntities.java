package net.damqn4etobg.oresplus.tileentity;

import net.damqn4etobg.oresplus.OresPlus;
import net.damqn4etobg.oresplus.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, OresPlus.MOD_ID);

    public static RegistryObject<TileEntityType<FusionCrafterTile>> FUSION_CRAFTER_TILE =
            TILE_ENTITIES.register("fusion_crafter_tile", () -> TileEntityType.Builder.create(
                    FusionCrafterTile::new, ModBlocks.FUSION_CRAFTER.get()).build(null));
    public static RegistryObject<TileEntityType<MegaFusionCrafterTile>> MEGA_FUSION_CRAFTER_TILE =
            TILE_ENTITIES.register("mega_fusion_crafter_tile", () -> TileEntityType.Builder.create(
                    MegaFusionCrafterTile::new, ModBlocks.MEGA_FUSION_CRAFTER.get()).build(null));
    public static RegistryObject<TileEntityType<RadioactiveGeneratorTile>> RADIOACTIVE_GENERATOR_TILE =
            TILE_ENTITIES.register("radioactive_generator_tile", () -> TileEntityType.Builder.create(
                    RadioactiveGeneratorTile::new, ModBlocks.RADIOACTIVE_GENERATOR.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
