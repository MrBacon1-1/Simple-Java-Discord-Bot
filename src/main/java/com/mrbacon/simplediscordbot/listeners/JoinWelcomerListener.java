package com.mrbacon.simplediscordbot.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.Color;

public class JoinWelcomerListener extends ListenerAdapter{

    // When A Member Joins
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        // Gets The Users ID

        String user = event.getMember().getUser().getId();

        // Prints This In Console

        System.out.println("[Bot] New Member Joined -> " + user);

        // Embed Builder For The Embed It Will Dm The User Joining

        EmbedBuilder web = new EmbedBuilder();
        
        // Change Color Below
        
        web.setColor(new Color(0, 255, 0));
        
        // The Title/Author (shows on the top of the embed so it looks like a title)
        
        web.setAuthor("Welcome!");
        
        // Sets The Image On The Right To The Guild Logo
        
        web.setThumbnail(event.getGuild().getIconUrl());
        
        // The Main Body Of The Embed
        
        web.setDescription("Welcome to the discord server :D \nHope you enjoy your time here!");

        // Sends The Embed In The Users Dms

        sendMessage(event.getUser(), web.build());
    }
    public void sendMessage(User user, MessageEmbed content) {
        user.openPrivateChannel()
                .flatMap(channel -> channel.sendMessageEmbeds(content))
                .queue();
    }
}
