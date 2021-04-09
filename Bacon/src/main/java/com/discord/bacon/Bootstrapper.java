package com.discord.bacon;

import com.discord.bacon.bot.BaconBot;
import com.github.kaktushose.jda.commands.entities.JDACommands;
import com.github.kaktushose.jda.commands.entities.JDACommandsBuilder;
import de.kaktushose.discord.reactionwaiter.ReactionListener;

public class Bootstrapper {

    public static void main(String[] args) {
        BaconBot baconBot = new BaconBot("");
        baconBot.start();
        ReactionListener.startListening(baconBot.getJda());
        JDACommands jdaCommands = new JDACommandsBuilder(baconBot.getJda())
                .addProvider(baconBot)
                .setCommandPackage("com.discord.bacon.bot.commands")
                .build();
    }
}
