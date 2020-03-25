package com.zhaoshy.guitarhelper.service;

import com.zhaoshy.guitarhelper.entity.Message;

import java.util.List;
public interface MessageService {
    int addMessage(Message record);
    List<Message> messagesList();
    List<Message> selectListByUserId(String userId);
    Message messageDetail(int id);
}
