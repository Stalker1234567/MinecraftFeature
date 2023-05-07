package com.minecraft.feature.minecraftfeature;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ItemEntity.class)
public interface MixinPlayerEntityItemPickCallback {
    @Invoker("onPlayerCollision")
    void callOnPlayerCollision(PlayerEntity player);
}
