package com.mrbacon.simplediscordbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class PingCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("ping")) {

            // Prints In Console Who Used The Command

            String user = event.getUser().getId();
            System.out.println("[Bot] The Ping Command Has Been Used By -> " + user);

            // Creates The Embed

            EmbedBuilder peb = new EmbedBuilder();
            
            // Change Color Below
            
            peb.setColor(new Color(0, 255, 0));
            
            // The Title/Author (shows on the top of the embed so it looks like a title)
            
            peb.setAuthor("Bot Stats");
            
            // Sets The Image On The Right To The Guild Logo
            
            peb.setThumbnail(event.getGuild().getIconUrl());
            
            // The Main Body Of The Embed
            
            peb.setDescription("Ping -> " + event.getJDA().getGatewayPing() + "ms");

            // Sends The Embed

            event.replyEmbeds(peb.build()).queue();
        }
    }
}
