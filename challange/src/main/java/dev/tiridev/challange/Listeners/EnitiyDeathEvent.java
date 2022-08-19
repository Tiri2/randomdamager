package dev.tiridev.challange.Listeners;

import dev.tiridev.challange.Challange;
import dev.tiridev.challange.Commands.StartCommand;
import dev.tiridev.challange.timer.Timer;
import jdk.javadoc.internal.tool.Start;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EnitiyDeathEvent implements Listener {

    private Timer timer;

    public EnitiyDeathEvent(Timer timer) {
        this.timer = timer;
    }

    // Send a message if the enderman is killed.
    @EventHandler(priority = EventPriority.MONITOR)
    private void entityDeathEventHandler(EntityDeathEvent event) {
        if (event.getEntityType() == EntityType.ENDER_DRAGON) {
            int seconds = timer.getTime();

            // Convert seconds into 00:00:00
            int sec = seconds % 60;
            int min = (seconds / 60)%60;
            int hours = (seconds/60)/60;
            String strSec=(sec<10)?"0"+ sec :Integer.toString(sec);
            String strmin=(min<10)?"0"+ min :Integer.toString(min);
            String strHours=(hours<10)?"0"+ hours :Integer.toString(hours);

            //broadcast the message
            Bukkit.broadcastMessage("» ────────────────────── «");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage(Challange.PREFIX + "GG! Ihr habt die Challange §agewonnen.");
            Bukkit.broadcastMessage("§7Dafür habt ihr §6" + strHours + " Stunde(n), \n" +
                    "" + strmin + " Minute(n), " + strSec + " Sekunde(n) §7gebraucht.");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("» ────────────────────── «");

            // Pause the timer
            timer.setRunning(false);

        }
    }

}
