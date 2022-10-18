package com.example.examplemod.item;

import com.example.examplemod.Main;
import com.example.examplemod.ModInfo;
import com.example.examplemod.init.ItemInit;
import com.example.examplemod.proxy.ClientProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name){
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.MATERIALS);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this,0,"inventory");
    }
}
