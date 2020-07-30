package com.neuda.shorturl.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.neuda.shorturl.filter.AnalyticsFilter;
@Configuration
public class AnalyticsConfig {

	@Bean
	public FilterRegistrationBean<AnalyticsFilter> analyticsFilter(){
	    FilterRegistrationBean<AnalyticsFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	        
	    registrationBean.setFilter(new AnalyticsFilter());
	    registrationBean.addUrlPatterns("/r/*");
	        
	    return registrationBean;    
	}
}
