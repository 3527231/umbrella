package com.example.examplemod.init;

import com.example.examplemod.keys.ModKeyBinding;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class KeyInit {
    public static final List<KeyBinding> KEYS_BINDING = new ArrayList<KeyBinding>();
    public static final KeyBinding SKILL1 = new ModKeyBinding("skill_1", KeyConflictContext.IN_GAME, KeyModifier.NONE, Keyboard.KEY_Z, "key.category.firstmod");
    public static final KeyBinding SKILL2 = new ModKeyBinding("skill_2", KeyConflictContext.IN_GAME, KeyModifier.NONE, Keyboard.KEY_X, "key.category.firstmod");
    public static final KeyBinding SKILL3 = new ModKeyBinding("skill_3", KeyConflictContext.IN_GAME, KeyModifier.NONE, Keyboard.KEY_C, "key.category.firstmod");
    public static final KeyBinding SUMMON = new ModKeyBinding("skill_1", KeyConflictContext.IN_GAME, KeyModifier.NONE, Keyboard.KEY_Z, "key.category.firstmod");

    public static void init(){
        for (KeyBinding keyBinding : KEYS_BINDING) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }
    }
}
