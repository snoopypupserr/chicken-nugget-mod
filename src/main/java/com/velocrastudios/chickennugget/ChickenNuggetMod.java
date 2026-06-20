package com.velocrastudios.chickennugget;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(ChickenNuggetMod.MODID)
public class ChickenNuggetMod {
    public static final String MODID = "chicken_nugget";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> CHICKEN_NUGGET = ITEMS.registerSimpleItem("chicken_nugget",
            new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2).saturationModifier(0.4f).build()));

    public ChickenNuggetMod(IEventBus modEventBus, ModContainer modContainer) {
        ITEMS.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(CreativeModeTabs.FOOD_AND_DRINKS)) {
            event.accept(CHICKEN_NUGGET);
        }
    }
}
