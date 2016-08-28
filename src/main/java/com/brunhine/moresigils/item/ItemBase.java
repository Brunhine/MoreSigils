package com.brunhine.moresigils.item;

import com.brunhine.moresigils.MoreSigils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements ItemModProvider
{
    protected String name;

    public ItemBase(String name)
    {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(MoreSigils.creativeTab);
    }

    @Override
    public void registerItemModel(Item item)
    {
        MoreSigils.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab)
    {
        super.setCreativeTab(tab);
        return this;
    }
}
