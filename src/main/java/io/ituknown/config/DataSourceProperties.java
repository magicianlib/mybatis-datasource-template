package io.ituknown.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 多数据源属性配置
 *
 * @author Shilin <br > mingrn97@gmail.com
 * @date 2022/06/16 14:40
 */
@Configuration
public class DataSourceProperties {

    @Setter
    @Getter
    @Component
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public static class MasterDataSourceProperties {

        private String username;

        private String password;

        private String url;

    }

    @Setter
    @Getter
    @Component
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public static class SlaveDataSourceProperties {

        private String username;

        private String password;

        private String url;

    }

}
