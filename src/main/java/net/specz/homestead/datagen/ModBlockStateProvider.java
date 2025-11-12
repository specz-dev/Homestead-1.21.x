package net.specz.homestead.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.specz.homestead.Homestead;
import net.specz.homestead.block.ModBlocks;
import net.specz.homestead.block.custom.LucerneCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Homestead.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerBale(ModBlocks.LUCERNE_BALE, "lucerne_bale_side", "lucerne_bale_top");
        registerBale(ModBlocks.CLOVER_BALE, "clover_bale_side", "clover_bale_top");
        registerBale(ModBlocks.PASTURE_HAY_BALE, "pasture_hay_bale_side", "pasture_hay_bale_top");

        makeCrop(((CropBlock) ModBlocks.LUCERNE_CROP.get()),"lucerne_crop_stage", "lucerne_crop_stage");
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LucerneCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(Homestead.MODID, "block/" + textureName + state.getValue(((LucerneCropBlock) block).getAgeProperty()))).renderType("cutout"));
        return models;
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


