/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.boot.webflux;

import freemarker.template.TemplateException;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.reactive.result.view.freemarker.FreeMarkerConfigurer;

/**
 *
 * @author Yang
 */
public class VelocityConfig {
    
    
    @Bean
    public ViewResolver viewResolver() {
        ViewResolver resolver = new VelocityViewResolver("", ".html");
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
        FreeMarkerConfigurationFactory factory = new VelocityConfigurerFactory();
        factory.setTemplateLoaderPaths("classpath:templates", "src/main/resource/templates");
        factory.setDefaultEncoding("UTF-8");
        FreeMarkerConfigurer result = new FreeMarkerConfigurer();
        result.setConfiguration(factory.createConfiguration());
        return result;
    }
}
