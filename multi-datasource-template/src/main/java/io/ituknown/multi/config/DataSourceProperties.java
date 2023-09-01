package io.ituknown.multi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceProperties {

    @Bean("src1DataSourceProperties")
    public Src1DataSource src1DataSourceProperties() {
        return new Src1DataSource();
    }

    @Bean("src2DataSourceProperties")
    public Src2DataSource src2DataSourceProperties() {
        return new Src2DataSource();
    }

    @Setter
    @Getter
    @ConfigurationProperties(prefix = "spring.datasource.src1")
    public static class Src1DataSource extends BasicDataSourceProperties {
    }

    @Setter
    @Getter
    @ConfigurationProperties(prefix = "spring.datasource.src2")
    public static class Src2DataSource extends BasicDataSourceProperties {
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