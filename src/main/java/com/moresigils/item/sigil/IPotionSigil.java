package com.moresigils.item.sigil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public interface IPotionSigil
{
    PotionEffect getPotionEffect();

    Potion getMobEffect();

    void applyEffect(EntityPlayer player);
}
