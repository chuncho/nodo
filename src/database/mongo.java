package database;

import com.mongodb.ConnectionString;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoDatabase;

public class mongo {

    public static MongoDatabase connectDB() {
        MongoClient mongoClient = MongoClients.create(new ConnectionString("mongodb://127.0.0.1:27017"));
        MongoDatabase database = mongoClient.getDatabase("dbmongo");
        return database;
    }

    public static void disconnect() {
        MongoClient mongoClient = MongoClients.create(new ConnectionString("mongodb://127.0.0.1:27017"));

    }
}
