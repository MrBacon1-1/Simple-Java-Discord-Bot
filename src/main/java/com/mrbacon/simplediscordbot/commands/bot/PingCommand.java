package com.mrbacon.simplediscordbot.commands.bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class PingCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("ping")) {

            String user = event.getUser().getId();
            System.out.println("[Bot] The Ping Command Has Been Used By -> " + user);

            EmbedBuilder peb = new EmbedBuilder();
            peb.setColor(new Color(0, 255, 0));
            peb.setAuthor("Ping -> Pong :D");
            peb.setThumbnail(event.getGuild().getIconUrl());
            peb.setDescription("Ping -> " + event.getJDA().getGatewayPing() + "ms");

            event.replyEmbeds(peb.build()).queue();
        }
    }
}
