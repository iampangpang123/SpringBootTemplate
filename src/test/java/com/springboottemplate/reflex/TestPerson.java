package com.springboottemplate.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestPerson {
    public static void main(String[] args) throws Exception {

    }

    @Test
    public void test1() throws Exception {
        /*
         * 三种获取，class文件的方式
         */
        Class clazz1 = Person.class;
        Class clazz2 = Class.forName("reflex.Person");
        Class clazz3 = new Person().getClass();
        Person p = (Person) clazz3.newInstance();// 默认的五重唱构造器
        p.setAge(1);

        p.setName("xxx");
    }

    @Test
    public void test2() throws Exception {
        /*
         * 如何操作构造器,不想test1一样先new对象在操作
         */
        Class<Person> clazz3 = (Class<Person>) new Person().getClass();// 得到。class文件
        Constructor<Person> constructor = clazz3.getConstructor(String.class, int.class);// 得到指定构造器的。class文件
        Person p = constructor.newInstance("aaa", 2);
        p.show();
    }

    /**
     * *
     *
     * @Description: 如何操作属性 前提是你要现有对象，因为这样属性属于某一个对象
     * @param: @throws Exception
     * @return: void
     */
    @Test
    public void test3() throws Exception {
        /*
         * 如何操作属性 前提是你要现有对象，因为这样属性属于某一个对象
         */
        Class clazz3 = new Person().getClass();// 得到。class文件
        Person person = (Person) clazz3.newInstance();
        // clazz3.getDeclaredFields();//这是得到所有属性
        Field field = clazz3.getDeclaredField("name");// 得到指定的name属性
        field.set(person, "xxx");// 设置name的值
        person.show();
    }

    @Test
    public void test4() throws Exception {
        /*
         * 78 如何操作属性 前提是你要现有对象，因为这样属性属于某一个对象
         */
        Class clazz3 = new Person().getClass();// 得到。class文件
        Person person = (Person) clazz3.newInstance();
        Method method = clazz3.getDeclaredMethod("setName", String.class);// 第一个参数是方法名，第二个参数是参数类型
        method.invoke(person, "aaa");
        person.show();
    }

    @Test
    public void test5() throws Exception {
        /*
         * 获取classpath路径
         */
        String classpath = System.getProperty("java.class.path");//得到扩展类的路径
        System.out.println(classpath);
        String classpath1 = TestPerson.class.getResource("/").toString();
        System.out.println(classpath1);
    }
}
