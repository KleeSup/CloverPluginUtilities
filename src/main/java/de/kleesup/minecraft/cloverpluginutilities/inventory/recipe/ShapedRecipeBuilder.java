package de.kleesup.minecraft.cloverpluginutilities.inventory.recipe;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.material.MaterialData;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 *
 * An implementation of {@link RecipeBuilder} for creating bukkit's {@link ShapedRecipe}
 */
public class ShapedRecipeBuilder extends RecipeBuilder<ShapedRecipe> {

    private ShapedRecipeIngredientsBuilder ingredientsBuilder = null;
    private final NamespacedKey key;
    public ShapedRecipeBuilder(NamespacedKey key, ItemStack result) {
        super(result);
        this.key = key;
    }

    public ShapedRecipeIngredientsBuilder setShape(final String... shape){
        recipe.shape(shape);
        if(ingredientsBuilder == null)ingredientsBuilder = new ShapedRecipeIngredientsBuilder(this);
        return ingredientsBuilder;
    }

    @Override
    protected void initRecipe(final ItemStack result) {
        this.recipe = new ShapedRecipe(key,result);
    }

    private static final class ShapedRecipeIngredientsBuilder{

        private final ShapedRecipeBuilder builder;
        private ShapedRecipeIngredientsBuilder(final ShapedRecipeBuilder builder){
            this.builder = builder;
        }
        public ShapedRecipeIngredientsBuilder setIngredient(final char key, final ItemStack ingredient){
            builder.recipe.setIngredient(key,ingredient);
            return this;
        }
        public ShapedRecipeIngredientsBuilder setIngredient(final char key, final Material ingredient){
            builder.recipe.setIngredient(key,ingredient);
            return this;
        }
        @SuppressWarnings("deprecation")
        public ShapedRecipeIngredientsBuilder setIngredient(final char key, final MaterialData ingredient){
            builder.recipe.setIngredient(key,ingredient);
            return this;
        }
        public ShapedRecipeIngredientsBuilder setIngredient(final char key, final RecipeChoice recipeChoice){
            builder.recipe.setIngredient(key,recipeChoice);
            return this;
        }

        public Recipe build(){
            return builder.build();
        }

    }

}
