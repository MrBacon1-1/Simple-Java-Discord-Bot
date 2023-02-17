package com.mrbacon.simplediscordbot.logs;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class SlashCommandLog extends ListenerAdapter {

    // Set To True If You Want It Enabled Else Delete The True And Leave It Empty
    String enabled = "";

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (enabled.equals("true")) {

            // Embed Builder

            EmbedBuilder slogs = new EmbedBuilder();

            // Change Color Below

            slogs.setColor(new Color(0, 255, 0));

            // The Title/Author

            slogs.setAuthor("Slash Command Logs");

            // Sets The Image On The Right To The Guild Logo

            slogs.setThumbnail(event.getGuild().getIconUrl());

            // The Main Body Of The Embed

            slogs.setDescription("Sender -> " + event.getMember().getUser().getName() + "\nCommand -> " + event.getName() + "\nSent In -> " + event.getChannel().getName());

            // Channel You Want The Bot To Send The Message Received Logs To

            TextChannel txtChannel = event.getJDA().getTextChannelById("Channel ID");

            // Sends Embed

            txtChannel.sendMessageEmbeds(slogs.build()).queue();

        }
    }
}