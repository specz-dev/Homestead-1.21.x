package net.specz.homestead.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.specz.homestead.block.ModBlocks;
import net.specz.homestead.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModBlocks.LUCERNE_BALE.getId(), new Compostable(85), false)
                .add(ModBlocks.CLOVER_BALE.getId(), new Compostable(85), false)
                .add(ModBlocks.PASTURE_HAY_BALE.getId(), new Compostable(85), false);
    }
}
