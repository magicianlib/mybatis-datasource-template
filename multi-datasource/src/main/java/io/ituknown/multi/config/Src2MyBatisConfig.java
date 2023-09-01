package io.ituknown.multi.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@DependsOn("src2DataSource")
@MapperScan(
        basePackages = "io.ituknown.multi.src2.mapper",
        sqlSessionTemplateRef = "src2SqlSessionTemplate"
)
public class Src2MyBatisConfig {

    @Bean("src2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("src2DataSource") DataSource dynamicDataSource) throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dynamicDataSource);

        // No Need
        // factoryBean.setTypeAliasesPackage("io.ituknown.multi.src2.domain");

        // mybatis-config.xml
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml"));

        // If `mapper.xml` in multi-jar, please use classpath*, like this:
        // factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/src2/**/*.xml"));
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/src2/**/*.xml"));

        return factoryBean.getObject();
    }

    @Bean("src2SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("src2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("src2TransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("src2DataSource") DataSource dynamicDataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dynamicDataSource);
        return transactionManager;
    }

    @Bean("src2TransactionTemplate")
    public TransactionTemplate transactionTemplate(@Qualifier("src2TransactionManager") DataSourceTransactionManager transactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager);
        return transactionTemplate;
    }
}
