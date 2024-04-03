package com.tartiflex.dofuscraft;

import com.tartiflex.dofuscraft.item.ModItemGroups;
import com.tartiflex.dofuscraft.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dofuscraft implements ModInitializer {
	public static final String MOD_ID = "dofuscraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();
		ModItems.registerModItems();
	}
}