package com.moresigils.item.sigil;

import WayofTime.bloodmagic.api.impl.ItemSigilToggleable;
import WayofTime.bloodmagic.api.util.helper.NBTHelper;
import WayofTime.bloodmagic.api.util.helper.PlayerHelper;
import WayofTime.bloodmagic.client.IMeshProvider;
import WayofTime.bloodmagic.util.Utils;
import WayofTime.bloodmagic.util.helper.TextHelper;
import com.google.common.base.Strings;
import com.moresigils.Constants;
import com.moresigils.MoreSigils;
import com.moresigils.client.mesh.CustomMeshDefinitionActivatable;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemSigilBaseToggleable extends ItemSigilToggleable implements IMeshProvider
{
    protected final String tooltipBase;
    private final String name;

    public ItemSigilBaseToggleable(String name, int lpUsed)
    {
        super(lpUsed);

        setUnlocalizedName(Constants.Mod.ID + ".sigil." + name);
        setCreativeTab(MoreSigils.CREATIVE_TAB);

        this.name = name;
        this.tooltipBase = "tooltip.moresigils.sigil." + name + ".";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
        if (TextHelper.canTranslate(tooltipBase + "desc"))
            tooltip.addAll(Arrays.asList(TextHelper.cutLongString(TextHelper.localizeEffect(tooltipBase + "desc"))));

        NBTHelper.checkNBT(stack);

        tooltip.add(TextHelper.localizeEffect("tooltip.BloodMagic." + (getActivated(stack) ? "activated" : "deactivated")));

        if (!Strings.isNullOrEmpty(getOwnerName(stack)))
            tooltip.add(TextHelper.localizeEffect("tooltip.BloodMagic.currentOwner", PlayerHelper.getUsernameFromStack(stack)));

        super.addInformation(stack, player, tooltip, advanced);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemMeshDefinition getMeshDefinition()
    {
        return new CustomMeshDefinitionActivatable("ItemSigil" + Utils.toFancyCasing(name));
    }

    @Override
    public ResourceLocation getCustomLocation()
    {
        return null;
    }

    @Override
    public List<String> getVariants()
    {
        List<String> ret = new ArrayList<>();
        ret.add("active=false");
        ret.add("active=true");
        return ret;
    }
}