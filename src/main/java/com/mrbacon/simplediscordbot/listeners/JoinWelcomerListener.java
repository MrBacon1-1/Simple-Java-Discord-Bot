package com.mrbacon.simplediscordbot.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.Color;

public class JoinWelcomerListener extends ListenerAdapter{
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        String user = event.getMember().getUser().getId();
        System.out.println("[Bot] New Member Joined -> " + user);

        EmbedBuilder web = new EmbedBuilder();
        web.setColor(new Color(0, 255, 0));
        web.setAuthor("Welcome!");
        web.setThumbnail(event.getGuild().getIconUrl());
        web.setDescription("Welcome to the discord server :D \nHope you enjoy your time here!");

        sendMessage(event.getUser(), web.build());
    }
    public void sendMessage(User user, MessageEmbed content) {
        user.openPrivateChannel()
                .flatMap(channel -> channel.sendMessageEmbeds(content))
                .queue();
    }
}
