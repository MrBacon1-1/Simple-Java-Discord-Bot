package com.mrbacon.simplediscordbot.commands.administrator;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TimeoutCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("timeout")) {

            // Timeout Command

            String tuser = event.getOption("member").getAsUser().getId();
            int time = event.getOption("time").getAsInt();

            if (event.getGuild().getOwner().getId().equals(tuser)) {

                EmbedBuilder beb = new EmbedBuilder();
                beb.setColor(new Color(255, 0, 0));
                beb.setAuthor("Timeout Command");
                beb.setThumbnail(event.getGuild().getIconUrl());
                beb.setDescription("You Can Not Timeout The Owner!");

                event.replyEmbeds(beb.build()).queue();

            }else {

                event.getGuild().timeoutFor(UserSnowflake.fromId(tuser), time, TimeUnit.MINUTES).queue();

                String user = event.getUser().getId();
                System.out.println("[Bot] The Timeout Command Has Been Used By -> " + user);

                EmbedBuilder beb = new EmbedBuilder();
                beb.setColor(new Color(0, 255, 0));
                beb.setAuthor("Timeout Command");
                beb.setThumbnail(event.getGuild().getIconUrl());
                beb.setDescription("User Has Been Banned Successfully.");

                event.replyEmbeds(beb.build()).queue();
            }
        }
    }
}
