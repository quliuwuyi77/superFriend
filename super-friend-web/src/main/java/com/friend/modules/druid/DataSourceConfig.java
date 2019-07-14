package com.friend.modules.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "SqlSessionFactory")
public class DataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);


    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.friend.modules.**.dao";
    static final String MAPPER_LOCATION = "com/friend/modules/**/dao/*Mapper.xml";

    @Autowired
    private DruidProperties properties;

    @Bean(name = "masterDataSource",destroyMethod = "close",initMethod = "init")
    @Primary
    public DataSource masterDataSource() {
        logger.info("开始配置druidDataSource");

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setDriverClassName(properties.getDriverClass());
        dataSource.setInitialSize(properties.getInitialSize());
        dataSource.setInitialSize(properties.getInitialSize());
        dataSource.setMinIdle(properties.getMinIdle());
        dataSource.setMaxActive(properties.getMaxActive());
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        dataSource.setMaxWait(properties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(properties.getValidationQuery());
        dataSource.setTestWhileIdle(properties.isTestWhileIdle());
        dataSource.setTestOnReturn(properties.isTestOnReturn());
        dataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
        try {
            dataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        logger.info("druidDataSource配置成功: \n" + properties.toString());
        return dataSource;

    }

    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean(name = "SqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);

        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(this.MAPPER_LOCATION));

        //配置分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("pageSizeZero","true");
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        PageInterceptor interceptor = new PageInterceptor();
        interceptor.setProperties(properties);
        //设置插件
        sessionFactory.setPlugins(new Interceptor[]{interceptor});
        return sessionFactory.getObject();
    }
}
