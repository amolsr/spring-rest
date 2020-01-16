package com.rest.spring.service;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisplayService {
    @GetMapping("/display")
    public String displayData() {
        String inline = "";

        //MongoDB connection URL
        MongoClientURI uri = new MongoClientURI("mongodb+srv://amolsr:root@test-5xceh.mongodb.net/test?retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("quiz");

        //Getting Database Entries in String
        FindIterable<Document> findIterable = collection.find(new Document());
        for (Document d : findIterable) {
            inline += d.toString();
        }
        return inline;
    }
}