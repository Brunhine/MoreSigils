package com.moresigils.proxy;

import WayofTime.bloodmagic.util.helper.InventoryRenderHelperV2;
import com.moresigils.util.handler.EventHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;


public class CommonProxy
{
    public InventoryRenderHelperV2 getRenderHelper()
    {
        return null;
    }

    public void preInit()
    {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        registerRenderers();
    }

    public void init()
    {

    }

    public void postInit()
    {

    }

    public void registerRenderers()
    {

    }

    public void tryHandleBlockModel(Block block, String name)
    {
        // NO-OP
    }

    public void tryHandleItemModel(Item item, String name)
    {
        // NO-OP
    }
}
