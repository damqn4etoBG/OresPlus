package net.damqn4etobg.oresplus.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup ORESPLUS_GROUP = new ItemGroup("oresplusgroup") {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.RUBY.get());
        }
    };

    public static final ItemGroup ORESPLUS_TOOLSGROUP = new ItemGroup("oresplustoolsgroup") {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.RUBY_SWORD.get());
        }
    };

    public static final ItemGroup ORESPLUS_ARMORGROUP = new ItemGroup("oresplusarmorgroup") {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.RUBY_CHESTPLATE.get());
        }
    };

    public static final ItemGroup ORESPLUS_FARMGROUP = new ItemGroup("oresplusfarmgroup") {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.CORN.get());
        }
    };

}
