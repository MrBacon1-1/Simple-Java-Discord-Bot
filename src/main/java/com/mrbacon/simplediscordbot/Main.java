package com.mrbacon.simplediscordbot;

import com.mrbacon.simplediscordbot.commands.administrator.*;
import com.mrbacon.simplediscordbot.commands.bot.*;
import com.mrbacon.simplediscordbot.commands.fun.*;
import com.mrbacon.simplediscordbot.commands.server.*;
import com.mrbacon.simplediscordbot.listeners.JoinWelcomerListener;
import com.mrbacon.simplediscordbot.logs.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException{

        // Bot Builder

        // Your Bot Token Goes Below

        JDA bot = JDABuilder.createDefault("")

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
                .addEventListeners(new ServerStatsCommand())
                .addEventListeners(new KickCommand())

                // Logs

                .addEventListeners(new MessageRecievedLog())
                .addEventListeners(new SlashCommandLog())
                .addEventListeners(new ChannelCreateLog())
                .addEventListeners(new ChannelDeleteLog())

                // Building The Bot

                .build();

        // Adding The Slash Commands

        bot.upsertCommand("ping", "Shows some data about the bot.").queue();
        bot.upsertCommand("coinflip", "Flips a coin for you.").queue();
        bot.upsertCommand("help", "The help command for WaterLand.").queue();
        bot.upsertCommand("stop", "Stops the bot. (owner only)").queue();
        bot.upsertCommand("serverstats", "Shows some information about the guild.").queue();
        bot.upsertCommand("kick", "Kicks a player from the guild.").addOptions(
                new OptionData(OptionType.USER, "member", "The user you want to kick."),
                new OptionData(OptionType.STRING, "reason", "Why do you want to kick them.")
        ).setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.KICK_MEMBERS, Permission.ADMINISTRATOR)).queue();



        // This Gets Printed When The Bot Is Ready/Loaded

        System.out.println("[Bot] Bot has successfully started!");
    }
}
