package com.mrbacon.simplediscordbot.logs;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class ChannelCreateLog extends ListenerAdapter {

    // Set To True If You Want It Enabled Else Delete The True And Leave It Empty

    String enabled = "";

    // Channel You Want The Bot To Send The Message Received Logs To (Channel ID)

    String channel = "";

    @Override
    public void onChannelCreate(ChannelCreateEvent event) {

        if (enabled.equals("true")) {

            if (channel.equals("")) return;

            EmbedBuilder clogs = new EmbedBuilder();
            clogs.setColor(new Color(0, 255, 0));
            clogs.setAuthor("Channel Create Log");
            clogs.setThumbnail(event.getGuild().getIconUrl());
            clogs.setDescription("Channel Name -> " + event.getChannel().getName() + "\nChannel Type -> " + event.getChannelType());

            TextChannel txtChannel = event.getJDA().getTextChannelById(channel);

            txtChannel.sendMessageEmbeds(clogs.build()).queue();
        }
    }
}
