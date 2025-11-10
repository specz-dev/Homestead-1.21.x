package net.specz.homestead.item;

import net.specz.homestead.Homestead;
import net.specz.homestead.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Homestead.MODID);

    public static final Supplier<CreativeModeTab> HOMESTEAD = CREATIVE_MODE_TAB.register("homestead",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.LUCERNE.get()))
                    .title(Component.translatable("creativetab.homestead.homestead"))
                    .displayItems((params, output) -> {
                        output.accept(ModItems.LUCERNE_SEEDS.get());
                        output.accept(ModItems.CLOVER_SEEDS.get());
                        output.accept(ModItems.PASTURE_HAY_SEEDS.get());

                        output.accept(ModItems.LUCERNE.get());
                        output.accept(ModItems.CLOVER.get());
                        output.accept(ModItems.PASTURE_HAY.get());

                        output.accept(ModBlocks.LUCERNE_BALE.get().asItem());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
