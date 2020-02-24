package com.bountychamp.service.dynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;

import java.util.UUID;

public class UserTableAccessor {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
    DynamoDBMapper mapper = new DynamoDBMapper(client);

    public void addUser(UserItem userItem)
            throws ConditionalCheckFailedException {
        mapper.save(userItem);
    }

    public UserItem getUser(String hashKey) {
        return mapper.load(UserItem.class, UUID.fromString(hashKey));
    }
}