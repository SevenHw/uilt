package com.look.mybatis.controller;


import com.look.mybatis.model.Jobs;
import com.look.mybatis.service.IJobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 求职信息 前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2022-05-18
 */
@RestController
@RequestMapping("/jobs")
public class JobsController {

    @Autowired
    private IJobsService jobsService;

    @RequestMapping("/showJobs")
    public List<Jobs> showJobs(){
        return jobsService.showJobs();
    }

}
