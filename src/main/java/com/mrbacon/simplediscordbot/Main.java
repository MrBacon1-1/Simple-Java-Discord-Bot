package com.mrbacon.simplediscordbot;

import com.mrbacon.simplediscordbot.commands.HelpCommand;
import com.mrbacon.simplediscordbot.commands.PingCommand;
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

        JDA bot = JDABuilder.createDefault("token")

                // Sets Bot Activity

                .setActivity(Activity.watching("MrBacon"))

                // Enabling Intents

                .enableIntents(GatewayIntent.GUILD_MEMBERS)

                // Adding Listeners

                .addEventListeners(new PingCommand())
                .addEventListeners(new JoinWelcomerListener())
                .addEventListeners(new HelpCommand())

                // Building The Bot

                .build();

        // This Gets Printed When The Bot Is Ready/Loaded

        System.out.println("[Bot] Bot has successfully started");

    }
}
