package com.example.examplemod.init;

import com.example.examplemod.item.ItemBase;
import com.example.examplemod.item.PoisonSword;
import com.example.examplemod.item.ToolSword;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import scala.tools.nsc.settings.Final;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item> ();
    public static final Item DIY_IRON = new ItemBase("diy_iron");
    public static final Item EMERALD_SWORD = new PoisonSword();
}
