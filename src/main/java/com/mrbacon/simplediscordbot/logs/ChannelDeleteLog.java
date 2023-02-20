package com.mrbacon.simplediscordbot.logs;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class ChannelDeleteLog extends ListenerAdapter {

    // Set To True If You Want It Enabled Else Delete The True And Leave It Empty

    String enabled = "";
    @Override
    public void onChannelDelete(ChannelDeleteEvent event) {

        if (enabled.equals("true")) {

            // Embed Builder

            EmbedBuilder cdlogs = new EmbedBuilder();

            // Change Color Below

            cdlogs.setColor(new Color(255, 0, 0));

            // The Title/Author

            cdlogs.setAuthor("Channel Delete Log");

            // Sets The Image On The Right To The Guild Logo

            cdlogs.setThumbnail(event.getGuild().getIconUrl());

            // The Main Body Of The Embed

            cdlogs.setDescription("Channel Name -> " + event.getChannel().getName() + "\nChannel Type -> " + event.getChannelType());
            // Channel You Want The Bot To Send The Message Received Logs To

            TextChannel txtChannel = event.getJDA().getTextChannelById("Channel ID");

            // Sends Embed

            txtChannel.sendMessageEmbeds(cdlogs.build()).queue();
        }
    }
}
