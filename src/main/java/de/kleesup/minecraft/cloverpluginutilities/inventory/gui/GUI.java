package de.kleesup.minecraft.cloverpluginutilities.inventory.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 *
 * A class that lets users create GUIs with custom handlers.
 */
public abstract class GUI {

    private static final HashMap<Inventory, GUI> MAP_INV = new HashMap<>();

    /**
     * Registers a GUI object. This method gets always called by the {@link GUI} constructor
     * @param gui The GUI to register
     */
    public static void registerGUI(final GUI gui){
        MAP_INV.put(gui.inventory, gui);
    }

    /**
     * Unregisters a GUI object from the map. All events etc. won't be handled by the {@link GuiListener} anymore
     * @param gui The GUI to unregister
     */
    public static void unregisterGUI(final GUI gui){
        MAP_INV.remove(gui.inventory);
    }

    /**
     * Gets a GUI object from an inventory
     * @param inventory The inventory that is bound to an GUI
     * @return The GUI object from this inventory
     */
    public static GUI getFromInventory(final Inventory inventory){
        return MAP_INV.getOrDefault(inventory,null);
    }

    private final Inventory inventory;

    //events
    protected Consumer<InventoryClickEvent> clickEvent;
    protected Consumer<InventoryOpenEvent> openEvent;
    protected Consumer<InventoryCloseEvent> closeEvent;

    public GUI(final Player holder, final int size, final String title){
        this.inventory = Bukkit.createInventory(holder,size, title);
        registerGUI(this);
        buildInventory();
    }
    public GUI(final Player holder, final InventoryType type, final String title){
        this.inventory = Bukkit.createInventory(holder, type, title);
        registerGUI(this);
        buildInventory();
    }
    public GUI(final Player holder, final InventoryType type){
        this.inventory = Bukkit.createInventory(holder, type);
        registerGUI(this);
        buildInventory();
    }
    public GUI(final Player holder, final int size){
        this.inventory = Bukkit.createInventory(holder,size);
        registerGUI(this);
        buildInventory();
    }

    /**
     * Method for editing the freshly built inventory
     */
    public abstract void buildInventory();

    /**
     * @return The inventory of this GUI
     */
    public Inventory getInventory(){
        return inventory;
    }

    /**
     * Opens this GUI for a player
     * @param player The player to open for
     */
    public void open(final Player player){
        player.openInventory(inventory);
    }

    /**
     * Closes the GUI for a certain player
     * @param player The player to close the GUI for
     */
    public void close(final Player player){
        if(player.getOpenInventory().getTopInventory().equals(inventory))player.closeInventory();
    }

    /**
     * Closes the GUI for all viewers
     */
    public void close(){
        for(HumanEntity viewer : inventory.getViewers()){
            viewer.closeInventory();
        }
    }

    //register events
    public void setClickEvent(Consumer<InventoryClickEvent> clickEvent) {
        this.clickEvent = clickEvent;
    }
    public void setOpenEvent(Consumer<InventoryOpenEvent> openEvent) {
        this.openEvent = openEvent;
    }
    public void setCloseEvent(Consumer<InventoryCloseEvent> closeEvent) {
        this.closeEvent = closeEvent;
    }



}
