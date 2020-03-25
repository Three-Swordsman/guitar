package com.zhaoshy.guitarhelper.controller;

import com.zhaoshy.guitarhelper.http.ResponseEntityBase;
import com.zhaoshy.guitarhelper.entity.Message;
import com.zhaoshy.guitarhelper.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    /**
     * 留言新增
     * @param message
     * @return
     */
    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public ResponseEntityBase addMessage(@RequestBody Message message) {
        Date date = new Date();
        int i = messageService.addMessage(message);
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
     * 留言列表查询
     * @return
     */
    @RequestMapping(value = "/list")
    public ResponseEntityBase messageList() {
        List<Message> list = messageService.messagesList();
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
     * 个人留言列表查询
     * @return
     */
    @RequestMapping(value = "/listByUserId")
    public ResponseEntityBase messageListByuserId(String userId) {
        List<Message> list = messageService.selectListByUserId(userId);
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
    public ResponseEntityBase messageDetail(@RequestParam int id) {
        Message guitar = messageService.messageDetail(id);
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
