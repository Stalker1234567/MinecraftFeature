package com.minecraft.feature.minecraftfeature.Impl;

import com.minecraft.feature.minecraftfeature.MinecraftFeature;
import com.minecraft.feature.minecraftfeature.MixinItemEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class MixinItemEntityImpl implements MixinItemEntity {
    @Inject(method = "onPlayerCollision", at = @At("HEAD"))
    @Override
    public void onPlayerCollision(PlayerEntity player, CallbackInfo ci) {
        ItemStack stack = ((ItemEntity)(Object)this).getStack();
        String itemName = stack.getName().getString();
        String playerNickname = player.getEntityName();

        MinecraftFeature.onItemPickedUp(playerNickname, itemName);
    }
}
