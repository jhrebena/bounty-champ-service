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
public class CreateUserController {
    @RequestMapping(path = "/create-user", method = RequestMethod.GET)
    public Map<String, String> createUser(String username, String email, String password) {

        UserItem userItem = new UserItem();
        userItem.setUsername(username);
        userItem.setEmail(email);
        userItem.setPassword(password);

        UserTableAccessor userTableAccessor = new UserTableAccessor();
        userTableAccessor.addUser(userItem);

        Map<String, String> out = new HashMap<>();
        out.put("sample user created!", "woohoo!");
        return out;
    }
}
