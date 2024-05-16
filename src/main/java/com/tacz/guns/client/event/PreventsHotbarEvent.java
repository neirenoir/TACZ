package com.tacz.guns.client.event;

import com.tacz.guns.client.gui.GunRefitScreen;
import com.tacz.guns.client.gui.GunSmithTableScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class PreventsHotbarEvent {
    @SubscribeEvent
    public static void onRenderHotbarEvent(RenderGuiOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.LAYER) {
            Screen screen = Minecraft.getInstance().screen;
            // 枪械合成台界面关闭背景
            if (screen instanceof GunSmithTableScreen) {
                event.setCanceled(true);
                return;
            }
            // 枪械改装界面关闭背景
            if (screen instanceof GunRefitScreen) {
                event.setCanceled(true);
            }
        }
    }
}
