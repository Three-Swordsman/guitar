package com.zhaoshy.shoppinghelper.service.impl;

import com.zhaoshy.shoppinghelper.entity.User;
import com.zhaoshy.shoppinghelper.mapper.UserMapper;
import com.zhaoshy.shoppinghelper.mapper.UserMapperExtend;
import com.zhaoshy.shoppinghelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserMapperExtend userMapperExtend;

    /**
     * @Author : zhaoshy
     * @Date : 2020-01-28 22:01
     * @Description : 用户注册
     */
    @Override
    public int addUser(User user) {
        int i = userMapper.insertSelective(user);
        return i;
    }

    /**
     * @Author : zhaoshy
     * @Date : 2020-01-28 22:01
     * @Description : 用户登录
     */
    @Override
    public User login(User user) {
        User login = userMapperExtend.login(user);
        return login;
    }

    /**
     * @Author : zhaoshy
     * @Date : 2020-01-31 21:05
     * @Description : 判断用户是否存在
     */
    @Override
    public String selectUser(String username) {
        String s = userMapperExtend.selectUser(username);
        return s;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userMapperExtend.getAllUser();
        return users;
    }

    @Override
    public int delUserById(Integer id) {
        int i = userMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int editUser(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        return i;
    }
}
