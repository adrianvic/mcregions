package io.github.adrianvic.regions;

import io.github.adrianvic.regions.policy.PolicyNode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static boolean canInteract(HumanEntity entity) {
        return true;
    }

    public static boolean canBreak(HumanEntity entity) {
        return true;
    }

    public static boolean canHit(HumanEntity entity) {
        return true;
    }

    public static List<PolicyNode> getPoliciesFor(HumanEntity entity) {
        return new ArrayList<>();
    }
}
