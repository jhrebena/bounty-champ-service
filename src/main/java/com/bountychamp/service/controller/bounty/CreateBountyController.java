package com.bountychamp.service.controller.bounty;

import com.bountychamp.service.dynamodb.dto.BountyItem;
import com.bountychamp.service.dynamodb.accessors.BountyTableAccessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

@RestController
@EnableWebMvc
public class CreateBountyController {
    @RequestMapping(path = "/create-bounty", method = RequestMethod.GET)
    public Map<String, String> createBounty(String creatorId, String targetId, String category, String description, Integer amountInCents) {

        BountyItem bountyItem = new BountyItem();
        bountyItem.setCreatorId(creatorId);
        bountyItem.setTargetId(targetId);
        bountyItem.setCategory(category);
        bountyItem.setDescription(description);
        bountyItem.setAmountInCents(amountInCents);
        bountyItem.setBountyStatus(BountyItem.BountyStatus.IN_PROGRESS);

        BountyTableAccessor bountyTableAccessor = new BountyTableAccessor();
        bountyTableAccessor.addBounty(bountyItem);

        Map<String, String> out = new HashMap<>();
        out.put("sample bounty created!", "woohoo!");
        return out;
    }
}