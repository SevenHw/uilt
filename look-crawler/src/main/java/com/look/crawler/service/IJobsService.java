package com.look.crawler.service;

import com.look.common.util.Message;
import com.look.crawler.model.Jobs;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 求职信息 服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2022-05-18
 */
public interface IJobsService extends IService<Jobs> {
    Message crawlerJobMain();
}
