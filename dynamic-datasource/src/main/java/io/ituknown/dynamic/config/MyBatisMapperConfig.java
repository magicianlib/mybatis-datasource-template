package io.ituknown.dynamic.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * MyBatis Mapper Config
 *
 * @author Shilin <br > mingrn97@gmail.com
 * @since 2023/09/01 16:13
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "io.ituknown.dynamic.mapper")
public class MyBatisMapperConfig {

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dynamicDataSource);

        // No Need
        // factoryBean.setTypeAliasesPackage("io.ituknown.domain");

        // mybatis-config.xml
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml"));

        // If `mapper.xml` in multi-jar, please use classpath*, like this:
        // factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/**/*.xml"));

        return factoryBean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager(DataSource dynamicDataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dynamicDataSource);
        return transactionManager;
    }

    @Bean
    @Primary
    public TransactionTemplate transactionTemplate(DataSourceTransactionManager transactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager);
        return transactionTemplate;
    }
}
