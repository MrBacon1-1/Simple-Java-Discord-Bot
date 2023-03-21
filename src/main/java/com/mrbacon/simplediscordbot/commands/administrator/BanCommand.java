package com.mrbacon.simplediscordbot.commands.administrator;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class BanCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("ban"));

        // Ban Command

        String buser = event.getOption("member").getAsString();
        String reason = event.getOption("reason").getAsString();

        if (event.getGuild().getOwner().getId().equals(buser)) {

            EmbedBuilder keb = new EmbedBuilder();
            keb.setColor(new Color(255, 0, 0));
            keb.setAuthor("Ban Command");
            keb.setThumbnail(event.getGuild().getIconUrl());
            keb.setDescription("You Can Not Ban The Owner!");

            event.replyEmbeds(keb.build()).queue();

        }else {

            event.getGuild().ban(UserSnowflake.fromId(buser), (7), (TimeUnit.DAYS)).queue();

            String user = event.getUser().getId();
            System.out.println("[Bot] The Ban Command Has Been Used By -> " + user);

            EmbedBuilder keb = new EmbedBuilder();
            keb.setColor(new Color(255, 0, 0));
            keb.setAuthor("Discord Bot Commands");
            keb.setThumbnail(event.getGuild().getIconUrl());
            keb.setDescription("User Has Been Banned Successfully.");

            event.replyEmbeds(keb.build()).queue();
        }
    }
}
