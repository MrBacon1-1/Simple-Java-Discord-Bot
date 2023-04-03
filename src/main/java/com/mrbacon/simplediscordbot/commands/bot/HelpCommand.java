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
            heb.setDescription("**Administrator** \n\n`/ban` -> Bans a user from the guild. \n`/unban` -> Unbans a user from the guild. \n`/kick` -> Kicks a user from the guild. \n`/timeout` -> Timeout a user in the guild/server. \n`/removetimeout` -> Removes a users timeout. \n`/stop` -> Stops the bot if you are the owner. \n`/addrole` -> Allows admins to give roles to users. \n`/removerole` -> Allows admins to remove roles from users. \n\n**Bot**\n\n`/help` -> Shows this menu. \n`/ping` -> Gives some stats on the bot. \n\n**Server**\n\n`/serverstats` -> Shows some stats about the guild. \n\n**Fun**\n\n`/coinflip` -> Flips a coin for you. \n`/8ball` -> Gives you a random output. e.g `Maybe, Yes, No` \n`/randomnum` -> Generates a random number with a min and max. \n\n**Other**");
            event.replyEmbeds(heb.build()).queue();
        }
    }
}
