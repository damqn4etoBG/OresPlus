package net.damqn4etobg.fluid;

import net.damqn4etobg.oresplus.OresPlus;
import net.damqn4etobg.oresplus.block.ModBlocks;
import net.damqn4etobg.oresplus.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, OresPlus.MOD_ID);

    public static final RegistryObject<FlowingFluid> MOLTEN_ALUMINIUM_FLUID
            = FLUIDS.register("molten_aluminium_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_ALUMINIUM_PROPERTIES));

    public static final RegistryObject<FlowingFluid> MOLTEN_ALUMINIUM_FLOWING
            = FLUIDS.register("molten_aluminium_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_ALUMINIUM_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MOLTEN_ALUMINIUM_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MOLTEN_ALUMINIUM_FLUID.get(), () -> MOLTEN_ALUMINIUM_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.BLOCK_WATER_AMBIENT).overlay(WATER_OVERLAY_RL)
            .color(1255255255)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> ModFluids.MOLTEN_ALUMINIUM_BLOCK.get()).bucket(() -> ModItems.MOLTEN_ALUMINIUM_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> MOLTEN_ALUMINIUM_BLOCK = ModBlocks.BLOCKS.register("molten_aluminium",
            () -> new FlowingFluidBlock(() -> ModFluids.MOLTEN_ALUMINIUM_FLUID.get(), AbstractBlock.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
