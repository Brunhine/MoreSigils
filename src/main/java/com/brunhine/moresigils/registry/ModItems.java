package com.brunhine.moresigils.registry;

import com.brunhine.moresigils.Constants;
import com.brunhine.moresigils.MoreSigils;
import com.brunhine.moresigils.item.ItemModProvider;
import com.brunhine.moresigils.item.sigil.ItemSigilNightVision;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems
{
    private static Item sigilNightVision;

    public static void init()
    {
        sigilNightVision = registerItem(new ItemSigilNightVision(), Constants.Items.SigilNightVision);
    }

    private static Item registerItem(Item item, String name)
    {

        if (item.getRegistryName() == null)
            item.setUnlocalizedName(name);
        item.setRegistryName(name);
        item.setCreativeTab(MoreSigils.creativeTab);
        GameRegistry.register(item);
        //MoreSigils.proxy.tryHandleItemModel(item, name);


        MoreSigils.proxy.registerItemRenderer(item, 0, name);


        return item;
    }

    public static <T extends Item> T register(T item)
    {
        GameRegistry.register(item);

        if (item instanceof ItemModProvider)
        {
            ((ItemModProvider) item).registerItemModel(item);
        }

        return item;
    }
}
