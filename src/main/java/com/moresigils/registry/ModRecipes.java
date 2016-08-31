package com.moresigils.registry;

import WayofTime.bloodmagic.api.BloodMagicAPI;
import WayofTime.bloodmagic.api.Constants;
import WayofTime.bloodmagic.api.registry.AlchemyArrayRecipeRegistry;
import WayofTime.bloodmagic.api.registry.TartaricForgeRecipeRegistry;
import WayofTime.bloodmagic.item.ItemComponent;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;

public class ModRecipes
{
    public static void init()
    {
        addAlchemyArrayRecipes();

        addHellfireForgeRecipes();
    }

    private static void addHellfireForgeRecipes()
    {
        addForgeRecipe(new ItemStack(ModItems.reagentNightVision), 2048, 1024,
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.LONG_NIGHT_VISION),
                ItemComponent.getStack(ItemComponent.REAGENT_BLOODLIGHT),
                ItemComponent.getStack(ItemComponent.REAGENT_SIGHT),
                new ItemStack(Blocks.DAYLIGHT_DETECTOR));
    }

    private static void addAlchemyArrayRecipes()
    {
        // Fire resist sigil
        AlchemyArrayRecipeRegistry.registerCraftingRecipe(new ItemStack(ModItems.reagentFireResist),
                new ItemStack(getBMItem(Constants.BloodMagicItem.SLATE), 1, 4),
                new ItemStack(ModItems.sigilFireResist));

        // Invisibility sigil
        AlchemyArrayRecipeRegistry.registerCraftingRecipe(new ItemStack(ModItems.reagentInvisibility),
                new ItemStack(getBMItem(Constants.BloodMagicItem.SLATE), 1, 4),
                new ItemStack(ModItems.sigilInvisibility));

        // Leaping sigil
        AlchemyArrayRecipeRegistry.registerCraftingRecipe(new ItemStack(ModItems.reagentLeaping),
                new ItemStack(getBMItem(Constants.BloodMagicItem.SLATE), 1, 4),
                new ItemStack(ModItems.sigilLeaping));

        // Night Vision sigil
        AlchemyArrayRecipeRegistry.registerCraftingRecipe(new ItemStack(ModItems.reagentNightVision),
                new ItemStack(getBMItem(Constants.BloodMagicItem.SLATE), 1, 4),
                new ItemStack(ModItems.sigilNightVision));

        // Regeneration sigil
        AlchemyArrayRecipeRegistry.registerCraftingRecipe(new ItemStack(ModItems.reagentRegeneration),
                new ItemStack(getBMItem(Constants.BloodMagicItem.SLATE), 1, 4),
                new ItemStack(ModItems.sigilRegeneration));

        // Strength sigil
        AlchemyArrayRecipeRegistry.registerCraftingRecipe(new ItemStack(ModItems.reagentStrength),
                new ItemStack(getBMItem(Constants.BloodMagicItem.SLATE), 1, 4),
                new ItemStack(ModItems.sigilStrength));

        // Swiftness sigil
        AlchemyArrayRecipeRegistry.registerCraftingRecipe(new ItemStack(ModItems.reagentSwiftness),
                new ItemStack(getBMItem(Constants.BloodMagicItem.SLATE), 1, 4),
                new ItemStack(ModItems.sigilSwiftness));

        // Water Breath sigil
        AlchemyArrayRecipeRegistry.registerCraftingRecipe(new ItemStack(ModItems.reagentWaterBreath),
                new ItemStack(getBMItem(Constants.BloodMagicItem.SLATE), 1, 4),
                new ItemStack(ModItems.sigilWaterBreath));
    }

    public static void addForgeRecipe(ItemStack output, double minWill, double drain, Object... recipe)
    {
        TartaricForgeRecipeRegistry.registerRecipe(output, minWill, drain, recipe);
    }

    private static Item getBMItem(Constants.BloodMagicItem item)
    {
        return BloodMagicAPI.getItem(item);
    }
}
