package de.kleesup.minecraft.cloverpluginutilities.inventory.recipe;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 *
 * A class for building recipes. The implementations of this class should be used!
 */
public abstract class RecipeBuilder<T extends Recipe> {

    protected T recipe;
    protected RecipeBuilder(final ItemStack result){
        initRecipe(result);
    }

    /**
     * Initiates the recipe in the implementing class
     * @param result The result given by the constructor
     */
    protected abstract void initRecipe(final ItemStack result);

    /**
     * Builds the recipe and returns it.
     * @return The build recipe.
     */
    public T build(){
        return recipe;
    }

}
