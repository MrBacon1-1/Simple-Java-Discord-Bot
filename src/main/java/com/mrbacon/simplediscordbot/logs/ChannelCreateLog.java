package com.mrbacon.simplediscordbot.logs;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class ChannelCreateLog extends ListenerAdapter {

    // Set To True If You Want It Enabled Else Delete The True And Leave It Empty

    String enabled = "";

    @Override
    public void onChannelCreate(ChannelCreateEvent event) {

        if (enabled.equals("true")) {

            // Embed Builder

            EmbedBuilder clogs = new EmbedBuilder();

            // Change Color Below

            clogs.setColor(new Color(0, 255, 0));

            // The Title/Author

            clogs.setAuthor("Channel Create Log");

            // Sets The Image On The Right To The Guild Logo

            clogs.setThumbnail(event.getGuild().getIconUrl());

            // The Main Body Of The Embed

            clogs.setDescription("Channel Name -> " + event.getChannel().getName() + "\nChannel Type -> " + event.getChannelType());
            // Channel You Want The Bot To Send The Message Received Logs To

            TextChannel txtChannel = event.getJDA().getTextChannelById("Channel ID");

            // Sends Embed

            txtChannel.sendMessageEmbeds(clogs.build()).queue();
        }
    }
}
