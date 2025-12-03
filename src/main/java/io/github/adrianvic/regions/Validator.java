package io.github.adrianvic.regions;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;


public class Validator {
    ArrayList<Material> blacklistedItems = new ArrayList<Material>();

    public Validator() {
        blacklistedItems.add(Material.COPPER_SWORD);
        blacklistedItems.add(Material.COPPER_AXE);
        blacklistedItems.add(Material.COPPER_HOE);
        blacklistedItems.add(Material.ROTTEN_FLESH);
    }

    public boolean isHumanoidAbleToHit(HumanEntity damager) {
        return isItemValid(damager.getInventory().getItemInMainHand().getType());
    }

    public boolean isHumanoidAbleToHarvest(HumanEntity harvester) {
        return isItemValid(harvester.getInventory().getItemInMainHand().getType());
    }

    public boolean isItemValid(Material item) {
        return !blacklistedItems.contains(item);
    }

    public void warnPlayer(Player player) {
        Location loc = player.getLocation();
        loc.getWorld().strikeLightningEffect(loc);
        player.sendMessage("Please note that you are not allowed to do this here!");
    }
}
