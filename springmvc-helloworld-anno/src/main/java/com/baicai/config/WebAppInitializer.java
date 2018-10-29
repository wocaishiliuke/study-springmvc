package com.baicai.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 替代web.xml配置
 * 方式一：实现WebApplicationInitializer接口
 * 方式二（推荐）：继承WebApplicationInitializer的实现类AbstractAnnotationConfigDispatcherServletInitializer
 */
/*public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletCxt) {
        // 加载SpringMVC的配置
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(MvcConfig.class);
        // refresh前先设置容器：
        // 因为refresh()中会创建defaultServletHandlerMapping实例，需要ServletContext容器，否则报错：
        // A ServletContext is required to configure default servlet handling
        ac.setServletContext(servletCxt);
        ac.refresh();

        // 创建和注册DispatcherServlet实例
        ServletRegistration.Dynamic registration = servletCxt.addServlet("springmvc", new DispatcherServlet(ac));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}*/

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
}
