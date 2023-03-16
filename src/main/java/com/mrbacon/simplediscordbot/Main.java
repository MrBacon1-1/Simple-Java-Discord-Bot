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

        JDA bot = JDABuilder.createDefault("token")

                // Sets Bot Activity

                .setActivity(Activity.watching("MrBacon"))

                // Enabling Intents

                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .enableIntents(GatewayIntent.GUILD_BANS)

                // Adding Listeners

                .addEventListeners(new PingCommand())
                .addEventListeners(new JoinWelcomerListener())
                .addEventListeners(new HelpCommand())
                .addEventListeners(new CoinFlipCommand())
                .addEventListeners(new StopCommand())
                .addEventListeners(new ServerStatsCommand())
                .addEventListeners(new KickCommand())
                .addEventListeners(new BanCommand())
                .addEventListeners(new EightBallCommand())
                .addEventListeners(new ServerInfoCommand())
                .addEventListeners(new AddRoleCommand())
                .addEventListeners(new RemoveRoleCommand())

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
        bot.upsertCommand("guildinfo", "Shows some info about the guild.").queue();
        bot.upsertCommand("8ball", "A 8ball Command.").queue();
        bot.upsertCommand("stop", "Stops the bot. (owner only)").queue();
        bot.upsertCommand("serverstats", "Shows some information about the guild.").queue();
        bot.upsertCommand("kick", "Kicks a user from the guild.").addOptions(
                new OptionData(OptionType.USER, "member", "The user you want to kick."),
                new OptionData(OptionType.STRING, "reason", "Why do you want to kick them.")
        ).setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.KICK_MEMBERS, Permission.ADMINISTRATOR)).queue();
        bot.upsertCommand("ban", "Bans a user from the guild.").addOptions(
                new OptionData(OptionType.USER, "member", "The user you want to ban."),
                new OptionData(OptionType.STRING, "reason", "Why do you want to ban them.")
        ).setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.BAN_MEMBERS, Permission.ADMINISTRATOR)).queue();
        bot.upsertCommand("addrole", "Adds a role to a user.").addOptions(
                new OptionData(OptionType.USER, "member", "The user you want to give the role to."),
                new OptionData(OptionType.ROLE, "role", "What role you want to give them.")
        ).setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.MANAGE_ROLES, Permission.ADMINISTRATOR)).queue();
        bot.upsertCommand("removerole", "Removes a role from a user.").addOptions(
                new OptionData(OptionType.USER, "member", "The user you want to take away the role from."),
                new OptionData(OptionType.ROLE, "role", "What role you want to take away.")
        ).setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.MANAGE_ROLES, Permission.ADMINISTRATOR)).queue();



        // This Gets Printed When The Bot Is Ready/Loaded

        System.out.println("-----------------------------------");
        System.out.println("[Bot] Bot has successfully started!");
        System.out.println("-----------------------------------");
    }
}
