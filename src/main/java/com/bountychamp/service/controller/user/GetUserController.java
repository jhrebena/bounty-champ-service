package com.bountychamp.service.controller.user;

import com.bountychamp.service.dynamodb.dto.UserItem;
import com.bountychamp.service.dynamodb.accessors.UserTableAccessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

@RestController
@EnableWebMvc
public class GetUserController {
    @RequestMapping(path = "/get-user", method = RequestMethod.GET)
    public Map<String, String> getUser(String userId) {
        UserTableAccessor userTableAccessor = new UserTableAccessor();
        UserItem user = userTableAccessor.getUser(userId);

        Map<String, String> out = new HashMap<>();
        out.put("username", user.getUsername());
        out.put("email", user.getEmail());
        return out;
    }
}
