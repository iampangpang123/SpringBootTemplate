package com.springboottemplate.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: ttao
 * @create: 2020-09-27 19:14
 **/
//暂时关闭定时任务
//@Component
public class ThreadTask {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ThreadTask.class);
    /*
     * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     *
     * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     *
     * @Scheduled(initialDelay=1000, fixedRate=5000)
     * ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     */

    ExecutorService fixedThreadPool= Executors.newFixedThreadPool(8);
    @Scheduled(cron =" 0/5 * * * * ?" )
    public void printTime() {
        for (int i=1;i<=2;i++){
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //业务处理
                    dosomeing();
                }
            });
        }

    }
    //业务处理
    @Async
    void dosomeing(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(new Date());
        System.out.println("线程名称："+Thread.currentThread().getName()+"时间:"+str);
    }

}
