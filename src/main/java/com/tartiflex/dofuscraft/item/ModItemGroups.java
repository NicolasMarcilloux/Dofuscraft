package com.tartiflex.dofuscraft.item;

import com.tartiflex.dofuscraft.Dofuscraft;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> DOFUSCRAFT = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Dofuscraft.MOD_ID, "dofuscraft_group"));

    public static void registerModItemGroups() {
        Registry.register(Registries.ITEM_GROUP, DOFUSCRAFT, FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.DOFUS_EMERAUDE))
                .displayName(Text.translatable("itemGroup.dofuscraft"))
                .build());
    }
}
