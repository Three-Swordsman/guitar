package com.zhaoshy.guitarhelper.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("guitar")
@Data
public class Guitar {
    private Integer id;

    private String brand;

    private String modelNum;

    private String img;

    private String color;

    private String fingerboardMaterial;

    private String appObject;

    private String size;

    private Double price;

    private String number;

    private Integer type;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private Integer delFlag;

}