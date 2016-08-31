package com.moresigils.registry;

import com.moresigils.MoreSigils;
import com.moresigils.item.ItemBase;
import com.moresigils.item.sigil.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.text.WordUtils;

public class ModItems
{
    public static Item reagentFireResist;
    public static Item reagentInvisibility;
    public static Item reagentLeaping;
    public static Item reagentNightVision;
    public static Item reagentRegeneration;
    public static Item reagentStrength;
    public static Item reagentSwiftness;
    public static Item reagentWaterBreath;

    public static Item sigilFireResist;
    public static Item sigilInvisibility;
    public static Item sigilLeaping;
    public static Item sigilNightVision;
    public static Item sigilRegeneration;
    public static Item sigilStrength;
    public static Item sigilSwiftness;
    public static Item sigilWaterBreath;

    public static void init()
    {
        /*
        Reagents
         */
        reagentFireResist = registerUniqueItem(new ItemBase("reagentFireResist"));
        reagentInvisibility = registerUniqueItem(new ItemBase("reagentInvisibility"));
        reagentLeaping = registerUniqueItem(new ItemBase("reagentLeaping"));
        reagentNightVision = registerUniqueItem(new ItemBase("reagentNightVision"));
        reagentRegeneration = registerUniqueItem(new ItemBase("reagentRegeneration"));
        reagentStrength = registerUniqueItem(new ItemBase("reagentStrength"));
        reagentSwiftness = registerUniqueItem(new ItemBase("reagentSwiftness"));
        reagentWaterBreath = registerUniqueItem(new ItemBase("reagentWaterBreath"));

        /*
        Sigils
         */
        sigilFireResist = registerItem(new ItemSigilFireResist());
        sigilInvisibility = registerItem(new ItemSigilInvisibility());
        sigilLeaping = registerItem(new ItemSigilLeaping());
        sigilNightVision = registerItem(new ItemSigilNightVision());
        sigilRegeneration = registerItem(new ItemSigilRegeneration());
        sigilStrength = registerItem(new ItemSigilStrength());
        sigilSwiftness = registerItem(new ItemSigilSwiftness());
        sigilWaterBreath = registerItem(new ItemSigilWaterBreath());
    }

    @SideOnly(Side.CLIENT)
    public static void initSpecialRenders()
    {
    }

    public static Item registerItem(Item item)
    {
        item.setRegistryName(item.getClass().getSimpleName());
        if (item.getRegistryName() == null)
        {
            MoreSigils.INSTANCE.getLogger().error("Attempted to register Item {} without setting a registry name. Item will not be registered. Please report this.", item.getClass().getCanonicalName());
            return item;
        }

        String itemName = item.getRegistryName().toString().split(":")[1];

        GameRegistry.register(item);
        MoreSigils.PROXY.tryHandleItemModel(item, itemName);


        return item;
    }

    private static Item registerUniqueItem(Item item)
    {
        item.setRegistryName(item.getClass().getSimpleName() + "." + WordUtils.capitalize(item.getUnlocalizedName().substring(16)));
        if (item.getRegistryName() == null)
        {
            MoreSigils.INSTANCE.getLogger().error("Attempted to register Item {} without setting a registry name. Item will not be registered. Please report this.", item.getClass().getCanonicalName());
            return item;
        }

        String itemName = item.getRegistryName().toString().split(":")[1];

        GameRegistry.register(item);
        MoreSigils.PROXY.tryHandleItemModel(item, itemName.split("[.]")[0]);

        return item;
    }
}
