package net.damqn4etobg.container;

import net.damqn4etobg.oresplus.OresPlus;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {

    public static DeferredRegister<ContainerType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, OresPlus.MOD_ID);

    public static final RegistryObject<ContainerType<FusionCrafterContainer>> FUSION_CRAFTER_CONTAINER
            = CONTAINERS.register("fusion_crafter_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new FusionCrafterContainer(windowId, world, pos, inv, inv.player);
            })));

    public static final RegistryObject<ContainerType<MegaFusionCrafterContainer>> MEGA_FUSION_CRAFTER_CONTAINER
            = CONTAINERS.register("mega_fusion_crafter_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new MegaFusionCrafterContainer(windowId, world, pos, inv, inv.player);
            })));

    public static final RegistryObject<ContainerType<RadioactiveGeneratorContainer>> RADIOACTIVE_GENERATOR_CONTAINER
            = CONTAINERS.register("radioactive_generator_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new RadioactiveGeneratorContainer(windowId, world, pos, inv, inv.player);
            })));


    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
