package io.ituknown.multi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceProperties {

    @Bean("src1DataSourceProperties")
    public Src1DataSourceProperties src1DataSourceProperties() {
        return new Src1DataSourceProperties();
    }

    @Bean("src2DataSourceProperties")
    public Src2DataSourceProperties src2DataSourceProperties() {
        return new Src2DataSourceProperties();
    }

    @Setter
    @Getter
    @ConfigurationProperties(prefix = "spring.datasource.src1")
    public static class Src1DataSourceProperties {

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
    @ConfigurationProperties(prefix = "spring.datasource.src2")
    public static class Src2DataSourceProperties {
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