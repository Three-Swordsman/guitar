package com.zhaoshy.guitarhelper.service;

import com.zhaoshy.guitarhelper.entity.User;

import java.util.List;

public interface UserService {
    int addUser(User user);
    User login(User user);
    String selectUser(String username);
    List<User> getAllUser();
    int delUserById(Integer id);
    int editUser(User user);
}
