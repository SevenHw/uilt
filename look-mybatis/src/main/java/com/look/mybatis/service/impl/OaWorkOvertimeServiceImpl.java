package com.look.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.look.mybatis.mapper.OaWorkOvertimeMapper;
import com.look.mybatis.model.OaWorkOvertime;
import com.look.mybatis.service.IOaWorkOvertimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 加班申请表 服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2022-08-30
 */
@Service
public class OaWorkOvertimeServiceImpl extends ServiceImpl<OaWorkOvertimeMapper, OaWorkOvertime> implements IOaWorkOvertimeService {

    private static final Logger logger = LoggerFactory.getLogger(OaWorkOvertimeServiceImpl.class);
    @Resource
    private OaWorkOvertimeMapper oaWorkOvertimeMapper;

    @Override
    public List<OaWorkOvertime> showList() {
        System.out.println(("----- selectAll method test ------"));
        //参数是一个Wrapper，条件结构器，这里先不用 填null
        //查询所有的用户
        List<OaWorkOvertime> userList = oaWorkOvertimeMapper.selectList(null);
//        userList.forEach(System.out::println);
        return userList;
    }
}
