package configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * Created by IntelliJ IDEA.
 * User: vulp
 * Date: 2/9/13
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebApp implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        final AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.setServletContext(servletContext);
        root.scan("configuration");
        root.refresh();
        ServletRegistration.Dynamic servlet = servletContext.addServlet("janoinen", new DispatcherServlet(root));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("resources/");
    }

}
