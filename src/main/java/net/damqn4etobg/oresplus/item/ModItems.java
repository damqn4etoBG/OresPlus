package net.damqn4etobg.oresplus.item;

import net.damqn4etobg.oresplus.OresPlus;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OresPlus.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().group(ModItemGroup.ORESPLUS_GROUP)));

    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot",
            () -> new Item(new Item.Properties().group(ModItemGroup.ORESPLUS_GROUP)));

    public static final RegistryObject<Item> ENPOWERED_CRYSTAL_SHARD = ITEMS.register("enpowered_crystal_shard",
            () -> new Item(new Item.Properties().group(ModItemGroup.ORESPLUS_GROUP)));

    public static final RegistryObject<Item> ENPOWERED_OBXIDIAN_INGOT = ITEMS.register("enpowered_obxidian_ingot",
            () -> new Item(new Item.Properties().group(ModItemGroup.ORESPLUS_GROUP)));

    public static final RegistryObject<Item> OBXIDIAN_DUST = ITEMS.register("obxidian_dust",
            () -> new Item(new Item.Properties().group(ModItemGroup.ORESPLUS_GROUP)));

    public static final RegistryObject<Item> ENPOWERED_OBXIDIAN_DUST = ITEMS.register("enpowered_obxidian_dust",
            () -> new Item(new Item.Properties().group(ModItemGroup.ORESPLUS_GROUP)));

    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModItemTier.RUBY, (int) 3f, 3f,
                new Item.Properties().group(ModItemGroup.ORESPLUS_TOOLSGROUP)));

    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModItemTier.RUBY, (int) 0f, 3f,
                    new Item.Properties().group(ModItemGroup.ORESPLUS_TOOLSGROUP)));

    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModItemTier.RUBY, (int) 6f, -3f,
                    new Item.Properties().group(ModItemGroup.ORESPLUS_TOOLSGROUP)));

    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModItemTier.RUBY, (int) 0f, 1f,
                    new Item.Properties().group(ModItemGroup.ORESPLUS_TOOLSGROUP)));

    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModItemTier.RUBY, (int) 0f, 0f,
                    new Item.Properties().group(ModItemGroup.ORESPLUS_TOOLSGROUP)));

    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.ORESPLUS_ARMORGROUP)));

    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.ORESPLUS_ARMORGROUP)));

    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.ORESPLUS_ARMORGROUP)));

    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.ORESPLUS_ARMORGROUP)));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}