package io.ituknown.config;

import java.lang.annotation.*;

/**
 * 数据源动态注解
 *
 * @author Shilin <br > mingrn97@gmail.com
 * @date 2022/06/16 15:47
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    DataSourceType type() default DataSourceType.MASTER;
}
