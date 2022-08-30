package com.look.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.look.mybatis.model.Jobs;

import java.util.List;

/**
 * <p>
 * 求职信息 服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2022-05-18
 */
public interface IJobsService extends IService<Jobs> {

    List<Jobs> showJobs();

}
