package com.mrbacon.simplediscordbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class HelpCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("help")) {

            // Prints In Console Who Used The Command

            String user = event.getUser().getId();
            System.out.println("[?] The Help Command Has Been Used By -> " + user);

            // Embed Builder

            EmbedBuilder heb = new EmbedBuilder();
            heb.setColor(new Color(0, 255, 0));
            heb.setAuthor("Discord Bot Commands");
            heb.setThumbnail(event.getGuild().getIconUrl());
            heb.setDescription("`/ping` -> Gives some stats on the bot. \n`/help` -> Shows this menu.");

            // Sends Embed

            event.replyEmbeds(heb.build()).queue();
        }
    }
}
