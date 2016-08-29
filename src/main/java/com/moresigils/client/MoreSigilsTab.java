package com.moresigils.client;

import com.moresigils.Constants;
import com.moresigils.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MoreSigilsTab extends CreativeTabs
{
    public MoreSigilsTab()
    {
        super(Constants.Mod.ID);
    }


    @Override
    public Item getTabIconItem()
    {
        return ModItems.sigilNightVision;
    }

    @Override
    public boolean hasSearchBar()
    {
        return true;
    }
}
