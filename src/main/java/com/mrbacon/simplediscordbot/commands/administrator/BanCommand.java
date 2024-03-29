package com.mrbacon.simplediscordbot.commands.administrator;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class BanCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("ban")) {

            // Ban Command

            String buser = event.getOption("member").getAsUser().getId();
            String reason = event.getOption("reason").getAsString();


            if (event.getGuild().getOwner().getId().equals(buser)) {

                EmbedBuilder beb = new EmbedBuilder();
                beb.setColor(new Color(255, 0, 0));
                beb.setAuthor("Ban Command");
                beb.setThumbnail(event.getGuild().getIconUrl());
                beb.setDescription("You Can Not Ban The Owner!");

                event.replyEmbeds(beb.build()).queue();

            } else {

                event.getGuild().ban(UserSnowflake.fromId(buser), (7), (TimeUnit.DAYS)).queue();

                String user = event.getUser().getId();
                System.out.println("[Bot] The Ban Command Has Been Used By -> " + user);

                EmbedBuilder beb = new EmbedBuilder();
                beb.setColor(new Color(0, 255, 0));
                beb.setAuthor("Ban Command");
                beb.setThumbnail(event.getGuild().getIconUrl());
                beb.setDescription("User Has Been Banned Successfully.");

                event.replyEmbeds(beb.build()).queue();
            }
        }
     }
}
