package io.ituknown.dynamic.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源动态路由
 *
 * @author Shilin <br > mingrn97@gmail.com
 * @since 2023/09/01 16:12
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.get();
    }
}
