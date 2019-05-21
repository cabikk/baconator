package com.atlasgroup.baconator.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class RequestsNumberInterceptorAppConfig implements WebMvcConfigurer {
  @Autowired
  RequestsNumberInterceptor productServiceInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(productServiceInterceptor).addPathPatterns("/give-me-bacon/*");
  }
}

