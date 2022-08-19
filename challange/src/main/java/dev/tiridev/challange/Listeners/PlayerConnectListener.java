package dev.tiridev.challange.Listeners;

import dev.tiridev.challange.Challange;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectListener implements Listener {

    private Challange plugin;

    public PlayerConnectListener(Challange plugin){
        this.plugin = plugin;
    }

    // decided what happened after a player join or leave

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getPlayers().add(event.getPlayer());
        event.getPlayer().setHealth(20);
        event.getPlayer().setFoodLevel(20);
        event.getPlayer().setGameMode(GameMode.SURVIVAL);
        event.setJoinMessage(Challange.PREFIX + "§6" + event.getPlayer().getDisplayName() + " §7hat den Server betreten.");
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) {
        plugin.getPlayers().remove(event.getPlayer());
        event.setQuitMessage("");
    }
}
