package de.kleesup.minecraft.cloverpluginutilities.inventory.gui;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 */
public abstract class GUI {

    private static final HashMap<Inventory, GUI> MAP_INV = new HashMap<>();
    public static void registerGUI(final GUI gui){
        MAP_INV.put(gui.inventory, gui);
    }
    public static void unregisterGUI(final GUI gui){
        MAP_INV.remove(gui.inventory);
    }
    public static GUI getFromInventory(final Inventory inventory){
        return MAP_INV.getOrDefault(inventory,null);
    }

    private final Inventory inventory;

    //events
    protected Consumer<InventoryClickEvent> clickEvent;
    protected Consumer<InventoryOpenEvent> openEvent;
    protected Consumer<InventoryCloseEvent> closeEvent;

    public GUI(final Player holder, final int size, final String title){
        this.inventory = Bukkit.createInventory(holder,size, Component.text(title));
        registerGUI(this);
        buildInventory();
    }
    public GUI(final Player holder, final InventoryType type, final String title){
        this.inventory = Bukkit.createInventory(holder, type, Component.text(title));
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

    public abstract void buildInventory();

    public Inventory getInventory(){
        return inventory;
    }
    public void open(final Player player){
        player.openInventory(inventory);
    }
    public void close(final Player player){
        if(player.getOpenInventory().getTopInventory().equals(inventory))player.closeInventory();
    }
    public void close(){
        inventory.close();
    }

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
