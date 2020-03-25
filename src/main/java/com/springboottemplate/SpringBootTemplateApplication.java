package com.springboottemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 * @SpringBootApplication 代表是启动类
 * @EnableScheduling      表示开启定时任务功能
 */
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class SpringBootTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTemplateApplication.class, args);
	}

}
