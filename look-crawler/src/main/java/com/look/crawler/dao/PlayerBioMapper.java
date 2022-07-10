package com.look.crawler.dao;

import com.look.crawler.model.PlayerBio;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 球员信息 Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2022-05-18
 */
@Mapper
public interface PlayerBioMapper extends BaseMapper<PlayerBio> {

}