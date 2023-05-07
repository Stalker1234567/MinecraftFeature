package com.minecraft.feature.minecraftfeature;

import com.minecraft.feature.minecraftfeature.Impl.db.MongoDBManagerImpl;
import com.minecraft.feature.minecraftfeature.player.PlayerPickEventListener;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class MinecraftFeature implements ModInitializer {
    @Override
    public void onInitialize() {
        System.out.println("Start!");
        PlayerPickEventListener.registerPlayerPickEvent();

        MongoDBManagerImpl mongoDBManager = new MongoDBManagerImpl();
        mongoDBManager.close();
    }

    public static void onItemPickedUp(String playerName, String itemName) {

        MongoDBManagerImpl.savePlayerPickData(playerName, itemName);

        String message = "Игрок " + playerName + " подобрал предмет " + itemName;

        PlayerEntity player = MinecraftClient.getInstance().player;

        Text chatMessage = Text.of(message);

        player.sendMessage(chatMessage, false);
    }
}
