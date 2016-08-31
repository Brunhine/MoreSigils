package com.moresigils;


import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler
{
    public static int sigilFireResistCost;
    public static int sigilInvisibilityCost;
    public static int sigilLeapingCost;
    public static int sigilNightVisionCost;
    public static int sigilRegenerationCost;
    public static int sigilStrengthCost;
    public static int sigilSwiftnessCost;
    public static int sigilWaterBreathCost;

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
        sigilFireResistCost = config.getInt("FireResistCost", category, 100, 0, 10000, "Set the LP cost for 'Sigil of Fire Resist'");
        sigilInvisibilityCost = config.getInt("InvisibilityCost", category, 400, 0, 10000, "Set the LP cost for 'Sigil of Invisibility'");
        sigilLeapingCost = config.getInt("LeapingCost", category, 200, 0, 10000, "Set the LP cost for 'Sigil of Leaping'");
        sigilNightVisionCost = config.getInt("NightVisionCost", category, 100, 0, 10000, "Set the LP cost for 'Sigil of Night Vision'");
        sigilRegenerationCost = config.getInt("RegenerationCost", category, 1000, 0, 10000, "Set the LP cost for the 'Sigil of Regeneration'");
        sigilStrengthCost = config.getInt("StrengthCost", category, 100, 0, 10000, "Set the cost for the 'Sigil of Strength'");
        sigilSwiftnessCost = config.getInt("SwiftnessCost", category, 200, 0, 10000, "Set the cost for the 'Sigil of Swiftness'");
        sigilWaterBreathCost = config.getInt("WaterBreathCost", category, 400, 0, 10000, "Set the cost for the 'Sigil of Water Breath'");

        config.save();
    }

    public static Configuration getConfig()
    {
        return config;
    }
}
