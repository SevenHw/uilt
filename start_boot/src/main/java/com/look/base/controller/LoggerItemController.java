package com.look.base.controller;

import com.look.common.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoggerItemController
 * @Author like
 * @Date 2022/5/12 21:44
 * 日志监控测试
 **/
@Controller
@RequestMapping("/loggerItem")
public class LoggerItemController {
    private static final Logger logger = LoggerFactory.getLogger(LoggerItemController.class);

    @ResponseBody
    @GetMapping("/logInfo")
    public Message logTest(){

        logger.debug("=====>测试日志debug级别打印<====");
        logger.info("=====>测试日志info级别打印<=====");
        logger.error("=====>测试日志error级别打印<====");
        logger.warn("=====>测试日志warn级别打印<=====");

        return Message.success();
    }
}
