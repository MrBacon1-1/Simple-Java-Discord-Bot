package com.mrbacon.simplediscordbot.commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

public class CoinFlipCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("coinflip")) {

            // Prints In Console Who Used The Command

            String user = event.getUser().getId();
            System.out.println("[Bot] The Coin flip Command Has Been Used By -> " + user);

            // Generating Random

            Random rand = new Random();
            int sideup = rand.nextInt(2);
            if (sideup == 0)
            {
                // Embed Builder

                EmbedBuilder ceb = new EmbedBuilder();

                // Change Color Below

                ceb.setColor(new Color(0, 255, 0));

                // // The Title/Author

                ceb.setAuthor("Coin Flip");

                // Sets The Image On The Right To The Guild Logo

                ceb.setThumbnail(event.getGuild().getIconUrl());

                // The Main Body Of The Embed

                ceb.setDescription("You Got Heads");

                // Sends Embed

                event.replyEmbeds(ceb.build()).queue();

            }
            else
            {
                // Embed Builder

                EmbedBuilder ceb1 = new EmbedBuilder();

                // Change Color Below

                ceb1.setColor(new Color(0, 255, 0));

                // // The Title/Author (shows on the top of the embed so it looks like a title)

                ceb1.setAuthor("Coin Flip");

                // Sets The Image On The Right To The Guild Logo

                ceb1.setThumbnail(event.getGuild().getIconUrl());

                // The Main Body Of The Embed

                ceb1.setDescription("You Got Tails");

                // Sends Embed

                event.replyEmbeds(ceb1.build()).queue();

            }

        }
    }
}
