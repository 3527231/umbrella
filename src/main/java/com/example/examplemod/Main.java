package com.example.examplemod;
import static com.example.examplemod.ModInfo.*;

import com.example.examplemod.init.KeyInit;
import com.example.examplemod.proxy.ClientProxy;
import com.example.examplemod.proxy.CommonProxy;
import net.minecraft.client.particle.ParticleLava;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class Main
{
    @Mod.Instance
    public static Main instance;

    @SidedProxy(clientSide = "com.example.examplemod.proxy.ClientProxy",serverSide = "com.example.examplemod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        if (proxy instanceof ClientProxy){
<<<<<<< HEAD
=======
            ParticleLava
>>>>>>> a3466a8302166c45fdaddfa324a647ec28977f0a
            KeyInit.init();
        }
    }
    @EventHandler
    public void postInit (FMLInitializationEvent event)
    {

    }
}
