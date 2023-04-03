package com.mrbacon.simplediscordbot.commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

public class RandomNumGen extends ListenerAdapter {

    public static int getRandom(int min, int max) {
        if (min > max) {
            return 0;
        }
        return (int) ( (long) min + Math.random() * ((long)max - min + 1));
    }
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("randomnum")) {

            // Random Num Gen

            String user = event.getUser().getId();
            System.out.println("[Bot] The Random Num Command Has Been Used By -> " + user);

            int minnum = event.getOption("min").getAsInt();
            int maxnum = event.getOption("max").getAsInt();

            EmbedBuilder emb = new EmbedBuilder();
            emb.setColor(new Color(0, 255, 0));
            emb.setAuthor("Random Number!");
            emb.setThumbnail(event.getGuild().getIconUrl());
            emb.setDescription("Number -> " + getRandom(minnum, maxnum));

            event.replyEmbeds(emb.build()).queue();
        }
    }
}
