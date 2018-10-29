package com.baicai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Java配置代替SpringMVC的xml配置文件
 *
 * @Configuration标注为配置类
 * @EnableWebMvc相当于<mvc:annotation-driven/>
 * @ComponentScan(value = "com.baicai.controller")相当于<context:component-scan base-package="com.baicai.controller" />
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.baicai.controller")
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 试图解析器
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    //相当于<mvc:default-servlet-handler/>，处理静态资源
    /*@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/
}

