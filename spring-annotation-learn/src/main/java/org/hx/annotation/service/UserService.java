package org.hx.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserService {

    private UserService1 userService1;

    @Autowired
    public UserService(UserService1 userService1) {
        this.userService1 = userService1;
    }
}
