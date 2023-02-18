package com.mrbacon.simplediscordbot.logs;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class MessageRecievedLog extends ListenerAdapter {

    // Set To True If You Want It Enabled Else Delete The True And Leave It Empty

    String enabled = "";

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) return;

        if (enabled.equals("true")) {

            // Embed Builder

            EmbedBuilder mlogs = new EmbedBuilder();

            // Change Color Below

            mlogs.setColor(new Color(0, 255, 0));

            // The Title/Author

            mlogs.setAuthor("Message Sent Logs");

            // Sets The Image On The Right To The Guild Logo

            mlogs.setThumbnail(event.getGuild().getIconUrl());

            // The Main Body Of The Embed

            mlogs.setDescription("Sender -> " + event.getMessage().getAuthor().getName() + "\nMessage -> " + event.getMessage().getContentRaw() + "\nSent In -> " + event.getMessage().getChannel().getName());

            // Channel You Want The Bot To Send The Message Received Logs To

            TextChannel txtChannel = event.getJDA().getTextChannelById("Channel ID");

            // Sends Embed

            txtChannel.sendMessageEmbeds(mlogs.build()).queue();
        }
    }
}
