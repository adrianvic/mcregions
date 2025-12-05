package io.github.adrianvic.regions.policy;

import org.bukkit.entity.HumanEntity;

public interface NodeHandler {
    boolean allows(HumanEntity entity, PolicyNode node, Action action);
}