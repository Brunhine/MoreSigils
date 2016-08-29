package com.moresigils.util.handler;

import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientHandler
{
    @SubscribeEvent
    public void onMouseEvent(MouseEvent event)
    {

    }


}
