package dev.tiridev.challange.Commands;

import dev.tiridev.challange.Challange;
import dev.tiridev.challange.Listeners.RandomDamage;
import dev.tiridev.challange.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCommand implements CommandExecutor {

    private Challange plugin;
    private RandomDamage randomDamager;
    private Timer timer;

    public StartCommand(Challange plugin) {
        this.plugin = plugin;
        randomDamager = new RandomDamage(plugin, 600);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(randomDamager.isRunning()){
            sender.sendMessage(Challange.PREFIX + "Die Challange ist bereits aktivert.");
            return true;
        }

        this.timer = plugin.getTimer();

        randomDamager.run();
        timer.setTime(0);
        timer.setRunning(true);
        Bukkit.broadcastMessage(Challange.PREFIX + "Die Challange hat begonnen!");

        return true;
    }

    public Timer getTimer() {
        return timer;
    }
}
