package io.github.adrianvic.regions;

import io.github.adrianvic.regions.commands.ListPolicies;
import io.github.adrianvic.regions.commands.PolicyInfo;
import org.bukkit.plugin.java.JavaPlugin;

public final class Regions extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlaceListener(), this);
        Config.getInstance().load();
        getCommand("mrlistpolicies").setExecutor(new ListPolicies());
        getCommand("mrpolicyinfo").setExecutor(new PolicyInfo());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Regions getInstance() {
        return getPlugin(Regions.class);
    }
}