package dev.tiridev.challange.Listeners;

import dev.tiridev.challange.Challange;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Random;

public class RandomDamage{

    private Challange plugin;
    private int time;

    private boolean isRunning;
    private int taskID;

    private int pass;
    private Random random;

    public RandomDamage(Challange plugin, int time) {
        this.plugin = plugin;
        this.time = time;
        random = new Random();

        pass = 0;
    }

    // Set the player health to a random int.
    // that happened every minute.
    public void run(){
        isRunning = true;
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

            @Override
            public void run() {
                for(Player player : plugin.getPlayers()){
                    player.setHealth(random.nextInt(20));
                    player.sendMessage(Challange.PREFIX + "Dein Leben wurde §cgeändert." +
                            "\n§cVIEL GLÜCK! §7MUHAHAHAHAHAHAHA");
                }

                pass++;
            }
        }, 0, 1200);
    }


    public void stop(){
        if(isRunning){
            Bukkit.getScheduler().cancelTask(taskID);
            isRunning = false;
            pass = 0;
        }
    }

    public int getPass() {
        return pass;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
