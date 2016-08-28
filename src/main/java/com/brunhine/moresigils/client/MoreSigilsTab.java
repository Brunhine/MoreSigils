package com.brunhine.moresigils.client;

import com.brunhine.moresigils.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class MoreSigilsTab extends CreativeTabs
{
    public MoreSigilsTab()
    {
        super(Constants.Mod.Id);
    }


    @Override
    public Item getTabIconItem()
    {
        return Items.SPLASH_POTION;
    }

    @Override
    public boolean hasSearchBar()
    {
        return true;
    }
}
