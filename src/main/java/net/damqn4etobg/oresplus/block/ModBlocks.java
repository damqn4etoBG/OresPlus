package net.damqn4etobg.oresplus.block;

import net.damqn4etobg.oresplus.OresPlus;
import net.damqn4etobg.oresplus.block.custom.FusionCrafterBlock;
import net.damqn4etobg.oresplus.item.ModItemGroup;
import net.damqn4etobg.oresplus.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, OresPlus.MOD_ID);


    public static final RegistryObject<Block> ALUMINIUM_ORE = registerBlock("aluminium_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));
    public static final RegistryObject<Block> ENPOWERED_CRYSTAL_ORE = registerBlock("enpowered_crystal_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));
    public static final RegistryObject<Block> FUSION_CRAFTER = registerBlock("fusion_crafter",
            () -> new FusionCrafterBlock(AbstractBlock.Properties.create(Material.IRON)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
        new Item.Properties().group(ModItemGroup.ORESPLUS_GROUP)));
    }



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
