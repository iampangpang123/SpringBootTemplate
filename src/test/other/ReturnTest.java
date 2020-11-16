package src.test.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReturnTest {

    @Test
    public void TestReturn() {
        return1();

        System.out.println("11111111111111");

    }

    public int return1() {
        return 1;

    }

    /***
     * @description: 递归-栈空间溢出1，
     * @param
     * @return: void
     */

    @Test
    public void stackMemmory1() {

        while (true) {
            stackMemmory1();
        }
    }

    /***
     * @description: 堆溢出
     * @param
     * @return: void
     */

    @Test
    public void heapMemmory() {

        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(new String(i + ""));
            i++;
        }
    }

}
