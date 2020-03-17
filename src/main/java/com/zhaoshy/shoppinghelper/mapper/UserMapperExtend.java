package com.zhaoshy.shoppinghelper.mapper;

import com.zhaoshy.shoppinghelper.entity.User;

import java.util.List;

public interface UserMapperExtend {
    User login(User user);
    String selectUser(String username);
    List<User> getAllUser();
}