package io.ituknown.config;

import java.lang.annotation.*;

/**
 * 从库
 *
 * @author Shilin <br > mingrn97@gmail.com
 * @date 2022/06/16 15:48
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DataSource(type = DataSourceType.SLAVE)
public @interface SlaveDataSource {
}
