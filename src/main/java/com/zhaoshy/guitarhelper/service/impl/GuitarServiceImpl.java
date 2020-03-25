package com.zhaoshy.guitarhelper.service.impl;

import com.zhaoshy.guitarhelper.entity.Guitar;
import com.zhaoshy.guitarhelper.mapper.GuitarMapper;
import com.zhaoshy.guitarhelper.mapper.GuitarMapperExtend;
import com.zhaoshy.guitarhelper.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GuitarServiceImpl implements GuitarService {

    @Autowired
    GuitarMapper guitarMapper;

    @Autowired
    GuitarMapperExtend guitarMapperExtend;

    /**
     * @Author : zhaoshy
     * @Date : 2020-01-28 22:01
     * @Description : 商品新增
     */
    @Override
    public int addGuitar(Guitar guitar) {
        int i = guitarMapper.insertSelective(guitar);
        return i;
    }
	

   /**
     * @Author: wuxiaojin
     * @Description: 商品信息维护
     * @return
     */
    @Override
    public int updateGuitar(Guitar guitar){
        int i = guitarMapper.updateByPrimaryKeySelective(guitar);
        return i;
    }

  /**
     * @Author: wuxiaojin
     * @Description: 商品删除
     * @return
     */
    @Override
    public int deleteGuitar(int id){
        int i = guitarMapper.deleteByPrimaryKey(id);
        return i;
    }


    /**
     * @Author: wuxiaojin
     * @Description: 管理员列表
     * @return
     */
    @Override
    public List<Guitar> guitarList(){
        List<Guitar> list = guitarMapper.selectByAll();
        return list;
    }

    /**
     * @Author: wuxiaojin
     * @Description: 按照型号查询列表
     * @return
     */
    @Override
    public List<Guitar> guitarListByModel(String modelNum){
        List<Guitar> list = guitarMapper.selectListBymodel(modelNum);
        return list;
    }

	/**
     * @Author: wuxiaojin
     * @Description: 商品详情
     * @return
     */
    @Override
    public Guitar guitarDetail(int id){
        Guitar guitar = guitarMapper.selectByPrimaryKey(id);
        return guitar;
    }
}
