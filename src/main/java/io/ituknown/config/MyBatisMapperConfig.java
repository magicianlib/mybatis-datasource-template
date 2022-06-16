package io.ituknown.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
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
 * @date 2022/06/16 14:46
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "io.ituknown.mapper")
public class MyBatisMapperConfig {

    @Bean
    @Primary
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dynamicDataSource) throws Exception {

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dynamicDataSource);
        factoryBean.setTypeAliasesPackage("io.ituknown.domain");
        factoryBean.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml"));
        factoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));

        // If `mapper.xml` in multi-jar, please use classpath*, like this:
        // factoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));

        return factoryBean;
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
