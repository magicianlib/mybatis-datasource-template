package io.ituknown.multi.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@DependsOn("src1DataSource")
@MapperScan(
        basePackages = "io.ituknown.multi.src1.mapper",
        sqlSessionTemplateRef = "sqlSessionTemplate"
)
public class Src1MyBatisConfig {

    @Primary
    @Bean("src1DataSource")
    public DataSource src1DataSource(@Qualifier("src1DataSourceProperties") DataSourceProperties.Src1DataSource properties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDbType("mysql");

        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        return dataSource;
    }

    @Primary
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("src1DataSource") DataSource dynamicDataSource) throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dynamicDataSource);

        // No Need
        // factoryBean.setTypeAliasesPackage("io.ituknown.multi.src1.domain");

        // mybatis-config.xml
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml"));

        // If `mapper.xml` in multi-jar, please use classpath*, like this:
        // factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/src1/**/*.xml"));
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/src1/**/*.xml"));

        return factoryBean.getObject();
    }

    @Primary
    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Primary
    @Bean("transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("src1DataSource") DataSource dynamicDataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dynamicDataSource);
        return transactionManager;
    }

    @Primary
    @Bean("transactionTemplate")
    public TransactionTemplate transactionTemplate(@Qualifier("transactionManager") DataSourceTransactionManager transactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager);
        return transactionTemplate;
    }
}
