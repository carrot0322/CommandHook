package me.carrot0322.commandhook.event;

import me.carrot0322.commandhook.util.SenderUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

import java.awt.*;
import java.io.IOException;

public class CommandEvent implements Listener {
    @EventHandler(priority = EventPriority.LOW)
    public void onCommand(ServerCommandEvent e) throws IOException {
        SenderUtil.sendWebhook(
                "CommandEvent: " + e.getSender().getName(),
                "https://mc-heads.net/avatar/" + e.getSender().getName() + "/512.png",
                e.getCommand(),
                Color.CYAN
        );
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onCommand(PlayerCommandPreprocessEvent e) throws IOException {
        SenderUtil.sendWebhook(
                "CommandEvent: " + e.getPlayer().getName(),
                "https://mc-heads.net/avatar/" + e.getPlayer().getName() + "/512.png",
                e.getMessage(),
                Color.CYAN
        );
    }
}
