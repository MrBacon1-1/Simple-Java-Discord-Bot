package com.mrbacon.simplediscordbot.commands.bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class HelpCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("help")) {

            // Help Command

            String user = event.getUser().getId();
            System.out.println("[Bot] The Help Command Has Been Used By -> " + user);

            EmbedBuilder heb = new EmbedBuilder();
            heb.setColor(new Color(0, 255, 0));
                heb.setAuthor("Help Command");
            heb.setThumbnail(event.getGuild().getIconUrl());
            heb.setDescription("`/help` -> Shows this menu. \n`/ping` -> Gives some stats on the bot. \n`/coinflip` -> Flips a coin for you. \n`/stop` -> Stops the bot if you are the owner. \n`/serverstats` -> Shows some stats about the guild. \n`/kick` -> Kicks a user from the guild. \n`/ban` -> Bans a user from the guild. \n`8ball` -> Gives you a random output. e.g `Maybe, Yes, No`");

            event.replyEmbeds(heb.build()).queue();
        }
    }
}
