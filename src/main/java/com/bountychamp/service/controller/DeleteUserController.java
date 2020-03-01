package com.bountychamp.service.controller;

import com.bountychamp.service.dynamodb.UserTableAccessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

@RestController
@EnableWebMvc
public class DeleteUserController {
    @RequestMapping(path = "/delete-user", method = RequestMethod.GET)
    public Map<String, String> createUser(String userId) {
        UserTableAccessor userTableAccessor = new UserTableAccessor();
        userTableAccessor.deleteUser(userId);

        Map<String, String> out = new HashMap<>();
        out.put("deleted user", userId);
        return out;
    }
}
