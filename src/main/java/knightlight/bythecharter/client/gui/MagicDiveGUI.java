package knightlight.bythecharter.client.gui;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MagicDiveGUI extends GuiScreen {

    private static final int TICKS_UNTIL_FULL_DIVE = 10;

    private static final int MAX_DIVE_OPACITY = 250;

    /**
     * Tracks the number of ticks that the dive has been active.
     */
    private int diveTime;

    public MagicDiveGUI() {
        super();
        diveTime = 0;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);

        Gui.drawRect(0, 0, width, height, MagicDiveGUI.getDiveBGColor(diveTime));
    }

    @Override
    public void updateScreen() {
        diveTime = Math.min(++diveTime,TICKS_UNTIL_FULL_DIVE);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }


    private static int getDiveBGColor(int time) {
        int opacity = (int)(((float)Math.min(time, TICKS_UNTIL_FULL_DIVE) / TICKS_UNTIL_FULL_DIVE) * MAX_DIVE_OPACITY);
        return opacity << 24;
    }
}
