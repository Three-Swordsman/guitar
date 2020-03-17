package com.zhaoshy.shoppinghelper.mapper;

import com.zhaoshy.shoppinghelper.entity.Guitar;

public interface GuitarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Guitar record);

    int insertSelective(Guitar record);

    Guitar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Guitar record);

    int updateByPrimaryKey(Guitar record);
}