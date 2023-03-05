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

        String buser = event.getOption("member").getAsString();
        String reason = event.getOption("reason").getAsString();
        Integer time = event.getOption("time").getAsInt();

        if (event.getGuild().getOwner().getId().equals(buser)) return;

        String user = event.getUser().getId();
        System.out.println("[Bot] The Ban Command Has Been Used By -> " + user);

        event.getGuild().ban(UserSnowflake.fromId(buser), (time), (TimeUnit.MINUTES));

        EmbedBuilder keb = new EmbedBuilder();
        keb.setColor(new Color(255, 0, 0));
        keb.setAuthor("Discord Bot Commands");
        keb.setThumbnail(event.getGuild().getIconUrl());
        keb.setDescription("User Has Been Kicked Successfully.");

        event.replyEmbeds(keb.build()).queue();

    }
}
