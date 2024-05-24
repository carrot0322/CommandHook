package me.carrot0322.commandhook;

import me.carrot0322.commandhook.event.ChatEvent;
import me.carrot0322.commandhook.event.CommandEvent;
import me.carrot0322.commandhook.event.JoinEvent;
import me.carrot0322.commandhook.util.SenderUtil;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.io.IOException;

public final class CommandHook extends JavaPlugin {
    public boolean commandEvent = true;
    public boolean joinEvent = false;
    public boolean chatEvent = false;

    public static String webhook = "https://discord.com/api/webhooks/...";

    @Override
    public void onEnable() {
        getLogger().info("Starting CommandHook...");

        // Save & Load Config
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();

        commandEvent = getConfig().getBoolean("CommandEvent");
        joinEvent = getConfig().getBoolean("JoinEvent");
        chatEvent = getConfig().getBoolean("ChatEvent");

        webhook = getConfig().getString("Webhook");

        getLogger().info("Config Loaded!");

        if(webhook.equals("https://discord.com/api/webhooks/...")){
            getLogger().warning("Please setting webhook");
            getLogger().warning("Disabling CommandHook Plugin...");
            getServer().getPluginManager().disablePlugin(this);
        }

        getLogger().info("Loading Events...");

        if(commandEvent)
            getServer().getPluginManager().registerEvents(new CommandEvent(), this);
        if(joinEvent)
            getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        if(chatEvent)
            getServer().getPluginManager().registerEvents(new ChatEvent(), this);

        getLogger().info("Events Loaded!");

        getLogger().info("CommandHook has been Enabled.");

        try {
            SenderUtil.sendWebhook(":white_check_mark: Server has been started!", "", Color.GREEN);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        try {
            SenderUtil.sendWebhook(":x: Disabled CommandHook", "", Color.RED);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        getLogger().info("CommandHook has been Disabled.");
    }
}
