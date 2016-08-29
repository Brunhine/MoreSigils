package com.moresigils;


import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler
{
    public static int sigilNightVisionCost;
    private static Configuration config;

    public static void init(File file)
    {
        config = new Configuration(file);
        syncConfig();
    }

    public static void syncConfig()
    {
        String category;

        category = "Sigils";
        config.addCustomCategoryComment(category, "Specific Sigil configs");
        config.setCategoryRequiresWorldRestart(category, true);
        sigilNightVisionCost = config.getInt("sigilDivinityCost", category, 100, 0, 10000, "Set the LP cost for 'Sigil of Night Vision'");

        config.save();
    }

    public static Configuration getConfig()
    {
        return config;
    }
}
