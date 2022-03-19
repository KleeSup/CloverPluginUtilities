package de.kleesup.minecraft.cloverpluginutilities;

import de.kleesup.minecraft.cloverpluginutilities.inventory.gui.GuiListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CloverPluginUtilities extends JavaPlugin {

    public static void register(final JavaPlugin plugin){
        plugin.getServer().getPluginManager().registerEvents(new GuiListener(), plugin);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
