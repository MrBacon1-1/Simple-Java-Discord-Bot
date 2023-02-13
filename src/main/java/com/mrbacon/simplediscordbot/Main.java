package com.mrbacon.simplediscordbot;

import com.mrbacon.simplediscordbot.commands.CoinFlipCommand;
import com.mrbacon.simplediscordbot.commands.HelpCommand;
import com.mrbacon.simplediscordbot.commands.PingCommand;
import com.mrbacon.simplediscordbot.commands.StopCommand;
import com.mrbacon.simplediscordbot.listeners.JoinWelcomerListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException{

        // Bot Builder

        // Your Bot Token Goes Below

        JDA bot = JDABuilder.createDefault("MTA3MjUxODg3OTU5Njc3NzU0Mw.GW2unX.3M9LvCZxQOa6DzkM1J3j3Y8r5pNUcLo_586R8g")

                // Sets Bot Activity

                .setActivity(Activity.watching("MrBacon"))

                // Enabling Intents

                .enableIntents(GatewayIntent.GUILD_MEMBERS)

                // Adding Listeners

                .addEventListeners(new PingCommand())
                .addEventListeners(new JoinWelcomerListener())
                .addEventListeners(new HelpCommand())
                .addEventListeners(new CoinFlipCommand())
                .addEventListeners(new StopCommand())

                // Building The Bot

                .build();

        // Adding The Slash Commands

        bot.upsertCommand("ping", "Shows some data about the bot.").queue();
        bot.upsertCommand("coinflip", "Flips a coin for you.").queue();
        bot.upsertCommand("help", "The help command for WaterLand.").queue();
        bot.upsertCommand("stop", "Stops the bot (owner only)").queue();

        // This Gets Printed When The Bot Is Ready/Loaded

        System.out.println("[Bot] Bot has successfully started!");

    }
}
