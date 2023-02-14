package com.mrbacon.simplediscordbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class MemberCountCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("membercount")) {

            // Prints In Console Who Used The Command

            String user = event.getUser().getId();
            System.out.println("[Bot] The Member Count Command Has Been Used By -> " + user);

            // Embed Builder

            EmbedBuilder meb = new EmbedBuilder();

            // Change Color Below

            meb.setColor(new Color(0, 255, 0));

            // // The Title/Author (shows on the top of the embed so it looks like a title)

            meb.setAuthor("Member Count");

            // Sets The Image On The Right To The Guild Logo

            meb.setThumbnail(event.getGuild().getIconUrl());

            // The Main Body Of The Embed

            meb.setDescription("Members -> " + (event.getGuild().getMembers().size()));

            // Sends Embed

            event.replyEmbeds(meb.build()).queue();
        }
    }
}
