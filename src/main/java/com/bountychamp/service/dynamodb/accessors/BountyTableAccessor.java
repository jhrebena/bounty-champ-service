package com.bountychamp.service.dynamodb.accessors;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.bountychamp.service.dynamodb.dto.BountyItem;

import java.util.UUID;

public class BountyTableAccessor {
    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
    DynamoDBMapper mapper = new DynamoDBMapper(client);

    public void addBounty(BountyItem bountyItem)
            throws ConditionalCheckFailedException {
        mapper.save(bountyItem);
    }

    public BountyItem getBounty(String bountyId) {
        return mapper.load(BountyItem.class, UUID.fromString(bountyId));
    }

    public void deleteBounty(String bountyId) {
        BountyItem bounty = new BountyItem();
        bounty.setBountyId(UUID.fromString(bountyId));
        mapper.delete(bounty);
    }
}
