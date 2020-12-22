package com.springboottemplate.string;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestDouble {





    //一个字符串是不是整数、浮点数、不能为负数
    @Test
    public void test10() {

        BigDecimal bigDecimal=new BigDecimal("1a");
        System.out.println(bigDecimal.toString());
    }


    //一个字符串是不是整数、浮点数、不能为负数
    @Test
    public void test9() {
        String value = "3.155555555552";

        Boolean strResult = value.matches("^[\\+]?([0-9]+\\.?)?[0-9]+$");
        if (strResult == true ) {
            System.out.println("Is Number!");
            Double num = Double.parseDouble(value);
            System.out.println(num);
        } else {
            System.out.println("Is not Number!");
        }


    }


    @Test
    public void test8() {
        String aa = "3014555555512312312";
        Double bb = Double.valueOf(aa);
        System.out.println(bb);
        System.out.println(new BigDecimal(aa).toPlainString());
        System.out.println(       aa.substring(0,aa.indexOf(".")));
        //***********///
        double cc=11.0;
        System.out.println(new BigDecimal(cc).toPlainString());

        String dd="11.0";

        System.out.println(     dd.matches("[1-9]+\\d*\\.?\\d*"));
        System.out.println(dd.substring(0,dd.indexOf(".")));



    }


    //一个字符串是不是整数、浮点数、科学计数
    @Test
    public void test7() {
        String str = "-1";

        String regx = "[+-]*\\d+\\.?\\d*[Ee]*[+-]*\\d+";
        Pattern pattern = Pattern.compile(regx);
        boolean isNumber = pattern.matcher(str).matches();
        if (isNumber) {
            System.out.println(isNumber);
        }
        regx = "^[-\\+]?[.\\d]*$";
        pattern = Pattern.compile(regx);
        System.out.println(pattern.matcher(str).matches());

    }


    @Test
    public void test6() {
        String number = "1.0E8";
        BigDecimal bigDecimal = new BigDecimal(number);
        System.out.println("string number:" + bigDecimal.toPlainString());
    }

    @Test
    public void test5() {
       String aa="0.999";
      double bb=Double.valueOf(aa);
        System.out.println(bb);
    }

    @Test
    public void test4() {
        int i = 5;
        System.out.println(i + 0L);
        System.out.println(i + 1L);
        long m = 1L;
        for (int j = 0; j < 10; j++) {
            m++;
            System.out.println(m);
        }

    }

    /**
     * 判断是否为整数
     *
     * @param str 传入的字符串
     * @return 是整数返回true, 否则返回false
     */
    @Test
    public void isInteger() {
        String str = "0.0";
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        System.out.println(pattern.matcher(str).matches());

    }

    public boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * *
     *
     * @Description: 判断为0的情况
     * @param:
     * @return: void
     */
    @Test
    public void test3() {
        double a = 0.00000000;
        System.out.println(a == 0);

    }

    /**
     * *
     *
     * @Description: 判断double有多少整数位，小数位
     * @param:
     * @return: void
     */
    @Test
    public void test2() {
        double d = 3.9999666;
        int a = (d + "").length() - (d + "").indexOf(".") - 1;
        System.out.println(a);
    }

    /**
     * *
     *
     * @Description:比较两个double的大小
     * @param:
     * @return: void
     */
    @Test
    public void test1() {
        double a = 10.0;
        double b = 9.0;
        System.out.println(Double.compare(a, b));
    }
}
