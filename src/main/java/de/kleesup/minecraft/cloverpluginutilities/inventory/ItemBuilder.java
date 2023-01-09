package de.kleesup.minecraft.cloverpluginutilities.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.function.Consumer;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 */
public class ItemBuilder {

    private final ItemStack is;
    public ItemBuilder(final Material material, int amount, byte data){
        this.is = new ItemStack(material, amount, data);
    }
    public ItemBuilder(final Material material, int amount){
        this(material,amount,(byte)0);
    }
    public ItemBuilder(final Material material){
        this(material,1,(byte) 0);
    }
    public ItemBuilder(final ItemStack itemStack){
        if(itemStack == null)throw new IllegalArgumentException("ItemStack cannot be null!");
        this.is = itemStack;
    }

    public ItemStack build(){
        return is;
    }

    public <T extends ItemMeta> ItemBuilder editMeta(final Class<T> clazz, final Consumer<ItemMeta> consumer){
        is.editMeta(clazz,consumer);
        return this;
    }
    public ItemBuilder editMeta(final Consumer<ItemMeta> consumer){
        return editMeta(ItemMeta.class, consumer);
    }

    public ItemBuilder setAmount(final int amount){
        is.setAmount(amount);
        return this;
    }
    public ItemBuilder setType(final Material material){
        is.setType(material);
        return this;
    }
    public ItemBuilder setData(final MaterialData data){
        is.setData(data);
        return this;
    }


}
