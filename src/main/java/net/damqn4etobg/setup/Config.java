package net.damqn4etobg.setup;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_POWER = "power";
    public static final String SUBCATEGORY_RADIOACTIVEGENERATORBLOCK = "radioactive_generator_block";

    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.IntValue RADIOACTIVEGENERATORBLOCK_MAXPOWER;
    public static ForgeConfigSpec.IntValue RADIOACTIVEGENERATORBLOCK_GENERATE;
    public static ForgeConfigSpec.IntValue RADIOACTIVEGENERATORBLOCK_SEND;
    public static ForgeConfigSpec.IntValue RADIOACTIVEGENERATORBLOCK_TICKS;

    public static ForgeConfigSpec.DoubleValue ROTATION_SPEED;


    static {

        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        CLIENT_BUILDER.comment("General settings").push(CATEGORY_GENERAL);
        ROTATION_SPEED = CLIENT_BUILDER.comment("Rotation speed of the magic block").defineInRange("rotationSpeed", 100.0, 0.0, 1000000.0);
        CLIENT_BUILDER.pop();

        SERVER_BUILDER.comment("Power settings").push(CATEGORY_POWER);

        setupFirstBlockConfig(SERVER_BUILDER, CLIENT_BUILDER);

        SERVER_BUILDER.pop();


        SERVER_CONFIG = SERVER_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    private static void setupFirstBlockConfig(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
        SERVER_BUILDER.comment("FirstBlock settings").push(SUBCATEGORY_RADIOACTIVEGENERATORBLOCK);

        RADIOACTIVEGENERATORBLOCK_MAXPOWER = SERVER_BUILDER.comment("Maximum power for the FirstBlock generator")
                .defineInRange("maxPower", 100000, 0, Integer.MAX_VALUE);
        RADIOACTIVEGENERATORBLOCK_GENERATE = SERVER_BUILDER.comment("Power generation per diamond")
                .defineInRange("generate", 1000, 0, Integer.MAX_VALUE);
        RADIOACTIVEGENERATORBLOCK_SEND = SERVER_BUILDER.comment("Power generation to send per tick")
                .defineInRange("send", 100, 0, Integer.MAX_VALUE);
        RADIOACTIVEGENERATORBLOCK_TICKS = SERVER_BUILDER.comment("Ticks per uranium")
                .defineInRange("ticks", 20, 0, Integer.MAX_VALUE);

        SERVER_BUILDER.pop();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {

    }

    @SubscribeEvent
    public static void onReload(final ModConfig.Reloading configEvent) {
    }

    @SubscribeEvent
    public static void renderGUI(RenderGameOverlayEvent.Post event){
//        new ManaTestScreen(Minecraft.getInstance(), event.getMatrixStack());
    }

}
