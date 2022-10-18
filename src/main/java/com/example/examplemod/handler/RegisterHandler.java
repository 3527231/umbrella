package com.example.examplemod.handler;

import com.example.examplemod.init.ItemInit;
import com.example.examplemod.item.IHasModel;
import com.google.common.eventbus.Subscribe;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegisterHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));

    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event){
        for (Item item : ItemInit.ITEMS) {
            if (item instanceof IHasModel){
                ((IHasModel)item).registerModels();
            }
        }
    }
}
