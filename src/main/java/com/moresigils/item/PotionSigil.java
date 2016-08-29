package com.moresigils.item;


import com.moresigils.item.sigil.ItemSigilBaseToggleable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class PotionSigil extends ItemSigilBaseToggleable
{
    private PotionEffect potionEffect;
    private Potion mobEffect;

    public PotionSigil(String name, int lpCost, PotionType potionType, Potion potion)
    {
        super(name, lpCost);
        MinecraftForge.EVENT_BUS.register(this);

        ItemStack stack = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), potionType);
        this.potionEffect = PotionUtils.getEffectsFromStack(stack).get(0);

        this.mobEffect = potion;
    }

    @Override
    public void onSigilUpdate(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected)
    {
        this.applyEffect(player);
    }

    public PotionEffect getPotionEffect()
    {
        return this.potionEffect;
    }

    public void applyEffect(EntityPlayer player)
    {
        PotionEffect currentEffect = player.getActivePotionEffect(getPotionEffect().getPotion());
        if (currentEffect == null || currentEffect.getDuration() < 205)
        {
            player.addPotionEffect(new PotionEffect(this.mobEffect, 285, 1, true, false));
        }
    }
}
