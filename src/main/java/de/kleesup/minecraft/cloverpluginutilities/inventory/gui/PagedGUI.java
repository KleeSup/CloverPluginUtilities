package de.kleesup.minecraft.cloverpluginutilities.inventory.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 */
public abstract class PagedGUI extends GUI {

    private final ArrayList<GUI> pages = new ArrayList<>();

    public PagedGUI(Player holder, int size, String title) {
        super(holder, size, title);
        addPage(this);
    }
    public PagedGUI(Player holder, InventoryType type, String title) {
        super(holder, type, title);
        addPage(this);
    }
    public PagedGUI(Player holder, InventoryType type) {
        super(holder, type);
        addPage(this);
    }
    public PagedGUI(Player holder, int size) {
        super(holder, size);
        addPage(this);
    }

    public boolean addPage(final GUI gui){
        Objects.requireNonNull(gui, "The GUI to add cannot be null!");
        return pages.add(gui);
    }
    public boolean removePage(final GUI gui){
        Objects.requireNonNull(gui, "The GUI to remove cannot be null!");
        if(gui.equals(this))throw new IllegalArgumentException("Main page of PagedGUI cannot be removed!");
        return pages.remove(gui);
    }
    public GUI getPage(final int index){
        return pages.get(index);
    }
    public int indexOf(final GUI gui){
        Objects.requireNonNull(gui, "The GUI to find the index for cannot be null!");
        return pages.indexOf(gui);
    }
    public boolean contains(final GUI gui){
        return pages.contains(gui);
    }
    public boolean contains(final Inventory inventory){
        Objects.requireNonNull(inventory, "Tried to check page contains but inventory is 'null'");
        for(GUI gui : pages){
            if(gui.getInventory().equals(inventory))return true;
        }
        return false;
    }
    public GUI getMainPage(){
        return this;
    }
    public GUI getLastPage(){
        return pages.get(pages.size()-1);
    }
    public GUI nextPage(final int currentIndex){
        return currentIndex + 1 < pages.size() ? getPage(currentIndex+1) : getLastPage();
    }
    public GUI previousPage(final int currentIndex){
        return currentIndex - 1 >= 0 ? getPage(currentIndex-1) : getMainPage();
    }

    @Override
    public void close(final Player player) {
        Objects.requireNonNull(player, "Player cannot be null!");
        final GUI gui = getFromInventory(player.getInventory());
        if(!contains(gui))return;
        if(gui == this){
            super.close(player);
        }else{
            gui.close(player);
        }
    }

    @Override
    public void close() {
        for(GUI gui : pages){
            if(gui == this){
                super.close();
            }else{
                gui.close();
            }
        }
    }
}
