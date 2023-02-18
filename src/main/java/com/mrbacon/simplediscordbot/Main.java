package com.mrbacon.simplediscordbot;

import com.mrbacon.simplediscordbot.commands.*;
import com.mrbacon.simplediscordbot.listeners.JoinWelcomerListener;
import com.mrbacon.simplediscordbot.logs.ChannelCreateLog;
import com.mrbacon.simplediscordbot.logs.MessageDeleteLog;
import com.mrbacon.simplediscordbot.logs.MessageRecievedLog;
import com.mrbacon.simplediscordbot.logs.SlashCommandLog;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException{

        // Bot Builder

        // Your Bot Token Goes Below

        JDA bot = JDABuilder.createDefault("token")

                // Sets Bot Activity

                .setActivity(Activity.watching("MrBacon"))

                // Enabling Intents

                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)

                // Adding Listeners

                .addEventListeners(new PingCommand())
                .addEventListeners(new JoinWelcomerListener())
                .addEventListeners(new HelpCommand())
                .addEventListeners(new CoinFlipCommand())
                .addEventListeners(new StopCommand())
                .addEventListeners(new ServerStatsCommand())

                // Logs

                .addEventListeners(new MessageRecievedLog())
                .addEventListeners(new SlashCommandLog())
                .addEventListeners(new ChannelCreateLog())
                .addEventListeners(new MessageDeleteLog())

                // Building The Bot

                .build();

        // Adding The Slash Commands

        bot.upsertCommand("ping", "Shows some data about the bot.").queue();
        bot.upsertCommand("coinflip", "Flips a coin for you.").queue();
        bot.upsertCommand("help", "The help command for WaterLand.").queue();
        bot.upsertCommand("stop", "Stops the bot. (owner only)").queue();
        bot.upsertCommand("serverstats", "Shows some information about the guild.").queue();

        // This Gets Printed When The Bot Is Ready/Loaded

        System.out.println("[Bot] Bot has successfully started!");
    }
}
