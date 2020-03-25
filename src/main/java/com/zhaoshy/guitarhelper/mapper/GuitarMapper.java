package com.zhaoshy.guitarhelper.mapper;

import com.zhaoshy.guitarhelper.entity.Guitar;
import java.util.List;

public interface GuitarMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Guitar record);
    int insertSelective(Guitar record);
    Guitar selectByPrimaryKey(Integer id);
    List<Guitar> selectByAll();
    List<Guitar> selectListBymodel(Guitar record);
    int updateByPrimaryKeySelective(Guitar record);
    int updateByPrimaryKey(Guitar record);
}