package io.github.adrianvic.regions.policy;

import org.bukkit.permissions.Permission;

import java.util.ArrayList;

public record PlayerNamePolicy(String name, ArrayList<String> playerName, PolicyNode nodes, boolean allowlist) {}