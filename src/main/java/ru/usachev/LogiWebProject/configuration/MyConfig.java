package ru.usachev.LogiWebProject.configuration;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.usachev.LogiWebProject.converter.StringArrayToWaypointDTOList;
import ru.usachev.LogiWebProject.converter.StringToWaypointDAO;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = "ru.usachev.LogiWebProject")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig extends WebMvcConfigurationSupport {

    @Autowired
    private StringArrayToWaypointDTOList stringArrayToWaypointDTOList;

    @Autowired
    private StringToWaypointDAO stringToWaypointDAO;

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/logiWeb?useSSL=false&amp&serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("cfif270599!");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("ru.usachev.LogiWebProject.entity");

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.connection.Charset", "UTF-8");
        hibernateProperties.setProperty("hibernate.connection.CharacterEncoding", "UTF-8");
        hibernateProperties.setProperty("hibernate.connection.Useunicode", "true");

        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

/*
    @Bean
    public ConversionService getConversionService()
    {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters( getConverters() );
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    private Set<Converter<?, ?>> getConverters()
    {
        Set<Converter<?, ?>> converters = new HashSet<>();

        converters.add( stringArrayToWaypointDTOList );

        return converters;
    }
*/


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringArrayToWaypointDTOList);
        registry.addConverter(stringToWaypointDAO);
        super.addFormatters(registry);
    }
}
