package com.example.examplemod.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy{
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item,meta,new ModelResourceLocation(item.getRegistryName(),id));
    }
<<<<<<< HEAD
    public static boolean isServer(){
        return false;
    }
=======
>>>>>>> 563e179ac11ef410ad2a925081a9c0acdc28927b
}
