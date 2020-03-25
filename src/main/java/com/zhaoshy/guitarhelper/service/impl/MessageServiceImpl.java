package com.zhaoshy.guitarhelper.service.impl;

import com.zhaoshy.guitarhelper.entity.Message;
import com.zhaoshy.guitarhelper.mapper.MessageMapper;
import com.zhaoshy.guitarhelper.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    /**
     * @Author : zhaoshy
     * @Date : 2020-01-28 22:01
     * @Description : 商品新增
     */
    @Override
    public int addMessage(Message message) {
        int i = messageMapper.insertSelective(message);
        return i;
    }


    /**
     * @Author: wuxiaojin
     * @Description: 管理员列表
     * @return
     */
    @Override
    public List<Message> messagesList(){
        List<Message> list = messageMapper.selectByAll();
        return list;
    }

    /**
     * @Author: wuxiaojin
     * @Description: 个人列表
     * @return
     */
    @Override
    public List<Message> selectListByUserId(String userId){
        List<Message> list = messageMapper.selectListByUserId(userId);
        return list;
    }

	/**
     * @Author: wuxiaojin
     * @Description: 商品详情
     * @return
     */
    @Override
    public Message messageDetail(int id){
        Message  message = messageMapper.selectByPrimaryKey(id);
        return message;
    }
}
