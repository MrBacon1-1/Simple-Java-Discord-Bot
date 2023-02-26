package com.mrbacon.simplediscordbot.commands.bot;

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
            
            // The Title/Author
            
            heb.setAuthor("Discord Bot Commands");
            
            // Sets The Image On The Right To The Guild Logo
            
            heb.setThumbnail(event.getGuild().getIconUrl());
            
            // The Main Body Of The Embed
            
            heb.setDescription("`/help` -> Shows this menu. \n`/ping` -> Gives some stats on the bot. \n`/coinflip` -> Flips a coin for you. \n`/stop` -> Stops the bot if you are the owner. \n`/serverstats` -> Shows some stats about the guild.");

            // Sends Embed

            event.replyEmbeds(heb.build()).queue();
        }
    }
}
