package net.damqn4etobg.world.gen;

import net.damqn4etobg.oresplus.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {
    RUBY(Lazy.of(ModBlocks.RUBY_ORE), 8, 10, 40),
    ALUMINIUM(Lazy.of(ModBlocks.ALUMINIUM_ORE), 16, 10, 50),
    ENPOWERED_CRYSTAL(Lazy.of(ModBlocks.ENPOWERED_CRYSTAL_ORE), 6, 5, 20);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
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
