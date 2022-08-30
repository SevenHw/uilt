package com.look.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.look.mybatis.model.Jobs;
import com.look.mybatis.model.OaWorkOvertime;

import java.util.List;

/**
 * <p>
 * 加班申请表 服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2022-08-30
 */
public interface IOaWorkOvertimeService extends IService<OaWorkOvertime> {

    List<OaWorkOvertime> showList();
}
