package com.springboottemplate.designpattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ttao
 * @create: 2020-09-11 10:35
 **/
public class Test1 {


    public static void main(String[] args) {
        final List<String> myList=new ArrayList<>();
        List<String> proxyInstance  =( List<String> ) Proxy.newProxyInstance(myList.getClass().getClassLoader(), myList.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(myList, args);
            }
        });
        proxyInstance.add("你好");
        System.out.println(proxyInstance.toString());
    }
}
