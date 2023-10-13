package com.cafe.intercepter;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class RoutingInterceptor implements WebMvcConfigurer{

	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
    	.allowedOrigins("http://localhost:8080/") // 허용할 출처
        .allowedMethods("GET", "POST") // 허용할 HTTP method
        .allowCredentials(true) // 쿠키 인증 요청 허용
        .maxAge(3000); // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/static/")
        .resourceChain(true)
        .addResolver(new PathResourceResolver() {
            @Override
            protected Resource getResource(String resourcePath, Resource location) throws IOException {
                Resource requestedResource = location.createRelative(resourcePath);
                //return new ClassPathResource("/static/index.html");
                return requestedResource.exists() && requestedResource.isReadable() ? requestedResource : new ClassPathResource("/static/index.html");
            }
        });
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new CustomInterceptor()).addPathPatterns("/*/**").excludePathPatterns("/login").excludePathPatterns("/api/login")
		.excludePathPatterns("/signUp").excludePathPatterns("/api/signUp");
	}

	
	

}

