package com.zhaoshy.guitarhelper.mapper;

import com.zhaoshy.guitarhelper.entity.Message;
import java.util.List;
public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    List<Message> selectByAll();

    List<Message> selectListByUserId(String userId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}