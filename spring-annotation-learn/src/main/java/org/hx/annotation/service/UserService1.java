package org.hx.annotation.service;

import org.hx.myjson.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserService1 {
    @Autowired
    public UserService1(@Lazy UserService userService) {
        this.userService = userService;
    }
    private UserService userService;
}
