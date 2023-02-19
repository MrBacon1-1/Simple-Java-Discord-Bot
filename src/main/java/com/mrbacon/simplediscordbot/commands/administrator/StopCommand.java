package com.mrbacon.simplediscordbot.commands.administrator;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class StopCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("stop")) {

            // Gets Owners ID

            String owner = event.getGuild().getOwnerId();

            // Gets The Users ID

            String user = event.getMember().getUser().getId();

            // Prints This In Console

            System.out.println("[Bot] The Stop Command Has Been Used By -> " + user);

            // If Owners Id Matches Person Who Executed The Command The Bot Will Stop Else It Will Say You Are Not The Chosen One

            if (event.getMember().getId().equals(owner)) {

                // Embed Builder

                EmbedBuilder seb1 = new EmbedBuilder();

                // Change Color Below

                seb1.setColor(new Color(0, 255, 0));

                // The Title/Author (shows on the top of the embed so it looks like a title)

                seb1.setAuthor("Coin Flip");

                // Sets The Image On The Right To The Guild Logo

                seb1.setThumbnail(event.getGuild().getIconUrl());

                // Sends This In Console

                System.out.println("[Bot] The Bot Has Been Stopped By -> " + user);

                // The Main Body Of The Embed

                seb1.setDescription("Bot is stopping...");

                // Sends Embed

                event.replyEmbeds(seb1.build()).queue();

                // Stops The Bot

                System.exit(3);

            } else {

                // Embed Builder

                EmbedBuilder seb2 = new EmbedBuilder();

                // Change Color Below

                seb2.setColor(new Color(0, 255, 0));

                // The Title/Author

                seb2.setAuthor("Stop Command");

                // Sets The Image On The Right To The Guild Logo

                seb2.setThumbnail(event.getGuild().getIconUrl());

                // Sends This In Console

                System.out.println("[Bot] A User Tried To Stop The Bot But Failed Their ID Is -> " + user);

                // The Main Body Of The Embed

                seb2.setDescription("You are not the chosen one.");

                // Sends Embed

                event.replyEmbeds(seb2.build()).queue();
            }
        }
    }
}
