package com.brunhine.moresigils;


import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;

@Mod(modid = Constants.Mod.Id, name = Constants.Mod.Name, version = Constants.Mod.Version)
public class MoreSigils
{

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        FMLLog.getLogger().log(Level.INFO, Constants.Mod.Name + " is loading!");
    }
}
