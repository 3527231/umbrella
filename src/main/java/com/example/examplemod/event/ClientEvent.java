package com.example.examplemod.event;

import com.example.examplemod.init.KeyInit;
import com.example.examplemod.item.PoisonSword;
import com.example.examplemod.skill.ModSwordSkill;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class ClientEvent {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onKeyPressed(InputEvent.KeyInputEvent event){
        ItemStack heldItem = Minecraft.getMinecraft().player.getHeldItem(EnumHand.MAIN_HAND);
        Item item = heldItem.getItem();
        if (item instanceof ModSwordSkill){
            if (KeyInit.SKILL1.isPressed()){
                ((ModSwordSkill) item).skill1();
                return;
            }
            if (KeyInit.SKILL2.isPressed()){
                ((ModSwordSkill) item).skill2();
                return;
            }
            if (KeyInit.SKILL3.isPressed()){
                ((ModSwordSkill) item).skill3();
                return;
            }
        }
    }
}
