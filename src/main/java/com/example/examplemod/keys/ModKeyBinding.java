package com.example.examplemod.keys;

import com.example.examplemod.ModInfo;
import com.example.examplemod.init.KeyInit;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;

public class ModKeyBinding extends KeyBinding {
    public ModKeyBinding(String description, IKeyConflictContext keyConflictContext, KeyModifier keyModifier, int keyCode, String category) {
        super(String.format("key.%s.%s", ModInfo.MODID,description), keyConflictContext, keyModifier, keyCode, category);
        KeyInit.KEYS_BINDING.add(this);
    }
}
