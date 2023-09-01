package io.ituknown.dynamic.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 多数据源属性配置
 *
 * @author Shilin <br > mingrn97@gmail.com
 * @since 2023/09/01 16:12
 */
@Configuration
public class DataSourceProperties {

    @Bean("masterDataSourceProperties")
    public MasterDataSource masterDataSource() {
        return new MasterDataSource();
    }

    @Bean("slaveDataSourceProperties")
    public SlaveDataSource slaveDataSource() {
        return new SlaveDataSource();
    }

    @Setter
    @Getter
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public static class MasterDataSource extends BasicDataSourceProperties {
    }

    @Setter
    @Getter
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public static class SlaveDataSource extends BasicDataSourceProperties {
    }

    @Getter
    @Setter
    public static class BasicDataSourceProperties {
        /**
         * 数据源名称
         */
        private String name;

        /**
         * 数据库用户名
         */
        private String username;

        /**
         * 数据库密码
         */
        private String password;

        /**
         * 数据库地址
         */
        private String url;
    }

}
