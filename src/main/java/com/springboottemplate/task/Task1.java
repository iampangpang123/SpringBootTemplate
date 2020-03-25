package com.springboottemplate.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description:定时任务1
 * @author: 唐涛
 * @date: 2020年3月25日 下午2:05:20
 * 
 */

/*
 * @Component 必须加
 * 
 */
@Component
public class Task1 {
	// org.slf4j.LoggerFactory.getLogger(Task1.class);
	// 不写Task1.class也行，也不会报错，就是会影响定位日志
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Task1.class);

	/*
	 * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
	 * 
	 * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
	 * 
	 * @Scheduled(initialDelay=1000, fixedRate=5000)
	 * ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
	 */
	@Scheduled(fixedRate = 10000)
	public void printTime() {
		log.info("日志级别info" + "定时任务，现在时间：" + System.currentTimeMillis());
		log.error("日志级别debug" + "定时任务，现在时间：" + System.currentTimeMillis());
	}
}
