package com.mrbacon.simplediscordbot.logs;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class SlashCommandLog extends ListenerAdapter {

    // Set To True If You Want It Enabled Else Delete The True And Leave It Empty

    String enabled = "";

    // Channel You Want The Bot To Send The Message Received Logs To

    String channel = "";

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (enabled.equals("true")) {

            if (channel.equals("")) return;

            EmbedBuilder slogs = new EmbedBuilder();
            slogs.setColor(new Color(0, 255, 0));
            slogs.setAuthor("Slash Command Logs");
            slogs.setThumbnail(event.getGuild().getIconUrl());
            slogs.setDescription("Sender -> " + event.getMember().getUser().getName() + "\nCommand -> " + event.getName() + "\nSent In -> " + event.getChannel().getName());

            TextChannel txtChannel = event.getJDA().getTextChannelById(channel);

            txtChannel.sendMessageEmbeds(slogs.build()).queue();

        }
    }
}