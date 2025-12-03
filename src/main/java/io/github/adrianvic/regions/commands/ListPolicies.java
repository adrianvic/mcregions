package io.github.adrianvic.regions.commands;

import io.github.adrianvic.regions.Config;
import io.github.adrianvic.regions.policy.LocationPolicy;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListPolicies implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        List<String> rstr = new ArrayList<>();
        for (LocationPolicy p : Config.getInstance().getLocationPolicies()) {
            rstr.add(p.name());
        }
        commandSender.sendMessage(String.join(", ", rstr) + ".");
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        return List.of();
    }
}
