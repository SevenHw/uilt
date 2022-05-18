package com.look.crawler.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 球员信息
 * </p>
 *
 * @author astupidcoder
 * @since 2022-05-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PlayerBio extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "bio_id", type = IdType.AUTO)
    private Integer bioId;

    /**
     * 球员姓名
     */
    private String bioName;

    /**
     * 球队名
     */
    private String bioCompanyName;

    /**
     * 球服号码
     */
    private String bioNumber;

    /**
     * 球员位置
     */
    private String bioSite;

    /**
     * 球员身高
     */
    private String bioStature;

    /**
     * 球员体重
     */
    private String bioWeight;

    /**
     * 数据来源
     */
    private String dataSource;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 修改时间
     */
    private LocalDateTime updateDate;

    /**
     * 状态
     */
    private String dataStatus;

    /**
     * 球员生日
     */
    private String bioBarthday;

    /**
     * 球员合同
     */
    private String bioContract;


}
