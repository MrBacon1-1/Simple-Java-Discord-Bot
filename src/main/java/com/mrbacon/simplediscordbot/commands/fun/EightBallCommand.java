package com.mrbacon.simplediscordbot.commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

public class EightBallCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("8ball")) {

            String user = event.getUser().getId();
            System.out.println("[Bot] The 8Ball Command Has Been Used By -> " + user);

            Random rand = new Random();
            int Random = rand.nextInt(6);

            if (Random == 1) {

                System.out.println("[8Ball] Yes! -> " + user);

                EmbedBuilder eeb = new EmbedBuilder();
                eeb.setColor(new Color(0, 255, 0));
                eeb.setAuthor("8Ball");
                eeb.setThumbnail(event.getGuild().getIconUrl());
                eeb.setDescription("Yes!");

                event.replyEmbeds(eeb.build()).queue();
            } else if (Random == 2) {

                System.out.println("[8Ball] No! -> " + user);

                EmbedBuilder eeb = new EmbedBuilder();
                eeb.setColor(new Color(255, 0, 0));
                eeb.setAuthor("8Ball");
                eeb.setThumbnail(event.getGuild().getIconUrl());
                eeb.setDescription("No!");

                event.replyEmbeds(eeb.build()).queue();
            } else if (Random == 3){

                System.out.println("[8Ball] Maybe. -> " + user);

                EmbedBuilder eeb = new EmbedBuilder();
                eeb.setColor(new Color(155, 100, 0));
                eeb.setAuthor("8Ball");
                eeb.setThumbnail(event.getGuild().getIconUrl());
                eeb.setDescription("Maybe.");

                event.replyEmbeds(eeb.build()).queue();
            } else if (Random == 4) {

                System.out.println("[8Ball] Unknown! -> " + user);

                EmbedBuilder eeb = new EmbedBuilder();
                eeb.setColor(new Color(0, 0, 255));
                eeb.setAuthor("8Ball");
                eeb.setThumbnail(event.getGuild().getIconUrl());
                eeb.setDescription("Unknown!");

                event.replyEmbeds(eeb.build()).queue();
            } else if (Random == 5) {

                System.out.println("[8Ball] Definitely! -> " + user);

                EmbedBuilder eeb = new EmbedBuilder();
                eeb.setColor(new Color(0, 255, 0));
                eeb.setAuthor("8Ball");
                eeb.setThumbnail(event.getGuild().getIconUrl());
                eeb.setDescription("Definitely!");

                event.replyEmbeds(eeb.build()).queue();
            } else {

                System.out.println("[8Ball] Definitely Not! -> " + user);

                EmbedBuilder eeb = new EmbedBuilder();
                eeb.setColor(new Color(255, 0, 0));
                eeb.setAuthor("8Ball");
                eeb.setThumbnail(event.getGuild().getIconUrl());
                eeb.setDescription("Definitely Not!");

                event.replyEmbeds(eeb.build()).queue();
            }


        }
    }
}
