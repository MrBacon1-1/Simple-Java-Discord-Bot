package com.mrbacon.simplediscordbot.logs;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class MessageDeleteLog extends ListenerAdapter {

    // Set To True If You Want It Enabled Else Delete The True And Leave It Empty

    String enabled = "";

    @Override
    public void onMessageDelete(MessageDeleteEvent event) {
        if (enabled.equals("true")) {

            // Embed Builder

            EmbedBuilder mdlogs = new EmbedBuilder();

            // Change Color Below

            mdlogs.setColor(new Color(0, 255, 0));

            // The Title/Author

            mdlogs.setAuthor("Channel Create Log");

            // Sets The Image On The Right To The Guild Logo

            mdlogs.setThumbnail(event.getGuild().getIconUrl());

            // The Main Body Of The Embed

            mdlogs.setDescription("Message -> " + event.getRawData());
            // Channel You Want The Bot To Send The Message Received Logs To

            TextChannel txtChannel = event.getJDA().getTextChannelById("Channel ID");

            // Sends Embed

            txtChannel.sendMessageEmbeds(mdlogs.build()).queue();
        }
    }
}