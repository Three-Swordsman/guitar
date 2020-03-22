package com.zhaoshy.guitarhelper.controller;
import com.zhaoshy.guitarhelper.entity.Guitar;
import com.zhaoshy.guitarhelper.http.ResponseEntityBase;
import com.zhaoshy.guitarhelper.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2020/3/17 21:17
 ****************************************
 */
@RestController
@RequestMapping("/guitar")
public class GuitarController {

    @Autowired
    GuitarService guitarService;

    /**
     * 商品新增
     * @param guitar
     * @return
     */
    @RequestMapping(value = "/registered", method = RequestMethod.POST)
        public ResponseEntityBase addGuitar(@RequestBody Guitar guitar) {
            Date date = new Date();
            int i = guitarService.addGuitar(guitar);
            ResponseEntityBase responseEntityBase = new ResponseEntityBase();
            if (i > 0) {
                responseEntityBase.setCode(1);
                responseEntityBase.setMessage("新增成功");
            }else{
                return responseEntityBase.failed("新增失败");
            }
            responseEntityBase.setData("");
            return responseEntityBase;
        }

    /**
     * 维护商品
     * @param guitar
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntityBase updateGuitar(@RequestBody Guitar guitar) {
        Date date = new Date();
        int i = guitarService.updateGuitar(guitar);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (i > 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("维护成功");
        }else{
            return responseEntityBase.failed("维护失败");
        }
        responseEntityBase.setData("");
        return responseEntityBase;
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseEntityBase deleteGuitar(@RequestParam int id) {
        Date date = new Date();
        int i = guitarService.deleteGuitar(id);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (i > 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("删除成功");
        }else{
            return responseEntityBase.failed("删除失败");
        }
        responseEntityBase.setData("");
        return responseEntityBase;
    }

    /**
     * 商品列表
     * @return
     */
    @RequestMapping(value = "/list")
    public ResponseEntityBase guitarList() {
        List<Guitar> list = guitarService.guitarList();
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (list.size() > 0) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("查询成功");
            responseEntityBase.setData(list);
        }else{
            return responseEntityBase.failed("未查到数据");
        }
        return responseEntityBase;
    }

    /**
     * 商品详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResponseEntityBase guitarDetail(@RequestParam int id) {
        Guitar guitar = guitarService.guitarDetail(id);
        ResponseEntityBase responseEntityBase = new ResponseEntityBase();
        if (guitar != null) {
            responseEntityBase.setCode(1);
            responseEntityBase.setMessage("查询成功");
            responseEntityBase.setData(guitar);
        }else{
            return responseEntityBase.failed("未查到数据");
        }
        return responseEntityBase;
    }
}
