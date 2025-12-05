package io.github.adrianvic.regions.policy.handlers;

import io.github.adrianvic.regions.policy.Action;
import io.github.adrianvic.regions.policy.NodeHandler;
import io.github.adrianvic.regions.policy.PolicyNode;
import org.bukkit.entity.HumanEntity;

public class attackWith implements NodeHandler {

    @Override
    public boolean allows(HumanEntity entity, PolicyNode node, Action action) {
        if (action == Action.HIT) {
            if (node.values().contains(entity.getMainHand() )) return false; // nope
        }
        return true;
    }
}
