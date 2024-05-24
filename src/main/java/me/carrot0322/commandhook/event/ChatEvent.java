package me.carrot0322.commandhook.event;

import me.carrot0322.commandhook.util.SenderUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.awt.*;
import java.io.IOException;

public class ChatEvent implements Listener {
    @EventHandler(priority = EventPriority.LOW)
    public void onCommand(AsyncPlayerChatEvent e) throws IOException {
        SenderUtil.sendWebhook(
                "Chat: " + e.getPlayer().getName(),
                "https://mc-heads.net/avatar/" + e.getPlayer().getName() + "/512.png",
                e.getMessage(),
                Color.WHITE
        );
    }
}