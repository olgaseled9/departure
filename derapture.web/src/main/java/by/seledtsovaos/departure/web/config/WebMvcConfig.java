package by.seledtsovaos.departure.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Creates a bean-component that recognizes views,
 * a prefix and suffix for the found views.
 */
@Configuration
@EnableWebMvc
@ComponentScan("by.seledtsovaos.departure.web")
public class WebMvcConfig {

    @Bean
    public UrlBasedViewResolver getViewResovler() {
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setViewClass(JstlView.class);
        urlBasedViewResolver.setPrefix("/WEB-INF/views/");
        urlBasedViewResolver.setSuffix(".jsp");
        return urlBasedViewResolver;
    }
}

