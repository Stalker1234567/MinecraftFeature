package com.minecraft.feature.minecraftfeature.Impl.db;

import com.minecraft.feature.minecraftfeature.MongoDBManager;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBManagerImpl implements MongoDBManager {

    private static final String DATABASE_NAME = "minecraft-feature";
    private static final String COLLECTION_NAME = "picks";

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    static {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase(DATABASE_NAME);
        collection = database.getCollection(COLLECTION_NAME);
    }

    public static void savePlayerPickData(String playerName, String itemName) {
        Document document = new Document()
                .append("playerName", playerName)
                .append("itemName", itemName);
        collection.insertOne(document);
    }

    @Override
    public void close() {
        mongoClient.close();
    }
}

