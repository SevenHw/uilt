
package com.look.common.util;

import java.lang.annotation.*;

/**
 * 功能描述 :分页标记型注解
 * @author Bin.Zhang
 * @version [版本号,  2018/7/21]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PageAnnotation
{
    /**
     * 当前页码的key
     * @return
     */
    String pageIndexKey() default "pageIndex";

    /**
     * 每页数据行数的key
     * @return
     */
    String pageSizeKey() default "pageSize";

    /**
     * 起始页码
     * @return
     */
    int startPageIndex() default 0;
}
