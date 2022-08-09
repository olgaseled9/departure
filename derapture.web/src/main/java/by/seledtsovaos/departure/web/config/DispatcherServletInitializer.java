package by.seledtsovaos.departure.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import by.seledtsovaos.departure.repository.spring.SpringPersistenceConfig;
import by.seledtsovaos.departure.service.spring.SpringServiceConfig;

/**
 * Registers the Spring Dispatcher Servlet when the application starts.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "by.seledtsovaos.departure.web")
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {SpringServiceConfig.class,
            SpringPersistenceConfig.class, WebMvcConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
