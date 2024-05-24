package me.carrot0322.commandhook.util;

import me.carrot0322.commandhook.CommandHook;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SenderUtil {
    public static void sendWebhook(String title, String thumbnail, String description, Color color) throws IOException {
        WebhookUtil webhook = new WebhookUtil(CommandHook.webhook);
        WebhookUtil.EmbedObject embed = new WebhookUtil.EmbedObject();
        embed.setTitle(title);
        embed.setThumbnail(thumbnail);
        embed.setDescription(description);
        embed.setColor(color);

        embed.setFooter(getTime(), null);
        webhook.addEmbed(embed);

        webhook.execute();
    }

    public static void sendWebhook(String title, String description, Color color) throws IOException {
        WebhookUtil webhook = new WebhookUtil(CommandHook.webhook);
        WebhookUtil.EmbedObject embed = new WebhookUtil.EmbedObject();
        embed.setTitle(title);
        embed.setDescription(description);
        embed.setColor(color);

        embed.setFooter(getTime(), null);
        webhook.addEmbed(embed);

        webhook.execute();
    }

    public static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd / HH:mm:ss");
        Date date = new Date();
        return (formatter.format(date));
    }
}
