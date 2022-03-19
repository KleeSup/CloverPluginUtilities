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
 *
 * An implementation of {@link GUI} for handling GUI-paging.
 */
public abstract class PagedGUI extends GUI {

    //all pages of this paged GUI
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

    /**
     * Adds a new GUI page
     * @param gui The GUI to add
     * @return {@code true} as specified in {@link ArrayList#add(Object)}
     */
    public boolean addPage(final GUI gui){
        Objects.requireNonNull(gui, "The GUI to add cannot be null!");
        return pages.add(gui);
    }

    /**
     * Removes a GUI page
     * @param gui The GUI to remove
     * @return {@code true} as specified in {@link ArrayList#add(Object)}
     */
    public boolean removePage(final GUI gui){
        Objects.requireNonNull(gui, "The GUI to remove cannot be null!");
        if(gui.equals(this))throw new IllegalArgumentException("Main page of PagedGUI cannot be removed!");
        return pages.remove(gui);
    }

    /**
     * @param index The index of the wanted page
     * @return The page based on its list-index
     */
    public GUI getPage(final int index){
        return pages.get(index);
    }

    /**
     * @param gui The GUI to find the index for
     * @return The index of the given GUI-page
     */
    public int indexOf(final GUI gui){
        Objects.requireNonNull(gui, "The GUI to find the index for cannot be null!");
        return pages.indexOf(gui);
    }

    /**
     * Checks if a GUI is a page
     * @param gui The GUI to check for
     * @return {@code true} if the {@link PagedGUI} contains the {@link GUI} object, {@code false} otherwise
     */
    public boolean contains(final GUI gui){
        return pages.contains(gui);
    }

    /**
     * Checks if an Inventory is a page
     * @param inventory The inventory to check for
     * @return {@code true} if the {@link PagedGUI} contains the {@link Inventory} object, {@code false} otherwise
     */
    public boolean contains(final Inventory inventory){
        Objects.requireNonNull(inventory, "Tried to check page contains but inventory is 'null'");
        for(GUI gui : pages){
            if(gui.getInventory().equals(inventory))return true;
        }
        return false;
    }

    /**
     * @return The main page of the PagedGUI (which is always the GUI itself)
     */
    public GUI getMainPage(){
        return this;
    }

    /**
     * @return The last page of the PagedGUI
     */
    public GUI getLastPage(){
        return pages.get(pages.size()-1);
    }

    /**
     * @param currentIndex The current page-index
     * @return The next page based on the currentIndex
     */
    public GUI nextPage(final int currentIndex){
        return currentIndex + 1 < pages.size() ? getPage(currentIndex+1) : getLastPage();
    }

    /**
     * @param currentIndex The current page-index
     * @return The previous page based on the currentIndex
     */
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
