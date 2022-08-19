package dev.tiridev.challange.timer;

import dev.tiridev.challange.Challange;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    private boolean running;
    private int time;
    private Challange plugin;

    public Timer(boolean running, int time, Challange plugin) {
        this.running = running;
        this.time = time;
        this.plugin = plugin;

        run();
    }


    // Send player actionbar
    public void sendActionBar(){
        for (Player player : Bukkit.getOnlinePlayers()){
            if(!isRunning()){
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§cTimer is paused."));
                continue;
            }

            int seconds = getTime();

            int sec = seconds % 60;
            int min = (seconds / 60)%60;
            int hours = (seconds/60)/60;

            String strSec=(sec<10)?"0"+ sec :Integer.toString(sec);
            String strmin=(min<10)?"0"+ min :Integer.toString(min);
            String strHours=(hours<10)?"0"+ hours :Integer.toString(hours);

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6§l" + strHours + ":" + strmin + ":" + strSec));
        }
    }


    // Timer itself. it counts every second + 1 to int time
    private void run(){
        new BukkitRunnable() {
            @Override
            public void run() {

                sendActionBar();

                if(!isRunning()){
                    return;
                }

                setTime(getTime() + 1);
            }
        }.runTaskTimer(plugin, 20, 20);
    }












    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public boolean isRunning() {
        return running;
    }
}
