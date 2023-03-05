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

            String user = event.getUser().getId();
            System.out.println("[Bot] The Coin Flip Command Has Been Used By -> " + user);

            Random rand = new Random();
            int sideup = rand.nextInt(2);
            if (sideup == 0)
            {

                EmbedBuilder ceb = new EmbedBuilder();
                ceb.setColor(new Color(0, 255, 0));
                ceb.setAuthor("Coin Flip");
                ceb.setThumbnail(event.getGuild().getIconUrl());
                ceb.setDescription("You Got Heads");

                event.replyEmbeds(ceb.build()).queue();

            }
            else
            {

                EmbedBuilder ceb1 = new EmbedBuilder();
                ceb1.setColor(new Color(0, 255, 0));
                ceb1.setAuthor("Coin Flip");
                ceb1.setThumbnail(event.getGuild().getIconUrl());
                ceb1.setDescription("You Got Tails");

                event.replyEmbeds(ceb1.build()).queue();

            }

        }
    }
}
