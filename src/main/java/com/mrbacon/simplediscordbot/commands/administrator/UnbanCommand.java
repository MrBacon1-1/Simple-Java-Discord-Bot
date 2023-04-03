package com.mrbacon.simplediscordbot.commands.administrator;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class UnbanCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("unban")) {

            // Unban Command

            String target = event.getOption("member").getAsString();
            String reason = event.getOption("reason").getAsString();

            try {

                event.getGuild().unban(UserSnowflake.fromId(target)).queue();

                String user = event.getUser().getId();
                System.out.println("[Bot] The Unban Command Has Been Used By -> " + user);

                EmbedBuilder emb = new EmbedBuilder();
                emb.setColor(new Color(0, 255, 0));
                emb.setAuthor("Unbanned!");
                emb.setThumbnail(event.getGuild().getIconUrl());
                emb.setDescription("The user has been unbanned.");

                event.replyEmbeds(emb.build()).queue();

            } catch (Exception e) {
                EmbedBuilder emb = new EmbedBuilder();
                emb.setColor(new Color(255, 0, 0));
                emb.setAuthor("Error!");
                emb.setThumbnail(event.getGuild().getIconUrl());
                emb.setDescription("A error occurred while trying to remove the ban from the user!");

                event.replyEmbeds(emb.build()).queue();
            }
        }
    }
}
