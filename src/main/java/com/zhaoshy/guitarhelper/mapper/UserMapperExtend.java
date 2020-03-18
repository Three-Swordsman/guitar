package com.zhaoshy.guitarhelper.mapper;

import com.zhaoshy.guitarhelper.entity.User;

import java.util.List;

public interface UserMapperExtend {
    User login(User user);
    String selectUser(String username);
    List<User> getAllUser();
}