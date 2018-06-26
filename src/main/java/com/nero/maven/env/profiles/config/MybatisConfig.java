package com.nero.maven.env.profiles.config;

import com.github.pagehelper.PageHelper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * @author Nero
 * @since 2018-06-26 11:17
 */
@Configuration
@ComponentScan
@EnableTransactionManagement
@MapperScan("com.nero.maven.env.profiles.persistence")
public class MybatisConfig implements TransactionManagementConfigurer{
    @Value("${db.driver}")
    String driverClass;
    @Value("${db.url}")
    String dbUrl;
    @Value("${db.username}")
    String userName;
    @Value("${db.password}")
    String passWord;

    @Value("${db.initialPoolSize}")
    int initialPoolSize;
    @Value("${db.autoCommitOnClose}")
    boolean autoCommitOnClose;
    @Value("${db.checkoutTimeout}")
    int checkoutTimeout;
    @Value("${db.minPoolSize}")
    int minPoolSize;
    @Value("${db.maxPoolSize}")
    int maxPoolSize;
    @Value("${db.maxIdleTime}")
    int maxIdleTime;
    @Value("${db.acquireIncrement}")
    int acquireIncrement;

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(driverClass);
            ds.setUser(userName);
            ds.setPassword(passWord);
            ds.setJdbcUrl(dbUrl);
            ds.setInitialPoolSize(initialPoolSize);
            ds.setAutoCommitOnClose(autoCommitOnClose);
            ds.setCheckoutTimeout(checkoutTimeout);
            ds.setMinPoolSize(minPoolSize);
            ds.setMaxPoolSize(maxPoolSize);
            ds.setMaxIdleTime(maxIdleTime);
            ds.setAcquireIncrement(acquireIncrement);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        VFS.addImplClass(SpringBootVFS.class);
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        //添加分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        sessionFactory.setPlugins(new Interceptor[]{pageHelper});
        // 设置默认别名
        sessionFactory.setTypeAliasesPackage("com.nero.maven.env.profiles.entities");
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/mappers/**/*.xml"));
        return sessionFactory;
    }
}
