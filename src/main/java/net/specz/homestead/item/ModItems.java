package net.specz.homestead.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.specz.homestead.Homestead;
import net.specz.homestead.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Homestead.MODID);

    // ITEMS
    public static final DeferredItem<Item> LUCERNE = ITEMS.register("lucerne",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CLOVER = ITEMS.register("clover",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PASTURE_HAY = ITEMS.register("pasture_hay",
            () -> new Item(new Item.Properties()));

    // SEEDS
    public static final DeferredItem<Item> LUCERNE_SEEDS = ITEMS.register("lucerne_seeds",
            () -> new ItemNameBlockItem(ModBlocks.LUCERNE_CROP.get(), new Item.Properties()));

    public static final DeferredItem<Item> CLOVER_SEEDS = ITEMS.register("clover_seeds",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PASTURE_HAY_SEEDS = ITEMS.register("pasture_hay_seeds",
            () -> new Item(new Item.Properties()));

    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
