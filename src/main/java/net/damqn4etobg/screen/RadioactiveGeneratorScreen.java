package net.damqn4etobg.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.damqn4etobg.container.FusionCrafterContainer;
import net.damqn4etobg.container.RadioactiveGeneratorContainer;
import net.damqn4etobg.oresplus.OresPlus;
import net.damqn4etobg.oresplus.tileentity.RadioactiveGeneratorTile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class RadioactiveGeneratorScreen extends ContainerScreen<RadioactiveGeneratorContainer> {

    private final ResourceLocation GUI = new ResourceLocation(OresPlus.MOD_ID,
            "textures/gui/radioactive_generator_gui.png");

    public RadioactiveGeneratorScreen(RadioactiveGeneratorContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrix, int mouseX, int mouseY) {
        drawString(matrix, Minecraft.getInstance().fontRenderer, "Energy: " + container.getEnergy(), 5, 5, 0xffffff);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);

        this.blit(matrixStack, i + 134, j + 15, 176, 17, 15, 55 - container.getEnergy());
    }
}
