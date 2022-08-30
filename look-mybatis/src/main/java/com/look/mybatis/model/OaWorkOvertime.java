package com.look.mybatis.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 加班申请表
 * </p>
 *
 * @author astupidcoder
 * @since 2022-08-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class OaWorkOvertime extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * UNID
     */
    private Integer oawtUnid;

    /**
     * UUID
     */
    private String oawtUuid;

    /**
     * 创建时间
     */
    private LocalDateTime oawtCreateTime;

    /**
     * 创建者uuid
     */
    private String oawtCreator;

    /**
     * 创建者name
     */
    private String oawtCreatorName;

    /**
     * 创建单位标识
     */
    private String oawtCreatorDeptUuid;

    /**
     * 创建单位名称
     */
    private String oawtCreatorDeptName;

    /**
     * 更新时间
     */
    private LocalDateTime oawtUpdateTime;

    /**
     * 更新者uuid
     */
    private String oawtUpdater;

    /**
     * 更新者name
     */
    private String oawtUpdaterName;

    /**
     * 状态
     */
    private String oawtStatus;

    /**
     * 排序
     */
    private Integer oawtOrder;

    /**
     * 备注
     */
    private String oawtRemarks;

    /**
     * 加班开始时间
     */
    private LocalDateTime oawtOvertimeStartDate;

    /**
     * 加班结束时间
     */
    private LocalDateTime oawtOvertimeEndDate;

    /**
     * 加班类型 数据字典：调休/加班费
     */
    private String oawtOvertimeType;

    /**
     * 加班人员
     */
    private String oawtOvertimePersion;

    /**
     * 加班原因
     */
    private String oawtOvertimeReason;

    /**
     * 表单分组UUID
     */
    private String oawtCmmGroupUuid;

    /**
     * 表单UUID
     */
    private String oawtCmmFormUuid;

    /**
     * 模型UUID
     */
    private String oawtModelid;

    /**
     * 流程标识
     */
    private String oawtCmmWfinstwkflwdefn;

    /**
     * 流程实例标识
     */
    private String oawtCmmWfinstuuid;

    /**
     * 标题
     */
    private String oawtTitle;

    /**
     * 加班汇总
     */
    private String oawtOvertimeCount;

    /**
     * 加班人员uuid
     */
    private String oawtOvertimePersionUuid;


}
