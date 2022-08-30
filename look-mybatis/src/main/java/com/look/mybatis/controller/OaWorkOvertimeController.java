package com.look.mybatis.controller;


import com.look.common.util.Message;
import com.look.mybatis.model.OaWorkOvertime;
import com.look.mybatis.service.IOaWorkOvertimeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 加班申请表 前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2022-08-30
 */
@RestController
@RequestMapping("/overtime")
public class OaWorkOvertimeController {

    @Resource
    private IOaWorkOvertimeService oaWorkOvertimeService;

    @PostMapping("/showList")
    public Message showJobs(){
        Message message = new Message();
        List<OaWorkOvertime> oaWorkOvertimes = oaWorkOvertimeService.showList();
        message.addInfo("data",oaWorkOvertimes);
        message.addInfo("total", oaWorkOvertimes.size());
        message.setCode(200);
        message.setMsg("成功");
        return message;
    }


}
