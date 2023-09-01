package io.ituknown.multi.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
    private DataSourceProperties.Src1DataSourceProperties src1DataSourceProperties;

    @Autowired
    private DataSourceProperties.Src2DataSourceProperties src2DataSourceProperties;

    @Primary
    @Bean("src1DataSource")
    public DataSource src1DataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDbType("mysql");

        dataSource.setUrl(src1DataSourceProperties.getUrl());
        dataSource.setUsername(src1DataSourceProperties.getUsername());
        dataSource.setPassword(src1DataSourceProperties.getPassword());

        return dataSource;
    }

    @Bean("src2DataSource")
    public DataSource src2DataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDbType("mysql");

        dataSource.setUrl(src2DataSourceProperties.getUrl());
        dataSource.setUsername(src2DataSourceProperties.getUsername());
        dataSource.setPassword(src2DataSourceProperties.getPassword());

        return dataSource;
    }
}
