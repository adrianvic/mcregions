package io.github.adrianvic.regions.commands;

import io.github.adrianvic.regions.Config;
import io.github.adrianvic.regions.policy.LocationPolicy;
import io.github.adrianvic.regions.policy.PolicyNode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PolicyInfo implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        List<LocationPolicy> policies = Config.getInstance().getLocationPolicies();
        for (LocationPolicy lp : policies) {
            if (lp.name().equals(strings[0])) {
                String locations = lp.locations().toString();

                List<PolicyNode> nodes = lp.nodes();
                List<String> nodeNames = new ArrayList<>();
                for (PolicyNode n : nodes) {
                    nodeNames.add(n.type());
                }
                String nodesStr = String.join(", ", nodeNames) + ".";

                commandSender.sendMessage(String.format("""
                        Showing info for policy "%s":
                        Type: %s
                        Locations: %s
                        Nodes: %s
                        %s
                        """, lp.name(), "location", locations, nodesStr, lp.allowlist() ? "Is allowlist" : "Is blacklist"));
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        List<String> rstr = new ArrayList<>();
        for (LocationPolicy p : Config.getInstance().getLocationPolicies()) {
            rstr.add(p.name());
        }
        return rstr;
    }
}
