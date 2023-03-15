package com.mrbacon.simplediscordbot.commands.administrator;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Objects;

public class AddRoleCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("addrole")) {
            
            // Add Role Command

            String user = event.getOption("member").getAsString();
            Role role = event.getOption("role").getAsRole();

            try {

                event.getGuild().addRoleToMember(UserSnowflake.fromId(user), (role)).queue();

                EmbedBuilder emb = new EmbedBuilder();
                emb.setColor(new Color(0, 255, 0));
                emb.setAuthor("Role Added!");
                emb.setThumbnail(event.getGuild().getIconUrl());
                emb.setDescription("The user has received the role.");

                event.replyEmbeds(emb.build()).queue();

            } catch (Exception e) {

                EmbedBuilder emb = new EmbedBuilder();
                emb.setColor(new Color(255, 0, 0));
                emb.setAuthor("Error!");
                emb.setThumbnail(event.getGuild().getIconUrl());
                emb.setDescription("A error occurred while trying to give the user the role!");

                event.replyEmbeds(emb.build()).queue();

            }
        }
    }
}
