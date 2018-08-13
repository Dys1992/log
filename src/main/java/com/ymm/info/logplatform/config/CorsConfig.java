package com.ymm.info.logplatform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author fanyu9488
 * @version Id: CorsConfig, v 0.1 2018/7/30 17:58 wyy32641 Exp $
 */

@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry){

        registry.addMapping("/**").allowedOrigins("*")
                .allowCredentials(true).allowedMethods("GET","POST","DELETE","PUT").maxAge(3600);
    }

}
