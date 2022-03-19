package de.kleesup.minecraft.cloverpluginutilities.inventory.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 *
 * An implementation of {@link GUI} which requires an {@link org.bukkit.inventory.InventoryHolder}
 * (and is also only accessible for them)
 */
public abstract class PlayerGUI extends GUI {

    //the holder
    private final Player holder;

    public PlayerGUI(@NotNull Player holder, int size, String title) {
        super(holder, size, title);
        this.holder = holder;
    }

    public PlayerGUI(@NotNull Player holder, InventoryType type, String title) {
        super(holder, type, title);
        this.holder = holder;
    }

    public PlayerGUI(@NotNull Player holder, InventoryType type) {
        super(holder, type);
        this.holder = holder;
    }

    public PlayerGUI(@NotNull Player holder, int size) {
        super(holder, size);
        this.holder = holder;
    }

    /**
     * @return The holder of the inventory
     */
    public Player getHolder(){
        return holder;
    }

    @Override
    public void open(Player player) {
        if(!player.equals(holder))return;
        super.open(player);
    }

    @Override
    public void close(Player player) {
        if(!player.equals(holder))return;
        super.close(player);
    }
}
