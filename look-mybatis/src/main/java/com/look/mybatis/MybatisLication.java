package com.look.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.look.mybatis.mapper")
public class MybatisLication {
    private static final Logger logger = LoggerFactory.getLogger(MybatisLication.class);
    public static void main(String[] args) {
        logger.info("爬虫项目启动");
        SpringApplication.run(MybatisLication.class, args);
        logger.info("爬虫项目启动完成");
    }
}
