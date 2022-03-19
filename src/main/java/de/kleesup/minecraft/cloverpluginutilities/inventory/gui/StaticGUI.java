package de.kleesup.minecraft.cloverpluginutilities.inventory.gui;

import org.bukkit.event.inventory.InventoryType;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 *
 * An implementation of {@link GUI} for static inventories (no {@link org.bukkit.inventory.InventoryHolder} is needed)
 */
public abstract class StaticGUI extends GUI {
    public StaticGUI(int size, String title) {
        super(null, size, title);
    }

    public StaticGUI(InventoryType type, String title) {
        super(null, type, title);
    }

    public StaticGUI(InventoryType type) {
        super(null, type);
    }

    public StaticGUI(int size) {
        super(null, size);
    }
}
