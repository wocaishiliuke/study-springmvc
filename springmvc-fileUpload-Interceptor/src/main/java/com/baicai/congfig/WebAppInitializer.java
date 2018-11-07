package com.baicai.congfig;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /** （父容器root WebApplicationContext）返回的带有@Configuration注解的类，用来配置ContextLoaderListener创建的应用上下文中的Bean
     * <context-param>
     *     <param-name>contextConfigLocation</param-name>
     *     <param-value>/WEB-INF/app-context.xml</param-value>
     * </context-param>
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /** （子容器servlet WebApplicationContext）加载SpringMVC配置文件
     * <servlet>
     *     <servlet-name>...</servlet-name>
     *     <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
     *     <init-param>
     *          <param-name>contextConfigLocation</param-name>
     *          <param-value></param-value>
     *    </init-param>
     * </servlet>
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ MvcConfig.class };
    }

    /**
     * DispatcherServlet的路径映射
     * <servlet-mapping>
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }

    /**
     * 使用StandardServletMultipartResolver时，需要配置Multipart
     * @param registration
     */
    /*@Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // 相当于<multipart-config>
        registration.setMultipartConfig(new MultipartConfigElement("/tmp", 1048576, 5242880, 0));
    }*/

    /**
     * Spring的过滤器，处理POST乱码（GET不起作用）
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] { characterEncodingFilter};
    }
}
