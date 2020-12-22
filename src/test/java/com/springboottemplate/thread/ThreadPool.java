package com.springboottemplate.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: ttao
 * @create: 2020-09-30 17:01
 **/
public class ThreadPool {


    /**
     * @param
     * @description: 下面写法是每循环一次，开一个线程，如果线程没归还，主流程继续跑，超出的线程在队列等待
     * @return: void
     */
    @Test
    public void test() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<String> userNameList = new ArrayList<>();
        userNameList.add("1");
        userNameList.add("1");
        userNameList.add("1");
        userNameList.add("1");
        userNameList.add("1");
        userNameList.add("1");
        //假设userNameList有一百条数据
        for (String username : userNameList) {

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("我说线程：" + Thread.currentThread().getName());
                }
            });

        }

    }

    /**
     * @param
     * @description: 两个线程去遍历集合里面的100条数据
     * @return: void
     */
    @Test
    public void test1() {
        ExecutorService executor1 = Executors.newFixedThreadPool(1);
        ExecutorService executor2 = Executors.newFixedThreadPool(1);
        List<String> userNameList1 = new ArrayList<>();//50条
        List<String> userNameList2 = new ArrayList<>();//50条


        executor1.execute(new Runnable() {
            @Override
            public void run() {
                for (String s : userNameList1) {
                }
            }

        });
        executor2.execute(new Runnable() {
            @Override
            public void run() {
                //数据保存到数据库
                for (String s : userNameList2) {
                }
            }
        });


        System.out.println("我是主流程，我跑完了，可能这一百条数据还没执行完");


    }

    public void test3() {
        //原始的数据 100条
        List<String> userNameList = new ArrayList<>();
        //根据5050 拆分后的  两个 50大小 的
        List<String> user1List = new ArrayList<>();

        List<String> user2List = new ArrayList<>();

        ExecutorService executor1 = Executors.newFixedThreadPool(2);
        executor1.execute(new Runnable() {
            @Override
            public void run() {
                doSoming(user1List);
            }
        });

        ExecutorService executor2 = Executors.newFixedThreadPool(2);
        executor2.execute(new Runnable() {
            @Override
            public void run() {
                doSoming(user2List);
            }

        });
    }

    private void doSoming(List<String> user2List) {
    }
}
