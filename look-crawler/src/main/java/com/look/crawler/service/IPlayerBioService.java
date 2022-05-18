package com.look.crawler.service;

import com.look.common.util.Message;
import com.look.crawler.model.PlayerBio;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 球员信息 服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2022-05-18
 */
public interface IPlayerBioService extends IService<PlayerBio> {
    Message crawlerBioMain();
}
