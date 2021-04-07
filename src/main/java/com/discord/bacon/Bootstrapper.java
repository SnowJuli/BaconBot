package com.discord.bacon;

import com.discord.bacon.bot.BaconBot;

public class Bootstrapper {

    public static void main(String[] args) {
        BaconBot baconBot = new BaconBot("");
        baconBot.start();
    }

}
