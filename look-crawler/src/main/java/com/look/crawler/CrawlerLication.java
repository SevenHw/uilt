package com.look.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrawlerLication {
    private static final Logger logger = LoggerFactory.getLogger(CrawlerLication.class);
    public static void main(String[] args) {
        logger.info("爬虫项目启动");
        SpringApplication.run(CrawlerLication.class, args);
        logger.info("爬虫项目启动完成");
    }
}
