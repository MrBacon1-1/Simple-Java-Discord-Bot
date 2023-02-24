package com.mrbacon.simplediscordbot.commands.administrator;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.UserSnowflake;
import com.mrbacon.simplediscordbot.Main;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class KickCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("kick")) {

            // Prints In Console Who Used The Command

            String user = event.getUser().getId();
            System.out.println("[Bot] The Kick Command Has Been Used By -> " + user);

            // Gets Options

            String kuser = event.getOption("member").getAsString();
            String reason = event.getOption("reason").getAsString();

            // Kicks The Member

            event.getGuild().kick(UserSnowflake.fromId((kuser)), (reason)).queue();

            // Send Message That User Has Been Kicked

            // Embed Builder

            EmbedBuilder keb = new EmbedBuilder();

            // Change Color Below

            keb.setColor(new Color(255, 0, 0));

            // The Title/Author

            keb.setAuthor("Discord Bot Commands");

            // Sets The Image On The Right To The Guild Logo

            keb.setThumbnail(event.getGuild().getIconUrl());

            // The Main Body Of The Embed

            keb.setDescription("User Has Been Kicked Successfully.");

            // Sends Embed

            event.replyEmbeds(keb.build()).queue();
        }
    }
}
