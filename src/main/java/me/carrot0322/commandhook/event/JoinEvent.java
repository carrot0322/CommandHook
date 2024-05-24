package me.carrot0322.commandhook.event;

import me.carrot0322.commandhook.util.SenderUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;
import java.io.IOException;

public class JoinEvent implements Listener {
    // Join
    @EventHandler(priority = EventPriority.LOW)
    public void onJoin(PlayerJoinEvent e) throws IOException {
        SenderUtil.sendWebhook(
                "JoinEvent: " + e.getPlayer().getName(),
                "https://mc-heads.net/avatar/" + e.getPlayer().getName() + "/512.png",
                e.getPlayer().getName() + " joined the game",
                Color.GREEN
        );
    }

    // Left
    @EventHandler(priority = EventPriority.LOW)
    public void onLeft(PlayerQuitEvent e) throws IOException {
        SenderUtil.sendWebhook(
                "LeftEvent: " + e.getPlayer().getName(),
                "https://mc-heads.net/avatar/" + e.getPlayer().getName() + "/512.png",
                e.getPlayer().getName() + " left the game",
                Color.RED
        );
    }
}
