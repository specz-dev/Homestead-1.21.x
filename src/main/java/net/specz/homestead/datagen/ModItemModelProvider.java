package net.specz.homestead.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.specz.homestead.Homestead;
import net.specz.homestead.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Homestead.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.LUCERNE.get());
        basicItem(ModItems.CLOVER.get());
        basicItem(ModItems.PASTURE_HAY.get());

        basicItem(ModItems.LUCERNE_SEEDS.get());
        basicItem(ModItems.CLOVER_SEEDS.get());
        basicItem(ModItems.PASTURE_HAY_SEEDS.get());
    }
}
