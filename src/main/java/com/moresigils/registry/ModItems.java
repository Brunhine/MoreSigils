package com.moresigils.registry;

import com.moresigils.ConfigHandler;
import com.moresigils.MoreSigils;
import com.moresigils.item.ItemBase;
import com.moresigils.item.PotionSigil;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.text.WordUtils;

public class ModItems
{
    public static Item reagentNightVision;

    public static Item sigilNightVision;
    public static Item sigilInvisibility;

    public static void init()
    {
        /*
        Reagents
         */
        reagentNightVision = registerUniqueItem(new ItemBase("reagentNightVision"));

        /*
        Sigils
         */
        //sigilNightVision = registerItem(new ItemSigilNightVision());
        sigilNightVision = registerUniqueItem(new PotionSigil("NightVision", ConfigHandler.sigilNightVisionCost, PotionTypes.NIGHT_VISION, MobEffects.NIGHT_VISION));
        sigilInvisibility = registerUniqueItem(new PotionSigil("Invisibility", 100, PotionTypes.INVISIBILITY, MobEffects.INVISIBILITY));
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
