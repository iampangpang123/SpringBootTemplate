//package com.springboottemplate.appPoint;
//
//import cn.tang.web1.reflex.Person;
//import org.apache.commons.beanutils.BeanUtils;
//import org.junit.Test;
//
//import cn.tang.web1.jihe.User;
//
//import java.lang.reflect.InvocationTargetException;
//
///**
// * @Description:局部变量引用与赋值问题
// * @author: 唐涛
// * @date: 2020年3月30日 下午7:28:58
// */
//public class AppPoint {
//    @Test
//    public void test1() {
//
//        String name = new String("张三");
//        ChangeValue(name);
//        System.out.println(name);
//        User user = new User();
//        user.setUserName("张三");
//        ChangeOjectValue(user);
//        System.out.println(user);
//
//    }
//
//    @Test
//    public void test2() throws InvocationTargetException, IllegalAccessException {
//    	User user=new User();
//		Person person=new Person();
//		person.setName("张三儿子");
//    	user.setUserName("张三");
//		user.setPerson(person);
//    	User usercopy=new User();
//        BeanUtils.copyProperties(usercopy,user);
//		System.out.println(usercopy);
//		user.setId(11);
//		user.setUserName("李四");
//		person.setName("李四儿子");
//		System.out.println(usercopy);
//
//    }
//
//    @Test
//    public void test3() throws InvocationTargetException, IllegalAccessException {
//        String aa="张三";
//        String bb=aa;
//        aa="李四";
//        System.out.println(aa+","+bb);
//
//    }
//
//
//
//    public void ChangeValue(String name) {
//        name = name + "测试";
//    }
//
//    public void ChangeOjectValue(User user) {
//        user.setId(1000);
//        user.setPassword("密码=1334454545");
//    }
//}
