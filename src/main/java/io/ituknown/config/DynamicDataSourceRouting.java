package io.ituknown.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源动态路由
 *
 * @author Shilin <br > mingrn97@gmail.com
 * @date 2022/06/16 14:40
 */
public class DynamicDataSourceRouting extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.get();
    }
}
