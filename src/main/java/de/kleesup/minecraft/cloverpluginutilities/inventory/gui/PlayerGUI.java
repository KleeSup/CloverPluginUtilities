package de.kleesup.minecraft.cloverpluginutilities.inventory.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 */
public abstract class PlayerGUI extends GUI {

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

    public Player getHolder(){
        return getHolder();
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
