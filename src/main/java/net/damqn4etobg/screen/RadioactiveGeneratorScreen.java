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

    private ResourceLocation GUI = new ResourceLocation(OresPlus.MOD_ID, "textures/gui/radioactive_generator_gui.png");

    public RadioactiveGeneratorScreen(RadioactiveGeneratorContainer container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
    }

    @Override
    public void render(MatrixStack matrix, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrix);
        super.render(matrix, mouseX, mouseY, partialTicks);
        super.renderHoveredTooltip(matrix, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrix, int mouseX, int mouseY) {
        drawString(matrix,Minecraft.getInstance().fontRenderer, "Energy: " + container.getEnergy(), 5, 5, 0xffffff);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrix, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(matrix, relX, relY, 0, 0, this.xSize, this.ySize);

        this.blit(matrix, relX + 133, relY + 15, 175, 17, 16, 55 - container.getEnergy());
    }
}
