package dev.tiridev.challange.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerDeathEvent implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerDeath(org.bukkit.event.entity.PlayerDeathEvent event) {
        event.setDeathMessage("§d" + event.getEntity().getDisplayName() + " §7ist nun §causgeschieden.");
        event.getEntity().setGameMode(GameMode.SPECTATOR);
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        for(Player player : Bukkit.getOnlinePlayers()) {
            event.setRespawnLocation(player.getLocation());
            break;
        }
    }
}
