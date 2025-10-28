package net.specz.homestead.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.specz.homestead.Homestead;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Homestead.MODID);



    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
