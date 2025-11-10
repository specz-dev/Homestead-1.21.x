package net.specz.homestead.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.specz.homestead.Homestead;
import net.specz.homestead.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Homestead.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerBale(ModBlocks.LUCERNE_BALE, "lucerne_bale_side", "lucerne_bale_top");
        registerBale(ModBlocks.CLOVER_BALE, "clover_bale_side", "clover_bale_top");
        registerBale(ModBlocks.PASTURE_HAY_BALE, "pasture_hay_bale_side", "pasture_hay_bale_top");
    }

    private void registerBale(DeferredBlock<?> block, String sideTexture, String topTexture) {
        simpleBlockWithItem(
                block.get(),
                models().withExistingParent(block.getId().getPath(), mcLoc("cube_column"))
                        .texture("end", modLoc("block/" + topTexture))
                        .texture("side", modLoc("block/" + sideTexture))
        );
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                cubeAll(deferredBlock.get())
        );
    }
}


