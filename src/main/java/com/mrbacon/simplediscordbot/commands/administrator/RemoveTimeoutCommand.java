package com.mrbacon.simplediscordbot.commands.administrator;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class RemoveTimeoutCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        
        if (event.getName().equals("removetimeout")) {

            String tuser = event.getOption("member").getAsUser().getId();

            if (event.getGuild().getOwner().getId().equals(tuser)) {

                EmbedBuilder emb = new EmbedBuilder();
                emb.setColor(new Color(255, 0, 0));
                emb.setAuthor("Remove Timeout Command");
                emb.setThumbnail(event.getGuild().getIconUrl());
                emb.setDescription("You Can Not Remove A Timeout From The Owner!");

                event.replyEmbeds(emb.build()).queue();

            }else {

                event.getGuild().removeTimeout(UserSnowflake.fromId(tuser)).queue();

                String user = event.getUser().getId();
                System.out.println("[Bot] The Remove Timeout Command Has Been Used By -> " + user);

                EmbedBuilder emb = new EmbedBuilder();
                emb.setColor(new Color(0, 255, 0));
                emb.setAuthor("Remove Timeout Command");
                emb.setThumbnail(event.getGuild().getIconUrl());
                emb.setDescription("The Timeout Has Been Removed Successfully.");

                event.replyEmbeds(emb.build()).queue();
            }
        }
    }
}
