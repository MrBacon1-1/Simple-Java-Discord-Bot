//package com.mrbacon.simplediscordbot.logs;
//
//import net.dv8tion.jda.api.EmbedBuilder;
//import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
//import net.dv8tion.jda.api.events.message.MessageUpdateEvent;
//import net.dv8tion.jda.api.hooks.ListenerAdapter;
//
//import java.awt.*;
//
//public class MessageEditLog extends ListenerAdapter {
//
//    // Set To True If You Want It Enabled Else Delete The True And Leave It Empty
//
//    String enabled = "true";
//
//    @Override
//    public void onMessageUpdate(MessageUpdateEvent event) {
//
//        if (event.getAuthor().isBot()) return;
//
//        if (enabled.equals("true")) {
//
//            // Embed Builder
//
//            EmbedBuilder melogs = new EmbedBuilder();
//
//            // Change Color Below
//
//            melogs.setColor(new Color(255, 140, 0));
//
//            // The Title/Author
//
//            melogs.setAuthor("Message Edited Logs");
//
//            // Sets The Image On The Right To The Guild Logo
//
//            melogs.setThumbnail(event.getGuild().getIconUrl());
//
//            // The Main Body Of The Embed
//
//            melogs.setDescription("Editor -> " + event.getMessage().getAuthor().getName() + "\nMessage -> " + event.getMessage().getContentRaw() + "\nEdited To -> " + event.getRawData() + "\nEdited In -> " + event.getMessage().getChannel().getName());
//
//            // Channel You Want The Bot To Send The Message Received Logs To
//
//            TextChannel txtChannel = event.getJDA().getTextChannelById("1076524006309642260");
//
//            // Sends Embed
//
//            txtChannel.sendMessageEmbeds(melogs.build()).queue();
//        }
//    }
//}