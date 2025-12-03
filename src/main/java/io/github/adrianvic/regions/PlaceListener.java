package io.github.adrianvic.regions;

import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlaceListener implements Listener {
    Validator val = new Validator();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        event.setCancelled(!val.isHumanoidAbleToHarvest(event.getPlayer()));
    }

    @EventHandler
    public void onInteractionEvent(PlayerInteractEvent event) {
        if (event.getItem() != null) {
            event.setCancelled(!val.isItemValid(event.getItem().getType()));
        }
    }

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof HumanEntity player) {
            boolean canceled = !val.isHumanoidAbleToHit(player);
            event.setCancelled(canceled);
        }
    }
}
