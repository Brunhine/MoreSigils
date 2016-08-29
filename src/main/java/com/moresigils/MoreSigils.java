package com.moresigils;

import WayofTime.bloodmagic.api.util.helper.LogHelper;
import com.moresigils.client.MoreSigilsTab;
import com.moresigils.proxy.CommonProxy;
import com.moresigils.registry.ModItems;
import com.moresigils.registry.ModRecipes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid = Constants.Mod.ID, name = Constants.Mod.NAME, version = Constants.Mod.VERSION, acceptedMinecraftVersions = Constants.Mod.MC_VERSION)
public class MoreSigils
{
    public static final MoreSigilsTab CREATIVE_TAB = new MoreSigilsTab();
    @SidedProxy(serverSide = "com.moresigils.proxy.CommonProxy", clientSide = "com.moresigils.proxy.ClientProxy")
    public static CommonProxy PROXY;
    @Mod.Instance(Constants.Mod.ID)
    public static MoreSigils INSTANCE;

    private LogHelper logger = new LogHelper(Constants.Mod.ID);
    private File configDir;

    public LogHelper getLogger()
    {
        return this.logger;
    }

    public File getConfigDir()
    {
        return this.configDir;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        this.configDir = new File(event.getModConfigurationDirectory(), Constants.Mod.ID);
        ConfigHandler.init(new File(getConfigDir(), Constants.Mod.ID + ".cfg"));

        ModItems.init();

        PROXY.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModRecipes.init();
        PROXY.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        PROXY.postInit();
    }
}
