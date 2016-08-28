package com.brunhine.moresigils.item.sigil;

import WayofTime.bloodmagic.api.impl.ItemSigilToggleable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSigilNightVision extends ItemSigilToggleable
{
    public ItemSigilNightVision()
    {
        super(10);
    }


    @Override
    public void onSigilUpdate(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected)
    {
        player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 2, 1, true, false));
    }
}
