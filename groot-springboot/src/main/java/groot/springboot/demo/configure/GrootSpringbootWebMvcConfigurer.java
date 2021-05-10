package groot.springboot.demo.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletContext;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/4/20
 */
@Configuration
public class GrootSpringbootWebMvcConfigurer implements WebMvcConfigurer, ServletContextAware {

    @Value("${groot.springboot.static-url-prefix}")
    private String staticUrlPrefix;

    /**
     * MVC 配置内容概览
     * 1.基本部分：GrootSpringbootWebMvcConfigurer 加双注解 @Configuration、@EnableWebMvc
     * 2.可增减部分：
     */
    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setAttribute("static_url_prefix", staticUrlPrefix);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**");
    }

}
