package io.ituknown.dynamic.config;

import java.lang.annotation.*;

/**
 * 从库
 *
 * @author Shilin <br > mingrn97@gmail.com
 * @since 2023/09/01 16:13
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DataSource(type = DataSourceType.SLAVE)
public @interface SlaveDataSource {
}
