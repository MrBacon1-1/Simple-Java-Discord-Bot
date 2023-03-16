package com.mrbacon.simplediscordbot.commands.administrator;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class RemoveRoleCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("removerole")) {

            // Remove Role Command

            String user = event.getOption("member").getAsString();
            Role role = event.getOption("role").getAsRole();

            try {

                event.getGuild().removeRoleFromMember(UserSnowflake.fromId(user), (role)).queue();

                String cuser = event.getUser().getId();
                System.out.println("[Bot] The Role Remove Command Has Been Used By -> " + cuser + "\n[Bot] The Role Is -> " + role);

                EmbedBuilder emb = new EmbedBuilder();
                emb.setColor(new Color(0, 255, 0));
                emb.setAuthor("Role Removed!");
                emb.setThumbnail(event.getGuild().getIconUrl());
                emb.setDescription("The role has been removed from the user.");

                event.replyEmbeds(emb.build()).queue();

            } catch (Exception e) {

                EmbedBuilder emb = new EmbedBuilder();
                emb.setColor(new Color(255, 0, 0));
                emb.setAuthor("Error!");
                emb.setThumbnail(event.getGuild().getIconUrl());
                emb.setDescription("A error occurred while trying to remove the role from the user!");

                event.replyEmbeds(emb.build()).queue();
            }
        }
    }
}
