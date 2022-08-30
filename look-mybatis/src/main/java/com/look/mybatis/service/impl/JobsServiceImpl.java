package com.look.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.look.mybatis.mapper.JobsMapper;
import com.look.mybatis.model.Jobs;
import com.look.mybatis.service.IJobsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 求职信息 服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2022-05-18
 */
@Service
public class JobsServiceImpl extends ServiceImpl<JobsMapper, Jobs> implements IJobsService {
    private static final Logger logger = LoggerFactory.getLogger(JobsServiceImpl.class);
    @Autowired
    private JobsMapper jobsMapper;

    @Override
    public List<Jobs> showJobs() {
         System.out.println(("----- selectAll method test ------"));
        //参数是一个Wrapper，条件结构器，这里先不用 填null
        //查询所有的用户
        List<Jobs> userList = jobsMapper.selectList(null);
        userList.forEach(System.out::println);
        return userList;
    }
}
