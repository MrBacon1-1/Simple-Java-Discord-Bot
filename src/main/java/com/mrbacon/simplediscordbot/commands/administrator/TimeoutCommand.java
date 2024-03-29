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

                EmbedBuilder emb = new EmbedBuilder();
                emb.setColor(new Color(255, 0, 0));
                emb.setAuthor("Timeout Command");
                emb.setThumbnail(event.getGuild().getIconUrl());
                emb.setDescription("You Can Not Timeout The Owner!");

                event.replyEmbeds(emb.build()).queue();

            }else {

                event.getGuild().timeoutFor(UserSnowflake.fromId(tuser), time, TimeUnit.MINUTES).queue();

                String user = event.getUser().getId();
                System.out.println("[Bot] The Timeout Command Has Been Used By -> " + user);

                EmbedBuilder emb = new EmbedBuilder();
                emb.setColor(new Color(0, 255, 0));
                emb.setAuthor("Timeout Command");
                emb.setThumbnail(event.getGuild().getIconUrl());
                emb.setDescription("User Has Been Timed Out Successfully.");

                event.replyEmbeds(emb.build()).queue();
            }
        }
    }
}
