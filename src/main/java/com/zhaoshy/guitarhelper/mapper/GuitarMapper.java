package com.zhaoshy.guitarhelper.mapper;

import com.zhaoshy.guitarhelper.entity.Guitar;

public interface GuitarMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Guitar record);
    int insertSelective(Guitar record);
    Guitar selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Guitar record);
    int updateByPrimaryKey(Guitar record);
}