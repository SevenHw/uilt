package com.look.crawler.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

/**
 * <p>
 * 求职信息
 * </p>
 *
 * @author astupidcoder
 * @since 2022-05-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Jobs extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "job_id", type = IdType.AUTO)
    private Integer jobId;

    /**
     * 岗位
     */
    private String jobName;

    /**
     * 公司名
     */
    private String companyName;

    /**
     * 公司地址
     */
    private String workAddr;

    /**
     * 薪水
     */
    private String salary;

    /**
     * 发布日期
     */
    private String pushDate;

    private String jobKey;

    /**
     * 数据来源
     */
    @Value("job58")
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
    @Value("1")
    private String dataStatus;


}
