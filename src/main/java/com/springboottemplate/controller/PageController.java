package com.springboottemplate.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description:Spring内部的一种配置方式 采用JavaBean的形式来代替传统的xml配置文件形式进行针对框架个性化定制
 * 在这个类上加上 @EnableWebMvc 注解代表全面接管springmvc会导致springboot扽自动配置失效
 * 所以不推荐使用
 * 
 * @author: 唐涛
 * @date: 2019年8月13日 下午5:30:51
 * 
 */
@Configuration
public class PageController extends WebMvcConfigurerAdapter {
//常用方法
//	1、addInterceptors：拦截器
//	2、addCorsMappings：跨域
//	3、addViewControllers：跳转指定页面
//	4、resourceViewResolver：视图解析器
//	5、configureMessageConverters：信息转换器
//	6、addResourceHandlers：静态资源

	/*
	 * 跳转到指定页面 (non-Javadoc)
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) { // index页面在 templates 文件夹下
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/userinfo").setViewName("userinfo");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

		super.addViewControllers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub

		super.addInterceptors(registry);
	}

	/* 跨域 */
//	public void addCorsMappings(CorsRegistry registry) {
//	    super.addCorsMappings(registry);
//	    registry.addMapping("/cors/**")
//	            .allowedHeaders("*")
//	            .allowedMethods("POST","GET")
//	            .allowedOrigins("*");
//	}


}
