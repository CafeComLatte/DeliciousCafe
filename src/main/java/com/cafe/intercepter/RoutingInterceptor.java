package com.cafe.intercepter;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class RoutingInterceptor implements WebMvcConfigurer{

	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/api/**").allowedOrigins("http://localhost:8080").maxAge(60).
		allowCredentials(true);
		
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/hello")
        .addResourceLocations("classpath:/static/")
        .resourceChain(true)
        .addResolver(new PathResourceResolver() {
            @Override
            protected Resource getResource(String resourcePath, Resource location) throws IOException {
                Resource requestedResource = location.createRelative(resourcePath);
                return requestedResource.exists() && requestedResource.isReadable() ? requestedResource : new ClassPathResource("/static/index.html");
            }
        });
	}

	
	

}

