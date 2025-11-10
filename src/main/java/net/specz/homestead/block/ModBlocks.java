package net.specz.homestead.block;

import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.specz.homestead.Homestead;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.specz.homestead.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Homestead.MODID);

    public static final DeferredBlock<Block> LUCERNE_BALE = registerBlock("lucerne_bale",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(0.5F).sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> CLOVER_BALE = registerBlock("clover_bale",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(0.5F).sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> PASTURE_HAY_BALE = registerBlock("pasture_hay_bale",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(0.5F).sound(SoundType.GRASS)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
