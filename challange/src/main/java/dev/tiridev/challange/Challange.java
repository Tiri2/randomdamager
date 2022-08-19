package dev.tiridev.challange;

import dev.tiridev.challange.Commands.StartCommand;
import dev.tiridev.challange.Listeners.EnitiyDeathEvent;
import dev.tiridev.challange.Listeners.PlayerConnectListener;
import dev.tiridev.challange.Listeners.PlayerDeathEvent;
import dev.tiridev.challange.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Challange extends JavaPlugin {

    public final static String PREFIX = "§7[§6Challange§7] §7";

    private ArrayList<Player> players;
    private Timer timer;

    @Override
    public void onEnable() {

        // Create a new Timer
        this.timer = new Timer(false, 0, this);
        players = new ArrayList<>();

        init(Bukkit.getPluginManager());
    }

    private void init(PluginManager pluginManager){
        // Register events and commands.
        pluginManager.registerEvents(new PlayerConnectListener(this), this);
        pluginManager.registerEvents(new EnitiyDeathEvent(this.timer), this);
        pluginManager.registerEvents(new PlayerDeathEvent(), this);

        getCommand("start").setExecutor(new StartCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Timer getTimer() {
        return timer;
    }
}
