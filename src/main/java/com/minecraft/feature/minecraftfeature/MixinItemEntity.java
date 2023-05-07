package com.minecraft.feature.minecraftfeature;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public interface MixinItemEntity {
    void onPlayerCollision(PlayerEntity player, CallbackInfo ci);
}
