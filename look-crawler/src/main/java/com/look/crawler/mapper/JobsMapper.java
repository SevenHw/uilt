package com.look.crawler.mapper;

import com.look.crawler.model.Jobs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 求职信息 Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2022-05-18
 */
@Repository
public interface JobsMapper extends BaseMapper<Jobs> {

}
