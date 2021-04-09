package com.discord.bacon.bot.commands;

import com.github.kaktushose.jda.commands.annotations.*;
import com.github.kaktushose.jda.commands.api.EmbedCache;
import com.github.kaktushose.jda.commands.entities.CommandEvent;
import net.dv8tion.jda.api.entities.Member;

@CommandController("sub")
public class SubCommand {

    @Inject
    EmbedCache embedCache;

    @Command("greet")
    public void onSubGreet(CommandEvent event, @Optional Member member) {
        event.reply("Hello %s!", member == null ? "World" : member.getAsMention());
    }

    @Command("reactionmsg")
    public void onTellAge(CommandEvent event, @Concat String msg) {
        event.reply(embedCache.getEmbed("reactionmsg"));
    }


}