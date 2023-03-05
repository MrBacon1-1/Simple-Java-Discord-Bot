package com.mrbacon.simplediscordbot.logs;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class ChannelDeleteLog extends ListenerAdapter {

    // Set To True If You Want It Enabled Else Delete The True And Leave It Empty

    String enabled = "";

    // Channel You Want The Bot To Send The Message Received Logs To

    String channel = "";
    @Override
    public void onChannelDelete(ChannelDeleteEvent event) {

        if (enabled.equals("true")) {

            if (channel.equals("")) return;

            EmbedBuilder cdlogs = new EmbedBuilder();
            cdlogs.setColor(new Color(255, 0, 0));
            cdlogs.setAuthor("Channel Delete Log");
            cdlogs.setThumbnail(event.getGuild().getIconUrl());
            cdlogs.setDescription("Channel Name -> " + event.getChannel().getName() + "\nChannel Type -> " + event.getChannelType());

            TextChannel txtChannel = event.getJDA().getTextChannelById(channel);

            txtChannel.sendMessageEmbeds(cdlogs.build()).queue();
        }
    }
}
