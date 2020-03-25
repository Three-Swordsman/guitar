package com.zhaoshy.guitarhelper.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("message")
@Data
public class Message {
    private Integer id;

    private String messageinfo;

    private String userid;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private Integer delFlag;
}