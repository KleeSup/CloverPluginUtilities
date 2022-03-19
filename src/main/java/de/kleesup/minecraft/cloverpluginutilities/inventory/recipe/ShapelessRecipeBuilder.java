package de.kleesup.minecraft.cloverpluginutilities.inventory.recipe;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.material.MaterialData;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 *
 * An implementation of {@link RecipeBuilder} for creating bukkit's {@link ShapelessRecipe}
 */
public class ShapelessRecipeBuilder extends RecipeBuilder<ShapelessRecipe> {

    private final NamespacedKey key;
    public ShapelessRecipeBuilder(NamespacedKey key, ItemStack result) {
        super(result);
        this.key = key;
    }

    @Override
    protected void initRecipe(ItemStack result) {
        this.recipe = new ShapelessRecipe(key,result);
    }

    public ShapelessRecipeBuilder addIngredient(final ItemStack ingredient){
        recipe.addIngredient(ingredient);
        return this;
    }
    public ShapelessRecipeBuilder addIngredient(final Material ingredient){
        recipe.addIngredient(ingredient);
        return this;
    }
    @SuppressWarnings("deprecation")
    public ShapelessRecipeBuilder addIngredient(final MaterialData ingredient){
        recipe.addIngredient(ingredient);
        return this;
    }
    public ShapelessRecipeBuilder addIngredient(final RecipeChoice ingredient){
        recipe.addIngredient(ingredient);
        return this;
    }

    public ShapelessRecipeBuilder removeIngredient(final ItemStack ingredient){
        recipe.removeIngredient(ingredient);
        return this;
    }
    public ShapelessRecipeBuilder removeIngredient(final Material ingredient){
        recipe.removeIngredient(ingredient);
        return this;
    }
    @SuppressWarnings("deprecation")
    public ShapelessRecipeBuilder removeIngredient(final MaterialData ingredient){
        recipe.removeIngredient(ingredient);
        return this;
    }
    public ShapelessRecipeBuilder removeIngredient(final RecipeChoice ingredient){
        recipe.removeIngredient(ingredient);
        return this;
    }

}
