package io.ituknown.dynamic.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 多数据源属性配置
 *
 * @author Shilin <br > mingrn97@gmail.com
 * @since 2023/09/01 16:12
 */
@Configuration
public class DataSourceProperties {

    @Bean("masterDataSourceProperties")
    public MasterDataSourceProperties masterDataSourceProperties() {
        return new MasterDataSourceProperties();
    }

    @Bean("slaveDataSourceProperties")
    public SlaveDataSourceProperties slaveDataSourceProperties() {
        return new SlaveDataSourceProperties();
    }

    @Setter
    @Getter
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public static class MasterDataSourceProperties {

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

    @Setter
    @Getter
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public static class SlaveDataSourceProperties {
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
