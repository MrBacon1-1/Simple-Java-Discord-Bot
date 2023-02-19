package com.mrbacon.simplediscordbot.commands.server;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class ServerStatsCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("serverstats")) {

            // Prints In Console Who Used The Command

            String user = event.getUser().getId();
            System.out.println("[Bot] The Server Stats Command Has Been Used By -> " + user);

            // Embed Builder

            EmbedBuilder meb = new EmbedBuilder();

            // Change Color Below

            meb.setColor(new Color(0, 255, 0));

            // The Title/Author

            meb.setAuthor("Server Stats");

            // Sets The Image On The Right To The Guild Logo

            meb.setThumbnail(event.getGuild().getIconUrl());

            // The Main Body Of The Embed

            meb.setDescription("Owner -> " + (event.getGuild().getOwner().getUser().getName()) + "\nMembers -> " + (event.getGuild().getMembers().size()) + "\nRoles -> " + (event.getGuild().getRoles().size()));

            // Sends Embed

            event.replyEmbeds(meb.build()).queue();
        }
    }
}
