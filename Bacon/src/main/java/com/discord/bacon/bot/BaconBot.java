package com.discord.bacon.bot;

import com.github.kaktushose.jda.commands.annotations.Produces;
import com.github.kaktushose.jda.commands.api.EmbedCache;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class BaconBot {

    private static final Logger log = LoggerFactory.getLogger(BaconBot.class);
    private final String token;
    private JDA jda;

    private final EmbedCache embedCache;

    public BaconBot(String token) {
        embedCache = new EmbedCache("./embeds.json");
        embedCache.loadEmbedsToCache();
        this.token = token;
    }

    public boolean start() {
        log.info("Starting bot...");
        try {
            jda = JDABuilder.create(
                    token,
                    GatewayIntent.GUILD_MEMBERS,
                    GatewayIntent.GUILD_VOICE_STATES,
                    GatewayIntent.GUILD_MESSAGES,
                    GatewayIntent.GUILD_MESSAGE_REACTIONS
            ).disableCache(
                    CacheFlag.ACTIVITY,
                    CacheFlag.EMOTE,
                    CacheFlag.CLIENT_STATUS
            ).setChunkingFilter(
                    ChunkingFilter.ALL
            ).setMemberCachePolicy(
                    MemberCachePolicy.ALL
            ).setActivity(
                    Activity.playing("starting...")
            ).setStatus(
                    OnlineStatus.DO_NOT_DISTURB
            ).build().awaitReady();
        } catch (InterruptedException | LoginException e) {
            log.error("Unable to start bot!", e);
            return false;
        }
        return true;
    }

    public JDA getJda() {
        return jda;
    }

    @Produces
    public EmbedCache embedCache() {
        return embedCache;
    }
}
