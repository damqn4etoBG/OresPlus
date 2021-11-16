package net.damqn4etobg.world.gen;

import net.damqn4etobg.oresplus.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {
    RUBY(Lazy.of(ModBlocks.RUBY_ORE), 8, 10, 40,4),
    ALUMINIUM(Lazy.of(ModBlocks.ALUMINIUM_ORE), 16, 10, 50,8),
    ENPOWERED_CRYSTAL(Lazy.of(ModBlocks.ENPOWERED_CRYSTAL_ORE), 6, 5, 20,1),
    URANIUM(Lazy.of(ModBlocks.URANIUM_ORE), 4, 5, 20,1),
    COPPER(Lazy.of(ModBlocks.COPPER_ORE), 16, 10, 50, 6);


    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;
    private final int veinsPerChunk;

    OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight, int veinsPerChunk) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.veinsPerChunk = veinsPerChunk;
    }

    public int getVeinsPerChunk() {
        return veinsPerChunk;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public static OreType get(Block block) {
        for (OreType ore : values()) {
            if (block == ore.block) {
                return ore;
            }
        }

        return null;
    }
}
