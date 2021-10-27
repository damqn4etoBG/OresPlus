package net.damqn4etobg.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.damqn4etobg.container.MegaFusionCrafterContainer;
import net.damqn4etobg.oresplus.OresPlus;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class MegaFusionCrafterScreen extends ContainerScreen<MegaFusionCrafterContainer> {

    private final ResourceLocation GUI = new ResourceLocation(OresPlus.MOD_ID,
            "textures/gui/mega_fusion_crafter_gui.png");

    public MegaFusionCrafterScreen(MegaFusionCrafterContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);

        if(container.isLightningStorm()) {
            this.blit(matrixStack, i + 139, j + 35, 176, 0, 13, 17);
        }


    }
}
