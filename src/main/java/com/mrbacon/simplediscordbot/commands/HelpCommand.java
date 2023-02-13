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
            System.out.println("[Bot] The Help Command Has Been Used By -> " + user);

            // Embed Builder

            EmbedBuilder heb = new EmbedBuilder();
            
            // Change Color Below
            
            heb.setColor(new Color(0, 255, 0));
            
            // // The Title/Author (shows on the top of the embed so it looks like a title)
            
            heb.setAuthor("Discord Bot Commands");
            
            // Sets The Image On The Right To The Guild Logo
            
            heb.setThumbnail(event.getGuild().getIconUrl());
            
            // The Main Body Of The Embed
            
            heb.setDescription("`/ping` -> Gives some stats on the bot. \n`/help` -> Shows this menu. \n`/coinflip` -> Flips a coin for you.");

            // Sends Embed

            event.replyEmbeds(heb.build()).queue();
        }
    }
}
