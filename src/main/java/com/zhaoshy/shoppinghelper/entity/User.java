package com.zhaoshy.shoppinghelper.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("user")
@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private String userType;

    private String name;

    private String moblie;

    private String address;

    private String occupation;

    private String idCardImg;

    private String driverLicenseImg;

    private String meberId;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

}