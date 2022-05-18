package com.look.common.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MybatisPlusGeneratorEntity implements Serializable {
    //库的路径
    private String url;

    //数据库驱动
    private String driverName;

    //数据库连接名
    private String userName;

    //数据库连接密码
    private String password;
}
