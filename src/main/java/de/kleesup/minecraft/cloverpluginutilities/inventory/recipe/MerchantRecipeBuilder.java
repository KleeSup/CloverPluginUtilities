package de.kleesup.minecraft.cloverpluginutilities.inventory.recipe;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 19.03.2022
 *
 * An implementation of {@link RecipeBuilder} for creating bukkit's {@link MerchantRecipe}
 */
public class MerchantRecipeBuilder extends RecipeBuilder<MerchantRecipe> {

    private final int maxUses;
    public MerchantRecipeBuilder(ItemStack result, final int maxUses) {
        super(result);
        this.maxUses = maxUses;
    }

    @Override
    protected void initRecipe(ItemStack result) {
        this.recipe = new MerchantRecipe(result,maxUses);
    }

    //editing methods
    public MerchantRecipeBuilder addIngredient(final ItemStack itemStack){
        recipe.addIngredient(itemStack);
        return this;
    }
    public MerchantRecipeBuilder setDemand(final int demand){
        recipe.setDemand(demand);
        return this;
    }
    public MerchantRecipeBuilder setIgnoreDiscounts(final boolean ignoreDiscounts){
        recipe.setIgnoreDiscounts(ignoreDiscounts);
        return this;
    }
    public MerchantRecipeBuilder setPriceMultiplier(final float priceMultiplier){
        recipe.setPriceMultiplier(priceMultiplier);
        return this;
    }
    public MerchantRecipeBuilder setExperienceReward(final boolean experienceReward){
        recipe.setExperienceReward(experienceReward);
        return this;
    }
    public MerchantRecipeBuilder setSpecialPrice(final int specialPrice){
        recipe.setSpecialPrice(specialPrice);
        return this;
    }
    public MerchantRecipeBuilder setVillagerExperience(final int villagerExperience){
        recipe.setVillagerExperience(villagerExperience);
        return this;
    }
    public MerchantRecipeBuilder setUses(final int uses){
        recipe.setUses(uses);
        return this;
    }



}
