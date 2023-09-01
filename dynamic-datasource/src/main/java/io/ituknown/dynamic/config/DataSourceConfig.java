package io.ituknown.dynamic.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据源配置
 *
 * @author Shilin <br > mingrn97@gmail.com
 * @since 2023/09/01 16:12
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private DataSourceProperties.MasterDataSourceProperties masterDataSourceProperties;

    @Autowired
    private DataSourceProperties.SlaveDataSourceProperties slaveDataSourceProperties;

    /**
     * 动态数据源
     */
    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {

        Map<Object, Object> targetDataSources = new ConcurrentHashMap<>(4);
        targetDataSources.put(DataSourceType.MASTER, masterDataSource());
        targetDataSources.put(DataSourceType.SLAVE, slaveDataSource());

        DynamicRoutingDataSource dynamicDataSource = new DynamicRoutingDataSource();
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource());
        dynamicDataSource.setTargetDataSources(targetDataSources);

        return dynamicDataSource;
    }

    @Bean("masterDataSource")
    public DataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDbType("mysql");

        dataSource.setUrl(masterDataSourceProperties.getUrl());
        dataSource.setUsername(masterDataSourceProperties.getUsername());
        dataSource.setPassword(masterDataSourceProperties.getPassword());

        return dataSource;
    }

    @Bean("slaveDataSource")
    public DataSource slaveDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDbType("mysql");

        dataSource.setUrl(slaveDataSourceProperties.getUrl());
        dataSource.setUsername(slaveDataSourceProperties.getUsername());
        dataSource.setPassword(slaveDataSourceProperties.getPassword());

        return dataSource;
    }
}
