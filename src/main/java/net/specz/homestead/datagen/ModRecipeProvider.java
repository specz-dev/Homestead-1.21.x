package net.specz.homestead.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.specz.homestead.block.ModBlocks;
import net.specz.homestead.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        // SHAPED RECIPES
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CLOVER_BALE.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.CLOVER.get())
                .unlockedBy("has_clover", has(ModItems.CLOVER)).save(recipeOutput);

        // SHAPELESS RECIPES
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.LUCERNE_BALE.get())
                .requires(ModItems.LUCERNE.get(),9)
                .unlockedBy("has_lucerne", has(ModItems.LUCERNE))
                .save(recipeOutput, "homestead:lucerne_bale_from_lucerne");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.LUCERNE.get(), 9)
                .requires(ModBlocks.LUCERNE_BALE)
                .unlockedBy("has_lucerne_bale", has(ModBlocks.LUCERNE_BALE))
                .save(recipeOutput, "homestead:lucerne_from_lucerne_bale");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.CLOVER_BALE.get())
                .requires(ModItems.CLOVER.get(),9)
                .unlockedBy("has_clover", has(ModItems.CLOVER))
                .save(recipeOutput, "homestead:clover_bale_from_clover");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.CLOVER.get(), 9)
                .requires(ModBlocks.CLOVER_BALE)
                .unlockedBy("has_clover_bale", has(ModBlocks.CLOVER_BALE))
                .save(recipeOutput, "homestead:clover_from_clover_bale");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.PASTURE_HAY_BALE.get())
                .requires(ModItems.PASTURE_HAY.get(),9)
                .unlockedBy("has_pasture_hay", has(ModItems.PASTURE_HAY))
                .save(recipeOutput, "homestead:pasture_hay_bale_from_pasture_hay");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.PASTURE_HAY.get(), 9)
                .requires(ModBlocks.PASTURE_HAY_BALE)
                .unlockedBy("has_pasture_hay_bale", has(ModBlocks.PASTURE_HAY_BALE))
                .save(recipeOutput, "homestead:pasture_hay_from_pasture_hay_bale");



    }
}
