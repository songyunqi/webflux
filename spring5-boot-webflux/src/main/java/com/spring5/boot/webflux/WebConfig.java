package com.spring5.boot.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.SpringTemplateLoader;
import org.springframework.web.reactive.result.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.reactive.result.view.freemarker.FreeMarkerViewResolver;


/**
 * Created by Yang on 2017/7/14.
 */
@Configuration
public class WebConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public FreeMarkerConfigurer freeMarkerConfig() {
        // Note this is the reactive version of FreeMarker's configuration, so there is no auto-configuration yet.
        final FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setPreTemplateLoaders(new SpringTemplateLoader(this.applicationContext, "/templates/"));
        return freeMarkerConfigurer;
    }

    /*
     * ViewResolver for FreeMarker templates executing in NORMAL mode (only mode available for FreeMarker)
     * No limit to output buffer size, all data fully resolved in context.
     */
    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        final FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver("/templates/", ".html");
        //freeMarkerViewResolver.setOrder(4);
        viewResolver.setViewNames(new String[]{"/*"});
        return viewResolver;
    }


//    @Bean
//    public ThymeleafReactiveViewResolver thymeleafReactiveViewResolver(final ISpringWebFluxTemplateEngine templateEngine){
//        final ThymeleafReactiveViewResolver viewResolver = new ThymeleafReactiveViewResolver();
//        viewResolver.setTemplateEngine(templateEngine);
//        viewResolver.setOrder(2);
//        viewResolver.setViewNames(new String[] {"thymeleaf/*"});
//        return viewResolver;
//    }
//
//    /*
//     * ViewResolver for Thymeleaf templates executing in BUFFERED or DATA-DRIVEN mode.
//     *
//     * CHUNKED: non-data-driven (all data fully resolved in context) but with an established limit to output chunk size.
//     *
//     * DATA-DRIVEN: the "dataSource" variable can be a Publisher<X>, in which case it will drive the execution of
//     *              the engine and Thymeleaf will be executed as a part of the data flow.
//     */
//    @Bean
//    public ThymeleafReactiveViewResolver thymeleafChunkedAndDataDrivenViewResolver(final ISpringWebFluxTemplateEngine templateEngine){
//        final ThymeleafReactiveViewResolver viewResolver = new ThymeleafReactiveViewResolver();
//        viewResolver.setTemplateEngine(templateEngine);
//        viewResolver.setOrder(1);
//        viewResolver.setViewNames(new String[] {"thymeleaf/*chunked*", "thymeleaf/*datadriven*"});
//        viewResolver.setResponseMaxChunkSizeBytes(8192); // OUTPUT BUFFER size limit
//        return viewResolver;
//    }

//    @Bean
//    public ThymeleafReactiveViewResolver thymeleafReactiveViewResolver(final ISpringWebFluxTemplateEngine templateEngine){
//        final ThymeleafReactiveViewResolver viewResolver = new ThymeleafReactiveViewResolver();
//        viewResolver.setTemplateEngine(templateEngine);
//        //viewResolver.setOrder(2);
//        //viewResolver.setViewNames(new String[] {"templates/**"});
//        return viewResolver;
//    }
//
//    @Bean
//    public ThymeleafReactiveViewResolver thymeleafChunkedAndDataDrivenViewResolver(final ISpringWebFluxTemplateEngine templateEngine){
//        final ThymeleafReactiveViewResolver viewResolver = new ThymeleafReactiveViewResolver();
//        viewResolver.setTemplateEngine(templateEngine);
//        //viewResolver.setOrder(1);
//        //viewResolver.setViewNames(new String[] {"thymeleaf/*chunked*", "thymeleaf/*datadriven*"});
//        viewResolver.setResponseMaxChunkSizeBytes(8192); // OUTPUT BUFFER size limit
//        return viewResolver;
//    }
}
