package ru.kpfu.itis.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.sql.DataSource;

@ComponentScan("ru.kpfu.itis")
@PropertySource("classpath:ru.kpfu.itis//application.properties")
public class AppAnnotationConfig {

  @Autowired
  private Environment environment;

  @Bean
  public FreeMarkerConfigurer freemarkerConfig() {
    FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
    freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/ftl/");
    return freeMarkerConfigurer;
  }

  @Bean(name = "freeMarkerViewResolver")
  public ViewResolver viewResolver() {
    FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
    viewResolver.setCache(true);
    viewResolver.setPrefix("");
    viewResolver.setSuffix(".ftl");
    viewResolver.setContentType("text/html; charset=UTF-8");
    return viewResolver;
  }

  /*@Bean
  public InternalResourceViewResolver cssViewResolver(){
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("WEB-INF/resources/css/");
    viewResolver.setSuffix(".css");
    return viewResolver;
  }*/

  /*@Bean
  public InternalResourceViewResolver jsViewResolver(){
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("WEB-INF/resources/js/");
    viewResolver.setSuffix(".js");
    return viewResolver;
  }*/

  /*@Bean
  public InternalResourceViewResolver scriptsViewResolver(){
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("WEB-INF/resources/scripts/");
    viewResolver.setSuffix(".js");
    return viewResolver;
  }

  @Bean
  public InternalResourceViewResolver imagesViewResolver(){
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("WEB-INF/resources/img/");
    viewResolver.setSuffix(".jpg");
    return viewResolver;
  }*/



  /*@Bean
  public ViewResolver viewResolver(){
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/jsp/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }*/
  @Bean
  public DataSource dataSourse(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setPassword(environment.getProperty("data.source.password"));
    dataSource.setUsername(environment.getProperty("data.source.username"));
    dataSource.setUrl(environment.getProperty("data.source.url"));
    dataSource.setDriverClassName(environment.getProperty("data.source.driver"));
    return dataSource;
  }


}
