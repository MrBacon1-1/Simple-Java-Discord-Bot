package com.mrbacon.simplediscordbot;

import com.mrbacon.simplediscordbot.Commands.Ping;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException{

        // Bot Builder

        // Your Bot Token Goes Below

        JDA bot = JDABuilder.createDefault("MTA3MjUxODg3OTU5Njc3NzU0Mw.GqNreh.021lT4jx8c-3INp-Nibm6vSJXBAsfvOTem8Pkc")

                // Sets Bot Activity

                .setActivity(Activity.watching("MrBacon"))

                // Enabling Intents

                .enableIntents(GatewayIntent.GUILD_MEMBERS)

                // Adding Listeners

                .addEventListeners(new Ping())

                // Building The Bot

                .build();

        // This Gets Printed When The Bot Is Ready/Loaded

        System.out.println("Bot is up and running :D");

    }
}