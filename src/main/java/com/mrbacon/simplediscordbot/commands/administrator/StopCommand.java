package com.mrbacon.simplediscordbot.commands.administrator;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class StopCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("stop")) {

            String owner = event.getGuild().getOwnerId();
            String user = event.getMember().getUser().getId();
            System.out.println("[Bot] The Stop Command Has Been Used By -> " + user);

            if (event.getMember().getId().equals(owner)) {

                EmbedBuilder seb1 = new EmbedBuilder();
                seb1.setColor(new Color(0, 255, 0));
                seb1.setAuthor("Coin Flip");
                seb1.setThumbnail(event.getGuild().getIconUrl());

                System.out.println("[Bot] The Bot Has Been Stopped By -> " + user);
                seb1.setDescription("Bot is stopping...");

                event.replyEmbeds(seb1.build()).queue();

                // Stops The Bot

                System.exit(3);

            } else {

                EmbedBuilder seb2 = new EmbedBuilder();
                seb2.setColor(new Color(0, 255, 0));
                seb2.setAuthor("Stop Command");
                seb2.setThumbnail(event.getGuild().getIconUrl());

                System.out.println("[Bot] A User Tried To Stop The Bot But Failed Their ID Is -> " + user);
                seb2.setDescription("You are not the chosen one...");

                event.replyEmbeds(seb2.build()).queue();
            }
        }
    }
}
