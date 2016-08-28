package com.brunhine.moresigils;

import com.brunhine.moresigils.client.MoreSigilsTab;
import com.brunhine.moresigils.proxy.CommonProxy;
import com.brunhine.moresigils.registry.ModItems;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;

@Mod(modid = Constants.Mod.Id, name = Constants.Mod.Name, version = Constants.Mod.Version, acceptedMinecraftVersions = Constants.Mod.McVersion)
public class MoreSigils
{

    public static final MoreSigilsTab creativeTab = new MoreSigilsTab();
    @SidedProxy(serverSide = "com.brunhine.moresigils.proxy.CommonProxy", clientSide = "com.brunhine.moresigils.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        FMLLog.getLogger().log(Level.INFO, Constants.Mod.Name + " is loading!");

        ModItems.init();
    }
}
