package by.seledtsovaos.departure.web.config;

import java.util.Properties;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
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

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return new Filter[] {encodingFilter};
    }

    @Bean(name = "simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver createSwitchableSimpleMappingExceptionResolver() {
        // Turn exception resolving off to start
        boolean initialState = false;

        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();

        Properties mappings = new Properties();
        String errorJspPage = "error_page";
        mappings.setProperty("DaoException", errorJspPage);
        mappings.setProperty("ServiceException", errorJspPage);

        resolver.setExceptionMappings(mappings);
        resolver.setExceptionAttribute("exception");
        resolver.setDefaultErrorView(errorJspPage);
        return resolver;
    }
}
