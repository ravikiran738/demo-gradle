package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ModelCookieInterceptor());
    }*/
	
	
	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
	    CharacterEncodingFilter filter = new CharacterEncodingFilter();
	    filter.setEncoding("UTF-8");
	    filter.setForceEncoding(true);
	    return filter;
	}
	
	 @Override
	    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	    configurer.favorPathExtension(false).
	            favorParameter(true).
	            defaultContentType(MediaType.APPLICATION_JSON).
	            mediaType("xml", MediaType.APPLICATION_JSON);
	    }
 
}