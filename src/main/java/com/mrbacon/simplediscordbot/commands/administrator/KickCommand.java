package com.mrbacon.simplediscordbot.commands.administrator;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class KickCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("kick")) {

            String kuser = event.getOption("member").getAsString();
            String reason = event.getOption("reason").getAsString();

            if (event.getGuild().getOwner().getId().equals(kuser)) {

                EmbedBuilder keb = new EmbedBuilder();
                keb.setColor(new Color(255, 0, 0));
                keb.setAuthor("Kick Command");
                keb.setThumbnail(event.getGuild().getIconUrl());
                keb.setDescription("You Can Not Kick The Owner!");

                event.replyEmbeds(keb.build()).queue();

            }

            event.getGuild().kick(UserSnowflake.fromId((kuser)), (reason)).queue();

            String user = event.getUser().getId();
            System.out.println("[Bot] The Kick Command Has Been Used By -> " + user);

            EmbedBuilder keb = new EmbedBuilder();
            keb.setColor(new Color(255, 0, 0));
            keb.setAuthor("Kick Command");
            keb.setThumbnail(event.getGuild().getIconUrl());
            keb.setDescription("User Has Been Kicked Successfully.");

            event.replyEmbeds(keb.build()).queue();
        }
    }
}
