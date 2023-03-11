package com.mrbacon.simplediscordbot.commands.bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class InfoCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("info")) {

            String user = event.getUser().getId();
            System.out.println("[Bot] The Info Command Has Been Used By -> " + user);

            EmbedBuilder ieb = new EmbedBuilder();
            ieb.setColor(new Color(0, 255, 0));
            ieb.setAuthor("Guild Info");
            ieb.setThumbnail(event.getGuild().getIconUrl());
            ieb.setDescription("Guild Name -> " + event.getGuild().getName() + "\nGuild ID -> " + event.getGuild().getId() + "\nNSFW? -> " + event.getGuild().getNSFWLevel() + "\nMembers -> " + event.getGuild().getMemberCount());

            event.replyEmbeds(ieb.build()).queue();
        }
    }
}
