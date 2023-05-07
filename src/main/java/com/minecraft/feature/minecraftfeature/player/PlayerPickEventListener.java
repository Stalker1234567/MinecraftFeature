package com.minecraft.feature.minecraftfeature.player;

import com.minecraft.feature.minecraftfeature.MinecraftFeature;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class PlayerPickEventListener {
    public static void registerPlayerPickEvent() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (PlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (player.isSneaking()) {
                    ItemStack stack = player.getMainHandStack();
                    ItemEntity itemEntity = new ItemEntity(player.world, player.getX(), player.getY(), player.getZ(), stack);
                    if (itemEntity != null) {
                        ItemStack stack2 = itemEntity.getStack();
                        String itemName = stack2.getName().getString();
                        String playerNickname = player.getEntityName();

                        MinecraftFeature.onItemPickedUp(playerNickname, itemName);
                    }
                }
            }
        });
    }
}