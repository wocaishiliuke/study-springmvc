package com.baicai.congfig;

import com.baicai.interceptor.AuthHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.baicai.controller")
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 试图解析器，bean name需为viewResolver
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * 文件上传，bean name需为multipartResolver
     * @return
     */
    /*@Bean
    public MultipartResolver multipartResolver() {

        //方式一：CommonsMultipartResolver
        *//* CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10485760);
        multipartResolver.setMaxUploadSizePerFile(3145728);
        multipartResolver.setDefaultEncoding("UTF-8");*//*

        // 方式二：StandardServletMultipartResolver
        StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
        return multipartResolver;
    }*/

    /**
     * Spring的静态资源处理
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
                .addResourceLocations("/image/")
                .setCachePeriod(3600);
        /*registry.addResourceHandler("/js/**")
                .addResourceLocations("/js/**")
                .setCachePeriod(3600);*/
    }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthHandlerInterceptor()).addPathPatterns("/**")
                                                            //排除fileUpload的请求
                                                            .excludePathPatterns("/file/**");
    }

    //相当于<mvc:default-servlet-handler/>，也可以处理静态资源
    /*@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/
}