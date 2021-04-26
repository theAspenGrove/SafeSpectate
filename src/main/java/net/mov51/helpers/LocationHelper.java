package net.mov51.helpers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Objects;

import static net.mov51.helpers.ChatHelper.sendChat;

public class LocationHelper {
    public static String LocationToString(Location l){
        String world = Objects.requireNonNull(l.getWorld()).getName();
        String x = String.valueOf(l.getX());
        String y = String.valueOf(l.getY());
        String z = String.valueOf(l.getZ());
        String Y = String.valueOf(l.getYaw());
        String P = String.valueOf(l.getPitch());

        return  world  + "," + x + "," + y + "," + z  + "," + Y  + "," + P;
    }

    public static Location LocationFromString(String s) {
        //split the provided string by ,
        String[] sA = s.split(",");

        //separate the array and typecast
        World world = Bukkit.getWorld(sA[0]);
        double x = Double.parseDouble(sA[1]);
        double y = Double.parseDouble(sA[2]);
        double z = Double.parseDouble(sA[3]);
        float Y = Float.parseFloat(sA[4]);
        float P = Float.parseFloat(sA[5]);

        //Parse then return the location
        return new Location(world, x, y, z, Y, P);
    }
    public static void TeleportPlayer(Player p, Location l){
        Location CurrentLocation = p.getLocation();
        if(l != CurrentLocation){
            p.teleport(l);
            sendChat("You have been teleported back to " + Math.round(l.getX()) + "," + Math.round(l.getX()) + "," + Math.round(l.getZ()) + ".", p);
        }

    }
}