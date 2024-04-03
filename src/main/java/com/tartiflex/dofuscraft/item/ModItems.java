package com.tartiflex.dofuscraft.item;

import com.tartiflex.dofuscraft.Dofuscraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RAZIELLE = registerItem("razielle", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item GOULTARD = registerItem("goultard", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item DOFUS_EMERAUDE = registerItem("dofus_emeraude", new Item(new FabricItemSettings().maxCount(1)));

    public static void registerModItems() {
        Dofuscraft.LOGGER.info("Registering items for " + Dofuscraft.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.DOFUSCRAFT).register(ModItems::addItemsToDofuscraftItemGroup);
    }

    private static void addItemsToDofuscraftItemGroup(FabricItemGroupEntries entries) {
        entries.add(RAZIELLE);
        entries.add(GOULTARD);
        entries.add(DOFUS_EMERAUDE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Dofuscraft.MOD_ID, name), item);
    }
}
