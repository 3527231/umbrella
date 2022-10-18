package com.example.examplemod.blocks;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CustomBlock extends BlockSlab {
    public CustomBlock(Material materialIn,String name) {
        super(materialIn);
        setCreativeTab(CreativeTabs.MISC);
        setRegistryName(name);
        setUnlocalizedName(name);

        IBlockState state = this.getBlockState().getBaseState();
        if (!this.isDouble()){
            state = state.withProperty(HALF,EnumBlockHalf.BOTTOM);
        }
        setDefaultState(state);
        this.useNeighborBrightness = true;
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return this.getUnlocalizedName();
    }

    @Override
    public boolean isDouble() {
        return false;
    }


    @Override
    public IProperty<?> getVariantProperty() {
        return HALF;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return EnumBlockHalf.BOTTOM;
    }

}
