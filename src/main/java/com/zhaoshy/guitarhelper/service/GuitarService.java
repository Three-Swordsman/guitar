package com.zhaoshy.guitarhelper.service;

import com.zhaoshy.guitarhelper.entity.Guitar;
import org.springframework.stereotype.Service;

import java.util.List;
public interface GuitarService {
    int addGuitar(Guitar record);
    int updateGuitar(Guitar record);
    int deleteGuitar(int id);
    List<Guitar> guitarList();
    List<Guitar> guitarListByModel(String modelNum);
    Guitar guitarDetail(int id);
}
