package com.springboottemplate.innerclass.statc;

public class OuterClass {//外围类

	//1.静态内部类的可以访问外围类中的所有静态成员，包括private的静态成员。
	       //原因：  为外部类的非静态成员是属于每一个外部类对象的，而本身静态内部类就是独立外部类对象存在的，所以静态内部类不能访问外部类的非静态成员
	//2.而外部类依然可以访问静态内部类对象的所有访问权限的成员，这一点和普通内部(成员内部类)类无异。

    public int aa; //实例成员
    private static float f = 1.5f;//private的静态成员

    static void println() {
        System.out.println("这是静态方法");
    }

    protected static class StaticInnerClass{//protected的静态内部类

        float a;

        public StaticInnerClass() {
             a = f;// 外围类的private静态变量
             println();//外围类的静态方法
        }
    }
}

class OtherClass{

   public static void main(String[] args) {
       //创建静态内部类的对象
    OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
   }
}
