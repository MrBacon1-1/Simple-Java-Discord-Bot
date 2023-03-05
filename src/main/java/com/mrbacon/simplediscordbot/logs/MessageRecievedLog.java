package com.mrbacon.simplediscordbot.logs;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class MessageRecievedLog extends ListenerAdapter {

    // Set To True If You Want It Enabled Else Delete The True And Leave It Empty

    String enabled = "";

    // Channel You Want The Bot To Send The Message Received Logs To

    String channel = "";

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) return;

        if (enabled.equals("true")) {

            if (channel.equals("")) return;

            EmbedBuilder mlogs = new EmbedBuilder();
            mlogs.setColor(new Color(0, 255, 0));
            mlogs.setAuthor("Message Sent Logs");
            mlogs.setThumbnail(event.getGuild().getIconUrl());
            mlogs.setDescription("Sender -> " + event.getMessage().getAuthor().getName() + "\nMessage -> " + event.getMessage().getContentRaw() + "\nSent In -> " + event.getMessage().getChannel().getName());

            TextChannel txtChannel = event.getJDA().getTextChannelById(channel);

            txtChannel.sendMessageEmbeds(mlogs.build()).queue();
        }
    }
}
