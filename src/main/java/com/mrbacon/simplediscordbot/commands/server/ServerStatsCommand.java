package com.mrbacon.simplediscordbot.commands.server;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class ServerStatsCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("serverstats")) {

            // Server Stats Command

            String user = event.getUser().getId();
            System.out.println("[Bot] The Server Stats Command Has Been Used By -> " + user);

            EmbedBuilder meb = new EmbedBuilder();
            meb.setColor(new Color(0, 255, 0));
            meb.setAuthor("Server Stats");
            meb.setThumbnail(event.getGuild().getIconUrl());
            meb.setDescription("Owner -> " + (event.getGuild().getOwner().getUser().getName()) + "\nMembers -> " + (event.getGuild().getMembers().size()) + "\nRoles -> " + (event.getGuild().getRoles().size()));

            event.replyEmbeds(meb.build()).queue();
        }
    }
}
