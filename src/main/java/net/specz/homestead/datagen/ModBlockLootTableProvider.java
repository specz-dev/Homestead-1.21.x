package net.specz.homestead.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.specz.homestead.block.ModBlocks;
import net.specz.homestead.block.custom.LucerneCropBlock;
import net.specz.homestead.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.LUCERNE_BALE.get());
        dropSelf(ModBlocks.CLOVER_BALE.get());
        dropSelf(ModBlocks.PASTURE_HAY_BALE.get());

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.LUCERNE_CROP.get())
                .setProperties((StatePropertiesPredicate.Builder.properties().hasProperty(LucerneCropBlock.AGE,7)));
        this.add(ModBlocks.LUCERNE_CROP.get(), this.createCropDrops(ModBlocks.LUCERNE_CROP.get(),
                ModItems.LUCERNE.get(), ModItems.LUCERNE_SEEDS.get(), lootItemConditionBuilder));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
