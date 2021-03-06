package de.kleesup.minecraft.cloverpluginutilities.inventory.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 *
 * A listener registered by {@link de.kleesup.minecraft.cloverpluginutilities.CloverPluginUtilities#register(JavaPlugin)} to handle
 * GUI interactions. This listener is needs to be registered in order to make GUIs work.
 */
public class GuiListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInventoryClick(final InventoryClickEvent event){
        final GUI gui = GUI.getFromInventory(event.getInventory());
        if(gui != null){
            gui.clickEvent.accept(event);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInventoryOpen(final InventoryOpenEvent event){
        final GUI gui = GUI.getFromInventory(event.getInventory());
        if(gui != null){
            gui.openEvent.accept(event);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInventoryOpen(final InventoryCloseEvent event){
        final GUI gui = GUI.getFromInventory(event.getInventory());
        if(gui != null){
            gui.closeEvent.accept(event);
        }
    }

}
