package com.geekykel.globalaccelerex.configuration;

import com.geekykel.globalaccelerex.exception.CustomResponseErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Kelvin on 09/03/2020
 *
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // Inject Custom Error Handler
        restTemplate.setErrorHandler(new CustomResponseErrorHandler());

        return restTemplate;
    }

}
